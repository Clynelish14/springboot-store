package com.pirvate.store.service.impl;

import com.pirvate.store.entity.Cart;
import com.pirvate.store.entity.CartExample;
import com.pirvate.store.entity.Product;
import com.pirvate.store.mapper.CartMapper;
import com.pirvate.store.mapper.ProductMapper;
import com.pirvate.store.service.CartService;
import com.pirvate.store.service.ex.InsertException;
import com.pirvate.store.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/31  2:00
 * Description(说明)):
 */
@Service
public class CartServiceImpl implements CartService{
    private CartMapper cartMapper;
    private ProductMapper productMapper;

    @Autowired
    public CartServiceImpl(CartMapper cartMapper, ProductMapper productMapper) {
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    /**
     *  添加购物车方法
     * @param uid  用户id
     * @param pid  商品id
     * @param num  添加数量
     * @param username  用户名字
     */
    @Override
    public void addToCart(Integer uid, Integer pid, Integer num, String username) {
        Date date = new Date();
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andPidEqualTo(pid).andUidEqualTo(uid);
        List<Cart> carts = cartMapper.selectByExample(cartExample);//先查询该商品在购物车里有没有
        // 在购物车没有 则添加完成信息
        if(carts.isEmpty()){
            Product product = productMapper.selectByPrimaryKey(pid);
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setPrice(product.getPrice());
            cart.setNum(num);

            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedUser(username);
            cart.setModifiedTime(date);

            int i = cartMapper.insertSelective(cart);
            if(i!=1){
                throw new InsertException("新增购物车数据时出现异常");
            }
        }else{ //在购物车有，则追加新加入的商品数量
            Integer i = carts.get(0).getNum() + num;
            carts.get(0).setNum(i);

            carts.get(0).setCreatedUser(username);
            carts.get(0).setCreatedTime(date);
            carts.get(0).setModifiedUser(username);
            carts.get(0).setModifiedTime(date);

            CartExample updateCartExample = new CartExample();
            updateCartExample.createCriteria().andUidEqualTo(uid).andPidEqualTo(pid);
            i = cartMapper.updateByExampleSelective(carts.get(0), updateCartExample);
            if(i!=1){
                throw new UpdateException("更新购物车数据出现异常");
            }
        }
    }

    /**
     *  购物车展示
     * @param uid
     * @return
     */
    @Override
    public List<Cart> queryByUid(Integer uid) {
        CartExample example = new CartExample();
        example.createCriteria().andUidEqualTo(uid);
        List<Cart> carts = cartMapper.selectByExampleWithProduct(example);
        return carts;
    }
}
