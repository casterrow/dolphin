package com.github.dolphin.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Stephen Liu
 * @since 2017/4/9
 */
@Configuration
@EnableConfigurationProperties(value = {
    DruidConfig.class
})
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(prefix = "druid", name = "url")
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class AutoConfig {

    @Autowired
    private DruidConfig druidConfig;

    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidConfig.getDriverClass());
        dataSource.setUrl(druidConfig.getUrl());
        dataSource.setUsername(druidConfig.getUsername());
        dataSource.setPassword(druidConfig.getPassword());
        dataSource.setMaxActive(druidConfig.getMaxActive());
        dataSource.setInitialSize(druidConfig.getInitialSize());
        dataSource.setMaxWait(druidConfig.getMaxWait());
        dataSource.setMinIdle(druidConfig.getMinIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(3000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setFilters("config");
        Properties properties = new Properties();
        //使用加密密码
        //properties.put("config.decrypt", "true");
        dataSource.setConnectProperties(properties);
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(5000);
        statFilter.setMergeSql(true);

        List<Filter> filterList = new ArrayList<>();
        filterList.add(statFilter);
        dataSource.setProxyFilters(filterList);
        return dataSource;
    }
}
