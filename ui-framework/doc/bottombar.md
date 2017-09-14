# 底部导航栏
## 简介
该控件是Google 官方BottomNavigationView的加强版，在此基础上添加了其他一些动画效果，遵循Material Design. 如果你想开发一款带底部导航栏+Fragment/ViewPager的App,通过配置相关信息，你甚至都不用在函数中写一行代码就可以实现炫丽的切换动画。该控件内部实现了切换的逻辑，让开发者们专注于Fragment页面的开发，提高开发效率。
## 使用

### menu菜单的设置

- 首先在res/menu/下面新建一个xml文件

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
  android:title="首页"
  android:icon="@drawable/ic_home"
  ></item>
    <item
  android:title="发现"
  android:icon="@drawable/ic_t4"
  ></item>
    <item
  android:title="社交"
  android:icon="@drawable/ic_t5"
  ></item>
</menu>
```

- 如果想自动集成fragment/viewpager切换逻辑


item: 
```xml
 <item
  ...
  fragment="com.wakehao.demo.fragment.WeChatHomeFragment"
  ></item>
  <item
  ...
  fragment="Fragment完整包名"
  >
  .
```

layout:

```xml
 <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></FrameLayout>
<com.wakehao.bar.BottomNavigationBar
    ...
    app:fragmentContainerId="@id/fragment_container"
    ...
    >   
```

### 自定义控件的设置

```xml
<com.wakehao.bar.BottomNavigationBar
  android:id="@+id/bar"
  app:switchMode="shift"
  app:isSlide="true"
  app:menu="@menu/demo_menu_2"
  app:selectedColor="#ffffff"
  app:unSelectedColor="#bbbbbb"
  app:fragmentContainerId="@id/fragment_container"
  app:viewpagerId="@id/viewpager"
  android:layout_alignParentBottom="true"
  android:layout_width="match_parent"
  android:layout_height="wrap_content">
</com.wakehao.bar.BottomNavigationBar>
```

#### app:switchMode
- still 点击item不产生动画效果
- scale 点击item有缩放效果,默认是scale
- shift 点击item有偏移效果

#### app:isSlide
默认false，设置为true表示可以随着viewPager的滑动item有渐变效果。所以设置为true需要提供viewPagerId以及icon2

- isSlide=true:随着viewPager的滑动而不断改变图片文字背景色等...

#### app:menu
将res/meun目录下的xml文件中的item填充到该视图中
#### app:selectedColor
被选中的item图片和文字的颜色，默认是colorPrimary
#### app:unSelectedColor
未被选中item图片和文字的颜色，默认是Color.GRAY
#### app:fragmentContainerId
指定存放fragment的容器，配合item里的设置可以自动实现bar点击切换相应的fragment
#### app:viewpagerId
指定存放viewpager的容器，配合item里的设置可以自动实现bar和viewpager之间的联动

### 代码设置
bar.showNum(position,num);

- num<0 显示小红点，不可拖拽
- 99>=num>0 显示1到99的数字，可拖拽
- num>99 显示99+，可拖拽

```java
bar.showNum(0,80);
bar.showNum(1,100);
bar.showNum(2,-2);
```
 
```java
bar.disMissNum(position) //指定位置的小红点消失 
```

```java
bar.setOnNavigationItemSelectedListener() //监听点击事件
```

```java
bar.setOnNavigationItemSelectedListener(new BottomNavigationBar.OnNavigationItemSelectedListener() {
    @Override
  public boolean onNavigationItemSelected(@NonNull BottomNavigationItem item, int selectedPosition) {
        if(selectedPosition==2){
            //返回值为false表示不可点击
  return false;
        }
        return true;
    }
    @Override
  public void onNavigationItemSelectedAgain(@NonNull BottomNavigationItem item, int reSelectedPosition) {
        //reSelectedPosition 表示已选中之后再次点击该位置
  Toast.makeText(MainActivity.this,"you click it again on item :"+reSelectedPosition,Toast.LENGTH_SHORT).show();
    }
});
```

```java
bar.setTitle(position,title)

//动态设置position位置的item的标题
bar.setItemSelected(position,true);

//通过代码设置position位置item选中,true表示执行动画(shfit,scale),false不执行.
bar.showBar()/bar.hideBar()

//Slide(滑动) 显示/隐藏bar
bar.showBar(1)/bar.hideBar(1)

//Fade(渐隐) 显示/隐藏bar
bar.getFragment(position)

//获取相应位置的Fragment实例
bar.getViewPager()

//获取ViewPager实例
```
### 导航栏的显示与隐藏

#### 隐藏

```java
bar.hideBar();
```

####显示

```java
bar.showBar();
```

```java
customScrollView.setScrollStateListener(new CustomScrollView.ScrollStateListener() {
            @Override
            public void onScrollUp() {
                bar.hideBar();
            }

            @Override
            public void onScrollDown() {
               bar.showBar();
            }
        });
```


## 效果

![效果图](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/Gif_20170914_154323.gif)

![效果图](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/Gif_20170914_154649.gif)





