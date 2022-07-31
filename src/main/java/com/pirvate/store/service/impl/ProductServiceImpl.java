package com.pirvate.store.service.impl;

import com.pirvate.store.entity.Product;
import com.pirvate.store.entity.ProductExample;
import com.pirvate.store.mapper.ProductMapper;
import com.pirvate.store.service.ProductService;
import com.pirvate.store.service.ex.ProductNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/31  7:08
 * Description(说明)):
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    /**
     *  热销商品展示
     * @return
     */
    @Override
    public List<Product> hotCommodity() {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andStatusEqualTo(1);
        productExample.setOrderByClause("priority DESC");
        List<Product> products = productMapper.selectByExample(productExample);
        List<Product> hotProducts = new ArrayList<>();
        hotProducts.add(products.get(0));
        hotProducts.add(products.get(1));
        hotProducts.add(products.get(2));
        hotProducts.add(products.get(3));

        return hotProducts;
    }


    /**
     *  商品详细页
     * @param id 商品id
     * @return
     */
    @Override
    public Product queryById(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        if(product==null){
            throw new ProductNotFindException("没有找到该商品");
        }
        return product;
    }
}
