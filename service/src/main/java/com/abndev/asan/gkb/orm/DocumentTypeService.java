package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.DocumentTypeDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentTypeService {
    @Autowired
    private DocumentTypeRepo documentTypeRepo;

    public DocumentTypeDict update(DocumentTypeDict type) {
        Optional<DocumentTypeDict> foundOpt = documentTypeRepo.findById(type.getCode());
        if (!foundOpt.isPresent()) {
            DocumentTypeDict savedType = documentTypeRepo.save(type);
            return savedType;
        }
        return type;
    }

}
