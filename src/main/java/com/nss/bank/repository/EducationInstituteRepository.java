package com.nss.bank.repository;

import com.nss.bank.entity.EducationInstitute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationInstituteRepository extends JpaRepository<EducationInstitute, String> {
    // Custom query methods can be defined here if needed
}
