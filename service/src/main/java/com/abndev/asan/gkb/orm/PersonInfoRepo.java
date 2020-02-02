package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.PersonInfo;
import com.abndev.asan.gkb.dom.dict.NationalityDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonInfoRepo
        extends CrudRepository<PersonInfo, String> {
//        extends JpaRepository<PersonInfo, String> {
}
