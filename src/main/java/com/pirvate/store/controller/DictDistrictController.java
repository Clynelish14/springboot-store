package com.pirvate.store.controller;

import com.pirvate.store.entity.DictDistrict;
import com.pirvate.store.service.DictDistrictService;
import com.pirvate.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/25  17:58
 * Description(说明)):
 */
@RequestMapping("/dictDistrict")
@RestController
public class DictDistrictController extends BaseController{

    private DictDistrictService dictDistrictService;

    @Autowired
    public DictDistrictController(DictDistrictService dictDistrictService) {
        this.dictDistrictService = dictDistrictService;
    }

    @RequestMapping({"/",""})
    public JsonResult<List<DictDistrict>> getByParent(String parent){
        List<DictDistrict> list = dictDistrictService.getByParent(parent);
        return new JsonResult<>(OK,list);
    }


}
