package com.guet.cn.springboottest1program.mapper;

import com.guet.cn.springboottest1program.bean.RechargeInformation;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RechargeInformationMapper {
    List<RechargeInformation> getAllData(String before,String after);
    List<RechargeInformation> getAllDatas(String before,String after,String type);
    void deleteInformation(String BILL_ID);
}
