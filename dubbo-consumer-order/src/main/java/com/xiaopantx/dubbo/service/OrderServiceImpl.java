package com.xiaopantx.dubbo.service;

import com.xiaopantx.pojo.Order;
import com.xiaopantx.service.OrderService;
import com.xiaopantx.service.ProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author panxj
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(version = "1.0.0", loadbalance = "roundrobin")
    private ProductService productService;

    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public Order info(Integer id) {
        return new Order()
                .setId(1)
                .setProductList(Arrays.asList(productService.info(1), productService.info(2)));
    }

    @Override
    public boolean save(Order entity) {
        return false;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }
}
