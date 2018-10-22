# PinchZoom   [![Lucem](https://camo.githubusercontent.com/cfcaf3a99103d61f387761e5fc445d9ba0203b01/68747470733a2f2f7472617669732d63692e6f72672f6477796c2f657374612e7376673f6272616e63683d6d6173746572)](https://about.me/lucem-anb) [![](https://jitpack.io/v/Lucem-Anb/ZoomableVideo.svg)](https://jitpack.io/#Lucem-Anb/ZoomableVideo)

This project implements pinch zoom on texture view on android which allows you to play a video while zooming around it in real time

### Illustration
![Zoomable Texture](https://anbinsane.files.wordpress.com/2018/10/untitled-project.gif)

### Implementation
Add jitpack to repositories in the root build.gradle file
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

###### Add the Dependancy

```
dependencies {
	        implementation 'com.github.Lucem-Anb:ZoomableVideo:1.0.0'
	}
```

### Usage

In XML

```
<com.lucemanb.zoomable.ZoomableTextureView
        android:id="@+id/textureView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

in Java
```
new ZoomableTextureView(this)
```

Customizations for the maximum zoom and minimum zoom

```
maxScale
minScale
```

Enjoy


       
