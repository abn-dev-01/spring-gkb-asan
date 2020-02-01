package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.dict.DocumentStatusDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentStatusService {
    @Autowired
    private DocumentStatusRepo documentStatusRepo;

    public DocumentStatusDict update(DocumentStatusDict dict) {
        Optional<DocumentStatusDict> foundOpt = documentStatusRepo.findById(dict.getCode());
        if (!foundOpt.isPresent()) {
            DocumentStatusDict savedType = documentStatusRepo.save(dict);
            return savedType;
        }
        return dict;
    }
}
