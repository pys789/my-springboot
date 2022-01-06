package com.pys.demo.annotation;

import com.pys.demo.config.EnableSelectorConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({EnableSelectorConfig.class})
public @interface EnableSelectorConfigAnno {
}
