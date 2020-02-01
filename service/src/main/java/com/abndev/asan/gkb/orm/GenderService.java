package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.CountryDict;
import com.abndev.asan.gkb.dom.dict.GenderDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderService {
    @Autowired
    private GenderRepo repository;

    public GenderDict update(GenderDict dict) {
        Optional<GenderDict> foundOpt = repository.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            GenderDict savedType = repository.save(dict);
            return savedType;
        }
        return dict;
    }
}
