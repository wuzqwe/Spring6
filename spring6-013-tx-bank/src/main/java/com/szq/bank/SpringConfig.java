package com.szq.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration //代替spring.xml文件
@ComponentScan("com.szq.bank")  //组件扫描
@EnableTransactionManagement//开启事务注解
public class SpringConfig {


    //Spring容器看到这个Bean注解后，会调用这个被标注的方法，这个方法的返回值是一个java对象，这个java对象会自动纳入IOC容器管理
    //返回的对象就是Spring容器当中的一个Bean
    //并且这个bean的名字是dataSource
    @Bean(name = "dataSource")
    public DruidDataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/spring6");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("137152001szq");

        return  druidDataSource;
    }

    @Bean(name="jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){//Spring在调用这个方法的时候会自动传递过来一个dataSource对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean(name = "txManger")
    public DataSourceTransactionManager getDataSourceTransactionManager(){
        DataSourceTransactionManager txManger = new DataSourceTransactionManager();
        txManger.setDataSource(getDataSource());
        return txManger;
    }
}
