package com.pys.demo.annotation;

import com.pys.demo.config.EnableConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({EnableConfig.class})
public @interface EnableConfigAnno {
}
