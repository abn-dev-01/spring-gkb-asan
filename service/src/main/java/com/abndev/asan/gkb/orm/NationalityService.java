package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.NationalityDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationalityService {
    @Autowired
    private NationalityRepo repository;

    public NationalityDict update(NationalityDict dict) {
        Optional<NationalityDict> foundOpt = repository.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            NationalityDict savedType = repository.save(dict);
            return savedType;
        }
        return dict;
    }
}
