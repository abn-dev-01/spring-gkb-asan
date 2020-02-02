package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.RegionDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegionService {
    @Autowired
    private RegionRepo repository;

    public RegionDict update(RegionDict dict) {
        Optional<RegionDict> foundOpt = repository.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            RegionDict savedType = repository.saveAndFlush(dict);
            return savedType;
        }
        return dict;
    }
}
