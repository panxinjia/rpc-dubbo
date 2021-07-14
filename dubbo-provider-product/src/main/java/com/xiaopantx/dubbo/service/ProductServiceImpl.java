package com.xiaopantx.dubbo.service;

import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * org.apache.dubbo.config.annotation.Service 注解，非Spring@Service注解
 * @author panxj
 */
@Slf4j
@Service(version = "1.0.0", timeout = 10000, interfaceClass = ProductService.class)
@Component
public class ProductServiceImpl implements ProductService {

    @Value("${server.port}")
    private Integer port;

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public Product info(Integer id) {
        log.info("port => {}", port);
        return Product.builder()
                .id(id)
                .productName(UUID.randomUUID().toString())
                .productNum(10)
                .productPrice(Math.random() * 10000)
                .build();
    }

    @Override
    public boolean save(Product entity) {
        return false;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }
}
