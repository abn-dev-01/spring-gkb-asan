package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.DistrictDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepo repository;

    public DistrictDict update(DistrictDict dict) {
        Optional<DistrictDict> foundOpt = repository.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            DistrictDict savedType = repository.save(dict);
            return savedType;
        }
        return dict;
    }
}
