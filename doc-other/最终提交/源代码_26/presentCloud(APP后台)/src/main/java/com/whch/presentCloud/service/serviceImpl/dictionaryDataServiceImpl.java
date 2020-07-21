package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.directoryData;
import com.whch.presentCloud.mapper.directoryDataMapper;
import com.whch.presentCloud.repository.IRepository.dictionaryDataRepository;
import com.whch.presentCloud.service.IService.IDictionaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dictionaryDataServiceImpl implements IDictionaryDataService {

    @Autowired
    private dictionaryDataRepository dictR;
    @Autowired
    private directoryDataMapper dictionaryM;

    @Override
    public int adddata(directoryData dirtdata) {
        return dictR.add(dirtdata);
    }

    @Override
    public int deletebykey(directoryData dirtdata) {
        return dictR.deletebykey(dirtdata);
    }

    @Override
    public int updatadata(directoryData dirtdata) {
        return dictR.update(dirtdata);
    }

    @Override
    public String findbykey(String keyd) {
        return dictR.findbykey(keyd);
    }

    @Override
    public List<directoryData> findbytype(String typed) {
        return dictR.findbytype(typed);
    }

    @Override
    public String finddefault(directoryData dirtdata) {
        return dictR.finddefault(dirtdata);
    }

    @Override
    public int findbyvalue(directoryData dirtdata, directoryData record) {
        String valued = dirtdata.getValued();
        String keyd = dirtdata.getKeyd();
        if(record.getTyped() == "sexy"){
            return dictR.findbyvalue1(valued, keyd, record.getValued());
        }
        else if(record.getTyped() == "role"){
            return  dictR.findbyvalue2(valued, keyd, record.getValued());
        }
        return dictR.findbyvalue0(valued, keyd, record.getValued());

    }

    @Override
    public String findbyValue(String value) {
       
        return dictionaryM.findByValue(value);
    }

}
