package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.DataObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface DataObjectRepo
        extends CrudRepository<DataObject, String> {
//        extends JpaRepository<DataObject, String> {

}
