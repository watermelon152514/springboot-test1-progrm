package com.guet.cn.springboottest1program.service.Impl;

import com.guet.cn.springboottest1program.bean.RechargeInformation;
import com.guet.cn.springboottest1program.mapper.RechargeInformationMapper;
import com.guet.cn.springboottest1program.service.RechargeInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeInformationImpl implements RechargeInformationService {
    @Autowired
    private RechargeInformationMapper rechargeInformationMapper;

    @Override
    public List<RechargeInformation> getAllDate(String before, String after) {
        return rechargeInformationMapper.getAllData(before,after);
    }

    @Override
    public List<RechargeInformation> getAllDates(String before, String after, String type) {
        return rechargeInformationMapper.getAllDatas(before,after,type);
    }

    @Override
    public void deleteInformation(String BILL_ID) {
        rechargeInformationMapper.deleteInformation(BILL_ID);
    }

    @Override
    public void changeInformation(RechargeInformation rechargeInformation) {
        rechargeInformationMapper.rechangeInformation(rechargeInformation);
    }
}
