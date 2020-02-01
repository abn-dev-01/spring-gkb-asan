package com.abndev.asan.gkb.soap;

import com.abndev.asan.gkb.dom.DataObject;
import com.abndev.asan.gkb.dom.PersonObject;
import com.abndev.asan.gkb.dom.PersonResponse;
import com.abndev.asan.gkb.dom.ResponseInfo;
import com.abndev.asan.gkb.orm.DataObjectRepo;
import com.abndev.asan.gkb.orm.ResponseInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private ResponseInfoRepo responseInfoRepo;
    @Autowired
    private DataObjectRepo dataObjectRepo;

    public void store(PersonResponse response) {

        PersonObject personObject = response.getReturnObject().getPersonObject();

        // ResponseInfo
        ResponseInfo responseInfo = (ResponseInfo) personObject.getResponseInfo();
        responseInfoRepo.save(responseInfo);

        //
        DataObject data = personObject.getResponseData().getDataObject();
        dataObjectRepo.save(data);
    }
}
