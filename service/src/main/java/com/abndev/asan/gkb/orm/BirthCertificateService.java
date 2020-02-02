package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.CertificateBirth;
import com.abndev.asan.gkb.dom.CertificateBirth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BirthCertificateService {
    @Autowired
    private BirthCertificateRepo repository;

    public CertificateBirth update(CertificateBirth dict) {
        Optional<CertificateBirth> foundOpt = repository.findById(dict.getNumber());
        if (!foundOpt.isPresent()) {
            CertificateBirth savedType = repository.saveAndFlush(dict);
            return savedType;
        }
        return dict;
    }
}
