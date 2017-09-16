# 简单的列表快速索引组件

> 版权说明：本代码摘自  https://github.com/SouthernBox/IndexBar

## 简介
这是一个很简单的列表快速索引组件，支持顶部悬浮标签。

## 使用

### 布局

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                android:id="@+id/activity_main"
                android:layout_width="match_parent"
                android:layout_height="match_parent">

	<android.support.v7.widget.RecyclerView
			android:id="@+id/rv"
			android:layout_width="match_parent"
			android:layout_height="match_parent" />

	<include
			layout="@layout/item_index"
			android:visibility="gone" />

	<com.xbm.android.widget.IndexBar
			android:id="@+id/indexbar"
			android:layout_width="20dp"
			android:layout_height="match_parent"
			android:layout_alignParentRight="true" />

	<TextView
			android:id="@+id/tv_toast"
			android:layout_width="80dp"
			android:layout_height="80dp"
			android:layout_centerInParent="true"
			android:alpha="0.8"
			android:background="@drawable/toast_bg"
			android:gravity="center"
			android:textColor="@color/white"
			android:textSize="40sp"
			android:visibility="gone" />

</RelativeLayout>

```
item_index:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:id="@+id/ll_index"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:background="#DDDDDD"
              android:orientation="vertical">

	<TextView
			android:id="@+id/tv_index"
			android:layout_width="wrap_content"
			android:layout_height="24dp"
			android:layout_marginLeft="19dp"
			android:gravity="center"
			android:textSize="14sp" />

	<View
			android:layout_width="wrap_content"
			android:layout_height="1px"
			android:background="#c7c7c7" />

</LinearLayout>
```

### 代码简介

- 初始化索引栏，这个是在滑动的时候列表滚动到指定的位置

```java
/**
	 * 初始化快速索引栏
	 */
	private void initIndexBar(View view) {
		mIndexBar = (IndexBar) view.findViewById(R.id.indexbar);
		TextView tvToast = (TextView) view.findViewById(R.id.tv_toast);
		mIndexBar.setSelectedIndexTextView(tvToast);
		mIndexBar.setOnIndexChangedListener(new IndexBar.OnIndexChangedListener() {
			@Override
			public void onIndexChanged(String index) {
				for (int i = 0; i < mList.size(); i++) {
					String firstWord = mList.get(i).getFirstWord();
					if (index.equals(firstWord)) {
						// 滚动列表到指定的位置
						layoutManager.scrollToPositionWithOffset(i, 0);
						return;
					}
				}
			}
		});
	}
```

- 初始化顶部悬浮标签

```java
	/**
	 * 初始化顶部悬浮标签
	 */
	private void initFlowIndex(View view) {
		vFlow = view.findViewById(R.id.ll_index);
		tvFlowIndex = (TextView) view.findViewById(R.id.tv_index);
		mRecyclerView.addOnScrollListener(new ScrollListener());
		//设置首项的索引字母
		if (mList.size() > 0) {
			tvFlowIndex.setText(mList.get(0).getFirstWord());
			vFlow.setVisibility(View.VISIBLE);
		}
	}
```
下面这个ScrollListener很重要，它会根据layoutManager得到第二个view然后得到第二个view的top与顶部的view的高度做比较来设置顶部view的y轴的值，如果没有这个比较的话，滑动的悬停改变标签内容的时候会很生硬。

```java
private class ScrollListener extends RecyclerView.OnScrollListener {

		private int mFlowHeight;
		private int mCurrentPosition = -1;

		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			mFlowHeight = vFlow.getMeasuredHeight();
		}

		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
			View view = layoutManager.findViewByPosition(firstVisibleItemPosition + 1);

			if (view != null) {
				if (view.getTop() <= mFlowHeight && isItem(firstVisibleItemPosition + 1)) {
					vFlow.setY(view.getTop() - mFlowHeight);
				} else {
					vFlow.setY(0);
				}
			}

			if (mCurrentPosition != firstVisibleItemPosition) {
				mCurrentPosition = firstVisibleItemPosition;
				tvFlowIndex.setText(mList.get(mCurrentPosition).getFirstWord());
			}
		}

		/**
		 * @param position 对应项的下标
		 * @return 是否为标签项
		 */
		private boolean isItem(int position) {
			return mAdapter.getItemViewType(position) == IndexBarAdapter.VIEW_INDEX;
		}
	}
```

*这里只是列举了几处关键的代码，具体的代码可在demo里面查看*

## 效果

![效果图](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/FlowIndex.gif)
![效果图](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/IndexBar.gif)

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




