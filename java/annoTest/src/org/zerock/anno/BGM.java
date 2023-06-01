package org.zerock.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //자바 리플렉션에 이용하려고
@Target({ElementType.TYPE, ElementType.METHOD})   //이용할 장소 제한
public @interface BGM {

    String value();
    int duration() default 30;
}
