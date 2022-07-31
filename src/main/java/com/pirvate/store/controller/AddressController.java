package com.pirvate.store.controller;

import com.pirvate.store.entity.Address;
import com.pirvate.store.service.AddressService;
import com.pirvate.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/25  11:49
 * Description(说明)):
 */
@RequestMapping("/addresses")
@RestController
public class AddressController extends BaseController{
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping("/addAddress")
    public JsonResult<Void> addAddress(HttpSession session, Address address){

        address.setUid(getUidFromSession(session));
        address.setCreatedUser(getUsernameFromSession(session));
        address.setModifiedUser(getUsernameFromSession(session));

        addressService.addAddress(address);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<Address>> queryByUid(HttpSession session){
        List<Address> addresses = addressService.queryByUid(getUidFromSession(session));
        return new JsonResult<>(OK,addresses);
    }

    @RequestMapping("/setDefault/{aid}")
    public JsonResult<Void> setDefault(HttpSession session,@PathVariable("aid") Integer aid){
        addressService.setDefault(aid,getUidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @RequestMapping("/deleteAddress/{aid}")
    public JsonResult<Void> deleteAddress(HttpSession session,@PathVariable("aid") Integer aid){
        addressService.deleteAddress(aid,getUidFromSession(session),getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

}
