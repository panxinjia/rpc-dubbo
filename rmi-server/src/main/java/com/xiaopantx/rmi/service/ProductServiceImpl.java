package com.xiaopantx.rmi.service;

import com.xiaopantx.pojo.Product;
import com.xiaopantx.service.ProductService;
import com.xiaopantx.service.adaptor.ProductServiceAdaptor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author panxj
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public Product info(Integer id) {
        return new Product().setId(id).setProductName("小米手机")
                .setProductNum(2)
                .setProductPrice(2000.00);
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
