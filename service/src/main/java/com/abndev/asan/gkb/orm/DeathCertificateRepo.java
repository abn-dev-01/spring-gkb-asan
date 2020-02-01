package com.abndev.asan.gkb.orm;

import com.abndev.asan.gkb.dom.CertificateDeath;
import com.abndev.asan.gkb.dom.dict.CitizenshipDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeathCertificateRepo
        extends JpaRepository<CertificateDeath, String> {
}
