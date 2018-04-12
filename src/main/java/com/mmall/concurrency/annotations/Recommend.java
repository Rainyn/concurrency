package com.mmall.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 用来标记[推荐]的写法
 * @author: Yuanjk
 * @create: 2018-04-12 00:50:11
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public  @interface Recommend {
    String value() default "";
}
