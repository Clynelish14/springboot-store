package com.pirvate.store.service;

import com.pirvate.store.entity.Cart;

import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/31  1:58
 * Description(说明)):
 * 购物车业务层接口
 */
public interface CartService {

    /**
     *  加入购物车
     * @param uid  用户id
     * @param pid  商品id
     * @param num  添加数量
     * @param username  用户名字
     */
    void addToCart(Integer uid,Integer pid,Integer num,String username);

    /**
     *  购物车显示
     * @return
     */
    List<Cart> queryByUid(Integer uid);

}
