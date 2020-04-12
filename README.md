# Taiwanses-Food-101
In this project, we propose how to create Taiwanese-Food-101 Dataset, how to use Deep Learning to train the model, and compare the accuracy of each famous model.
## Dataset
We download the image from Google and Instagram to create Taiwanese-Food-101 Dataset. <br>
The details of how we use Google and Instagram create Taiwanese-Food-101 Dataset method is in **Download-image-code.txt**.
## Training model
We use different famous convolutional neural network model on Keras. <br>
The details of how we train the model is in **Tawanese-Food-101.ipynb**. <br>
We also evaluate each model by Top-1 and Top-5 accuracy.

    Model    |  Top-1 Accuracy  |  Top-5 Accuracy  |  Size  |  Total params
------------ | ---------------- | ---------------- | ------ | ---------------
VGG16        |      0.6765      |      0.8933      |  528MB | 65,468,325
InceptionV3  |      0.6987      |      0.8996      |  92MB  | 114,499,461
DenseNet121  |      0.7886      |      0.9403      |  33MB  | 91,345,573
ResNet34     |      0.3536      |      0.6200      |  98MB  | 22,738,277
MobileNet    |      0.6973      |      0.9119      |  16MB  | 87,536,933
