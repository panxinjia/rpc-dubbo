package com.xiaopantx.dubbo.runner;

import com.xiaopantx.pojo.Order;
import com.xiaopantx.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 测试， 容器启动 dubbo 做rpc调用
 * @author panxj
 */
@Slf4j
@Component
public class LoadRunner implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            Order order = orderService.info(i+1);
            log.info("order => {}", order);
        }
    }
}
