package com.nss.bank.service;

import com.nss.bank.entity.EducationInstitute;
import com.nss.bank.repository.EducationInstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationInstituteService {

    @Autowired
    private EducationInstituteRepository educationInstituteRepository;

    public List<EducationInstitute> getAllInstitutes() {
        return educationInstituteRepository.findAll();
    }

    public Optional<EducationInstitute> getInstituteById(String universityId) {
        return educationInstituteRepository.findById(universityId);
    }

    public EducationInstitute saveInstitute(EducationInstitute institute) {
        return educationInstituteRepository.save(institute);
    }

    public void deleteInstitute(String universityId) {
        educationInstituteRepository.deleteById(universityId);
    }
}
