# 组件过度动画

> 版权声明： 本代码摘自  https://github.com/florent37/ExpectAnim
## 简介

这是一个组件移动的动画库

## 使用

因为库的源码我已经全部加入到ui-framework的源码里面了，所以用的时候不需要gradle引入依赖。

### 代码示例

```java
new ExpectAnim()

                .expect(avatar)
                .toBe(
                        bottomOfParent().withMarginDp(16),
                        leftOfParent().withMarginDp(16),
                        width(40).toDp().keepRatio()
                )

                .expect(name)
                .toBe(
                        toRightOf(avatar).withMarginDp(16),
                        sameCenterVerticalAs(avatar),
                        toHaveTextColor(Color.WHITE)
                )

                .expect(subname)
                .toBe(
                        toRightOf(name).withMarginDp(5),
                        sameCenterVerticalAs(name),
                        toHaveTextColor(Color.WHITE)
                )

                .expect(follow)
                .toBe(
                        rightOfParent().withMarginDp(4),
                        bottomOfParent().withMarginDp(12),
                        toHaveBackgroundAlpha(0f)
                )

                .expect(message)
                .toBe(
                        aboveOf(follow).withMarginDp(4),
                        rightOfParent().withMarginDp(4),
                        toHaveBackgroundAlpha(0f)
                )

                .expect(bottomLayout)
                .toBe(
                        atItsOriginalPosition()
                )

                .expect(content)
                .toBe(
                        atItsOriginalPosition(),
                        visible()
                )

                .toAnimation()
                .setDuration(1500)

                .start();
```

## 效果

![效果](https://github.com/xiaobaima520gyj/android/blob/master/ui-framework/dep-imgs/expect_anim.gif)

## 附加说明

另外的话还有一个组件移动的动画效果挺好的：  
https://github.com/saulmm/From-design-to-Android-part1