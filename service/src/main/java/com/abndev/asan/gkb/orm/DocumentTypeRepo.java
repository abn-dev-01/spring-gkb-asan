package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.DocumentTypeDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepo
        extends JpaRepository<DocumentTypeDict, String> {
}
