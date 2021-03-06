# 浮动按钮组件

## 简介
这是一个浮动按钮的组件，其中包括浮动菜单，点击的时候向上弹出一串按钮菜单

## 使用

### 布局示例

```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             xmlns:fab="http://schemas.android.com/apk/res-auto"
             android:layout_width="match_parent"
             android:layout_height="match_parent">

	<ListView
			android:id="@+id/list"
			android:layout_width="match_parent"
			android:layout_height="match_parent" />

	<com.xbm.android.flobtn.FloatingActionMenu
			android:id="@+id/menu_labels_right"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:layout_alignParentBottom="true"
			android:paddingRight="10dp"
			android:paddingBottom="10dp"
			android:paddingLeft="10dp"
			fab:menu_labels_ellipsize="end"
			fab:menu_labels_singleLine="true"
			fab:menu_backgroundColor="#ccffffff"
			fab:menu_labels_position="left"
			fab:menu_fab_hide_animation="@anim/fab_scale_down">

		<com.xbm.android.flobtn.FloatingActionButton
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:src="@drawable/ic_arrow_back_white_24dp"
				fab:fab_size="mini"
				fab:fab_label="Menu item 1" />

		<com.xbm.android.flobtn.FloatingActionButton
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:src="@drawable/ic_arrow_back_white_24dp"
				fab:fab_size="mini"
				fab:fab_label="Menu item 2" />

		<com.xbm.android.flobtn.FloatingActionButton
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:src="@drawable/ic_arrow_back_white_24dp"
				fab:fab_size="mini"
				fab:fab_label="@string/lorem_ipsum" />

	</com.xbm.android.flobtn.FloatingActionMenu>

</FrameLayout>
```

如果想在列表滑动的时候按钮有所动画的话

```java
listView.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				Log.i(TAG, "firstVisibleItem====>>>" + firstVisibleItem);
				Log.i(TAG, "mPreviousVisibleItem====>>>" + mPreviousVisibleItem);
				if (firstVisibleItem > mPreviousVisibleItem){
					floatingActionMenu.hideMenu(true);
				}else if (firstVisibleItem < mPreviousVisibleItem){
					floatingActionMenu.showMenu(true);
				}

				mPreviousVisibleItem = firstVisibleItem;
			}
		});
```

## 效果

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/device-2017-09-20-095826.png)


