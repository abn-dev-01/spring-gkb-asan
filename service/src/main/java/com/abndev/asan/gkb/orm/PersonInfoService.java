package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonInfoService {
    @Autowired
    private PersonInfoRepo repository;

    public PersonInfo update(PersonInfo personInfo) {
        Optional<PersonInfo> foundOpt = repository.findById(personInfo.getIin());
        if (!foundOpt.isPresent()) {
            PersonInfo savedType = repository.save(personInfo);
            return savedType;
        }
        return personInfo;
    }
}
