package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.CountryDict;
import com.abndev.asan.gkb.dom.dict.DocumentStatusDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo
        extends JpaRepository<CountryDict, String> {
}
