# 下拉刷新框架--SmartRefreshLayout

> 版权声明： 本框架转载自 https://github.com/scwang90/SmartRefreshLayout

## 简介

下拉刷新、上拉加载、RefreshLayout、OverScroll，Android智能下拉刷新框架，支持越界回弹，具有极强的扩展性，集成了几十种炫酷的Header和 Footer。 


## 特点功能

- 
    支持所有的 View（AbsListView、RecyclerView、WebView....View） 和多层嵌套的视图结构
-     支持自定义并且已经集成了很多炫酷的 Header 和 Footer （图）.
 -    支持和ListView的同步滚动 和 RecyclerView、AppBarLayout、CoordinatorLayout 的嵌套滚动 NestedScrolling.
 -    支持在Android Studio Xml 编辑器中预览 效果（图）
 -    支持分别在 Default（默认）、Xml、JavaCode 三个中设置 Header 和 Footer.
  -   支持自动刷新、自动上拉加载（自动检测列表惯性滚动到底部，而不用手动上拉）.
 -    支持通用的刷新监听器 OnRefreshListener 和更详细的滚动监听 OnMultiPurposeListener.
 -    支持自定义回弹动画的插值器，实现各种炫酷的动画效果.
  -  支持设置主题来适配任何场景的App，不会出现炫酷但很尴尬的情况.
  -  支持设置多种滑动方式来适配各种效果的Header和Footer：平移、拉伸、背后固定、顶层固定、全屏
  -  支持内容尺寸自适应 Content-wrap_content
  -  支持继承重写和扩展功能，内部实现没有 private 方法和字段，继承之后都可以重写覆盖
  -  支持越界回弹（Listview、RecyclerView、ScrollView、WebView...View）
  -  支持多点触摸，下拉、上拉各种手势冲突
  
## 使用

1. 在 buld.gradle 中添加依赖
	
```gradle
compile 'com.android.support:appcompat-v7:25.3.1'//版本随意
compile 'com.scwang.smartrefresh:SmartRefreshLayout:1.0.3'
compile 'com.scwang.smartrefresh:SmartRefreshHeader:1.0.3'//没有使用特殊Header，可以不加这行
```

2. 在XML布局文件中添加 SmartRefreshLayout

```xml
<?xml version="1.0" encoding="utf-8"?>
<com.scwang.smartrefresh.layout.SmartRefreshLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/refreshLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:overScrollMode="never"
        android:background="#fff" />
</com.scwang.smartrefresh.layout.SmartRefreshLayout>
```
3. 在 Activity 或者 Fragment 中添加代码

```java
RefreshLayout refreshLayout = (RefreshLayout)findViewById(R.id.refreshLayout);
refreshLayout.setOnRefreshListener(new OnRefreshListener() {
    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        refreshlayout.finishRefresh(2000);
    }
});
refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        refreshlayout.finishLoadmore(2000);
    }
});
```

## 使用指定的 Header 和 Footer

1. 方法一 全局设置

```java
public class App extends Application {
    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
                @Override
                public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                    layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                    return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);//指定为经典Header，默认是 贝塞尔雷达Header
                }
            });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
                @Override
                public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                    //指定为经典Footer，默认是 BallPulseFooter
                    return new ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
                }
            });
    }
}
```
*注意：方法一 设置的Header和Footer的优先级是最低的，如果同时还使用了方法二、三，将会被其它方法取代*

2. 方法二 XML布局文件指定

```xml
<com.scwang.smartrefresh.layout.SmartRefreshLayout
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/refreshLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#444444"
    app:srlPrimaryColor="#444444"
    app:srlAccentColor="@android:color/white"
    app:srlEnablePreviewInEditMode="true">
    <!--srlAccentColor srlPrimaryColor 将会改变 Header 和 Footer 的主题颜色-->
    <!--srlEnablePreviewInEditMode 可以开启和关闭预览功能-->
    <com.scwang.smartrefresh.layout.header.ClassicsHeader
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="@dimen/padding_common"
        android:background="@android:color/white"
        android:text="@string/description_define_in_xml"/>
    <com.scwang.smartrefresh.layout.footer.ClassicsFooter
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</com.scwang.smartrefresh.layout.SmartRefreshLayout>
```
*注意：方法二 XML设置的Header和Footer的优先级是中等的，会被方法三覆盖。而且使用本方法的时候，Android Studio 会有预览效果*

3. 方法三 Java代码设置

```java
final RefreshLayout refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
//设置 Header 为 Material风格
refreshLayout.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
//设置 Footer 为 球脉冲
refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
```

## 效果

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/gif_practive_repast.gif)
![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/gif_practive_weibo.gif)
![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/gif_WaterDrop.gif)
![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/gif_WaveSwipe.gif)

## License

Copyright 2017 xiaobaima from scwang90

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


