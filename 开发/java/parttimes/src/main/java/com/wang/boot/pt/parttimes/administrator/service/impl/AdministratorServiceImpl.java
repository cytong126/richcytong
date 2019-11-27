package com.wang.boot.pt.parttimes.administrator.service.impl;

/*
 *@author: Wang He
 *@time: 2019/11/1 0001 15:26
 *@description:
 */

import com.wang.boot.pt.parttimes.administrator.dao.AdministratorDao;
import com.wang.boot.pt.parttimes.administrator.dto.AdministratorDto;
import com.wang.boot.pt.parttimes.administrator.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorDao dao;

    @Override
    public int insertByObject(AdministratorDto dto) {
        return dao.insertByObject(dto);
    }

    @Override
    public int updatePass(AdministratorDto dto) {
        return dao.updatePass(dto);
    }

    @Override
    public List<AdministratorDto> selectByCodePass(String code, String pass) {
        return dao.selectByCodePass(code,pass);
    }

    @Override
    public List<AdministratorDto> selectPassByCode(String code, String pass) {
        return dao.selectPassByCode(code,pass);
    }

    @Override
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    @Override
    public List<AdministratorDto> selectByCode(String code) {
        return dao.selectByCode(code);
    }
}
