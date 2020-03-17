package edu.ethan.cartoon.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Administrator
 * @date 2019/12/9
 */

@Configuration
@ComponentScan(basePackages = "edu.ethan.cartoon")
@EnableTransactionManagement
@MapperScan("edu.ethan.cartoon.dao")
public class AppConfig {

    /**
     * 配置Druid数据源连接池
     * , excludeFilters = @ComponentScan.Filter(Controller.class)
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/cartoon?useSSL=true&useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setMaxActive(200);
        ds.setInitialSize(5);
        ds.setMinIdle(5);
        ds.setMaxWait(60000);
        ds.setMinEvictableIdleTimeMillis(300000);
        ds.setTimeBetweenEvictionRunsMillis(60000);
        ds.setTestWhileIdle(true);
        ds.setTestOnReturn(false);
        ds.setPoolPreparedStatements(false);
        ds.setValidationQuery("select 1");
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //注入数据源
        factoryBean.setDataSource(dataSource());
        //设置实体包的别名
        factoryBean.setTypeAliasesPackage("edu.ethan.cartoon.entity");
        //指定mapper映射文件的路径
        PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resource.getResources("classpath:mapper/*.xml"));


        return factoryBean;
    }

    /**
     * 配置事务管理器，并注入数据源
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}