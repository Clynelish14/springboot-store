package com.pirvate.store.service.impl;

import com.pirvate.store.entity.Address;
import com.pirvate.store.entity.AddressExample;
import com.pirvate.store.mapper.AddressMapper;
import com.pirvate.store.service.AddressService;
import com.pirvate.store.service.DictDistrictService;
import com.pirvate.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

/**
 * Author(作者): Ashen one
 * Date(时间): 2022/7/25  8:24
 * Description(说明)):
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Value("${address.max-count}")
    private Integer max_count;

    private AddressMapper addressMapper;
    private AddressExample addressExample;
    private DictDistrictService dictDistrictService;

    @Autowired
    public AddressServiceImpl(AddressMapper addressMapper, AddressExample addressExample, DictDistrictService dictDistrictService) {
        this.addressMapper = addressMapper;
        this.addressExample = addressExample;
        this.dictDistrictService = dictDistrictService;
    }




    /**
     * 新增收货地址
     * @param address
     */
    @Override
    public void addAddress(Address address) {
        addressExample.createCriteria().andUidEqualTo(address.getUid());
        int i = addressMapper.countByExample(addressExample);
        if(i>max_count){
            throw new AddressCountLimitException("最多只能设置20个收货地址");
        }

        Integer isDefault = i == 0 ? 1 : 0; //如果没有别的收货地址，就把这条设为默认的
        address.setIsDefault(isDefault);

        String ProvinceCode = dictDistrictService.getByCode(address.getProvinceCode());
        String CityCode = dictDistrictService.getByCode(address.getCityCode());
        String AreaCode = dictDistrictService.getByCode(address.getAreaCode());
        address.setProvinceName(ProvinceCode);
        address.setCityName(CityCode);
        address.setAreaName(AreaCode);

        Date date = new Date();
        address.setCreatedTime(date);
        address.setModifiedTime(date);
        int i1 = addressMapper.insertSelective(address);
        if(i1 !=1 ){
            throw new InsertException("新增收获地址失败");
        }
    }

    /**
     * 展示收获地址的方法
     * @param uid
     * @return
     */
    @Override
    public List<Address> queryByUid(Integer uid) {
        addressExample.createCriteria().andUidEqualTo(uid);
        addressExample.setOrderByClause("is_default DESC");
        List<Address> addresses = addressMapper.selectByExample(addressExample);
        return addresses;
    }

    /**
     * 设置默认收获地址
     * @param aid   收获地址主键
     * @param uid   归属人uid
     * @param modifiedUser   最后修改人
     */
    @Transactional
    @Override
    public void setDefault(Integer aid, Integer uid, String modifiedUser) {
        Address address = addressMapper.selectByPrimaryKey(aid);
        if(address == null){
            throw new AddressNotFoundException("该收货地址不存在");
        }
        if(!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问，该收货地址不属于当前用户");
        }

        // 将该uid下所有收货地址设置为不默认
        addressExample.createCriteria().andUidEqualTo(uid);
        Address sd = new Address();
        sd.setIsDefault(0);
        int i = addressMapper.updateByExampleSelective(sd, addressExample);
        if(i<1){
            throw new UpdateException("更新数据产生未知的异常");
        }
        // 根据主键 把用户选中的这条数据设置为默认的
        sd.setAid(aid);
        sd.setIsDefault(1);
        sd.setModifiedUser(modifiedUser);
        sd.setModifiedTime(new Date());
        int i1 = addressMapper.updateByPrimaryKeySelective(sd);
        if(i1!=1){
            throw new UpdateException("更新数据产生未知的异常");
        }

    }

    /**
     *  删除收获地址
     * @param aid   根据aid来删
     */
    @Transactional
    @Override
    public void deleteAddress(Integer aid,Integer uid,String name) {
        Address address = addressMapper.selectByPrimaryKey(aid);
        if(address==null){
            throw new AddressNotFoundException("该收货地址不存在");
        }
        if(!address.getUid().equals(uid)){
            throw new AccessDeniedException("非法访问，该收货地址不属于当前用户");
        }

        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andAidEqualTo(aid);
        int i = addressMapper.deleteByExample(addressExample);
        if(i!=1){
            throw new DeleteException("删除数据产生未知错误");
        }
        // 删除之后还有几个收货地址
        AddressExample addressExample1 = new AddressExample();
        addressExample1.createCriteria().andUidEqualTo(uid);
        i = addressMapper.countByExample(addressExample1);
        if(i==0){//没有了就结束
            return;
        }
        //还有就把最近一次操作过的记录变更为默认地址
        AddressExample addressExample2 = new AddressExample();
        addressExample2.createCriteria().andUidEqualTo(uid);
        addressExample2.setOrderByClause("modified_time DESC");
        List<Address> addresses = addressMapper.selectByExample(addressExample2);

        setDefault(addresses.get(0).getAid(),addresses.get(0).getUid(),name);

    }


}
