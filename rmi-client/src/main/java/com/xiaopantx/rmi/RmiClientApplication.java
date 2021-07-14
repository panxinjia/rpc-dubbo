package com.xiaopantx.rmi;

import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.util.Arrays;

/**
 * @author panxj
 */
@Slf4j
@SpringBootApplication
public class RmiClientApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(RmiClientApplication.class, args);
    }

    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        // 面向接口代理
        proxy.setServiceInterface(ProductService.class);
        // 远程方法调用
        proxy.setServiceUrl("rmi://127.0.0.1:8200/product-service");
        return proxy;
    }


    @Autowired
    private RmiProxyFactoryBean rmiProxyFactoryBean;

    /**
     * SpringBoot 时执行， CommandLineRunner 回调接口
     * @param args 外部启动参数
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Object proxyBean = rmiProxyFactoryBean.getObject();
        ProductService productService = (ProductService) proxyBean;
        for(int i = 0; i < 10; i++) {
            Product prod = productService.info(i + 1);
            log.info("prod => {}", prod.toString());
        }
    }

}
