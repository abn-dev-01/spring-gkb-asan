package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.CountryDict;
import com.abndev.asan.gkb.dom.dict.RegionDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo
        extends JpaRepository<RegionDict, String> {
}
