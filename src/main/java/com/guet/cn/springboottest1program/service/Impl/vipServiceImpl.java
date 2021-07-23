package com.guet.cn.springboottest1program.service.Impl;

import com.guet.cn.springboottest1program.bean.vip_information;
import com.guet.cn.springboottest1program.mapper.VipMapper;
import com.guet.cn.springboottest1program.service.IVipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class vipServiceImpl implements IVipService {

    @Autowired
    private VipMapper vipMapper;

    @Override
    public List<vip_information> selectVip(String VIP_TYPE) {
        return vipMapper.selectVip(VIP_TYPE);
    }

    @Override
    public List<vip_information> viewVips() {
        return vipMapper.viewVips();
    }

    @Override
    public void deleteVip(String VIP_ID) {
        vipMapper.deleteVip(VIP_ID);
    }

    @Override
    public vip_information selectVipById(String VIP_ID) {
        return vipMapper.selectVipById(VIP_ID);
    }

    @Override
    public void modifyVip(String VIP_NAME, String VIP_PHONE, String VIP_ID) {
        vipMapper.modifyVip(VIP_NAME,VIP_PHONE,VIP_ID);
    }

}
