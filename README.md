[![](https://jitpack.io/v/hadibtf/SemiCircleArcProgressBar.svg)](https://jitpack.io/#hadibtf/SemiCircleArcProgressBar)
# SemiCircleArcProgressBar

A fully Customizable Semi Circle Arc Progress Bar.
You can customize the the width and color of both progress and progress place holder from Java and XML.
Also you can set the amount of progress bar with percentage from Java and XML.
Additionally you can set percentage with a smooth filling animation.

![demo.gif](https://github.com/hadibtf/SemiCircleArcProgressBar/blob/master/DemoGif/demo.gif "Demo Gif") 

# Setting Percentage With Animation
Please note that if you set percentage with animation ".setPercentWithAnimation(10)" at the initial of your activity, set it with a delay to let the view to load and then animate.
# Width to Height Ratio
Also for a better circular look, the width to height ratio is recommended to be 2:1 for example if your width is 100dp set your height to 50dp.

## Installation

Add this repository to your Module build.gradle

```bash
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
And then add this dependency to your Project build.gradle

```bash
dependencies {
    implementation 'com.github.hadibtf:SemiCircleArcProgressBar:1.1.0'
}
```

## Usage

```Java
//Java
progressBar.setPercent(40);
progressBar.setPercentWithAnimation(10);
        
progressBar.setProgressBarColor(0xffff00ff);
progressBar.setProgressPlaceHolderColor(0xff00ffff);
        
progressBar.setProgressBarWidth(10);
progressBar.setProgressPlaceHolderWidth(10);
```

```xml
//XML
<me.bastanfar.semicirclearcprogressbar.SemiCircleArcProgressBar
        android:layout_width="100dp"
        android:layout_height="50dp"
        app:percent="30"
        app:progressBarColor="#ff00ff"
        app:progressPlaceHolderColor="#00ffff"
        app:progressBarWidth="10"
        app:progressPlaceHolderWidth="10" />
```


![1.png](https://github.com/hadibtf/SemiCircleArcProgressBar/blob/master/DemoSC/1.png  =100x20)
![2.png](https://github.com/hadibtf/SemiCircleArcProgressBar/blob/master/DemoSC/2.png "Demo Screen Shot")
![3.png](https://github.com/hadibtf/SemiCircleArcProgressBar/blob/master/DemoSC/3.png "Demo Screen Shot")
