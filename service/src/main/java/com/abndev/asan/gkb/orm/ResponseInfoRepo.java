package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.ResponseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseInfoRepo
        extends JpaRepository<ResponseInfo, Integer> {

}
