//package com.ayush.article.annotation;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.util.Objects;
//
//@Component
//@Aspect
//public class NonZeroIntegerAspect {
//
//    @Before("@annotation(NonZeroInteger)")
//    public  void checkIntegerValue(ProceedingJoinPoint joinPoint) {
//        if (Objects.isNull(object)) {
//            throw new RuntimeException("The Integer value is null");
//        }
//        Class<?> clazz = object.getClass();
//       /*
//        if (!clazz.isAnnotationPresent(NonZeroInteger.class)) {
//            throw new RuntimeException("The class "
//                    + clazz.getSimpleName()
//                    + " is not annotated with NonZeroInteger");
//        }*/
//
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field field:declaredFields){
//            field.setAccessible(true);
//            if (field.isAnnotationPresent(NonZeroInteger.class)){
//                NonZeroInteger fieldAnnotation = field.getAnnotation(NonZeroInteger.class);
//                int value = fieldAnnotation.value();
//                if (value==0){
//                    throw new RuntimeException("Integer Value Cannot be Zero");
//                }
//            }
//        }
//
//    }
//}
