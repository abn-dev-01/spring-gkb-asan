package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.CertificateBirth;
import com.abndev.asan.gkb.dom.CertificateDeath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthCertificateRepo
        extends JpaRepository<CertificateBirth, String> {
}
