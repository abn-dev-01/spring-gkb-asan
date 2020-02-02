package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.CitizenshipDict;
import com.abndev.asan.gkb.dom.dict.NationalityDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitizenshipService {
    @Autowired
    private CitizenshipRepo repository;

    public CitizenshipDict update(CitizenshipDict dict) {
        Optional<CitizenshipDict> foundOpt = repository.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            CitizenshipDict savedType = repository.saveAndFlush(dict);
            return savedType;
        }
        return dict;
    }
}
