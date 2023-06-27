package com.ayush.article.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonZeroInteger {
/*    String message() default "Integer value cannot be 0.";*/
    int value() default 0;
}
