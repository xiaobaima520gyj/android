# 滑动返回--类似微信的滑动返回效果

> 版本声明： 此代码并非本人实现，代码转载于: https://github.com/XBeats/and_swipeback


## 特点

- 不需要设置透明theme或windowIsTranslucent = true
- 不影响activity的生命周期
- 只需继承SwipeBackActivity
- 支持Dialog的滑动返回


## 使用

首先在你的application里面添加如下代码：

```java
public class CustomApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());
    }

}
```

然后在你的activity上继承SwipeBackActivity：

```java
public class BaseActivity extends SwipeBackActivity {

}
```

## API

Application在Api14之后添加了新的Callback方法

```java
public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {

    }
```

这样就可以根据activity的生命周期缓存所有Activity，通过list获取上一个activity的实例，从而获取id为content的ContentView的子View（即setContentView中的View），并进行滑动展示。

默认SwipeBackActivity是支持滑动返回的，不需要滑动返回时则需要复写SwipeBackActivity的方法supportSlideBack，其中方法canBeSlideBack意思是能否返回至本Activity；两个方法相互配合使用，以应对各种需求。

```java
public class SwipeBackActivity extends AppCompatActivity implements SwipeBackHelper.SlideBackManager {

    private static final String TAG = "SwipeBackActivity";

    private SwipeBackHelper mSwipeBackHelper;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(mSwipeBackHelper == null) {
            mSwipeBackHelper = new SwipeBackHelper(this);
        }
        return mSwipeBackHelper.processTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

    @Override
    public Activity getSlideActivity() {
        return this;
    }

    @Override
    public boolean supportSlideBack() {
        return true;
    }

    @Override
    public boolean canBeSlideBack() {
        return true;
    }

    @Override
    public void finish() {
        if(mSwipeBackHelper != null) {
            mSwipeBackHelper.finishSwipeImmediately();
            mSwipeBackHelper = null;
        }
        super.finish();
    }
}
```

## 6种事件状态

```java
 	private static final int MSG_ACTION_DOWN = 1; //点击事件  
    private static final int MSG_ACTION_MOVE = 2; //滑动事件
    private static final int MSG_ACTION_UP = 3;  //点击结束
    private static final int MSG_SLIDE_CANCEL = 4; //开始滑动，不返回前一个页面
    private static final int MSG_SLIDE_CANCELED = 5;  //结束滑动，不返回前一个页面
    private static final int MSG_SLIDE_PROCEED = 6; //开始滑动，返回前一个页面
    private static final int MSG_SLIDE_FINISHED = 7;//结束滑动，返回前一个页面
```


1. 在Down手势发生时，只要将上一个Activity的ContentView从parentView中剥离，并加入到当前View的ContentView中；
2. 在滑动手势发生时，加上阴影View，并进行滑动；同时滑动的有当前Activity的ContentView、上一个Activity的ContentView和自定义的阴影View；
3. 在Up手势发生时，判断滑动是否超过半屏，触发返回操作，并展示滑动动画；
4. 滑动取消或滑动返回发生时，需要将上个Activity的ContentView从新加入到上一个Acitivity的布局中。

## 效果

![效果图](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/Gif_20170914_172235.gif)