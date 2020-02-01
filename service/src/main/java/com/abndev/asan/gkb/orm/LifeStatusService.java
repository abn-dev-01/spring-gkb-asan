package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.LifeStatusDict;
import com.abndev.asan.gkb.dom.dict.LifeStatusDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LifeStatusService {
    @Autowired
    private LifeStatusRepo repository;

    public LifeStatusDict update(LifeStatusDict dict) {
        Optional<LifeStatusDict> foundOpt = repository.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            LifeStatusDict savedType = repository.save(dict);
            return savedType;
        }
        return dict;
    }
}
