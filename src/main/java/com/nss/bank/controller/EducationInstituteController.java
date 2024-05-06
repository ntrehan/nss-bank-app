package com.nss.bank.controller;

import com.nss.bank.entity.EducationInstitute;
import com.nss.bank.service.EducationInstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/institutes")
public class EducationInstituteController {

    @Autowired
    private EducationInstituteService educationInstituteService;

    @GetMapping
    public List<EducationInstitute> getAllInstitutes() {
        return educationInstituteService.getAllInstitutes();
    }

    @GetMapping("/{id}")
    public Optional<EducationInstitute> getInstituteById(@PathVariable String id) {
        return educationInstituteService.getInstituteById(id);
    }

    @PostMapping
    public EducationInstitute createInstitute(@RequestBody EducationInstitute institute, @RequestHeader(name="Authorization") String token) {
        return educationInstituteService.saveInstitute(institute);
    }

    @PutMapping("/{id}")
    public EducationInstitute updateInstitute(@PathVariable String id, @RequestBody EducationInstitute institute) {
        institute.setUniversityId(id);
        return educationInstituteService.saveInstitute(institute);
    }

    @DeleteMapping("/{id}")
    public void deleteInstitute(@PathVariable String id) {
        educationInstituteService.deleteInstitute(id);
    }
}
