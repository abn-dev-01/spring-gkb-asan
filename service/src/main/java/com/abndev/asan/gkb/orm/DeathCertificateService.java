package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.CertificateDeath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeathCertificateService {
    @Autowired
    private DeathCertificateRepo repository;

    public CertificateDeath update(CertificateDeath dict) {
        Optional<CertificateDeath> foundOpt = repository.findById(dict.getNumber());
        if (!foundOpt.isPresent()) {
            CertificateDeath savedType = repository.save(dict);
            return savedType;
        }
        return dict;
    }
}
