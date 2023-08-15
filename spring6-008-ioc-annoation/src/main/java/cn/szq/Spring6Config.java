package cn.szq;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类，代替Spring框架的配置文件
 * 全注解开发
 */
@Configuration
@ComponentScan({"cn.szq.dao","cn.szq.service"})
public class Spring6Config {

}
