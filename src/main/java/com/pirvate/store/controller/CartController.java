package com.pirvate.store.controller;


import com.pirvate.store.entity.Cart;
import com.pirvate.store.service.CartService;
import com.pirvate.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/31  2:02
 * Description(说明)):
 */
@RequestMapping("/carts")
@RestController
public class CartController extends BaseController{
    private CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/addToCart")
    public JsonResult<Void> addToCart(HttpSession session,Integer pid,Integer num){
        cartService.addToCart(getUidFromSession(session),pid,num,getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("/queryByUid")
    public JsonResult<List<Cart>> queryByUid(HttpSession session){
        List<Cart> carts = cartService.queryByUid(getUidFromSession(session));
        return new JsonResult<>(OK,carts);
    }
}
