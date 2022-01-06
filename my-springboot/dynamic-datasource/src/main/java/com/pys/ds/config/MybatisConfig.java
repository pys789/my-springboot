package com.pys.ds.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@MapperScan("com.pys.ds.dao")
public class MybatisConfig {

    @Autowired
    private MasterDruidDataSourceProperties masterProperties;

    @Autowired
    private SlaveDruidDataSourceProperties slaveProperties;

    @Bean("master")
    @Primary
    public DataSource master() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(masterProperties.getDriverClassName());
        druidDataSource.setUrl(masterProperties.getUrl());
        druidDataSource.setUsername(masterProperties.getUsername());
        druidDataSource.setPassword(masterProperties.getPassword());
        return druidDataSource;
    }

    @Bean("slave")
    public DataSource slave() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(slaveProperties.getDriverClassName());
        druidDataSource.setUrl(slaveProperties.getUrl());
        druidDataSource.setUsername(slaveProperties.getUsername());
        druidDataSource.setPassword(slaveProperties.getPassword());
        return druidDataSource;
    }

    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(master());
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceKey.MASTER.getName(), master());
        dataSourceMap.put(DataSourceKey.SLAVE.getName(), slave());
        dynamicDataSource.setDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource());
        // 扫描Model
        sessionFactory.setTypeAliasesPackage("com.pys.springboot.model");

        // 扫描映射文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));

        Objects.requireNonNull(sessionFactory.getObject())
                .getConfiguration().setMapUnderscoreToCamelCase(true);

        return sessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
