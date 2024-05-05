package com.nss.bank.service;

import com.nss.bank.entity.Employee;
import com.nss.bank.entity.Role;
import com.nss.bank.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveEmployee(String name, String password,String email, Role role)  {
        try {
            Employee employee = Employee
                    .builder()
                    .EmployeeId(generateEmployeeId(name))
                    .name(name)
                    .email(email)
                    .role(role)
                    .password(passwordEncoder.encode(password))
                    .build();

            employeeRepository.save(employee);
        } catch (UnsupportedEncodingException ex) {
            return "Something went wrong!";
        }
        return "Ho Gaya";


//        return new Employee();
    }
    private String generateEmployeeId(String name) throws UnsupportedEncodingException {
        byte[] bytes = name.getBytes("UTF-8");
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        return uuid.toString();
    }
}
