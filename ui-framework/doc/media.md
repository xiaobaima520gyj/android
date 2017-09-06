# 视频点播库
## 简介
这个库是基于google开源的exoplayer进行的分装，目前具有以下功能：

- 播放
- 快进/快退
- 停止（释放资源）
- 获取视频总的进度
- 获取当前播放的位置
- 继续播放（用与暂停之后想继续播放的时候调用）
- 暂停

## 使用
### 初始化
```java
IMediaPlayer mediaPlayer = new XbmMediaPlayer(getActivity(), surfaceView); //surfaceView  你布局里面的surfaceView组件
```
### 播放
```java
mediaPlayer.play(url, this); //this指的是播放的状态回调接口：IPlayState
```
### 播放所传入的回调接口方法
```java
public void onPlayState(boolean playWhenReady, int playbackState) 
```
第一个参数playWhenReady一般不是很重要，这里主要看第二个参数playbackState：

| 参数值 | 说明 | 
|--------|-------|
|ExoPlayer.STATE_BUFFERING|正在缓冲中
|ExoPlayer.STATE_ENDED|播放结束
|ExoPlayer.STATE_IDLE|网络状态差
|ExoPlayer.STATE_PREPARING|正在加载
|ExoPlayer.STATE_READY|加载完毕(这个时候就可以播放了)

### 快进/快退

```java
mediaPlayer.seekTo(/*这里传入播放的位置*/);
```

### 停止并释放那个资源

```java
mediaPlayer.stop();
```

### 获取视频的总进度

```java
mediaPlayer.getDuration();
```

### 获取当前播放的位置

```java
mediaPlayer.getCurrentPosition();
```
### 继续播放（用与暂停之后想继续播放的时候调用）

```java
mediaPlayer.start();
```
### 暂停

```java
mediaPlayer.pause();
```
-------

## 示例代码

*关于示例代码可在本项目的[demo](https://github.com/xiaobaima520gyj/android/tree/master/ui-framework/UIFrameworkDemo)中查看*

------

## 效果图

![效果图](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/media.png)
