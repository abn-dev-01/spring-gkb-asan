package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.DataObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DataObjectRepo
        extends JpaRepository<DataObject, String> {

}
