package com.pirvate.store.service.impl;

import com.pirvate.store.entity.DictDistrict;
import com.pirvate.store.entity.DictDistrictExample;
import com.pirvate.store.mapper.DictDistrictMapper;
import com.pirvate.store.service.DictDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/25  15:40
 * Description(说明)):
 */
@Service
public class DictDistrictServiceImpl implements DictDistrictService {

    private DictDistrictExample districtExample;
    private DictDistrictMapper districtMapper;

    @Autowired
    public DictDistrictServiceImpl(DictDistrictExample districtExample, DictDistrictMapper districtMapper) {
        this.districtExample = districtExample;
        this.districtMapper = districtMapper;
    }

    /**
     * 查询省市信息
     * @param parent  上级区域代号
     * @return
     */
    @Override
    public List<DictDistrict> getByParent(String parent) {
        //Example 类方法如果采用Autowired 注入到IOC中，会有条件的残留 连续多次调用这个方法会导致参数一直停留在第一次传入的参数
        DictDistrictExample dde = new DictDistrictExample();
        dde.createCriteria().andParentEqualTo(parent);
        List<DictDistrict> list = districtMapper.selectByExample(dde);
        return list;
    }

    /**
     *  根据代号拿到具体的省市区名字
     * @param code
     * @return
     */
    @Override
    public String getByCode(String code) {
        //Example 类方法如果采用Autowired 注入到IOC中，会有条件的残留 连续多次调用这个方法会导致参数一直停留在第一次传入的参数
        DictDistrictExample dde = new DictDistrictExample();
        dde.createCriteria().andCodeEqualTo(code);
        List<DictDistrict> dictDistricts = districtMapper.selectByExample(dde);
        String name = dictDistricts.get(0).getName();
        return name;
    }
}
