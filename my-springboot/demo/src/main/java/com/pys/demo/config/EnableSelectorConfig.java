package com.pys.demo.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class EnableSelectorConfig implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 可以根据实际情况加入参数
        //Map<String, Object> annotationAttributes = annotationMetadata
        // .getAnnotationAttributes(AutoSelectorConfigAnno.class.getName());
        //String XXX = (String) annotationAttributes.get("XXX");
        return new String[]{EnableSelectorConfigBean.class.getName()};
    }
}
