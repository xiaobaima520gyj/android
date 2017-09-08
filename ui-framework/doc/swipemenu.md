# 列表项的侧滑组件

> 版权声明：本文转自严振杰的博客: http://blog.yanzhenjie.com

## 简介
首先声明的是这个组件是由严振杰先生开发的，非常好用，所以就引进来了

## 使用

关于使用，我想严振杰先生说的非常的清楚，以下就是严振杰先生对该组件的讲解：

- [侧滑菜单 github源码](https://github.com/yanzhenjie/SwipeRecyclerView)
- [ RecyclerView侧滑菜单  博客讲解](http://blog.csdn.net/yanzhenjie1003/article/details/52115566)

### StickyNestedScrollView 标题头停靠组件
> 另外的话，我看到严先生的博客以及文档里面没有对StickyNestedScrollView(列表项的标题头停靠)组件做说明，所以这里的话我就停靠组件做下说明吧

#### 布局示例

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android = "http://schemas.android.com/apk/res/android"
              android:orientation = "vertical"
              android:layout_width = "match_parent"
              android:layout_height = "match_parent">
	<com.yanzhenjie.recyclerview.swipe.widget.StickyNestedScrollView
			android:id="@+id/scroll_view"
			android:layout_width="match_parent"
			android:layout_height="wrap_content">
	<com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView
			android:id="@+id/recycler_view"
			android:layout_width="match_parent"
			android:layout_height="wrap_content"/>
	</com.yanzhenjie.recyclerview.swipe.widget.StickyNestedScrollView>
</LinearLayout>
```

## 效果

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/swipe_menu.png)

接下来就是声明那个组件是停靠组件了，这个也非常简单，就是在需要停靠的组件上面加一个名字为sticky的tag属性就可以了

```xml
<?xml version="1.0" encoding="utf-8"?>

<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorPrimary"
    android:tag="sticky">  <!--有了这个tag属性这个布局的view就可以停靠了-->

    <TextView
        android:id="@+id/tv_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center_vertical"
        android:padding="@dimen/dp_10"
        android:text="AAAAA"
        android:textColor="?colorAccent"/>

</FrameLayout>

```

如果想实现了静态的添加停靠的话也非常简单，只要在StickyNestedScrollView布局里面添加一个tag属性为sticky的布局组件就行了

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android = "http://schemas.android.com/apk/res/android"
              android:orientation = "vertical"
              android:layout_width = "match_parent"
              android:layout_height = "match_parent">
	<com.yanzhenjie.recyclerview.swipe.widget.StickyNestedScrollView
			android:id="@+id/scroll_view"
			android:layout_width="match_parent"
			android:layout_height="wrap_content">
			 <TextView
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:background="@color/green_normal"
				android:padding="@dimen/dp_10"
				android:tag="sticky"  <!--有了这个tag属性这个布局的view就可以停靠了-->
				android:text="A"/>
	</com.yanzhenjie.recyclerview.swipe.widget.StickyNestedScrollView>
</LinearLayout>
```

## License

Copyright 2017 xiaobaima

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.