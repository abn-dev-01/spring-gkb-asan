package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.CountryDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepo repository;

    public CountryDict update(CountryDict dict) {
        Optional<CountryDict> foundOpt = repository.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            CountryDict savedType = repository.save(dict);
            return savedType;
        }
        return dict;
    }
}
