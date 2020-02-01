package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.CitizenshipDict;
import com.abndev.asan.gkb.dom.dict.NationalityDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenshipRepo
        extends JpaRepository<CitizenshipDict, String> {
}
