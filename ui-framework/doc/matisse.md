# 图片视频选择组件

> 版本说明：本代码摘自  https://github.com/zhihu/Matisse

## 特点

- 可以在activity与fragment中用
- 可以选择包括JPEG, PNG, GIF和视频(MPEG, MP4)
- 可以自定义主题，目前已经有了两个主题：Matisse_Zhihu (light mode) 和 Matisse_Dracula

- 不同的图片加载器
- 可以定义过滤规则

## 混淆

如果你用的图片加载库是glide，可以加入：
```
-dontwarn com.bumptech.glide.**
```

如果你用的图片加载库是picasso，可以加入：
```
-dontwarn com.squareup.picasso.**
```

## 使用

### 权限

这个库要求要两个权限：

- android.permission.READ_EXTERNAL_STORAGE
- android.permission.WRITE_EXTERNAL_STORAGE

*如果是android 6.0以上的话，在启动图片选择的页面之前要做下权限检查*

### 启动
从当前的activity或者fragment启动选择页面：

```java
Matisse.from(MainActivity.this)
        .choose(MimeType.allOf())
        .countable(true)
        .maxSelectable(9)
        .addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
        .thumbnailScale(0.85f)
        .imageEngine(new GlideEngine())
        .forResult(REQUEST_CODE_CHOOSE);
```

### 主题
- R.style.Matisse_Zhihu (light mode)
- R.style.Matisse_Dracula (dark mode)

### 接收返回的路径结果

```java
List<Uri> mSelected;

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
        mSelected = Matisse.obtainResult(data);
        Log.d("Matisse", "mSelected: " + mSelected);
    }
}
```
*注意：源代码已经加入到了ui库里面了，用的时候就直接用就可以了，这个便于以后在项目中进行定制*

## 效果

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/device-2017-09-20-102705.png)

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/device-2017-09-20-102730.png)

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/device-2017-09-20-102801.png)

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/device-2017-09-20-102823.png)

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/device-2017-09-20-102855.png)

## License

Copyright 2017 xiaobaima.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

