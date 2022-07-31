package com.pirvate.store.service;


import com.pirvate.store.entity.Product;

import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/31  7:06
 * Description(说明)):
 *  商品热销接口
 */
public interface ProductService {
    /**
     * 首页展示热销商品，根据优先级(销量)倒序排，取4个
     */
    List<Product> hotCommodity();

    /**
     *  根据id 查询商品详细信息
     * @param id 商品id
     * @return 商品详细信息
     */
    Product queryById(Integer id);
}
