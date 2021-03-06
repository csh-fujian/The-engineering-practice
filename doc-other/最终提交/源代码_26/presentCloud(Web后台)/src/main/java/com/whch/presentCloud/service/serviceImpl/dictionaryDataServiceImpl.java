package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.directoryData;
import com.whch.presentCloud.repository.IRepository.dictionaryDataRepository;
import com.whch.presentCloud.service.IService.IDictionaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dictionaryDataServiceImpl implements IDictionaryDataService {

    @Autowired
    private dictionaryDataRepository dictR;

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
    public String finddefault(String typed) {
        return dictR.finddefault(typed);
    }

    @Override
    public List<String> findAllvalue(String typed) {
        return dictR.findAllvalue(typed);
    }

    @Override
    public int findbyvalue(directoryData dirtdata, directoryData record) {
        String valued = dirtdata.getValued();
        String keyd = dirtdata.getKeyd();
        Integer defaultvalued = dirtdata.getDefaultvalued();
        if(record.getTyped().equals("sexy")){
            return dictR.findbyvalue1(valued, keyd, defaultvalued, record.getValued());
        }
        else if(record.getTyped().equals("role")){
            return dictR.findbyvalue2(valued, keyd, defaultvalued, record.getValued());
        }
        return dictR.findbyvalue0(valued, keyd, defaultvalued, record.getValued());

    }

}
