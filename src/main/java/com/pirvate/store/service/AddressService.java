package com.pirvate.store.service;

import com.pirvate.store.entity.Address;

import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/25  8:24
 * Description(说明)):
 */
public interface AddressService {
    /**
     *  新增收货地址的方法
     * @param address
     */
    void addAddress(Address address);

    /**
     * 展示收货地址的方法
     * @param uid
     * @return
     */
    List<Address> queryByUid(Integer uid);

    /**
     *  设置默认收货地址
     * @param aid   收获地址主键
     * @param uid   归属人uid
     * @param modifiedUser   最后修改人
     * @return
     */
    void setDefault(Integer aid,Integer uid,String modifiedUser);


    /**
     *  删除收获地址
     * @param aid   根据aid来删
     */
    void deleteAddress(Integer aid,Integer uid,String name);

}
