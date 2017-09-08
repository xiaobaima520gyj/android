# 侧滑菜单的组件
## 简介
这个组件是类似qq测试的一个组件的实现，使用的时候扩展性也比较强，我在示例里面也加入了沉浸式状态栏的实现，当然具体的效果还是得跟业务需求的不同来定。
## 使用

>  因为这个组件的大部分实现是在布局中，所以这里就主要展示布局怎么使用

### 布局示例

*注意: 左边的布局根布局目前只支持RelativeLayout*

```xml
<?xml version="1.0" encoding="utf-8"?>
<com.xbm.android.widget.DragLayout xmlns:android = "http://schemas.android.com/apk/res/android"
              android:orientation = "vertical"
              android:layout_width = "match_parent"
              android:id="@+id/drag_layout"
              android:layout_height = "match_parent"
              android:background="@android:color/transparent">
	<!--左边的布局-->
	<include layout="@layout/left_menu_layout"/>
	<!--右边的主布局-->
	<com.xbm.android.widget.CustomRelativeLayout
			android:layout_width = "match_parent"
			android:layout_height = "match_parent"
			android:background="@android:color/white">
			<LinearLayout android:layout_width = "match_parent"
			              android:layout_height="fill_parent"
			              android:orientation="vertical">
				<RelativeLayout
						android:id="@+id/rl_title"
						android:layout_width="match_parent"
						android:layout_height="49dp"
						android:gravity="bottom"
						android:background="@android:color/holo_blue_dark">
					<TextView android:layout_width = "match_parent"
					          android:layout_height = "wrap_content"
					          android:text="这里是顶部的内容"
					          android:textSize="@dimen/dimen_28sp"
					          android:layout_gravity = "center"
					          android:gravity="center"/>
				</RelativeLayout>

			</LinearLayout>
	</com.xbm.android.widget.CustomRelativeLayout>
</com.xbm.android.widget.DragLayout>
```
左边的布局：

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android = "http://schemas.android.com/apk/res/android"
              android:layout_width = "match_parent"
              android:layout_height = "match_parent"
              android:paddingTop="70dp"
              android:background="@android:color/holo_green_light">
	<LinearLayout
			android:layout_width = "match_parent"
			android:layout_height = "match_parent"
			android:orientation="vertical">
		<TextView android:layout_width = "wrap_content"
		          android:layout_height = "wrap_content"
		          android:text="这里是内容"
		          android:layout_gravity="center"
		          android:textSize="@dimen/dimen_28sp"/>
	</LinearLayout>
</RelativeLayout>
```

### 滑动监听示例

```java
DragLayout dragLayout = (DragLayout) findViewById(R.id.drag_layout);
		dragLayout.setDragListener(new DragLayout.DragListener() {
			//界面打开的时候
			@Override
			public void onOpen() {
			}
			//界面关闭的时候
			@Override
			public void onClose() {
			}

			//界面滑动的时候
			@Override
			public void onDrag(float percent) {
			}
		});
```

*另外的demo的示例代码中有沉浸式状态栏的实现，具体可参考下demo的实现*

## 效果

![效果图1](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/skid1.png)

![效果图2](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/skid2.png)

