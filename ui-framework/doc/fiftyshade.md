# 数据加载布局占位的实现

> 版本说明：本代码出自 https://github.com/florent37/FiftyShadesOf

## 简介
一个数据加载时候布局占位的库

## 用法

使用的时候非常简单，一句代码就搞定了

### 开始占位
```java
FiftyShadesOf.with(context)
             .on(view1, view2, view3)
             .start();
```

### 停止占位

```java
fiftyShadesOf.stop();
```

## 效果

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/cross.gif)