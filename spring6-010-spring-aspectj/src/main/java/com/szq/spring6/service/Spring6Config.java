package com.szq.spring6.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//代替spring.xml文件
@ComponentScan({"com.szq.spring6.service"})//组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)//使用aspectj的动态代理GLIB的动态代理
public class Spring6Config {
}
