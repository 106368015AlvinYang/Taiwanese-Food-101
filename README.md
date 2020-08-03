# Taiwanese-Food-101
In this project, we propose how to create Taiwanese-Food-101 Dataset, how to use Deep Learning to train the model, and compare the accuracy of each famous model.
## Taiwanese-Food-101 Food Image Dataset
* 101 Taiwanese food categories.
* Each category has 200 images.
* A total of 20,200 images. <br>
* The dataset is available for download at https://drive.google.com/drive/folders/1wOdqes1KzEzp4DPG5jO8kHbFwcCmjzjh/.
## Methods of Establishing Dataset
We download the image from Google and Instagram to create Taiwanese-Food-101 Dataset. <br>
The details of how we use Google and Instagram create Taiwanese-Food-101 Dataset method is in **Download-image-code.txt**.
## Training model
We use different famous convolutional neural network model on Keras. <br>
The details of how we train the model is in **Tawanese-Food-101.ipynb**. <br>
We also evaluate each model by Top-1 and Top-5 accuracy.
Model           | Top-1 Accuracy  | Top-5 Accuracy  | Size | Total params
--------------  | --------------  | --------------  | ---  | ----------
**VGG16**       |      0.6765     |      0.8933     | 749MB| 65,468,325
**InceptionV3** |      0.6987     |      0.8996     |  1.28GB| 114,499,461
**DenseNet121** |      0.7886     |      0.9403     |  1.02MB| 91,345,573
**ResNet34**    |      0.3536     |      0.6200     |  260MB| 22,738,277
**MobileNet**   |      0.6973     |      0.9119     |  0.97GB| 87,536,933
## Application
![avatar](https://github.com/stratospark/food-101-keras/blob/master/demo.jpg)
