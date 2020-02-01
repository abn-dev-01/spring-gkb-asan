package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.GenderDict;
import com.abndev.asan.gkb.dom.dict.NationalityDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalityRepo
        extends JpaRepository<NationalityDict, String> {
}
