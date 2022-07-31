package com.pirvate.store.service;

import com.pirvate.store.entity.DictDistrict;

import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/25  15:08
 * Description(说明)):
 * 省市区接口
 */

public interface DictDistrictService {
    /**
     *  根据上级代号查询区域信息
     * @param parent  上级区域代号
     * @return
     */
    List<DictDistrict> getByParent(String parent);

    /**
     * 根据代号查询省市区名字
     * @param code
     * @return
     */
    String getByCode(String code);



}
