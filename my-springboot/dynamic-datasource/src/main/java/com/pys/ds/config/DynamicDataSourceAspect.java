package com.pys.ds.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1) // 该切面应当先于 @Transactional 执行
@Component
@Slf4j
public class DynamicDataSourceAspect {
    /**
     * 切换数据源
     */
    @Before("@annotation(dataSource))")
    public void switchDataSource(JoinPoint point, DataSource dataSource) {
        if (!DynamicDataSourceContextHolder.containDataSourceKey(dataSource.value().getName())) {
            log.info("DataSource [{}] doesn't exist, use default DataSource [{}]",dataSource.value());
        } else {
            DynamicDataSourceContextHolder.setDataSourceKey(dataSource.value().getName());
            log.info("Switch DataSource to {} in Method {}",
                    DynamicDataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }
    }

    /**
     * 重置数据源
     */
    @After("@annotation(dataSource))")
    public void restoreDataSource(JoinPoint point, DataSource dataSource) {
        // 将数据源置为默认数据源
        DynamicDataSourceContextHolder.clearDataSourceKey();
        log.info("Restore DataSource to {} in Method {}",
                DynamicDataSourceContextHolder.getDataSourceKey(),point.getSignature());
    }
}