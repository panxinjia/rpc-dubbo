package com.xiaopantx.rmi.config;

import com.xiaopantx.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * @author panxj
 */
@Configuration
public class RmiConfig {

    @Autowired
    private ProductService productService;

    @Bean
    public RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        // 代理端口
        exporter.setRegistryPort(8200);
        // 服务名
        exporter.setServiceName("product-service");
        // 真实服务实例
        exporter.setService(productService);
        // 面向接口代理
        exporter.setServiceInterface(ProductService.class);
        return exporter;
    }
}
