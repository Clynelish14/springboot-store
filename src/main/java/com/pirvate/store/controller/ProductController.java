package com.pirvate.store.controller;

import com.pirvate.store.entity.Product;
import com.pirvate.store.service.ProductService;
import com.pirvate.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/31  7:21
 * Description(说明)):
 */
@RequestMapping("/Product")
@RestController
public class ProductController extends BaseController{
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping({"/hotCommodity"})
    public JsonResult<List<Product>> hotCommodity(){
        List<Product> products = productService.hotCommodity();
        return new JsonResult<>(OK,products);
    }


    @RequestMapping("/queryById/{id}")
    public JsonResult<Product> queryById(@PathVariable("id") Integer id){
        Product product = productService.queryById(id);
        return new JsonResult<>(OK,product);
    }
}
