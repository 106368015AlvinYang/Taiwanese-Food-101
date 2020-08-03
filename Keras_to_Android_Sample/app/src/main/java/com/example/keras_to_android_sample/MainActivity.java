package com.example.keras_to_android_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.contrib.android.TensorFlowInferenceInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("tensorflow_inference");
        Log.i("wumei","load tensorflow_inference successfully");
    }

    private String MODEL_PATH = "file:///android_asset/FoodRecognizeModel.pb";

    private String INPUT_NAME = "input_1";
    private String OUTPUT_NAME = "output_1";
    private TensorFlowInferenceInterface tf;

    float[] PREDICTIONS = new float[1000];
    private float[] floatValues;
    private int[] INPUT_SIZE = {299,299,3};

    private static final int WRITE_PERMISSION = 0x01;

    int selection;
    public static final int USE_CAMERA = 1111;
    public static final int CHOOSE_PHOTO = 2222;

    String label;

    ImageView imageView;
    TextView resultView;
    Button buttonCamera;
    Button buttonAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestWritePermission();

        tf = new TensorFlowInferenceInterface(getAssets(),MODEL_PATH);

        imageView=(ImageView)findViewById(R.id.imageView1);
        resultView=(TextView)findViewById(R.id.text_show);
        buttonCamera=(Button)findViewById(R.id.button2);
        buttonAlbum=(Button)findViewById(R.id.button3);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

        //web crawler
        resultView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("message", label);
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        //Recognize static image
        buttonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection = CHOOSE_PHOTO;
                Intent intent = new Intent();
                //開啟Pictures畫面Type設定為image
                intent.setType("image/*");
                //使用Intent.ACTION_GET_CONTENT這個Action 會開啟選取圖檔視窗讓您選取手機內圖檔
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //取得相片後返回本畫面
                startActivityForResult(intent, 1);
                //buttonAlbum.setText("選擇圖片");
            }
        });
        //open camera
        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selection = USE_CAMERA;
                openCamera();
            }
        });

    }


    //permission for album
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if(requestCode == WRITE_PERMISSION){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Log.d(LOG_TAG, "Write Permission Failed");
                Toast.makeText(this, "You must allow permission write external storage to your mobile device.", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    private void requestWritePermission(){
        if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},WRITE_PERMISSION);
        }
    }




    public Object[] argmax(float[] array){

        int best = -1;
        float best_confidence = 0.0f;
        for(int i = 0;i < array.length;i++){
            float value = array[i];
            if (value > best_confidence){
                best_confidence = value;
                best = i;
            }
        }
        return new Object[]{best,best_confidence};
    }



    public void predict(final Bitmap bitmap){

        //Runs inference in background thread
        new AsyncTask<Integer,Integer,Integer>(){

            @Override
            protected Integer doInBackground(Integer ...params){
                //Resize the image into 224 x 224
                Bitmap resized_image = ImageUtils.processBitmap(bitmap,299);

                //Normalize the pixels
                floatValues = ImageUtils.normalizeBitmap(resized_image,299,255.0f,1.0f);

                //Pass input into the tensorflow
                tf.feed(INPUT_NAME,floatValues,1,299,299,3);

                //compute predictions
                tf.run(new String[]{OUTPUT_NAME});

                //copy the output into the PREDICTIONS array
                tf.fetch(OUTPUT_NAME,PREDICTIONS);

                //Obtained highest prediction
                Object[] results = argmax(PREDICTIONS);

                int class_index = (Integer) results[0];
                float confidence = (Float) results[1];

                try{
                    final String conf = String.valueOf(confidence * 100).substring(0,5);
                    final float c = confidence;
                    //Convert predicted class index into actual label name

                    label = ImageUtils.getLabel(getAssets().open("labels.json"),class_index);
                    //final String label = Integer.toString(class_index);
                    //Display result on UI
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (c > 0.5){
                                resultView.setText(label + " : " + conf + "%"); //这里控制textview显示当前的结果值
                            }
                            else{
                                resultView.setText("It's not food!!!");
                            }

                        }
                    });
                } catch (Exception e){
                }

                return 0;
            }

        }.execute(0);

    }

    public void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File tmpFile = new File(Environment.getExternalStorageDirectory(),"img.jpg");
        Uri outputFileUri = Uri.fromFile(tmpFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        startActivityForResult(intent, 0);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK&& selection == USE_CAMERA) {
            //super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = BitmapFactory.decodeFile(Environment
                    .getExternalStorageDirectory() + "/img.jpg");
            imageView.setImageBitmap(bitmap);
            predict(bitmap);
        }

        else if(resultCode == RESULT_OK&& selection == CHOOSE_PHOTO){
            Uri uri = data.getData();
            String filepath = getRealPathFromDocumentUri(MainActivity.this, uri);

            //查詢照片角度
            ExifInterface exif = null;
            try {
                exif = new ExifInterface(filepath);
            } catch (IOException e) {
                e.printStackTrace();
                exif = null;
            }
            int digree=0;
            if (exif != null) {
                int ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                        ExifInterface.ORIENTATION_UNDEFINED);
                switch (ori) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        digree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        digree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        digree = 270;
                        break;
                    default:
                        digree = 0;
                        break;
                }
            }

            //寫log
            Log.e("uri", uri.toString());

            //抽象資料的接口
            ContentResolver cr = this.getContentResolver();
            try {
                //由抽象資料接口轉換圖檔路徑為Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                //rotate
                if (digree != 0) {
                    Matrix m = new Matrix();
                    m.postRotate(digree);
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                            bitmap.getHeight(), m, true);
                }
                // 將Bitmap設定到ImageView
                imageView.setImageBitmap(bitmap);
                predict(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    //get image file path
    public static String getRealPathFromDocumentUri(Context context, Uri uri){
        String filePath = "";

        Pattern p = Pattern.compile("(\\d+)$");
        Matcher m = p.matcher(uri.toString());
        if (!m.find()) {
            //Log.e(ImageConverter.class.getSimpleName(), "ID for requested image not found: " + uri.toString());
            return filePath;
        }
        String imgId = m.group();

        String[] column = { MediaStore.Images.Media.DATA };
        String sel = MediaStore.Images.Media._ID + "=?";

        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                column, sel, new String[]{ imgId }, null);

        int columnIndex = cursor.getColumnIndex(column[0]);

        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex);
        }
        cursor.close();

        return filePath;
    }

}
