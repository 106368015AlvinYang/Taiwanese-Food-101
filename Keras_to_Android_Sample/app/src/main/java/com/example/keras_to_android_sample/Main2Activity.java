package com.example.keras_to_android_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;


public class Main2Activity extends AppCompatActivity {

    URL url;
    TextView t01,t02,txt1;
    Thread th;
    String location;
    String te01,te02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t01 = (TextView) this.findViewById(R.id.t01);
        t02 = (TextView) this.findViewById(R.id.t02);
        txt1 = (TextView) this.findViewById(R.id.txt1);


        ///傳送資料到Activity2
        Bundle bundle = getIntent().getExtras();
        location = bundle.getString("message");

        //location = "yolk_pastry";
        txt1.setText(location);
        th=new Thread(catch_data);  //執行緒
        th.start();
    }

    private Runnable catch_data = new Runnable(){
        public void run(){
            try {

                switch (location)
                {
                    case "apple_pie" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/315571");
                        Document doc_apple_pie = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_apple_pie = doc_apple_pie.select("div.ingredients-groups div.group");
                        for(int i=1;i<subtitle_apple_pie.size();i++)
                        {
                            te02=subtitle_apple_pie.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_apple_pie_1 = doc_apple_pie.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_apple_pie_1.size();i++)
                        {
                            te02=subtitle_apple_pie_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%98%8B%E6%9E%9C%E6%B4%BE?sortby=popular");
                        Document doc_apple_pie_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_apple_pie_rec = doc_apple_pie_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_apple_pie_rec.size();i++)
                        {
                            te01=subtitle_apple_pie_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;
                    case "baby_back_ribs" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/320467");
                        Document doc_baby_back_ribs = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_baby_back_ribs = doc_baby_back_ribs.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_baby_back_ribs.size();i++)
                        {
                            te02=subtitle_baby_back_ribs.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_baby_back_ribs_1 = doc_baby_back_ribs.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_baby_back_ribs_1.size();i++)
                        {
                            te02=subtitle_baby_back_ribs_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%83%A4%E8%82%8B%E6%8E%92?sortby=popular");
                        Document doc_baby_back_ribs_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_baby_back_ribs_rec = doc_baby_back_ribs_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_baby_back_ribs_rec.size();i++)
                        {
                            te01=subtitle_baby_back_ribs_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "bawan" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/193513");
                        Document doc_bawan = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bawan = doc_bawan.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_bawan.size();i++)
                        {
                            te02=subtitle_bawan.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_bawan_1 = doc_bawan.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_bawan_1.size();i++)
                        {
                            te02=subtitle_bawan_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%82%89%E5%9C%93?sortby=popular");
                        Document doc_bawan_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bawan_rec = doc_bawan_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_bawan_rec.size();i++)
                        {
                            te01=subtitle_bawan_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "beef_carpaccio" :
                        //recipe
                        url = new URL("https://www.japancentre.com/zh/recipes/1318-beef-tataki-carpaccio");
                        Document doc_beef_carpaccio = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_carpaccio = doc_beef_carpaccio.select("div.ingredients");
                        for(int i=0;i<subtitle_beef_carpaccio.size();i++)
                        {
                            te02=subtitle_beef_carpaccio.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_beef_carpaccio_1 = doc_beef_carpaccio.select("div.prepare");
                        for(int i=0;i<subtitle_beef_carpaccio_1.size();i++)
                        {
                            te02=subtitle_beef_carpaccio_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%A9%E5%BC%8F%E7%94%9F%E7%89%9B%E8%82%89?sortby=popular");
                        Document doc_beef_carpaccio_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_carpaccio_rec = doc_beef_carpaccio_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_beef_carpaccio_rec.size();i++)
                        {
                            te01=subtitle_beef_carpaccio_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "beef_noodles" :
                        //recipe
                        url = new URL("https://www.how-living.com/p/15335/%e6%af%94%e5%86%a0%e8%bb%8d%e5%90%8d%e5%ba%97%e9%82%84%e5%a5%bd%e5%90%83%ef%bc%81%e8%bf%b7%e4%ba%ba%e9%a3%84%e9%a6%99%e3%80%90%e7%95%aa%e8%8c%84%e7%b4%85%e7%87%92%e7%89%9b%e8%82%89%e9%ba%b5%e3%80%91");
                        Document doc_beef_noodles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_noodles = doc_beef_noodles.select("div.recipe-content-text p");
                        for(int i=2;i<subtitle_beef_noodles.size();i++)
                        {
                            te02=subtitle_beef_noodles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%89%9B%E8%82%89%E9%BA%B5?sortby=popular");
                        Document doc_beef_noodles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_noodles_rec = doc_beef_noodles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_beef_noodles_rec.size();i++)
                        {
                            te01=subtitle_beef_noodles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "beef_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/180327");
                        Document doc_beef_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_soup = doc_beef_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_beef_soup.size();i++)
                        {
                            te02=subtitle_beef_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_beef_soup_1 = doc_beef_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_beef_soup_1.size();i++)
                        {
                            te02=subtitle_beef_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%89%9B%E8%82%89%E6%B9%AF?sortby=popular");
                        Document doc_beef_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_soup_rec = doc_beef_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_beef_soup_rec.size();i++)
                        {
                            te01=subtitle_beef_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "beef_tartare" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/207010");
                        Document doc_beef_tartare = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_tartare = doc_beef_tartare.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_beef_tartare.size();i++)
                        {
                            te02=subtitle_beef_tartare.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_beef_tartare_1 = doc_beef_tartare.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_beef_tartare_1.size();i++)
                        {
                            te02=subtitle_beef_tartare_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%9E%91%E9%9D%BC%E7%89%9B%E8%82%89?sortby=popular");
                        Document doc_beef_tartare_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_beef_tartare_rec = doc_beef_tartare_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_beef_tartare_rec.size();i++)
                        {
                            te01=subtitle_beef_tartare_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "bibimbap" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/328341");
                        Document doc_bibimbap = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bibimbap = doc_bibimbap.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_bibimbap.size();i++)
                        {
                            te02=subtitle_bibimbap.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_bibimbap_1 = doc_bibimbap.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_bibimbap_1.size();i++)
                        {
                            te02=subtitle_bibimbap_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%9F%93%E5%BC%8F%E6%8B%8C%E9%A3%AF?sortby=popular");
                        Document doc_bibimbap_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bibimbap_rec = doc_bibimbap_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_bibimbap_rec.size();i++)
                        {
                            te01=subtitle_bibimbap_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "bitter_melon_with_salted_eggs" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/316807");
                        Document doc_bitter_melon_with_salted_eggs = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bitter_melon_with_salted_eggs = doc_bitter_melon_with_salted_eggs.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_bitter_melon_with_salted_eggs.size();i++)
                        {
                            te02=subtitle_bitter_melon_with_salted_eggs.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_bitter_melon_with_salted_eggs_1 = doc_bitter_melon_with_salted_eggs.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_bitter_melon_with_salted_eggs_1.size();i++)
                        {
                            te02=subtitle_bitter_melon_with_salted_eggs_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%B9%B9%E8%9B%8B%E8%8B%A6%E7%93%9C?sortby=popular");
                        Document doc_bitter_melon_with_salted_eggs_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bitter_melon_with_salted_eggs_rec = doc_bitter_melon_with_salted_eggs_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_bitter_melon_with_salted_eggs_rec.size();i++)
                        {
                            te01=subtitle_bitter_melon_with_salted_eggs_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "braised_napa_cabbage" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/324354");
                        Document doc_braised_napa_cabbage = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_braised_napa_cabbage = doc_braised_napa_cabbage.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_braised_napa_cabbage.size();i++)
                        {
                            te02=subtitle_braised_napa_cabbage.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_braised_napa_cabbage_1 = doc_braised_napa_cabbage.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_braised_napa_cabbage_1.size();i++)
                        {
                            te02=subtitle_braised_napa_cabbage_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%99%BD%E8%8F%9C%E6%BB%B7?sortby=popular");
                        Document doc_braised_napa_cabbage_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_braised_napa_cabbage_rec = doc_braised_napa_cabbage_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_braised_napa_cabbage_rec.size();i++)
                        {
                            te01=subtitle_braised_napa_cabbage_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "braised_pork_over_rice" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/327109");
                        Document doc_braised_pork_over_rice = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_braised_pork_over_rice = doc_braised_pork_over_rice.select("div.ingredients-groups div.group");
                        for(int i=1;i<subtitle_braised_pork_over_rice.size();i++)
                        {
                            te02=subtitle_braised_pork_over_rice.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_braised_pork_over_rice_1 = doc_braised_pork_over_rice.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_braised_pork_over_rice_1.size();i++)
                        {
                            te02=subtitle_braised_pork_over_rice_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%BB%B7%E8%82%89%E9%A3%AF?sortby=popular");
                        Document doc_braised_pork_over_rice_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_braised_pork_over_rice_rec = doc_braised_pork_over_rice_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_braised_pork_over_rice_rec.size();i++)
                        {
                            te01=subtitle_braised_pork_over_rice_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "bread_pudding" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/134193");
                        Document doc_bread_pudding = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bread_pudding = doc_bread_pudding.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_bread_pudding.size();i++)
                        {
                            te02=subtitle_bread_pudding.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_bread_pudding_1 = doc_bread_pudding.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_bread_pudding_1.size();i++)
                        {
                            te02=subtitle_bread_pudding_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/%E9%BA%B5%E5%8C%85%E5%B8%83%E7%94%B8?sortby=popular");
                        Document doc_bread_pudding_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bread_pudding_rec = doc_bread_pudding_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_bread_pudding_rec.size();i++)
                        {
                            te01=subtitle_bread_pudding_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "brown_sugar_cake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/326104");
                        Document doc_brown_sugar_cake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_brown_sugar_cake = doc_brown_sugar_cake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_brown_sugar_cake.size();i++)
                        {
                            te02=subtitle_brown_sugar_cake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_brown_sugar_cake_1 = doc_brown_sugar_cake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_brown_sugar_cake_1.size();i++)
                        {
                            te02=subtitle_brown_sugar_cake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%BB%91%E7%B3%96%E7%B3%95?sortby=popular");
                        Document doc_brown_sugar_cake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_brown_sugar_cake_rec = doc_brown_sugar_cake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_brown_sugar_cake_rec.size();i++)
                        {
                            te01=subtitle_brown_sugar_cake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "bubble_tea" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/140671");
                        Document doc_bubble_tea = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bubble_tea = doc_bubble_tea.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_bubble_tea.size();i++)
                        {
                            te02=subtitle_bubble_tea.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_bubble_tea_1 = doc_bubble_tea.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_bubble_tea_1.size();i++)
                        {
                            te02=subtitle_bubble_tea_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/%E7%8F%8D%E7%8F%A0%E5%A5%B6%E8%8C%B6?sortby=popular");
                        Document doc_bubble_tea_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_bubble_tea_rec = doc_bubble_tea_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_bubble_tea_rec.size();i++)
                        {
                            te01=subtitle_bubble_tea_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "caesar_salad" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/310170");
                        Document doc_caesar_salad = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_caesar_salad = doc_caesar_salad.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_caesar_salad.size();i++)
                        {
                            te02=subtitle_caesar_salad.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_caesar_salad_1 = doc_caesar_salad.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_caesar_salad_1.size();i++)
                        {
                            te02=subtitle_caesar_salad_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/%E5%87%B1%E8%96%A9%E6%B2%99%E6%8B%89?sortby=popular");
                        Document doc_caesar_salad_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_caesar_salad_rec = doc_caesar_salad_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_caesar_salad_rec.size();i++)
                        {
                            te01=subtitle_caesar_salad_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "caozaiguo" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/289468");
                        Document doc_caozaiguo = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_caozaiguo = doc_caozaiguo.select("div.ingredients-groups div.group");
                        for(int i=1;i<subtitle_caozaiguo.size();i++)
                        {
                            te02=subtitle_caozaiguo.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_caozaiguo_1 = doc_caozaiguo.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_caozaiguo_1.size();i++)
                        {
                            te02=subtitle_caozaiguo_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/%E8%8D%89%E4%BB%94%E7%B2%BF?sortby=popular");
                        Document doc_caozaiguo_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_caozaiguo_rec = doc_caozaiguo_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_caozaiguo_rec.size();i++)
                        {
                            te01=subtitle_caozaiguo_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "cheese_plate" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/90110");
                        Document doc_cheese_plate = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cheese_plate = doc_cheese_plate.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_cheese_plate.size();i++)
                        {
                            te02=subtitle_cheese_plate.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_cheese_plate_1 = doc_cheese_plate.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_cheese_plate_1.size();i++)
                        {
                            te02=subtitle_cheese_plate_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/cheese%20plate?sortby=popular");
                        Document doc_cheese_plate_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cheese_plate_rec = doc_cheese_plate_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_cheese_plate_rec.size();i++)
                        {
                            te01=subtitle_cheese_plate_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "cheesecake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/308405");
                        Document doc_cheesecake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cheesecake = doc_cheesecake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_cheesecake.size();i++)
                        {
                            te02=subtitle_cheesecake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_cheesecake_1 = doc_cheesecake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_cheesecake_1.size();i++)
                        {
                            te02=subtitle_cheesecake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/cheese%20cake?sortby=popular");
                        Document doc_cheesecake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cheesecake_rec = doc_cheesecake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_cheesecake_rec.size();i++)
                        {
                            te01=subtitle_cheesecake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "chicken_curry" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/327955");
                        Document doc_chicken_curry = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chicken_curry = doc_chicken_curry.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_chicken_curry.size();i++)
                        {
                            te02=subtitle_chicken_curry.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_chicken_curry_1 = doc_chicken_curry.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_chicken_curry_1.size();i++)
                        {
                            te02=subtitle_chicken_curry_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/%E5%92%96%E5%93%A9%E9%9B%9E?sortby=popular");
                        Document doc_chicken_curry_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chicken_curry_rec = doc_chicken_curry_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_chicken_curry_rec.size();i++)
                        {
                            te01=subtitle_chicken_curry_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "chicken_mushroom_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/322838");
                        Document doc_chicken_mushroom_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chicken_mushroom_soup = doc_chicken_mushroom_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_chicken_mushroom_soup.size();i++)
                        {
                            te02=subtitle_chicken_mushroom_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_chicken_mushroom_soup_1 = doc_chicken_mushroom_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_chicken_mushroom_soup_1.size();i++)
                        {
                            te02=subtitle_chicken_mushroom_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/%E9%A6%99%E8%8F%87%E9%9B%9E%E6%B9%AF?sortby=popular");
                        Document doc_chicken_mushroom_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chicken_mushroom_soup_rec = doc_chicken_mushroom_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_chicken_mushroom_soup_rec.size();i++)
                        {
                            te01=subtitle_chicken_mushroom_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "chicken_wings" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/314912");
                        Document doc_chicken_wings = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chicken_wings = doc_chicken_wings.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_chicken_wings.size();i++)
                        {
                            te02=subtitle_chicken_wings.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_chicken_wings_1 = doc_chicken_wings.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_chicken_wings_1.size();i++)
                        {
                            te02=subtitle_chicken_wings_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/%E5%8F%B0%E5%8C%97%E5%B8%82/list/%E6%B0%B4%E7%89%9B%E5%9F%8E%E8%BE%A3%E9%9B%9E%E7%BF%85?sortby=popular");
                        Document doc_chicken_wings_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chicken_wings_rec = doc_chicken_wings_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_chicken_wings_rec.size();i++)
                        {
                            te01=subtitle_chicken_wings_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "chinese_pickled_cucumber" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/330352");
                        Document doc_chinese_pickled_cucumber = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chinese_pickled_cucumber = doc_chinese_pickled_cucumber.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_chinese_pickled_cucumber.size();i++)
                        {
                            te02=subtitle_chinese_pickled_cucumber.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_chinese_pickled_cucumber_1 = doc_chinese_pickled_cucumber.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_chinese_pickled_cucumber_1.size();i++)
                        {
                            te02=subtitle_chinese_pickled_cucumber_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B6%BC%E6%8B%8C%E5%B0%8F%E9%BB%83%E7%93%9C?sortby=popular");
                        Document doc_chinese_pickled_cucumber_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chinese_pickled_cucumber_rec = doc_chinese_pickled_cucumber_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_chinese_pickled_cucumber_rec.size();i++)
                        {
                            te01=subtitle_chinese_pickled_cucumber_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "chocolate_cake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337596");
                        Document doc_chocolate_cake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chocolate_cake = doc_chocolate_cake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_chocolate_cake.size();i++)
                        {
                            te02=subtitle_chocolate_cake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_chocolate_cake_1 = doc_chocolate_cake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_chocolate_cake_1.size();i++)
                        {
                            te02=subtitle_chocolate_cake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%B7%A7%E5%85%8B%E5%8A%9B%E8%9B%8B%E7%B3%95?sortby=popular");
                        Document doc_chocolate_cake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chocolate_cake_rec = doc_chocolate_cake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_chocolate_cake_rec.size();i++)
                        {
                            te01=subtitle_chocolate_cake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "chocolate_mousse" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/334435");
                        Document doc_chocolate_mousse = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chocolate_mousse = doc_chocolate_mousse.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_chocolate_mousse.size();i++)
                        {
                            te02=subtitle_chocolate_mousse.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_chocolate_mousse_1 = doc_chocolate_mousse.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_chocolate_mousse_1.size();i++)
                        {
                            te02=subtitle_chocolate_mousse_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%B7%A7%E5%85%8B%E5%8A%9B%E6%85%95%E6%96%AF?sortby=popular");
                        Document doc_chocolate_mousse_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_chocolate_mousse_rec = doc_chocolate_mousse_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_chocolate_mousse_rec.size();i++)
                        {
                            te01=subtitle_chocolate_mousse_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "churros" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335611");
                        Document doc_churros = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_churros = doc_churros.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_churros.size();i++)
                        {
                            te02=subtitle_churros.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_churros_1 = doc_churros.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_churros_1.size();i++)
                        {
                            te02=subtitle_churros_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%90%89%E6%8B%BF%E6%A3%92?sortby=popular");
                        Document doc_churros_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_churros_rec = doc_churros_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_churros_rec.size();i++)
                        {
                            te01=subtitle_churros_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "clam_chowder" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/126388");
                        Document doc_clam_chowder = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_clam_chowder = doc_clam_chowder.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_clam_chowder.size();i++)
                        {
                            te02=subtitle_clam_chowder.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_clam_chowder_1 = doc_clam_chowder.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_clam_chowder_1.size();i++)
                        {
                            te02=subtitle_clam_chowder_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%9B%A4%E8%A0%A3%E6%BF%83%E6%B9%AF?sortby=popular");
                        Document doc_clam_chowder_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_clam_chowder_rec = doc_clam_chowder_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_clam_chowder_rec.size();i++)
                        {
                            te01=subtitle_clam_chowder_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "club_sandwich" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/132432");
                        Document doc_club_sandwich = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_club_sandwich = doc_club_sandwich.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_club_sandwich.size();i++)
                        {
                            te02=subtitle_club_sandwich.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_club_sandwich_1 = doc_club_sandwich.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_club_sandwich_1.size();i++)
                        {
                            te02=subtitle_club_sandwich_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B4%BE%E5%B0%8D%E4%B8%89%E6%98%8E%E6%B2%BB?sortby=popular");
                        Document doc_club_sandwich_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_club_sandwich_rec = doc_club_sandwich_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_club_sandwich_rec.size();i++)
                        {
                            te01=subtitle_club_sandwich_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "coffin_toast" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337518");
                        Document doc_coffin_toast = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_coffin_toast = doc_coffin_toast.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_coffin_toast.size();i++)
                        {
                            te02=subtitle_coffin_toast.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_coffin_toast_1 = doc_coffin_toast.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_coffin_toast_1.size();i++)
                        {
                            te02=subtitle_coffin_toast_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%A3%BA%E6%9D%90%E6%9D%BF?sortby=popular");
                        Document doc_coffin_toast_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_coffin_toast_rec = doc_coffin_toast_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_coffin_toast_rec.size();i++)
                        {
                            te01=subtitle_coffin_toast_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "cold_noodles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/334586");
                        Document doc_cold_noodles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cold_noodles = doc_cold_noodles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_cold_noodles.size();i++)
                        {
                            te02=subtitle_cold_noodles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_cold_noodles_1 = doc_cold_noodles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_cold_noodles_1.size();i++)
                        {
                            te02=subtitle_cold_noodles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B6%BC%E9%BA%B5?sortby=popular");
                        Document doc_cold_noodles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cold_noodles_rec = doc_cold_noodles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_cold_noodles_rec.size();i++)
                        {
                            te01=subtitle_cold_noodles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "crab_cakes" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/158530");
                        Document doc_crab_cakes = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_crab_cakes = doc_crab_cakes.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_crab_cakes.size();i++)
                        {
                            te02=subtitle_crab_cakes.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_crab_cakes_1 = doc_crab_cakes.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_crab_cakes_1.size();i++)
                        {
                            te02=subtitle_crab_cakes_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%9F%B9%E8%82%89%E9%A4%85?sortby=popular");
                        Document doc_crab_cakes_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_crab_cakes_rec = doc_crab_cakes_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_crab_cakes_rec.size();i++)
                        {
                            te01=subtitle_crab_cakes_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "crab_migao" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/250827");
                        Document doc_crab_migao = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_crab_migao = doc_crab_migao.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_crab_migao.size();i++)
                        {
                            te02=subtitle_crab_migao.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_crab_migao_1 = doc_crab_migao.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_crab_migao_1.size();i++)
                        {
                            te02=subtitle_crab_migao_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%B4%85%E8%9F%B3%E7%B1%B3%E7%B3%95?sortby=popular");
                        Document doc_crab_migao_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_crab_migao_rec = doc_crab_migao_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_crab_migao_rec.size();i++)
                        {
                            te01=subtitle_crab_migao_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "creme_brulee" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/323169");
                        Document doc_creme_brulee = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_creme_brulee = doc_creme_brulee.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_creme_brulee.size();i++)
                        {
                            te02=subtitle_creme_brulee.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_creme_brulee_1 = doc_creme_brulee.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_creme_brulee_1.size();i++)
                        {
                            te02=subtitle_creme_brulee_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%84%A6%E7%B3%96%E7%83%A4%E5%B8%83%E8%95%BE?sortby=popular");
                        Document doc_creme_brulee_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_creme_brulee_rec = doc_creme_brulee_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_creme_brulee_rec.size();i++)
                        {
                            te01=subtitle_creme_brulee_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "cup_cakes" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340916");
                        Document doc_cup_cakes = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cup_cakes = doc_cup_cakes.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_cup_cakes.size();i++)
                        {
                            te02=subtitle_cup_cakes.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_cup_cakes_1 = doc_cup_cakes.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_cup_cakes_1.size();i++)
                        {
                            te02=subtitle_cup_cakes_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%9D%AF%E5%AD%90%E8%9B%8B%E7%B3%95?sortby=popular");
                        Document doc_cup_cakes_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_cup_cakes_rec = doc_cup_cakes_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_cup_cakes_rec.size();i++)
                        {
                            te01=subtitle_cup_cakes_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "deep_fried_pork_rib_and_radish_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/313058");
                        Document doc_deep_fried_pork_rib_and_radish_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_deep_fried_pork_rib_and_radish_soup = doc_deep_fried_pork_rib_and_radish_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_deep_fried_pork_rib_and_radish_soup.size();i++)
                        {
                            te02=subtitle_deep_fried_pork_rib_and_radish_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_deep_fried_pork_rib_and_radish_soup_1 = doc_deep_fried_pork_rib_and_radish_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_deep_fried_pork_rib_and_radish_soup_1.size();i++)
                        {
                            te02=subtitle_deep_fried_pork_rib_and_radish_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%8E%92%E9%AA%A8%E9%85%A5%E6%B9%AF?sortby=popular");
                        Document doc_deep_fried_pork_rib_and_radish_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_deep_fried_pork_rib_and_radish_soup_rec = doc_deep_fried_pork_rib_and_radish_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_deep_fried_pork_rib_and_radish_soup_rec.size();i++)
                        {
                            te01=subtitle_deep_fried_pork_rib_and_radish_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "deep-fried_chicken_cutlets" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/287346");
                        Document doc_deep_fried_chicken_cutlets = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_deep_fried_chicken_cutlets = doc_deep_fried_chicken_cutlets.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_deep_fried_chicken_cutlets.size();i++)
                        {
                            te02=subtitle_deep_fried_chicken_cutlets.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_deep_fried_chicken_cutlets_1 = doc_deep_fried_chicken_cutlets.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_deep_fried_chicken_cutlets_1.size();i++)
                        {
                            te02=subtitle_deep_fried_chicken_cutlets_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%82%B8%E9%9B%9E%E6%8E%92?sortby=popular");
                        Document doc_deep_fried_chicken_cutlets_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_deep_fried_chicken_cutlets_rec = doc_deep_fried_chicken_cutlets_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_deep_fried_chicken_cutlets_rec.size();i++)
                        {
                            te01=subtitle_deep_fried_chicken_cutlets_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "deviled_eggs" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/193535");
                        Document doc_deviled_eggs = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_deviled_eggs = doc_deviled_eggs.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_deviled_eggs.size();i++)
                        {
                            te02=subtitle_deviled_eggs.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_deviled_eggs_1 = doc_deviled_eggs.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_deviled_eggs_1.size();i++)
                        {
                            te02=subtitle_deviled_eggs_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%83%A1%E9%AD%94%E8%9B%8B?sortby=popular");
                        Document doc_deviled_eggs_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_deviled_eggs_rec = doc_deviled_eggs_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_deviled_eggs_rec.size();i++)
                        {
                            te01=subtitle_deviled_eggs_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "donuts" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342301");
                        Document doc_donuts = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_donuts = doc_donuts.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_donuts.size();i++)
                        {
                            te02=subtitle_donuts.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_donuts_1 = doc_donuts.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_donuts_1.size();i++)
                        {
                            te02=subtitle_donuts_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%94%9C%E7%94%9C%E5%9C%88?sortby=popular");
                        Document doc_donuts_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_donuts_rec = doc_donuts_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_donuts_rec.size();i++)
                        {
                            te01=subtitle_donuts_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "dumplings" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/336970");
                        Document doc_dumplings = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_dumplings = doc_dumplings.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_dumplings.size();i++)
                        {
                            te02=subtitle_dumplings.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_dumplings_1 = doc_dumplings.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_dumplings_1.size();i++)
                        {
                            te02=subtitle_dumplings_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%92%B8%E9%A4%83?sortby=popular");
                        Document doc_dumplings_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_dumplings_rec = doc_dumplings_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_dumplings_rec.size();i++)
                        {
                            te01=subtitle_dumplings_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "edamame" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/338740");
                    Document doc_edamame = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_edamame = doc_edamame.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_edamame.size();i++)
                    {
                        te02=subtitle_edamame.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_edamame_1 = doc_edamame.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_edamame_1.size();i++)
                    {
                        te02=subtitle_edamame_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E6%AF%9B%E8%B1%86?sortby=popular");
                    Document doc_edamame_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_edamame_rec = doc_edamame_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_edamame_rec.size();i++)
                    {
                        te01=subtitle_edamame_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "egg_pancake_roll" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340543");
                        Document doc_egg_pancake_roll = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_egg_pancake_roll = doc_egg_pancake_roll.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_egg_pancake_roll.size();i++)
                        {
                            te02=subtitle_egg_pancake_roll.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_egg_pancake_roll_1 = doc_egg_pancake_roll.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_egg_pancake_roll_1.size();i++)
                        {
                            te02=subtitle_egg_pancake_roll_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%9B%8B%E9%A4%85?sortby=popular");
                        Document doc_egg_pancake_roll_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_egg_pancake_roll_rec = doc_egg_pancake_roll_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_egg_pancake_roll_rec.size();i++)
                        {
                            te01=subtitle_egg_pancake_roll_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "eggs_benedict" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/315316");
                        Document doc_eggs_benedict = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_eggs_benedict = doc_eggs_benedict.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_eggs_benedict.size();i++)
                        {
                            te02=subtitle_eggs_benedict.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_eggs_benedict_1 = doc_eggs_benedict.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_eggs_benedict_1.size();i++)
                        {
                            te02=subtitle_eggs_benedict_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%8F%AD%E5%B0%BC%E8%BF%AA%E5%85%8B%E8%9B%8B?sortby=popular");
                        Document doc_eggs_benedict_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_eggs_benedict_rec = doc_eggs_benedict_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_eggs_benedict_rec.size();i++)
                        {
                            te01=subtitle_eggs_benedict_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "eight_treasure_shaved_ice" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/110496");
                    Document doc_eight_treasure_shaved_ice = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_eight_treasure_shaved_ice = doc_eight_treasure_shaved_ice.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_eight_treasure_shaved_ice.size();i++)
                    {
                        te02=subtitle_eight_treasure_shaved_ice.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_eight_treasure_shaved_ice_1 = doc_eight_treasure_shaved_ice.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_eight_treasure_shaved_ice_1.size();i++)
                    {
                        te02=subtitle_eight_treasure_shaved_ice_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E5%85%AB%E5%AF%B6%E5%86%B0?sortby=popular");
                    Document doc_eight_treasure_shaved_ice_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_eight_treasure_shaved_ice_rec = doc_eight_treasure_shaved_ice_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_eight_treasure_shaved_ice_rec.size();i++)
                    {
                        te01=subtitle_eight_treasure_shaved_ice_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "escargots" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/89985");
                        Document doc_escargots = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_escargots = doc_escargots.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_escargots.size();i++)
                        {
                            te02=subtitle_escargots.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_escargots_1 = doc_escargots.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_escargots_1.size();i++)
                        {
                            te02=subtitle_escargots_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B3%95%E5%BC%8F%E7%94%B0%E8%9E%BA?sortby=popular");
                        Document doc_escargots_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_escargots_rec = doc_escargots_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_escargots_rec.size();i++)
                        {
                            te01=subtitle_escargots_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "falafel" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/329926");
                        Document doc_falafel = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_falafel = doc_falafel.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_falafel.size();i++)
                        {
                            te02=subtitle_falafel.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_falafel_1 = doc_falafel.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_falafel_1.size();i++)
                        {
                            te02=subtitle_falafel_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%B7%B9%E5%98%B4%E8%B1%86%E9%A4%85?sortby=popular");
                        Document doc_falafel_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_falafel_rec = doc_falafel_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_falafel_rec.size();i++)
                        {
                            te01=subtitle_falafel_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "filet_mignon" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/54669");
                    Document doc_filet_mignon = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_filet_mignon = doc_filet_mignon.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_filet_mignon.size();i++)
                    {
                        te02=subtitle_filet_mignon.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_filet_mignon_1 = doc_filet_mignon.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_filet_mignon_1.size();i++)
                    {
                        te02=subtitle_filet_mignon_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E8%8F%B2%E5%8A%9B%E7%89%9B%E6%8E%92?sortby=popular");
                    Document doc_filet_mignon_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_filet_mignon_rec = doc_filet_mignon_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_filet_mignon_rec.size();i++)
                    {
                        te01=subtitle_filet_mignon_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "fish_and_chips" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340430");
                        Document doc_fish_and_chips = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fish_and_chips = doc_fish_and_chips.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_fish_and_chips.size();i++)
                        {
                            te02=subtitle_fish_and_chips.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_fish_and_chips_1 = doc_fish_and_chips.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_fish_and_chips_1.size();i++)
                        {
                            te02=subtitle_fish_and_chips_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%82%B8%E9%AD%9A%E8%96%AF%E6%A2%9D?sortby=popular");
                        Document doc_fish_and_chips_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fish_and_chips_rec = doc_fish_and_chips_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_fish_and_chips_rec.size();i++)
                        {
                            te01=subtitle_fish_and_chips_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "fish_head_casserole" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341011");
                        Document doc_fish_head_casserole = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fish_head_casserole = doc_fish_head_casserole.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_fish_head_casserole.size();i++)
                        {
                            te02=subtitle_fish_head_casserole.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_fish_head_casserole_1 = doc_fish_head_casserole.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_fish_head_casserole_1.size();i++)
                        {
                            te02=subtitle_fish_head_casserole_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%A0%82%E9%8D%8B%E9%AD%9A%E9%A0%AD?sortby=popular");
                        Document doc_fish_head_casserole_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fish_head_casserole_rec = doc_fish_head_casserole_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_fish_head_casserole_rec.size();i++)
                        {
                            te01=subtitle_fish_head_casserole_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "foie_gras" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/323059");
                        Document doc_foie_gras = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_foie_gras = doc_foie_gras.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_foie_gras.size();i++)
                        {
                            te02=subtitle_foie_gras.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_foie_gras_1 = doc_foie_gras.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_foie_gras_1.size();i++)
                        {
                            te02=subtitle_foie_gras_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%B5%9D%E8%82%9D?sortby=popular");
                        Document doc_foie_gras_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_foie_gras_rec = doc_foie_gras_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_foie_gras_rec.size();i++)
                        {
                            te01=subtitle_foie_gras_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "french_fries" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/329069");
                        Document doc_french_fries = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_french_fries = doc_french_fries.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_french_fries.size();i++)
                        {
                            te02=subtitle_french_fries.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_french_fries_1 = doc_french_fries.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_french_fries_1.size();i++)
                        {
                            te02=subtitle_french_fries_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%96%AF%E6%A2%9D?sortby=popular");
                        Document doc_french_fries_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_french_fries_rec = doc_french_fries_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_french_fries_rec.size();i++)
                        {
                            te01=subtitle_french_fries_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "french_onion_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/334414");
                        Document doc_french_onion_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_french_onion_soup = doc_french_onion_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_french_onion_soup.size();i++)
                        {
                            te02=subtitle_french_onion_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_french_onion_soup_1 = doc_french_onion_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_french_onion_soup_1.size();i++)
                        {
                            te02=subtitle_french_onion_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B3%95%E5%BC%8F%E6%B4%8B%E8%94%A5%E6%B9%AF?sortby=popular");
                        Document doc_french_onion_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_french_onion_soup_rec = doc_french_onion_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_french_onion_soup_rec.size();i++)
                        {
                            te01=subtitle_french_onion_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "french_toast" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335228");
                        Document doc_french_toast = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_french_toast = doc_french_toast.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_french_toast.size();i++)
                        {
                            te02=subtitle_french_toast.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_french_toast_1 = doc_french_toast.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_french_toast_1.size();i++)
                        {
                            te02=subtitle_french_toast_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B3%95%E5%BC%8F%E5%90%90%E5%8F%B8?sortby=popular");
                        Document doc_french_toast_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_french_toast_rec = doc_french_toast_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_french_toast_rec.size();i++)
                        {
                            te01=subtitle_french_toast_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "fried_calamari" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/290466");
                    Document doc_fried_calamari = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_fried_calamari = doc_fried_calamari.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_fried_calamari.size();i++)
                    {
                        te02=subtitle_fried_calamari.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_fried_calamari_1 = doc_fried_calamari.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_fried_calamari_1.size();i++)
                    {
                        te02=subtitle_fried_calamari_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E7%82%B8%E9%AD%B7%E9%AD%9A?sortby=popular");
                    Document doc_fried_calamari_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_fried_calamari_rec = doc_fried_calamari_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_fried_calamari_rec.size();i++)
                    {
                        te01=subtitle_fried_calamari_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "fried_eel_noodles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/247000");
                        Document doc_fried_eel_noodles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_eel_noodles = doc_fried_eel_noodles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_fried_eel_noodles.size();i++)
                        {
                            te02=subtitle_fried_eel_noodles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_fried_eel_noodles_1 = doc_fried_eel_noodles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_fried_eel_noodles_1.size();i++)
                        {
                            te02=subtitle_fried_eel_noodles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%B1%94%E9%AD%9A%E6%84%8F%E9%BA%B5?sortby=popular");
                        Document doc_fried_eel_noodles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_eel_noodles_rec = doc_fried_eel_noodles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_fried_eel_noodles_rec.size();i++)
                        {
                            te01=subtitle_fried_eel_noodles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "fried_instant_noodles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341342");
                        Document doc_fried_instant_noodles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_instant_noodles = doc_fried_instant_noodles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_fried_instant_noodles.size();i++)
                        {
                            te02=subtitle_fried_instant_noodles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_fried_instant_noodles_1 = doc_fried_instant_noodles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_fried_instant_noodles_1.size();i++)
                        {
                            te02=subtitle_fried_instant_noodles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%82%92%E6%B3%A1%E9%BA%B5?sortby=popular");
                        Document doc_fried_instant_noodles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_instant_noodles_rec = doc_fried_instant_noodles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_fried_instant_noodles_rec.size();i++)
                        {
                            te01=subtitle_fried_instant_noodles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "fried_rice" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341216");
                        Document doc_fried_rice = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_rice = doc_fried_rice.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_fried_rice.size();i++)
                        {
                            te02=subtitle_fried_rice.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_fried_rice_1 = doc_fried_rice.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_fried_rice_1.size();i++)
                        {
                            te02=subtitle_fried_rice_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%82%92%E9%A3%AF?sortby=popular");
                        Document doc_fried_rice_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_rice_rec = doc_fried_rice_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_fried_rice_rec.size();i++)
                        {
                            te01=subtitle_fried_rice_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "fried_rice_noodles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342066");
                        Document doc_fried_rice_noodles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_rice_noodles = doc_fried_rice_noodles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_fried_rice_noodles.size();i++)
                        {
                            te02=subtitle_fried_rice_noodles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_fried_rice_noodles_1 = doc_fried_rice_noodles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_fried_rice_noodles_1.size();i++)
                        {
                            te02=subtitle_fried_rice_noodles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%82%92%E7%B1%B3%E7%B2%89?sortby=popular");
                        Document doc_fried_rice_noodles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_rice_noodles_rec = doc_fried_rice_noodles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_fried_rice_noodles_rec.size();i++)
                        {
                            te01=subtitle_fried_rice_noodles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "fried-spanish_mackerel_thick_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/333196");
                        Document doc_fried_spanish_mackerel_thick_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_spanish_mackerel_thick_soup = doc_fried_spanish_mackerel_thick_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_fried_spanish_mackerel_thick_soup.size();i++)
                        {
                            te02=subtitle_fried_spanish_mackerel_thick_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_fried_spanish_mackerel_thick_soup_1 = doc_fried_spanish_mackerel_thick_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_fried_spanish_mackerel_thick_soup_1.size();i++)
                        {
                            te02=subtitle_fried_spanish_mackerel_thick_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%9C%9F%E6%89%98%E9%AD%9A%E7%BE%B9?sortby=popular");
                        Document doc_fried_spanish_mackerel_thick_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_fried_spanish_mackerel_thick_soup_rec = doc_fried_spanish_mackerel_thick_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_fried_spanish_mackerel_thick_soup_rec.size();i++)
                        {
                            te01=subtitle_fried_spanish_mackerel_thick_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "garlic_bread" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/278100");
                        Document doc_garlic_bread = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_garlic_bread = doc_garlic_bread.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_garlic_bread.size();i++)
                        {
                            te02=subtitle_garlic_bread.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_garlic_bread_1 = doc_garlic_bread.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_garlic_bread_1.size();i++)
                        {
                            te02=subtitle_garlic_bread_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%92%9C%E9%A6%99%E9%BA%B5%E5%8C%85?sortby=popular");
                        Document doc_garlic_bread_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_garlic_bread_rec = doc_garlic_bread_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_garlic_bread_rec.size();i++)
                        {
                            te01=subtitle_garlic_bread_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "ginger_duck_stew" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/286063");
                        Document doc_ginger_duck_stew = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ginger_duck_stew = doc_ginger_duck_stew.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_ginger_duck_stew.size();i++)
                        {
                            te02=subtitle_ginger_duck_stew.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_ginger_duck_stew_1 = doc_ginger_duck_stew.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_ginger_duck_stew_1.size();i++)
                        {
                            te02=subtitle_ginger_duck_stew_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%96%91%E6%AF%8D%E9%B4%A8?sortby=popular");
                        Document doc_ginger_duck_stew_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ginger_duck_stew_rec = doc_ginger_duck_stew_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_ginger_duck_stew_rec.size();i++)
                        {
                            te01=subtitle_ginger_duck_stew_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "gnocchi" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/209368");
                        Document doc_gnocchi = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_gnocchi = doc_gnocchi.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_gnocchi.size();i++)
                        {
                            te02=subtitle_gnocchi.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_gnocchi_1 = doc_gnocchi.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_gnocchi_1.size();i++)
                        {
                            te02=subtitle_gnocchi_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%A9%E5%A4%A7%E5%88%A9%E9%BA%B5%E7%96%99%E7%98%A9?sortby=popular");
                        Document doc_gnocchi_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_gnocchi_rec = doc_gnocchi_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_gnocchi_rec.size();i++)
                        {
                            te01=subtitle_gnocchi_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "grilled_cheese_sandwich" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/147988");
                    Document doc_grilled_cheese_sandwich = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_grilled_cheese_sandwich = doc_grilled_cheese_sandwich.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_grilled_cheese_sandwich.size();i++)
                    {
                        te02=subtitle_grilled_cheese_sandwich.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_grilled_cheese_sandwich_1 = doc_grilled_cheese_sandwich.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_grilled_cheese_sandwich_1.size();i++)
                    {
                        te02=subtitle_grilled_cheese_sandwich_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E7%83%A4%E8%B5%B7%E5%8F%B8%E4%B8%89%E6%98%8E%E6%B2%BB?sortby=popular");
                    Document doc_grilled_cheese_sandwich_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_grilled_cheese_sandwich_rec = doc_grilled_cheese_sandwich_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_grilled_cheese_sandwich_rec.size();i++)
                    {
                        te01=subtitle_grilled_cheese_sandwich_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "grilled_corn" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/319792");
                        Document doc_grilled_corn = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_grilled_corn = doc_grilled_corn.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_grilled_corn.size();i++)
                        {
                            te02=subtitle_grilled_corn.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_grilled_corn_1 = doc_grilled_corn.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_grilled_corn_1.size();i++)
                        {
                            te02=subtitle_grilled_corn_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%83%A4%E7%8E%89%E7%B1%B3?sortby=popular");
                        Document doc_grilled_corn_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_grilled_corn_rec = doc_grilled_corn_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_grilled_corn_rec.size();i++)
                        {
                            te01=subtitle_grilled_corn_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "grilled_salmon" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341594");
                        Document doc_grilled_salmon = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_grilled_salmon = doc_grilled_salmon.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_grilled_salmon.size();i++)
                        {
                            te02=subtitle_grilled_salmon.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_grilled_salmon_1 = doc_grilled_salmon.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_grilled_salmon_1.size();i++)
                        {
                            te02=subtitle_grilled_salmon_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%AE%AD%E9%AD%9A%E6%8E%92?sortby=popular");
                        Document doc_grilled_salmon_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_grilled_salmon_rec = doc_grilled_salmon_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_grilled_salmon_rec.size();i++)
                        {
                            te01=subtitle_grilled_salmon_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "grilled_taiwanese_sausage" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/331446");
                        Document doc_grilled_taiwanese_sausage = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_grilled_taiwanese_sausage = doc_grilled_taiwanese_sausage.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_grilled_taiwanese_sausage.size();i++)
                        {
                            te02=subtitle_grilled_taiwanese_sausage.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_grilled_taiwanese_sausage_1 = doc_grilled_taiwanese_sausage.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_grilled_taiwanese_sausage_1.size();i++)
                        {
                            te02=subtitle_grilled_taiwanese_sausage_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%83%A4%E9%A6%99%E8%85%B8?sortby=popular");
                        Document doc_grilled_taiwanese_sausage_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_grilled_taiwanese_sausage_rec = doc_grilled_taiwanese_sausage_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_grilled_taiwanese_sausage_rec.size();i++)
                        {
                            te01=subtitle_grilled_taiwanese_sausage_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "gyoza" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/263103");
                        Document doc_gyoza = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_gyoza = doc_gyoza.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_gyoza.size();i++)
                        {
                            te02=subtitle_gyoza.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_gyoza_1 = doc_gyoza.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_gyoza_1.size();i++)
                        {
                            te02=subtitle_gyoza_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%A4%83%E5%AD%90?sortby=popular");
                        Document doc_gyoza_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_gyoza_rec = doc_gyoza_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_gyoza_rec.size();i++)
                        {
                            te01=subtitle_gyoza_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "hakka_stir-fried" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/329366");
                        Document doc_hakka_stir_fried = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hakka_stir_fried = doc_hakka_stir_fried.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_hakka_stir_fried.size();i++)
                        {
                            te02=subtitle_hakka_stir_fried.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_hakka_stir_fried_1 = doc_hakka_stir_fried.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_hakka_stir_fried_1.size();i++)
                        {
                            te02=subtitle_hakka_stir_fried_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%AE%A2%E5%AE%B6%E5%B0%8F%E7%82%92?sortby=popular");
                        Document doc_hakka_stir_fried_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hakka_stir_fried_rec = doc_hakka_stir_fried_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_hakka_stir_fried_rec.size();i++)
                        {
                            te01=subtitle_hakka_stir_fried_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "hamburger" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335270");
                        Document doc_hamburger = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hamburger = doc_hamburger.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_hamburger.size();i++)
                        {
                            te02=subtitle_hamburger.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_hamburger_1 = doc_hamburger.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_hamburger_1.size();i++)
                        {
                            te02=subtitle_hamburger_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%8E%E5%BC%8F%E6%BC%A2%E5%A0%A1?sortby=popular");
                        Document doc_hamburger_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hamburger_rec = doc_hamburger_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_hamburger_rec.size();i++)
                        {
                            te01=subtitle_hamburger_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "hot_and_sour_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335195");
                        Document doc_hot_and_sour_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hot_and_sour_soup = doc_hot_and_sour_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_hot_and_sour_soup.size();i++)
                        {
                            te02=subtitle_hot_and_sour_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_hot_and_sour_soup_1 = doc_hot_and_sour_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_hot_and_sour_soup_1.size();i++)
                        {
                            te02=subtitle_hot_and_sour_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%85%B8%E8%BE%A3%E6%B9%AF?sortby=popular");
                        Document doc_hot_and_sour_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hot_and_sour_soup_rec = doc_hot_and_sour_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_hot_and_sour_soup_rec.size();i++)
                        {
                            te01=subtitle_hot_and_sour_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "hot_dog" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/125185");
                        Document doc_hot_dog = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hot_dog = doc_hot_dog.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_hot_dog.size();i++)
                        {
                            te02=subtitle_hot_dog.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_hot_dog_1 = doc_hot_dog.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_hot_dog_1.size();i++)
                        {
                            te02=subtitle_hot_dog_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%86%B1%E7%8B%97%E5%A0%A1?sortby=popular");
                        Document doc_hot_dog_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hot_dog_rec = doc_hot_dog_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_hot_dog_rec.size();i++)
                        {
                            te01=subtitle_hot_dog_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "hot_sour_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337149");
                        Document doc_hot_sour_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hot_sour_soup = doc_hot_sour_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_hot_sour_soup.size();i++)
                        {
                            te02=subtitle_hot_sour_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_hot_sour_soup_1 = doc_hot_sour_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_hot_sour_soup_1.size();i++)
                        {
                            te02=subtitle_hot_sour_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%85%B8%E8%BE%A3%E6%B9%AF?sortby=popular");
                        Document doc_hot_sour_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hot_sour_soup_rec = doc_hot_sour_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_hot_sour_soup_rec.size();i++)
                        {
                            te01=subtitle_hot_sour_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "hummus" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/322601");
                        Document doc_hummus = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hummus = doc_hummus.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_hummus.size();i++)
                        {
                            te02=subtitle_hummus.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_hummus_1 = doc_hummus.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_hummus_1.size();i++)
                        {
                            te02=subtitle_hummus_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%B7%B9%E5%98%B4%E8%B1%86%E6%B3%A5?sortby=popular");
                        Document doc_hummus_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hummus_rec = doc_hummus_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_hummus_rec.size();i++)
                        {
                            te01=subtitle_hummus_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "hung_rui_chen_sandwich" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/331262");
                        Document doc_hung_rui_chen_sandwich = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hung_rui_chen_sandwich = doc_hung_rui_chen_sandwich.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_hung_rui_chen_sandwich.size();i++)
                        {
                            te02=subtitle_hung_rui_chen_sandwich.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_hung_rui_chen_sandwich_1 = doc_hung_rui_chen_sandwich.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_hung_rui_chen_sandwich_1.size();i++)
                        {
                            te02=subtitle_hung_rui_chen_sandwich_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B4%AA%E7%91%9E%E7%8F%8D%E4%B8%89%E6%98%8E%E6%B2%BB?sortby=popular");
                        Document doc_hung_rui_chen_sandwich_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_hung_rui_chen_sandwich_rec = doc_hung_rui_chen_sandwich_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_hung_rui_chen_sandwich_rec.size();i++)
                        {
                            te01=subtitle_hung_rui_chen_sandwich_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "ice_cream" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342054");
                        Document doc_ice_cream = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ice_cream = doc_ice_cream.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_ice_cream.size();i++)
                        {
                            te02=subtitle_ice_cream.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_ice_cream_1 = doc_ice_cream.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_ice_cream_1.size();i++)
                        {
                            te02=subtitle_ice_cream_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%86%B0%E6%B7%87%E6%B7%8B?sortby=popular");
                        Document doc_ice_cream_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ice_cream_rec = doc_ice_cream_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_ice_cream_rec.size();i++)
                        {
                            te01=subtitle_ice_cream_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "intestine_and_oyster_vermicelli" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/338356");
                        Document doc_intestine_and_oyster_vermicelli = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_intestine_and_oyster_vermicelli = doc_intestine_and_oyster_vermicelli.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_intestine_and_oyster_vermicelli.size();i++)
                        {
                            te02=subtitle_intestine_and_oyster_vermicelli.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_intestine_and_oyster_vermicelli_1 = doc_intestine_and_oyster_vermicelli.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_intestine_and_oyster_vermicelli_1.size();i++)
                        {
                            te02=subtitle_intestine_and_oyster_vermicelli_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%A4%A7%E8%85%B8%E8%9A%B5%E4%BB%94%E9%BA%B5%E7%B7%9A?sortby=popular");
                        Document doc_intestine_and_oyster_vermicelli_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_intestine_and_oyster_vermicelli_rec = doc_intestine_and_oyster_vermicelli_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_intestine_and_oyster_vermicelli_rec.size();i++)
                        {
                            te01=subtitle_intestine_and_oyster_vermicelli_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "iron_egg" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/319561");
                        Document doc_iron_egg = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_iron_egg = doc_iron_egg.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_iron_egg.size();i++)
                        {
                            te02=subtitle_iron_egg.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_iron_egg_1 = doc_iron_egg.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_iron_egg_1.size();i++)
                        {
                            te02=subtitle_iron_egg_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%90%B5%E8%9B%8B?sortby=popular");
                        Document doc_iron_egg_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_iron_egg_rec = doc_iron_egg_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_iron_egg_rec.size();i++)
                        {
                            te01=subtitle_iron_egg_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "jelly_of_gravey_and_chicken_feet_skin" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/278302");
                        Document doc_jelly_of_gravey_and_chicken_feet_skin = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_jelly_of_gravey_and_chicken_feet_skin = doc_jelly_of_gravey_and_chicken_feet_skin.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_jelly_of_gravey_and_chicken_feet_skin.size();i++)
                        {
                            te02=subtitle_jelly_of_gravey_and_chicken_feet_skin.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_jelly_of_gravey_and_chicken_feet_skin_1 = doc_jelly_of_gravey_and_chicken_feet_skin.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_jelly_of_gravey_and_chicken_feet_skin_1.size();i++)
                        {
                            te02=subtitle_jelly_of_gravey_and_chicken_feet_skin_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%9B%9E%E8%85%B3%E5%87%8D?sortby=popular");
                        Document doc_jelly_of_gravey_and_chicken_feet_skin_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_jelly_of_gravey_and_chicken_feet_skin_rec = doc_jelly_of_gravey_and_chicken_feet_skin_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_jelly_of_gravey_and_chicken_feet_skin_rec.size();i++)
                        {
                            te01=subtitle_jelly_of_gravey_and_chicken_feet_skin_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "jerky" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/330693");
                        Document doc_jerky = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_jerky = doc_jerky.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_jerky.size();i++)
                        {
                            te02=subtitle_jerky.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_jerky_1 = doc_jerky.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_jerky_1.size();i++)
                        {
                            te02=subtitle_jerky_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%82%89%E4%B9%BE?sortby=popular");
                        Document doc_jerky_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_jerky_rec = doc_jerky_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_jerky_rec.size();i++)
                        {
                            te01=subtitle_jerky_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "kung-pao_chicken" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335839");
                        Document doc_kung_pao_chicken = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_kung_pao_chicken = doc_kung_pao_chicken.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_kung_pao_chicken.size();i++)
                        {
                            te02=subtitle_kung_pao_chicken.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_kung_pao_chicken_1 = doc_kung_pao_chicken.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_kung_pao_chicken_1.size();i++)
                        {
                            te02=subtitle_kung_pao_chicken_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%AE%AE%E4%BF%9D%E9%9B%9E%E4%B8%81?sortby=popular");
                        Document doc_kung_pao_chicken_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_kung_pao_chicken_rec = doc_kung_pao_chicken_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_kung_pao_chicken_rec.size();i++)
                        {
                            te01=subtitle_kung_pao_chicken_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "lasagna" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/338393");
                        Document doc_lasagna = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_lasagna = doc_lasagna.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_lasagna.size();i++)
                        {
                            te02=subtitle_lasagna.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_lasagna_1 = doc_lasagna.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_lasagna_1.size();i++)
                        {
                            te02=subtitle_lasagna_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%8D%83%E5%B1%A4%E9%BA%B5?sortby=popular");
                        Document doc_lasagna_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_lasagna_rec = doc_lasagna_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_lasagna_rec.size();i++)
                        {
                            te01=subtitle_lasagna_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "lobster_bisque" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/232052");
                        Document doc_lobster_bisque = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_lobster_bisque = doc_lobster_bisque.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_lobster_bisque.size();i++)
                        {
                            te02=subtitle_lobster_bisque.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_lobster_bisque_1 = doc_lobster_bisque.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_lobster_bisque_1.size();i++)
                        {
                            te02=subtitle_lobster_bisque_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%BE%8D%E8%9D%A6%E6%BF%83%E6%B9%AF?sortby=popular");
                        Document doc_lobster_bisque_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_lobster_bisque_rec = doc_lobster_bisque_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_lobster_bisque_rec.size();i++)
                        {
                            te01=subtitle_lobster_bisque_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "lobster_roll_sandwich" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/247765");
                        Document doc_lobster_roll_sandwich = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_lobster_roll_sandwich = doc_lobster_roll_sandwich.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_lobster_roll_sandwich.size();i++)
                        {
                            te02=subtitle_lobster_roll_sandwich.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_lobster_roll_sandwich_1 = doc_lobster_roll_sandwich.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_lobster_roll_sandwich_1.size();i++)
                        {
                            te02=subtitle_lobster_roll_sandwich_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%BE%8D%E8%9D%A6%E5%A0%A1?sortby=popular");
                        Document doc_lobster_roll_sandwich_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_lobster_roll_sandwich_rec = doc_lobster_roll_sandwich_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_lobster_roll_sandwich_rec.size();i++)
                        {
                            te01=subtitle_lobster_roll_sandwich_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "luwei" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/327886");
                        Document doc_luwei = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_luwei = doc_luwei.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_luwei.size();i++)
                        {
                            te02=subtitle_luwei.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_luwei_1 = doc_luwei.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_luwei_1.size();i++)
                        {
                            te02=subtitle_luwei_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%BB%B7%E5%91%B3?sortby=popular");
                        Document doc_luwei_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_luwei_rec = doc_luwei_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_luwei_rec.size();i++)
                        {
                            te01=subtitle_luwei_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "macaroni_and_cheese" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/325650");
                        Document doc_macaroni_and_cheese = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_macaroni_and_cheese = doc_macaroni_and_cheese.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_macaroni_and_cheese.size();i++)
                        {
                            te02=subtitle_macaroni_and_cheese.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_macaroni_and_cheese_1 = doc_macaroni_and_cheese.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_macaroni_and_cheese_1.size();i++)
                        {
                            te02=subtitle_macaroni_and_cheese_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%80%9A%E5%BF%83%E7%B2%89?sortby=popular");
                        Document doc_macaroni_and_cheese_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_macaroni_and_cheese_rec = doc_macaroni_and_cheese_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_macaroni_and_cheese_rec.size();i++)
                        {
                            te01=subtitle_macaroni_and_cheese_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "macarons" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340831");
                        Document doc_macarons = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_macarons = doc_macarons.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_macarons.size();i++)
                        {
                            te02=subtitle_macarons.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_macarons_1 = doc_macarons.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_macarons_1.size();i++)
                        {
                            te02=subtitle_macarons_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%A6%AC%E5%8D%A1%E9%BE%8D?sortby=popular");
                        Document doc_macarons_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_macarons_rec = doc_macarons_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_macarons_rec.size();i++)
                        {
                            te01=subtitle_macarons_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "mango_shaved_ice" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342489");
                        Document doc_mango_shaved_ice = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mango_shaved_ice = doc_mango_shaved_ice.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_mango_shaved_ice.size();i++)
                        {
                            te02=subtitle_mango_shaved_ice.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_mango_shaved_ice_1 = doc_mango_shaved_ice.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_mango_shaved_ice_1.size();i++)
                        {
                            te02=subtitle_mango_shaved_ice_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%8A%92%E6%9E%9C%E5%86%B0?sortby=popular");
                        Document doc_mango_shaved_ice_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mango_shaved_ice_rec = doc_mango_shaved_ice_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_mango_shaved_ice_rec.size();i++)
                        {
                            te01=subtitle_mango_shaved_ice_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "meat_dumpling_in_chili_oil" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341824");
                        Document doc_meat_dumpling_in_chili_oil = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_meat_dumpling_in_chili_oil = doc_meat_dumpling_in_chili_oil.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_meat_dumpling_in_chili_oil.size();i++)
                        {
                            te02=subtitle_meat_dumpling_in_chili_oil.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_meat_dumpling_in_chili_oil_1 = doc_meat_dumpling_in_chili_oil.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_meat_dumpling_in_chili_oil_1.size();i++)
                        {
                            te02=subtitle_meat_dumpling_in_chili_oil_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%B4%85%E6%B2%B9%E6%8A%84%E6%89%8B?sortby=popular");
                        Document doc_meat_dumpling_in_chili_oil_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_meat_dumpling_in_chili_oil_rec = doc_meat_dumpling_in_chili_oil_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_meat_dumpling_in_chili_oil_rec.size();i++)
                        {
                            te01=subtitle_meat_dumpling_in_chili_oil_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "milkfish_belly_congee" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/257370");
                        Document doc_milkfish_belly_congee = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_milkfish_belly_congee = doc_milkfish_belly_congee.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_milkfish_belly_congee.size();i++)
                        {
                            te02=subtitle_milkfish_belly_congee.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_milkfish_belly_congee_1 = doc_milkfish_belly_congee.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_milkfish_belly_congee_1.size();i++)
                        {
                            te02=subtitle_milkfish_belly_congee_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%99%B1%E7%9B%AE%E9%AD%9A%E7%B2%A5?sortby=popular");
                        Document doc_milkfish_belly_congee_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_milkfish_belly_congee_rec = doc_milkfish_belly_congee_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_milkfish_belly_congee_rec.size();i++)
                        {
                            te01=subtitle_milkfish_belly_congee_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "miso_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341971");
                        Document doc_miso_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_miso_soup = doc_miso_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_miso_soup.size();i++)
                        {
                            te02=subtitle_miso_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_miso_soup_1 = doc_miso_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_miso_soup_1.size();i++)
                        {
                            te02=subtitle_miso_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%91%B3%E5%99%8C%E6%B9%AF?sortby=popular");
                        Document doc_miso_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_miso_soup_rec = doc_miso_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_miso_soup_rec.size();i++)
                        {
                            te01=subtitle_miso_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "mochi" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335764");
                        Document doc_mochi = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mochi = doc_mochi.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_mochi.size();i++)
                        {
                            te02=subtitle_mochi.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_mochi_1 = doc_mochi.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_mochi_1.size();i++)
                        {
                            te02=subtitle_mochi_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%BA%BB%E7%B3%AC?sortby=popular");
                        Document doc_mochi_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mochi_rec = doc_mochi_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_mochi_rec.size();i++)
                        {
                            te01=subtitle_mochi_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "mung_bean_smoothie_milk" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/170562");
                        Document doc_mung_bean_smoothie_milk = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mung_bean_smoothie_milk = doc_mung_bean_smoothie_milk.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_mung_bean_smoothie_milk.size();i++)
                        {
                            te02=subtitle_mung_bean_smoothie_milk.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_mung_bean_smoothie_milk_1 = doc_mung_bean_smoothie_milk.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_mung_bean_smoothie_milk_1.size();i++)
                        {
                            te02=subtitle_mung_bean_smoothie_milk_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%B6%A0%E8%B1%86%E6%B2%99%E7%89%9B%E5%A5%B6?sortby=popular");
                        Document doc_mung_bean_smoothie_milk_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mung_bean_smoothie_milk_rec = doc_mung_bean_smoothie_milk_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_mung_bean_smoothie_milk_rec.size();i++)
                        {
                            te01=subtitle_mung_bean_smoothie_milk_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "mussels" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/307044");
                        Document doc_mussels = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mussels = doc_mussels.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_mussels.size();i++)
                        {
                            te02=subtitle_mussels.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_mussels_1 = doc_mussels.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_mussels_1.size();i++)
                        {
                            te02=subtitle_mussels_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B7%A1%E8%8F%9C%E6%96%99%E7%90%86?sortby=popular");
                        Document doc_mussels_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mussels_rec = doc_mussels_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_mussels_rec.size();i++)
                        {
                            te01=subtitle_mussels_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "mutton_fried_noodles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/176823");
                        Document doc_mutton_fried_noodles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mutton_fried_noodles = doc_mutton_fried_noodles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_mutton_fried_noodles.size();i++)
                        {
                            te02=subtitle_mutton_fried_noodles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_mutton_fried_noodles_1 = doc_mutton_fried_noodles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_mutton_fried_noodles_1.size();i++)
                        {
                            te02=subtitle_mutton_fried_noodles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%8A%E8%82%89%E7%82%92%E9%BA%B5?sortby=popular");
                        Document doc_mutton_fried_noodles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mutton_fried_noodles_rec = doc_mutton_fried_noodles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_mutton_fried_noodles_rec.size();i++)
                        {
                            te01=subtitle_mutton_fried_noodles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "mutton_hot_pot" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/286628");
                        Document doc_mutton_hot_pot = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mutton_hot_pot = doc_mutton_hot_pot.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_mutton_hot_pot.size();i++)
                        {
                            te02=subtitle_mutton_hot_pot.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_mutton_hot_pot_1 = doc_mutton_hot_pot.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_mutton_hot_pot_1.size();i++)
                        {
                            te02=subtitle_mutton_hot_pot_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%8A%E8%82%89%E7%88%90?sortby=popular");
                        Document doc_mutton_hot_pot_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_mutton_hot_pot_rec = doc_mutton_hot_pot_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_mutton_hot_pot_rec.size();i++)
                        {
                            te01=subtitle_mutton_hot_pot_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "nabeyaki_egg_noodles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/315742");
                        Document doc_nabeyaki_egg_noodles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_nabeyaki_egg_noodles = doc_nabeyaki_egg_noodles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_nabeyaki_egg_noodles.size();i++)
                        {
                            te02=subtitle_nabeyaki_egg_noodles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_nabeyaki_egg_noodles_1 = doc_nabeyaki_egg_noodles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_nabeyaki_egg_noodles_1.size();i++)
                        {
                            te02=subtitle_nabeyaki_egg_noodles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%8D%8B%E7%87%92%E6%84%8F%E9%BA%B5?sortby=popular");
                        Document doc_nabeyaki_egg_noodles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_nabeyaki_egg_noodles_rec = doc_nabeyaki_egg_noodles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_nabeyaki_egg_noodles_rec.size();i++)
                        {
                            te01=subtitle_nabeyaki_egg_noodles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "night_market_steak" :
                        //recipe
                        url = new URL("https://www.how-living.com/p/18148/%E5%A4%9C%E5%B8%82%E9%90%B5%E6%9D%BF%E7%89%9B%E6%8E%92");
                        Document doc_night_market_steak = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_night_market_steak = doc_night_market_steak.select("div.recipe-content-text p");
                        for(int i=1;i<subtitle_night_market_steak.size();i++)
                        {
                            te02=subtitle_night_market_steak.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%A4%9C%E5%B8%82%E7%89%9B%E6%8E%92?sortby=popular");
                        Document doc_night_market_steak_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_night_market_steak_rec = doc_night_market_steak_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_night_market_steak_rec.size();i++)
                        {
                            te01=subtitle_night_market_steak_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "nougat" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340267");
                        Document doc_nougat = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_nougat = doc_nougat.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_nougat.size();i++)
                        {
                            te02=subtitle_nougat.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_nougat_1 = doc_nougat.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_nougat_1.size();i++)
                        {
                            te02=subtitle_nougat_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%89%9B%E8%BB%8B%E7%B3%96?sortby=popular");
                        Document doc_nougat_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_nougat_rec = doc_nougat_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_nougat_rec.size();i++)
                        {
                            te01=subtitle_nougat_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "omelette" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/309477");
                        Document doc_omelette = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_omelette = doc_omelette.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_omelette.size();i++)
                        {
                            te02=subtitle_omelette.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_omelette_1 = doc_omelette.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_omelette_1.size();i++)
                        {
                            te02=subtitle_omelette_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%AD%90%E5%A7%86%E8%9B%8B?sortby=popular");
                        Document doc_omelette_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_omelette_rec = doc_omelette_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_omelette_rec.size();i++)
                        {
                            te01=subtitle_omelette_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "onion_rings" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/338993");
                        Document doc_onion_rings = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_onion_rings = doc_onion_rings.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_onion_rings.size();i++)
                        {
                            te02=subtitle_onion_rings.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_onion_rings_1 = doc_onion_rings.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_onion_rings_1.size();i++)
                        {
                            te02=subtitle_onion_rings_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%82%B8%E6%B4%8B%E8%94%A5%E5%9C%88?sortby=popular");
                        Document doc_onion_rings_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_onion_rings_rec = doc_onion_rings_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_onion_rings_rec.size();i++)
                        {
                            te01=subtitle_onion_rings_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "oyster_fritter" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340950");
                        Document doc_oyster_fritter = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_oyster_fritter = doc_oyster_fritter.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_oyster_fritter.size();i++)
                        {
                            te02=subtitle_oyster_fritter.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_oyster_fritter_1 = doc_oyster_fritter.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_oyster_fritter_1.size();i++)
                        {
                            te02=subtitle_oyster_fritter_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%9A%B5%E5%97%B2?sortby=popular");
                        Document doc_oyster_fritter_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_oyster_fritter_rec = doc_oyster_fritter_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_oyster_fritter_rec.size();i++)
                        {
                            te01=subtitle_oyster_fritter_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "oyster_omelet" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340570");
                        Document doc_oyster_omelet = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_oyster_omelet = doc_oyster_omelet.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_oyster_omelet.size();i++)
                        {
                            te02=subtitle_oyster_omelet.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_oyster_omelet_1 = doc_oyster_omelet.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_oyster_omelet_1.size();i++)
                        {
                            te02=subtitle_oyster_omelet_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%9A%B5%E4%BB%94%E7%85%8E?sortby=popular");
                        Document doc_oyster_omelet_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_oyster_omelet_rec = doc_oyster_omelet_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_oyster_omelet_rec.size();i++)
                        {
                            te01=subtitle_oyster_omelet_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "oysters" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/56649");
                        Document doc_oysters = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_oysters = doc_oysters.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_oysters.size();i++)
                        {
                            te02=subtitle_oysters.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_oysters_1 = doc_oysters.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_oysters_1.size();i++)
                        {
                            te02=subtitle_oysters_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%94%9F%E8%A0%94?sortby=popular");
                        Document doc_oysters_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_oysters_rec = doc_oysters_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_oysters_rec.size();i++)
                        {
                            te01=subtitle_oysters_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pad_thai" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/329236");
                        Document doc_pad_thai = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pad_thai = doc_pad_thai.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pad_thai.size();i++)
                        {
                            te02=subtitle_pad_thai.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pad_thai_1 = doc_pad_thai.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pad_thai_1.size();i++)
                        {
                            te02=subtitle_pad_thai_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B3%B0%E5%BC%8F%E7%82%92%E6%B2%B3%E7%B2%89?sortby=popular");
                        Document doc_pad_thai_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pad_thai_rec = doc_pad_thai_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pad_thai_rec.size();i++)
                        {
                            te01=subtitle_pad_thai_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "paella" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/338388");
                        Document doc_paella = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_paella = doc_paella.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_paella.size();i++)
                        {
                            te02=subtitle_paella.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_paella_1 = doc_paella.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_paella_1.size();i++)
                        {
                            te02=subtitle_paella_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%A5%BF%E7%8F%AD%E7%89%99%E6%B5%B7%E9%AE%AE%E9%A3%AF?sortby=popular");
                        Document doc_paella_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_paella_rec = doc_paella_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_paella_rec.size();i++)
                        {
                            te01=subtitle_paella_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pancakes" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/336788");
                        Document doc_pancakes = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pancakes = doc_pancakes.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pancakes.size();i++)
                        {
                            te02=subtitle_pancakes.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pancakes_1 = doc_pancakes.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pancakes_1.size();i++)
                        {
                            te02=subtitle_pancakes_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%AC%86%E9%A4%85?sortby=popular");
                        Document doc_pancakes_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pancakes_rec = doc_pancakes_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pancakes_rec.size();i++)
                        {
                            te01=subtitle_pancakes_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "panna_cotta" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/332551");
                        Document doc_panna_cotta = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_panna_cotta = doc_panna_cotta.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_panna_cotta.size();i++)
                        {
                            te02=subtitle_panna_cotta.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_panna_cotta_1 = doc_panna_cotta.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_panna_cotta_1.size();i++)
                        {
                            te02=subtitle_panna_cotta_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%A9%E5%BC%8F%E5%A5%B6%E9%85%AA?sortby=popular");
                        Document doc_panna_cotta_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_panna_cotta_rec = doc_panna_cotta_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_panna_cotta_rec.size();i++)
                        {
                            te01=subtitle_panna_cotta_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "papaya_milk" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/331460");
                        Document doc_papaya_milk = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_papaya_milk = doc_papaya_milk.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_papaya_milk.size();i++)
                        {
                            te02=subtitle_papaya_milk.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_papaya_milk_1 = doc_papaya_milk.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_papaya_milk_1.size();i++)
                        {
                            te02=subtitle_papaya_milk_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%9C%A8%E7%93%9C%E7%89%9B%E5%A5%B6?sortby=popular");
                        Document doc_papaya_milk_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_papaya_milk_rec = doc_papaya_milk_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_papaya_milk_rec.size();i++)
                        {
                            te01=subtitle_papaya_milk_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "peanut_brittle" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/320194");
                        Document doc_peanut_brittle = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_peanut_brittle = doc_peanut_brittle.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_peanut_brittle.size();i++)
                        {
                            te02=subtitle_peanut_brittle.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_peanut_brittle_1 = doc_peanut_brittle.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_peanut_brittle_1.size();i++)
                        {
                            te02=subtitle_peanut_brittle_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%8A%B1%E7%94%9F%E7%B3%96?sortby=popular");
                        Document doc_peanut_brittle_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_peanut_brittle_rec = doc_peanut_brittle_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_peanut_brittle_rec.size();i++)
                        {
                            te01=subtitle_peanut_brittle_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "peking_duck" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/182351");
                        Document doc_peking_duck = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_peking_duck = doc_peking_duck.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_peking_duck.size();i++)
                        {
                            te02=subtitle_peking_duck.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_peking_duck_1 = doc_peking_duck.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_peking_duck_1.size();i++)
                        {
                            te02=subtitle_peking_duck_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%8C%97%E4%BA%AC%E7%83%A4%E9%B4%A8?sortby=popular");
                        Document doc_peking_duck_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_peking_duck_rec = doc_peking_duck_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_peking_duck_rec.size();i++)
                        {
                            te01=subtitle_peking_duck_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pepper_pork_bun" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/336012");
                        Document doc_pepper_pork_bun = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pepper_pork_bun = doc_pepper_pork_bun.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pepper_pork_bun.size();i++)
                        {
                            te02=subtitle_pepper_pork_bun.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pepper_pork_bun_1 = doc_pepper_pork_bun.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pepper_pork_bun_1.size();i++)
                        {
                            te02=subtitle_pepper_pork_bun_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%83%A1%E6%A4%92%E9%A4%85?sortby=popular");
                        Document doc_pepper_pork_bun_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pepper_pork_bun_rec = doc_pepper_pork_bun_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pepper_pork_bun_rec.size();i++)
                        {
                            te01=subtitle_pepper_pork_bun_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pho" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337367");
                        Document doc_pho = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pho = doc_pho.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pho.size();i++)
                        {
                            te02=subtitle_pho.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pho_1 = doc_pho.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pho_1.size();i++)
                        {
                            te02=subtitle_pho_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B2%B3%E7%B2%89?sortby=popular");
                        Document doc_pho_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pho_rec = doc_pho_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pho_rec.size();i++)
                        {
                            te01=subtitle_pho_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pig's_blood_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/309536");
                        Document doc_pigs_blood_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pigs_blood_soup = doc_pigs_blood_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pigs_blood_soup.size();i++)
                        {
                            te02=subtitle_pigs_blood_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pigs_blood_soup_1 = doc_pigs_blood_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pigs_blood_soup_1.size();i++)
                        {
                            te02=subtitle_pigs_blood_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%B1%AC%E8%A1%80%E6%B9%AF?sortby=popular");
                        Document doc_pigs_blood_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pigs_blood_soup_rec = doc_pigs_blood_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pigs_blood_soup_rec.size();i++)
                        {
                            te01=subtitle_pigs_blood_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pineapple_cake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341099");
                        Document doc_pineapple_cake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pineapple_cake = doc_pineapple_cake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pineapple_cake.size();i++)
                        {
                            te02=subtitle_pineapple_cake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pineapple_cake_1 = doc_pineapple_cake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pineapple_cake_1.size();i++)
                        {
                            te02=subtitle_pineapple_cake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%B3%B3%E6%A2%A8%E9%85%A5?sortby=popular");
                        Document doc_pineapple_cake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pineapple_cake_rec = doc_pineapple_cake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pineapple_cake_rec.size();i++)
                        {
                            te01=subtitle_pineapple_cake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pizza" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337877");
                        Document doc_pizza = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pizza = doc_pizza.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pizza.size();i++)
                        {
                            te02=subtitle_pizza.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pizza_1 = doc_pizza.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pizza_1.size();i++)
                        {
                            te02=subtitle_pizza_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%8A%AB%E8%96%A9?sortby=popular");
                        Document doc_pizza_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pizza_rec = doc_pizza_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pizza_rec.size();i++)
                        {
                            te01=subtitle_pizza_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pork_chop" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337115");
                        Document doc_pork_chop = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pork_chop = doc_pork_chop.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_pork_chop.size();i++)
                        {
                            te02=subtitle_pork_chop.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_pork_chop_1 = doc_pork_chop.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_pork_chop_1.size();i++)
                        {
                            te02=subtitle_pork_chop_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%85%8E%E8%B1%AC%E6%8E%92?sortby=popular");
                        Document doc_pork_chop_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_pork_chop_rec = doc_pork_chop_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_pork_chop_rec.size();i++)
                        {
                            te01=subtitle_pork_chop_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "pork_intestines_fire_pot" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/339383");
                    Document doc_pork_intestines_fire_pot = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_pork_intestines_fire_pot = doc_pork_intestines_fire_pot.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_pork_intestines_fire_pot.size();i++)
                    {
                        te02=subtitle_pork_intestines_fire_pot.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_pork_intestines_fire_pot_1 = doc_pork_intestines_fire_pot.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_pork_intestines_fire_pot_1.size();i++)
                    {
                        te02=subtitle_pork_intestines_fire_pot_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E4%BA%94%E6%9B%B4%E8%85%B8%E6%97%BA?sortby=popular");
                    Document doc_pork_intestines_fire_pot_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_pork_intestines_fire_pot_rec = doc_pork_intestines_fire_pot_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_pork_intestines_fire_pot_rec.size();i++)
                    {
                        te01=subtitle_pork_intestines_fire_pot_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "potsticker" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337580");
                        Document doc_potsticker = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_potsticker = doc_potsticker.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_potsticker.size();i++)
                        {
                            te02=subtitle_potsticker.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_potsticker_1 = doc_potsticker.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_potsticker_1.size();i++)
                        {
                            te02=subtitle_potsticker_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%8D%8B%E8%B2%BC?sortby=popular");
                        Document doc_potsticker_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_potsticker_rec = doc_potsticker_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_potsticker_rec.size();i++)
                        {
                            te01=subtitle_potsticker_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "poutine" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/121053");
                        Document doc_poutine = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_poutine = doc_poutine.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_poutine.size();i++)
                        {
                            te02=subtitle_poutine.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_poutine_1 = doc_poutine.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_poutine_1.size();i++)
                        {
                            te02=subtitle_poutine_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/Poutine?sortby=popular");
                        Document doc_poutine_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_poutine_rec = doc_poutine_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_poutine_rec.size();i++)
                        {
                            te01=subtitle_poutine_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "preserved_egg_tofu" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342011");
                        Document doc_preserved_egg_tofu = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_preserved_egg_tofu = doc_preserved_egg_tofu.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_preserved_egg_tofu.size();i++)
                        {
                            te02=subtitle_preserved_egg_tofu.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_preserved_egg_tofu_1 = doc_preserved_egg_tofu.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_preserved_egg_tofu_1.size();i++)
                        {
                            te02=subtitle_preserved_egg_tofu_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%9A%AE%E8%9B%8B%E8%B1%86%E8%85%90?sortby=popular");
                        Document doc_preserved_egg_tofu_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_preserved_egg_tofu_rec = doc_preserved_egg_tofu_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_preserved_egg_tofu_rec.size();i++)
                        {
                            te01=subtitle_preserved_egg_tofu_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "prime_rib" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/315975");
                        Document doc_prime_rib = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_prime_rib = doc_prime_rib.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_prime_rib.size();i++)
                        {
                            te02=subtitle_prime_rib.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_prime_rib_1 = doc_prime_rib.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_prime_rib_1.size();i++)
                        {
                            te02=subtitle_prime_rib_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%82%8B%E7%9C%BC%E7%89%9B%E6%8E%92?sortby=popular");
                        Document doc_prime_rib_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_prime_rib_rec = doc_prime_rib_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_prime_rib_rec.size();i++)
                        {
                            te01=subtitle_prime_rib_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "ramen" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/287747");
                        Document doc_ramen = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ramen = doc_ramen.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_ramen.size();i++)
                        {
                            te02=subtitle_ramen.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_ramen_1 = doc_ramen.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_ramen_1.size();i++)
                        {
                            te02=subtitle_ramen_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%8B%89%E9%BA%B5?sortby=popular");
                        Document doc_ramen_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ramen_rec = doc_ramen_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_ramen_rec.size();i++)
                        {
                            te01=subtitle_ramen_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "ravioli" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/262179");
                        Document doc_ravioli = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ravioli = doc_ravioli.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_ravioli.size();i++)
                        {
                            te02=subtitle_ravioli.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_ravioli_1 = doc_ravioli.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_ravioli_1.size();i++)
                        {
                            te02=subtitle_ravioli_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%A9%E5%A4%A7%E5%88%A9%E9%A4%83?sortby=popular");
                        Document doc_ravioli_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_ravioli_rec = doc_ravioli_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_ravioli_rec.size();i++)
                        {
                            te01=subtitle_ravioli_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "rice_dumpling" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341551");
                        Document doc_rice_dumpling = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_rice_dumpling = doc_rice_dumpling.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_rice_dumpling.size();i++)
                        {
                            te02=subtitle_rice_dumpling.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_rice_dumpling_1 = doc_rice_dumpling.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_rice_dumpling_1.size();i++)
                        {
                            te02=subtitle_rice_dumpling_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%B2%BD%E5%AD%90?sortby=popular");
                        Document doc_rice_dumpling_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_rice_dumpling_rec = doc_rice_dumpling_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_rice_dumpling_rec.size();i++)
                        {
                            te01=subtitle_rice_dumpling_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "rice_noodles_with_squid" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/289358");
                        Document doc_rice_noodles_with_squid = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_rice_noodles_with_squid = doc_rice_noodles_with_squid.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_rice_noodles_with_squid.size();i++)
                        {
                            te02=subtitle_rice_noodles_with_squid.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_rice_noodles_with_squid_1 = doc_rice_noodles_with_squid.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_rice_noodles_with_squid_1.size();i++)
                        {
                            te02=subtitle_rice_noodles_with_squid_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%B0%8F%E5%8D%B7%E7%B1%B3%E7%B2%89?sortby=popular");
                        Document doc_rice_noodles_with_squid_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_rice_noodles_with_squid_rec = doc_rice_noodles_with_squid_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_rice_noodles_with_squid_rec.size();i++)
                        {
                            te01=subtitle_rice_noodles_with_squid_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "rice_with_soy-stewed_pork" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/321090");
                        Document doc_rice_with_soy_stewed_pork = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_rice_with_soy_stewed_pork = doc_rice_with_soy_stewed_pork.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_rice_with_soy_stewed_pork.size();i++)
                        {
                            te02=subtitle_rice_with_soy_stewed_pork.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_rice_with_soy_stewed_pork_1 = doc_rice_with_soy_stewed_pork.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_rice_with_soy_stewed_pork_1.size();i++)
                        {
                            te02=subtitle_rice_with_soy_stewed_pork_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%8E%A7%E8%82%89%E9%A3%AF?sortby=popular");
                        Document doc_rice_with_soy_stewed_pork_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_rice_with_soy_stewed_pork_rec = doc_rice_with_soy_stewed_pork_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_rice_with_soy_stewed_pork_rec.size();i++)
                        {
                            te01=subtitle_rice_with_soy_stewed_pork_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "risotto" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/269895");
                        Document doc_risotto = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_risotto = doc_risotto.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_risotto.size();i++)
                        {
                            te02=subtitle_risotto.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_risotto_1 = doc_risotto.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_risotto_1.size();i++)
                        {
                            te02=subtitle_risotto_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%BE%A9%E5%A4%A7%E5%88%A9%E7%87%89%E9%A3%AF?sortby=popular");
                        Document doc_risotto_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_risotto_rec = doc_risotto_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_risotto_rec.size();i++)
                        {
                            te01=subtitle_risotto_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "roasted_sweet_potato" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/333809");
                        Document doc_roasted_sweet_potato = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_roasted_sweet_potato = doc_roasted_sweet_potato.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_roasted_sweet_potato.size();i++)
                        {
                            te02=subtitle_roasted_sweet_potato.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_roasted_sweet_potato_1 = doc_roasted_sweet_potato.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_roasted_sweet_potato_1.size();i++)
                        {
                            te02=subtitle_roasted_sweet_potato_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%83%A4%E5%9C%B0%E7%93%9C?sortby=popular");
                        Document doc_roasted_sweet_potato_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_roasted_sweet_potato_rec = doc_roasted_sweet_potato_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_roasted_sweet_potato_rec.size();i++)
                        {
                            te01=subtitle_roasted_sweet_potato_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sailfish_stick" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/39534");
                        Document doc_sailfish_stick = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sailfish_stick = doc_sailfish_stick.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sailfish_stick.size();i++)
                        {
                            te02=subtitle_sailfish_stick.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sailfish_stick_1 = doc_sailfish_stick.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sailfish_stick_1.size();i++)
                        {
                            te02=subtitle_sailfish_stick_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%97%97%E9%AD%9A%E9%BB%91%E8%BC%AA?sortby=popular");
                        Document doc_sailfish_stick_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sailfish_stick_rec = doc_sailfish_stick_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sailfish_stick_rec.size();i++)
                        {
                            te01=subtitle_sailfish_stick_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "salty_fried_chicken_nuggets" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/334387");
                        Document doc_salty_fried_chicken_nuggets = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_salty_fried_chicken_nuggets = doc_salty_fried_chicken_nuggets.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_salty_fried_chicken_nuggets.size();i++)
                        {
                            te02=subtitle_salty_fried_chicken_nuggets.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_salty_fried_chicken_nuggets_1 = doc_salty_fried_chicken_nuggets.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_salty_fried_chicken_nuggets_1.size();i++)
                        {
                            te02=subtitle_salty_fried_chicken_nuggets_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%B9%B9%E9%85%A5%E9%9B%9E?sortby=popular");
                        Document doc_salty_fried_chicken_nuggets_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_salty_fried_chicken_nuggets_rec = doc_salty_fried_chicken_nuggets_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_salty_fried_chicken_nuggets_rec.size();i++)
                        {
                            te01=subtitle_salty_fried_chicken_nuggets_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sanxia_golden_croissants" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/311844");
                        Document doc_sanxia_golden_croissants = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sanxia_golden_croissants = doc_sanxia_golden_croissants.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sanxia_golden_croissants.size();i++)
                        {
                            te02=subtitle_sanxia_golden_croissants.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sanxia_golden_croissants_1 = doc_sanxia_golden_croissants.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sanxia_golden_croissants_1.size();i++)
                        {
                            te02=subtitle_sanxia_golden_croissants_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%87%91%E7%89%9B%E8%A7%92?sortby=popular");
                        Document doc_sanxia_golden_croissants_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sanxia_golden_croissants_rec = doc_sanxia_golden_croissants_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sanxia_golden_croissants_rec.size();i++)
                        {
                            te01=subtitle_sanxia_golden_croissants_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sashimi" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/309315");
                        Document doc_sashimi = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sashimi = doc_sashimi.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sashimi.size();i++)
                        {
                            te02=subtitle_sashimi.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sashimi_1 = doc_sashimi.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sashimi_1.size();i++)
                        {
                            te02=subtitle_sashimi_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%94%9F%E9%AD%9A%E7%89%87?sortby=popular");
                        Document doc_sashimi_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sashimi_rec = doc_sashimi_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sashimi_rec.size();i++)
                        {
                            te01=subtitle_sashimi_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "saute_spring_onion_with_beef" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/334450");
                        Document doc_saute_spring_onion_with_beef = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_saute_spring_onion_with_beef = doc_saute_spring_onion_with_beef.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_saute_spring_onion_with_beef.size();i++)
                        {
                            te02=subtitle_saute_spring_onion_with_beef.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_saute_spring_onion_with_beef_1 = doc_saute_spring_onion_with_beef.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_saute_spring_onion_with_beef_1.size();i++)
                        {
                            te02=subtitle_saute_spring_onion_with_beef_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%94%A5%E7%88%86%E7%89%9B%E8%82%89?sortby=popular");
                        Document doc_saute_spring_onion_with_beef_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_saute_spring_onion_with_beef_rec = doc_saute_spring_onion_with_beef_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_saute_spring_onion_with_beef_rec.size();i++)
                        {
                            te01=subtitle_saute_spring_onion_with_beef_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "scallion_pancake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/339838");
                        Document doc_scallion_pancake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_scallion_pancake = doc_scallion_pancake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_scallion_pancake.size();i++)
                        {
                            te02=subtitle_scallion_pancake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_scallion_pancake_1 = doc_scallion_pancake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_scallion_pancake_1.size();i++)
                        {
                            te02=subtitle_scallion_pancake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%94%A5%E6%8A%93%E9%A4%85?sortby=popular");
                        Document doc_scallion_pancake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_scallion_pancake_rec = doc_scallion_pancake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_scallion_pancake_rec.size();i++)
                        {
                            te01=subtitle_scallion_pancake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "scallops" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/334852");
                        Document doc_scallops = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_scallops = doc_scallops.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_scallops.size();i++)
                        {
                            te02=subtitle_scallops.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_scallops_1 = doc_scallops.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_scallops_1.size();i++)
                        {
                            te02=subtitle_scallops_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%85%8E%E5%B9%B2%E8%B2%9D?sortby=popular");
                        Document doc_scallops_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_scallops_rec = doc_scallops_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_scallops_rec.size();i++)
                        {
                            te01=subtitle_scallops_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "scrambled_eggs_with_shrimp" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/330537");
                        Document doc_scrambled_eggs_with_shrimp = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_scrambled_eggs_with_shrimp = doc_scrambled_eggs_with_shrimp.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_scrambled_eggs_with_shrimp.size();i++)
                        {
                            te02=subtitle_scrambled_eggs_with_shrimp.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_scrambled_eggs_with_shrimp_1 = doc_scrambled_eggs_with_shrimp.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_scrambled_eggs_with_shrimp_1.size();i++)
                        {
                            te02=subtitle_scrambled_eggs_with_shrimp_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%BB%91%E8%9B%8B%E8%9D%A6%E4%BB%81?sortby=popular");
                        Document doc_scrambled_eggs_with_shrimp_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_scrambled_eggs_with_shrimp_rec = doc_scrambled_eggs_with_shrimp_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_scrambled_eggs_with_shrimp_rec.size();i++)
                        {
                            te01=subtitle_scrambled_eggs_with_shrimp_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "scrambled_eggs_with_tomatoes" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/342562");
                    Document doc_scrambled_eggs_with_tomatoes = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_scrambled_eggs_with_tomatoes = doc_scrambled_eggs_with_tomatoes.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_scrambled_eggs_with_tomatoes.size();i++)
                    {
                        te02=subtitle_scrambled_eggs_with_tomatoes.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_scrambled_eggs_with_tomatoes_1 = doc_scrambled_eggs_with_tomatoes.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_scrambled_eggs_with_tomatoes_1.size();i++)
                    {
                        te02=subtitle_scrambled_eggs_with_tomatoes_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E8%95%83%E8%8C%84%E7%82%92%E8%9B%8B?sortby=popular");
                    Document doc_scrambled_eggs_with_tomatoes_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_scrambled_eggs_with_tomatoes_rec = doc_scrambled_eggs_with_tomatoes_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_scrambled_eggs_with_tomatoes_rec.size();i++)
                    {
                        te01=subtitle_scrambled_eggs_with_tomatoes_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "seafood_congee" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342780");
                        Document doc_seafood_congee = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_seafood_congee = doc_seafood_congee.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_seafood_congee.size();i++)
                        {
                            te02=subtitle_seafood_congee.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_seafood_congee_1 = doc_seafood_congee.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_seafood_congee_1.size();i++)
                        {
                            te02=subtitle_seafood_congee_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B5%B7%E9%AE%AE%E7%B2%A5?sortby=popular");
                        Document doc_seafood_congee_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_seafood_congee_rec = doc_seafood_congee_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_seafood_congee_rec.size();i++)
                        {
                            te01=subtitle_seafood_congee_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "seaweed_salad" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/332609");
                        Document doc_seaweed_salad = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_seaweed_salad = doc_seaweed_salad.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_seaweed_salad.size();i++)
                        {
                            te02=subtitle_seaweed_salad.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_seaweed_salad_1 = doc_seaweed_salad.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_seaweed_salad_1.size();i++)
                        {
                            te02=subtitle_seaweed_salad_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B6%BC%E6%8B%8C%E6%B5%B7%E8%97%BB?sortby=popular");
                        Document doc_seaweed_salad_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_seaweed_salad_rec = doc_seaweed_salad_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_seaweed_salad_rec.size();i++)
                        {
                            te01=subtitle_seaweed_salad_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sesame_oil_chicken_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/337218");
                        Document doc_sesame_oil_chicken_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sesame_oil_chicken_soup = doc_sesame_oil_chicken_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sesame_oil_chicken_soup.size();i++)
                        {
                            te02=subtitle_sesame_oil_chicken_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sesame_oil_chicken_soup_1 = doc_sesame_oil_chicken_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sesame_oil_chicken_soup_1.size();i++)
                        {
                            te02=subtitle_sesame_oil_chicken_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%BA%BB%E6%B2%B9%E9%9B%9E%E6%B9%AF?sortby=popular");
                        Document doc_sesame_oil_chicken_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sesame_oil_chicken_soup_rec = doc_sesame_oil_chicken_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sesame_oil_chicken_soup_rec.size();i++)
                        {
                            te01=subtitle_sesame_oil_chicken_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "shrimp_rice" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341811");
                        Document doc_shrimp_rice = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_shrimp_rice = doc_shrimp_rice.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_shrimp_rice.size();i++)
                        {
                            te02=subtitle_shrimp_rice.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_shrimp_rice_1 = doc_shrimp_rice.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_shrimp_rice_1.size();i++)
                        {
                            te02=subtitle_shrimp_rice_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%9D%A6%E4%BB%81%E9%A3%AF?sortby=popular");
                        Document doc_shrimp_rice_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_shrimp_rice_rec = doc_shrimp_rice_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_shrimp_rice_rec.size();i++)
                        {
                            te01=subtitle_shrimp_rice_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sishen_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/339476");
                        Document doc_sishen_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sishen_soup = doc_sishen_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sishen_soup.size();i++)
                        {
                            te02=subtitle_sishen_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sishen_soup_1 = doc_sishen_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sishen_soup_1.size();i++)
                        {
                            te02=subtitle_sishen_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%9B%9B%E7%A5%9E%E6%B9%AF?sortby=popular");
                        Document doc_sishen_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sishen_soup_rec = doc_sishen_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sishen_soup_rec.size();i++)
                        {
                            te01=subtitle_sishen_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sliced_pork_bun" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/332090");
                        Document doc_sliced_pork_bun = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sliced_pork_bun = doc_sliced_pork_bun.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sliced_pork_bun.size();i++)
                        {
                            te02=subtitle_sliced_pork_bun.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sliced_pork_bun_1 = doc_sliced_pork_bun.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sliced_pork_bun_1.size();i++)
                        {
                            te02=subtitle_sliced_pork_bun_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%88%88%E5%8C%85?sortby=popular");
                        Document doc_sliced_pork_bun_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sliced_pork_bun_rec = doc_sliced_pork_bun_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sliced_pork_bun_rec.size();i++)
                        {
                            te01=subtitle_sliced_pork_bun_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "spaghetti_bolognese" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341503");
                        Document doc_spaghetti_bolognese = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spaghetti_bolognese = doc_spaghetti_bolognese.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_spaghetti_bolognese.size();i++)
                        {
                            te02=subtitle_spaghetti_bolognese.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_spaghetti_bolognese_1 = doc_spaghetti_bolognese.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_spaghetti_bolognese_1.size();i++)
                        {
                            te02=subtitle_spaghetti_bolognese_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%82%89%E9%86%AC%E7%BE%A9%E5%A4%A7%E5%88%A9%E9%BA%B5?sortby=popular");
                        Document doc_spaghetti_bolognese_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spaghetti_bolognese_rec = doc_spaghetti_bolognese_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_spaghetti_bolognese_rec.size();i++)
                        {
                            te01=subtitle_spaghetti_bolognese_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "spaghetti_carbonara" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335836");
                        Document doc_spaghetti_carbonara = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spaghetti_carbonara = doc_spaghetti_carbonara.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_spaghetti_carbonara.size();i++)
                        {
                            te02=subtitle_spaghetti_carbonara.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_spaghetti_carbonara_1 = doc_spaghetti_carbonara.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_spaghetti_carbonara_1.size();i++)
                        {
                            te02=subtitle_spaghetti_carbonara_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%9F%B9%E6%A0%B9%E8%9B%8B%E9%BB%83%E7%BE%A9%E5%A4%A7%E5%88%A9%E9%BA%B5?sortby=popular");
                        Document doc_spaghetti_carbonara_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spaghetti_carbonara_rec = doc_spaghetti_carbonara_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_spaghetti_carbonara_rec.size();i++)
                        {
                            te01=subtitle_spaghetti_carbonara_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "spicy_duck_blood" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/339555");
                        Document doc_spicy_duck_blood = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spicy_duck_blood = doc_spicy_duck_blood.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_spicy_duck_blood.size();i++)
                        {
                            te02=subtitle_spicy_duck_blood.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_spicy_duck_blood_1 = doc_spicy_duck_blood.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_spicy_duck_blood_1.size();i++)
                        {
                            te02=subtitle_spicy_duck_blood_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E9%BA%BB%E8%BE%A3%E9%B4%A8%E8%A1%80?sortby=popular");
                        Document doc_spicy_duck_blood_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spicy_duck_blood_rec = doc_spicy_duck_blood_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_spicy_duck_blood_rec.size();i++)
                        {
                            te01=subtitle_spicy_duck_blood_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "spring_rolls" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/317013");
                        Document doc_spring_rolls = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spring_rolls = doc_spring_rolls.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_spring_rolls.size();i++)
                        {
                            te02=subtitle_spring_rolls.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_spring_rolls_1 = doc_spring_rolls.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_spring_rolls_1.size();i++)
                        {
                            te02=subtitle_spring_rolls_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%98%A5%E6%8D%B2?sortby=popular");
                        Document doc_spring_rolls_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_spring_rolls_rec = doc_spring_rolls_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_spring_rolls_rec.size();i++)
                        {
                            te01=subtitle_spring_rolls_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "steak" :
                    //recipe
                    url = new URL("https://icook.tw/recipes/340409");
                    Document doc_steak = Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_steak = doc_steak.select("div.ingredients-groups div.group");
                    for(int i=0;i<subtitle_steak.size();i++)
                    {
                        te02=subtitle_steak.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }

                    Elements subtitle_steak_1 = doc_steak.select("div.recipe-details-steps-note div.step-instruction-content");
                    for(int i=0;i<subtitle_steak_1.size();i++)
                    {
                        te02=subtitle_steak_1.get(i).text();
                        runOnUiThread(new Runnable() {
                            public void run(){
                                t01.append("\n"+te02+"\n");
                            }
                        });
                        Thread.sleep(100);
                    }
                    //recommend
                    url=new URL("https://ifoodie.tw/explore/list/%E7%89%9B%E6%8E%92?sortby=popular");
                    Document doc_steak_rec =  Jsoup.parse(url, 3000);        //連結該網址
                    Elements subtitle_steak_rec = doc_steak_rec.select("div.jsx-3523532887 div.restaurant-item");
                    for(int i=0;i<subtitle_steak_rec.size();i++)
                    {
                        te01=subtitle_steak_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                        runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                            public void run(){
                                t02.append("\n"+te01+"\n");
                            }
                        });
                        Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                    }
                    break;

                    case "steamed_cod_fish_with_crispy_bean" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/321165");
                        Document doc_steamed_cod_fish_with_crispy_bean = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_steamed_cod_fish_with_crispy_bean = doc_steamed_cod_fish_with_crispy_bean.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_steamed_cod_fish_with_crispy_bean.size();i++)
                        {
                            te02=subtitle_steamed_cod_fish_with_crispy_bean.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_steamed_cod_fish_with_crispy_bean_1 = doc_steamed_cod_fish_with_crispy_bean.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_steamed_cod_fish_with_crispy_bean_1.size();i++)
                        {
                            te02=subtitle_steamed_cod_fish_with_crispy_bean_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%B1%86%E9%85%A5%E9%B1%88%E9%AD%9A?sortby=popular");
                        Document doc_steamed_cod_fish_with_crispy_bean_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_steamed_cod_fish_with_crispy_bean_rec = doc_steamed_cod_fish_with_crispy_bean_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_steamed_cod_fish_with_crispy_bean_rec.size();i++)
                        {
                            te01=subtitle_steamed_cod_fish_with_crispy_bean_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "steamed_taro_cake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/339112");
                        Document doc_steamed_taro_cake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_steamed_taro_cake = doc_steamed_taro_cake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_steamed_taro_cake.size();i++)
                        {
                            te02=subtitle_steamed_taro_cake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_steamed_taro_cake_1 = doc_steamed_taro_cake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_steamed_taro_cake_1.size();i++)
                        {
                            te02=subtitle_steamed_taro_cake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%8A%8B%E7%B2%BF%E5%B7%A7?sortby=popular");
                        Document doc_steamed_taro_cake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_steamed_taro_cake_rec = doc_steamed_taro_cake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_steamed_taro_cake_rec.size();i++)
                        {
                            te01=subtitle_steamed_taro_cake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "steam-fried_bun" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340554");
                        Document doc_steam_fried_bun = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_steam_fried_bun = doc_steam_fried_bun.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_steam_fried_bun.size();i++)
                        {
                            te02=subtitle_steam_fried_bun.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_steam_fried_bun_1 = doc_steam_fried_bun.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_steam_fried_bun_1.size();i++)
                        {
                            te02=subtitle_steam_fried_bun_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B0%B4%E7%85%8E%E5%8C%85?sortby=popular");
                        Document doc_steam_fried_bun_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_steam_fried_bun_rec = doc_steam_fried_bun_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_steam_fried_bun_rec.size();i++)
                        {
                            te01=subtitle_steam_fried_bun_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "stewed_pig's_knuckles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/336547");
                        Document doc_stewed_pigs_knuckles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stewed_pigs_knuckles = doc_stewed_pigs_knuckles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_stewed_pigs_knuckles.size();i++)
                        {
                            te02=subtitle_stewed_pigs_knuckles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_stewed_pigs_knuckles_1 = doc_stewed_pigs_knuckles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_stewed_pigs_knuckles_1.size();i++)
                        {
                            te02=subtitle_stewed_pigs_knuckles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%BB%B7%E8%B1%AC%E8%85%B3?sortby=popular");
                        Document doc_stewed_pigs_knuckles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stewed_pigs_knuckles_rec = doc_stewed_pigs_knuckles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_stewed_pigs_knuckles_rec.size();i++)
                        {
                            te01=subtitle_stewed_pigs_knuckles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "stinky_tofu" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/308698");
                        Document doc_stinky_tofu = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stinky_tofu = doc_stinky_tofu.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_stinky_tofu.size();i++)
                        {
                            te02=subtitle_stinky_tofu.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_stinky_tofu_1 = doc_stinky_tofu.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_stinky_tofu_1.size();i++)
                        {
                            te02=subtitle_stinky_tofu_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%87%AD%E8%B1%86%E8%85%90?sortby=popular");
                        Document doc_stinky_tofu_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stinky_tofu_rec = doc_stinky_tofu_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_stinky_tofu_rec.size();i++)
                        {
                            te01=subtitle_stinky_tofu_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "stir_fried_clams_with_basil" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340932");
                        Document doc_stir_fried_clams_with_basil = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_clams_with_basil = doc_stir_fried_clams_with_basil.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_stir_fried_clams_with_basil.size();i++)
                        {
                            te02=subtitle_stir_fried_clams_with_basil.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_stir_fried_clams_with_basil_1 = doc_stir_fried_clams_with_basil.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_stir_fried_clams_with_basil_1.size();i++)
                        {
                            te02=subtitle_stir_fried_clams_with_basil_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%82%92%E6%B5%B7%E7%93%9C%E5%AD%90?sortby=popular");
                        Document doc_stir_fried_clams_with_basil_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_clams_with_basil_rec = doc_stir_fried_clams_with_basil_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_stir_fried_clams_with_basil_rec.size();i++)
                        {
                            te01=subtitle_stir_fried_clams_with_basil_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "stir-fried_duck_meat_broth" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/281172");
                        Document doc_stir_fried_duck_meat_broth = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_duck_meat_broth = doc_stir_fried_duck_meat_broth.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_stir_fried_duck_meat_broth.size();i++)
                        {
                            te02=subtitle_stir_fried_duck_meat_broth.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_stir_fried_duck_meat_broth_1 = doc_stir_fried_duck_meat_broth.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_stir_fried_duck_meat_broth_1.size();i++)
                        {
                            te02=subtitle_stir_fried_duck_meat_broth_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%94%9F%E7%82%92%E9%B4%A8%E8%82%89%E7%BE%B9?sortby=popular");
                        Document doc_stir_fried_duck_meat_broth_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_duck_meat_broth_rec = doc_stir_fried_duck_meat_broth_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_stir_fried_duck_meat_broth_rec.size();i++)
                        {
                            te01=subtitle_stir_fried_duck_meat_broth_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "stir-fried_calamari_broth" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/252981");
                        Document doc_stir_fried_calamari_broth = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_calamari_broth = doc_stir_fried_calamari_broth.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_stir_fried_calamari_broth.size();i++)
                        {
                            te02=subtitle_stir_fried_calamari_broth.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_stir_fried_calamari_broth_1 = doc_stir_fried_calamari_broth.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_stir_fried_calamari_broth_1.size();i++)
                        {
                            te02=subtitle_stir_fried_calamari_broth_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%94%9F%E7%82%92%E8%8A%B1%E6%9E%9D%E7%BE%B9?sortby=popular");
                        Document doc_stir_fried_calamari_broth_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_calamari_broth_rec = doc_stir_fried_calamari_broth_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_stir_fried_calamari_broth_rec.size();i++)
                        {
                            te01=subtitle_stir_fried_calamari_broth_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "stir-fried_loofah_with_clam" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/338358");
                        Document doc_stir_fried_loofah_with_clam = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_loofah_with_clam = doc_stir_fried_loofah_with_clam.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_stir_fried_loofah_with_clam.size();i++)
                        {
                            te02=subtitle_stir_fried_loofah_with_clam.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_stir_fried_loofah_with_clam_1 = doc_stir_fried_loofah_with_clam.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_stir_fried_loofah_with_clam_1.size();i++)
                        {
                            te02=subtitle_stir_fried_loofah_with_clam_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%9B%A4%E8%9C%8A%E7%B5%B2%E7%93%9C?sortby=popular");
                        Document doc_stir_fried_loofah_with_clam_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_loofah_with_clam_rec = doc_stir_fried_loofah_with_clam_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_stir_fried_loofah_with_clam_rec.size();i++)
                        {
                            te01=subtitle_stir_fried_loofah_with_clam_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "stir-fried_pork_intestine_with_ginger" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341410");
                        Document doc_stir_fried_pork_intestine_with_ginger = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_pork_intestine_with_ginger = doc_stir_fried_pork_intestine_with_ginger.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_stir_fried_pork_intestine_with_ginger.size();i++)
                        {
                            te02=subtitle_stir_fried_pork_intestine_with_ginger.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_stir_fried_pork_intestine_with_ginger_1 = doc_stir_fried_pork_intestine_with_ginger.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_stir_fried_pork_intestine_with_ginger_1.size();i++)
                        {
                            te02=subtitle_stir_fried_pork_intestine_with_ginger_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%96%91%E7%B5%B2%E7%82%92%E5%A4%A7%E8%85%B8?sortby=popular");
                        Document doc_stir_fried_pork_intestine_with_ginger_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_stir_fried_pork_intestine_with_ginger_rec = doc_stir_fried_pork_intestine_with_ginger_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_stir_fried_pork_intestine_with_ginger_rec.size();i++)
                        {
                            te01=subtitle_stir_fried_pork_intestine_with_ginger_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "xiaolongbao" :
                        url = new URL("https://www.how-living.com/p/25083/%e7%b0%a1%e6%98%93%e5%b0%8f%e7%b1%a0%e5%8c%85");
                        Document doc_xiaolongbao = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_xiaolongbao = doc_xiaolongbao.select("div.recipe-content-text p");
                        for(int i=1;i<subtitle_xiaolongbao.size();i++)
                        {
                            te02=subtitle_xiaolongbao.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        url=new URL("https://ifoodie.tw/explore/list/%E5%B0%8F%E7%B1%A0%E5%8C%85?sortby=popular");
                        Document doc_xiaolongbao_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_xiaolongbao_rec = doc_xiaolongbao_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_xiaolongbao_rec.size();i++)
                        {
                            te01=subtitle_xiaolongbao_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sugar_coated_sweet_potato" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/294421");
                        Document doc_sugar_coated_sweet_potato = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sugar_coated_sweet_potato = doc_sugar_coated_sweet_potato.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sugar_coated_sweet_potato.size();i++)
                        {
                            te02=subtitle_sugar_coated_sweet_potato.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sugar_coated_sweet_potato_1 = doc_sugar_coated_sweet_potato.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sugar_coated_sweet_potato_1.size();i++)
                        {
                            te02=subtitle_sugar_coated_sweet_potato_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%8B%94%E7%B5%B2%E5%9C%B0%E7%93%9C?sortby=popular");
                        Document doc_sugar_coated_sweet_potato_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sugar_coated_sweet_potato_rec = doc_sugar_coated_sweet_potato_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sugar_coated_sweet_potato_rec.size();i++)
                        {
                            te01=subtitle_sugar_coated_sweet_potato_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sun_cake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/313716");
                        Document doc_sun_cake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sun_cake = doc_sun_cake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sun_cake.size();i++)
                        {
                            te02=subtitle_sun_cake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sun_cake_1 = doc_sun_cake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sun_cake_1.size();i++)
                        {
                            te02=subtitle_sun_cake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%A4%AA%E9%99%BD%E9%A4%85?sortby=popular");
                        Document doc_sun_cake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sun_cake_rec = doc_sun_cake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sun_cake_rec.size();i++)
                        {
                            te01=subtitle_sun_cake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sushi" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/161963");
                        Document doc_sushi = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sushi = doc_sushi.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sushi.size();i++)
                        {
                            te02=subtitle_sushi.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sushi_1 = doc_sushi.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sushi_1.size();i++)
                        {
                            te02=subtitle_sushi_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%A3%BD%E5%8F%B8?sortby=popular");
                        Document doc_sushi_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sushi_rec = doc_sushi_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sushi_rec.size();i++)
                        {
                            te01=subtitle_sushi_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sweet_and_sour_pork_ribs" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342850");
                        Document doc_sweet_and_sour_pork_ribs = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sweet_and_sour_pork_ribs = doc_sweet_and_sour_pork_ribs.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sweet_and_sour_pork_ribs.size();i++)
                        {
                            te02=subtitle_sweet_and_sour_pork_ribs.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sweet_and_sour_pork_ribs_1 = doc_sweet_and_sour_pork_ribs.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sweet_and_sour_pork_ribs_1.size();i++)
                        {
                            te02=subtitle_sweet_and_sour_pork_ribs_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%B3%96%E9%86%8B%E6%8E%92%E9%AA%A8?sortby=popular");
                        Document doc_sweet_and_sour_pork_ribs_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sweet_and_sour_pork_ribs_rec = doc_sweet_and_sour_pork_ribs_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sweet_and_sour_pork_ribs_rec.size();i++)
                        {
                            te01=subtitle_sweet_and_sour_pork_ribs_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "sweet_potato_ball" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335530");
                        Document doc_sweet_potato_ball = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sweet_potato_ball = doc_sweet_potato_ball.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_sweet_potato_ball.size();i++)
                        {
                            te02=subtitle_sweet_potato_ball.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_sweet_potato_ball_1 = doc_sweet_potato_ball.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_sweet_potato_ball_1.size();i++)
                        {
                            te02=subtitle_sweet_potato_ball_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%9C%B0%E7%93%9C%E7%90%83?sortby=popular");
                        Document doc_sweet_potato_ball_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_sweet_potato_ball_rec = doc_sweet_potato_ball_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_sweet_potato_ball_rec.size();i++)
                        {
                            te01=subtitle_sweet_potato_ball_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "tacos" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/270750");
                        Document doc_tacos = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tacos = doc_tacos.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_tacos.size();i++)
                        {
                            te02=subtitle_tacos.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_tacos_1 = doc_tacos.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_tacos_1.size();i++)
                        {
                            te02=subtitle_tacos_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%A2%A8%E8%A5%BF%E5%93%A5%E5%8D%B7?sortby=popular");
                        Document doc_tacos_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tacos_rec = doc_tacos_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_tacos_rec.size();i++)
                        {
                            te01=subtitle_tacos_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "taiwanese_burrito" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/330447");
                        Document doc_taiwanese_burrito = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taiwanese_burrito = doc_taiwanese_burrito.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_taiwanese_burrito.size();i++)
                        {
                            te02=subtitle_taiwanese_burrito.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_taiwanese_burrito_1 = doc_taiwanese_burrito.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_taiwanese_burrito_1.size();i++)
                        {
                            te02=subtitle_taiwanese_burrito_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%BD%A4%E9%A4%85?sortby=popular");
                        Document doc_taiwanese_burrito_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taiwanese_burrito_rec = doc_taiwanese_burrito_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_taiwanese_burrito_rec.size();i++)
                        {
                            te01=subtitle_taiwanese_burrito_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "taiwanese_pork_ball_soup" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/331086");
                        Document doc_taiwanese_pork_ball_soup = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taiwanese_pork_ball_soup = doc_taiwanese_pork_ball_soup.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_taiwanese_pork_ball_soup.size();i++)
                        {
                            te02=subtitle_taiwanese_pork_ball_soup.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_taiwanese_pork_ball_soup_1 = doc_taiwanese_pork_ball_soup.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_taiwanese_pork_ball_soup_1.size();i++)
                        {
                            te02=subtitle_taiwanese_pork_ball_soup_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%B2%A2%E4%B8%B8%E6%B9%AF?sortby=popular");
                        Document doc_taiwanese_pork_ball_soup_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taiwanese_pork_ball_soup_rec = doc_taiwanese_pork_ball_soup_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_taiwanese_pork_ball_soup_rec.size();i++)
                        {
                            te01=subtitle_taiwanese_pork_ball_soup_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "taiwanese_sausage_in_rice_bun" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/299526");
                        Document doc_taiwanese_sausage_in_rice_bun = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taiwanese_sausage_in_rice_bun = doc_taiwanese_sausage_in_rice_bun.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_taiwanese_sausage_in_rice_bun.size();i++)
                        {
                            te02=subtitle_taiwanese_sausage_in_rice_bun.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_taiwanese_sausage_in_rice_bun_1 = doc_taiwanese_sausage_in_rice_bun.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_taiwanese_sausage_in_rice_bun_1.size();i++)
                        {
                            te02=subtitle_taiwanese_sausage_in_rice_bun_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E5%A4%A7%E8%85%B8%E5%8C%85%E5%B0%8F%E8%85%B8?sortby=popular");
                        Document doc_taiwanese_sausage_in_rice_bun_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taiwanese_sausage_in_rice_bun_rec = doc_taiwanese_sausage_in_rice_bun_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_taiwanese_sausage_in_rice_bun_rec.size();i++)
                        {
                            te01=subtitle_taiwanese_sausage_in_rice_bun_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "takoyaki" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340768");
                        Document doc_takoyaki = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_takoyaki = doc_takoyaki.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_takoyaki.size();i++)
                        {
                            te02=subtitle_takoyaki.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_takoyaki_1 = doc_takoyaki.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_takoyaki_1.size();i++)
                        {
                            te02=subtitle_takoyaki_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%AB%A0%E9%AD%9A%E7%87%92?sortby=popular");
                        Document doc_takoyaki_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_takoyaki_rec = doc_takoyaki_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_takoyaki_rec.size();i++)
                        {
                            te01=subtitle_takoyaki_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "tanghulu" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/243604");
                        Document doc_tanghulu = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tanghulu = doc_tanghulu.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_tanghulu.size();i++)
                        {
                            te02=subtitle_tanghulu.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_tanghulu_1 = doc_tanghulu.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_tanghulu_1.size();i++)
                        {
                            te02=subtitle_tanghulu_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%B3%96%E8%91%AB%E8%98%86?sortby=popular");
                        Document doc_tanghulu_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tanghulu_rec = doc_tanghulu_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_tanghulu_rec.size();i++)
                        {
                            te01=subtitle_tanghulu_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "tangyuan" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/322732");
                        Document doc_tangyuan = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tangyuan = doc_tangyuan.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_tangyuan.size();i++)
                        {
                            te02=subtitle_tangyuan.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_tangyuan_1 = doc_tangyuan.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_tangyuan_1.size();i++)
                        {
                            te02=subtitle_tangyuan_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%B9%AF%E5%9C%93?sortby=popular");
                        Document doc_tangyuan_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tangyuan_rec = doc_tangyuan_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_tangyuan_rec.size();i++)
                        {
                            te01=subtitle_tangyuan_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "taro_ball" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/302107");
                        Document doc_taro_ball = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taro_ball = doc_taro_ball.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_taro_ball.size();i++)
                        {
                            te02=subtitle_taro_ball.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_taro_ball_1 = doc_taro_ball.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_taro_ball_1.size();i++)
                        {
                            te02=subtitle_taro_ball_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%8A%8B%E5%9C%93?sortby=popular");
                        Document doc_taro_ball_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_taro_ball_rec = doc_taro_ball_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_taro_ball_rec.size();i++)
                        {
                            te01=subtitle_taro_ball_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "three-cup_chicken" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/342451");
                        Document doc_three_cup_chicken = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_three_cup_chicken = doc_three_cup_chicken.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_three_cup_chicken.size();i++)
                        {
                            te02=subtitle_three_cup_chicken.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_three_cup_chicken_1 = doc_three_cup_chicken.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_three_cup_chicken_1.size();i++)
                        {
                            te02=subtitle_three_cup_chicken_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E4%B8%89%E6%9D%AF%E9%9B%9E?sortby=popular");
                        Document doc_three_cup_chicken_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_three_cup_chicken_rec = doc_three_cup_chicken_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_three_cup_chicken_rec.size();i++)
                        {
                            te01=subtitle_three_cup_chicken_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "tiramisu" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/340021");
                        Document doc_tiramisu = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tiramisu = doc_tiramisu.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_tiramisu.size();i++)
                        {
                            te02=subtitle_tiramisu.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_tiramisu_1 = doc_tiramisu.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_tiramisu_1.size();i++)
                        {
                            te02=subtitle_tiramisu_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E6%8F%90%E6%8B%89%E7%B1%B3%E8%98%87?sortby=popular");
                        Document doc_tiramisu_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tiramisu_rec = doc_tiramisu_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_tiramisu_rec.size();i++)
                        {
                            te01=subtitle_tiramisu_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "tube-shaped_migao" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/335655");
                        Document doc_tube_shaped_migao = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tube_shaped_migao = doc_tube_shaped_migao.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_tube_shaped_migao.size();i++)
                        {
                            te02=subtitle_tube_shaped_migao.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_tube_shaped_migao_1 = doc_tube_shaped_migao.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_tube_shaped_migao_1.size();i++)
                        {
                            te02=subtitle_tube_shaped_migao_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%AD%92%E4%BB%94%E7%B1%B3%E7%B3%95?sortby=popular");
                        Document doc_tube_shaped_migao_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_tube_shaped_migao_rec = doc_tube_shaped_migao_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_tube_shaped_migao_rec.size();i++)
                        {
                            te01=subtitle_tube_shaped_migao_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "turkey_rice" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/177217");
                        Document doc_turkey_rice = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_turkey_rice = doc_turkey_rice.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_turkey_rice.size();i++)
                        {
                            te02=subtitle_turkey_rice.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_turkey_rice_1 = doc_turkey_rice.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_turkey_rice_1.size();i++)
                        {
                            te02=subtitle_turkey_rice_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E7%81%AB%E9%9B%9E%E8%82%89%E9%A3%AF?sortby=popular");
                        Document doc_turkey_rice_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_turkey_rice_rec = doc_turkey_rice_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_turkey_rice_rec.size();i++)
                        {
                            te01=subtitle_turkey_rice_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "turnip_cake" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/341754");
                        Document doc_turnip_cake = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_turnip_cake = doc_turnip_cake.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_turnip_cake.size();i++)
                        {
                            te02=subtitle_turnip_cake.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_turnip_cake_1 = doc_turnip_cake.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_turnip_cake_1.size();i++)
                        {
                            te02=subtitle_turnip_cake_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%98%BF%E8%94%94%E7%B3%95?sortby=popular");
                        Document doc_turnip_cake_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_turnip_cake_rec = doc_turnip_cake_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_turnip_cake_rec.size();i++)
                        {
                            te01=subtitle_turnip_cake_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "waffles" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/257220");
                        Document doc_waffles = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_waffles = doc_waffles.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_waffles.size();i++)
                        {
                            te02=subtitle_waffles.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_waffles_1 = doc_waffles.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_waffles_1.size();i++)
                        {
                            te02=subtitle_waffles_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/waffle?sortby=popular");
                        Document doc_waffles_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_waffles_rec = doc_waffles_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_waffles_rec.size();i++)
                        {
                            te01=subtitle_waffles_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                    case "wheel_pie" :
                        //recipe
                        url = new URL("https://icook.tw/recipes/141869");
                        Document doc_wheel_pie = Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_wheel_pie = doc_wheel_pie.select("div.ingredients-groups div.group");
                        for(int i=0;i<subtitle_wheel_pie.size();i++)
                        {
                            te02=subtitle_wheel_pie.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }

                        Elements subtitle_wheel_pie_1 = doc_wheel_pie.select("div.recipe-details-steps-note div.step-instruction-content");
                        for(int i=0;i<subtitle_wheel_pie_1.size();i++)
                        {
                            te02=subtitle_wheel_pie_1.get(i).text();
                            runOnUiThread(new Runnable() {
                                public void run(){
                                    t01.append("\n"+te02+"\n");
                                }
                            });
                            Thread.sleep(100);
                        }
                        //recommend
                        url=new URL("https://ifoodie.tw/explore/list/%E8%BB%8A%E8%BC%AA%E9%A4%85?sortby=popular");
                        Document doc_wheel_pie_rec =  Jsoup.parse(url, 3000);        //連結該網址
                        Elements subtitle_wheel_pie_rec = doc_wheel_pie_rec.select("div.jsx-3523532887 div.restaurant-item");
                        for(int i=0;i<subtitle_wheel_pie_rec.size();i++)
                        {
                            te01=subtitle_wheel_pie_rec.get(i).text();        //只抓取第 0,2,3 Tag的文字
                            runOnUiThread(new Runnable() {             //將內容交給UI執行緒做顯示
                                public void run(){
                                    t02.append("\n"+te01+"\n");
                                }
                            });
                            Thread.sleep(100);    //避免執行緒跑太快而UI執行續顯示太慢,覆蓋掉te01~03內容所以設個延遲,也可以使用AsyncTask-異步任務
                        }
                        break;

                }

            }

            catch (Exception e){
                // TODO Auto-generated catch block
                e.printStackTrace();
                t01.append("error");
            }
        }
    };


}
