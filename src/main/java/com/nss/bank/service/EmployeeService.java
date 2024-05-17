package com.nss.bank.service;

import com.nss.bank.entity.Employee;
import com.nss.bank.entity.Role;
import com.nss.bank.entity.User;
import com.nss.bank.repository.EmployeeRepository;
import com.nss.bank.repository.UserRepository;
import jakarta.transaction.Transactional;
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

    @Autowired
    private UserRepository userRepository;
    @Transactional
    public String saveEmployee(String name, String password,String email, Role role)  {
        try {
            Employee employee = Employee
                    .builder()
                    .employeeId(generateEmployeeId(name))
                    .name(name)
                    .email(email)
                    .role(role)
                    .password(passwordEncoder.encode(password))
                    .build();

            employeeRepository.save(employee);
            User user = User
                    .builder()
                    .role(Role.ADMIN)
                    .password(passwordEncoder.encode(password))
                    .username(employee.getUsername()).build();
            userRepository.save(user);

            return user.getUsername();

        } catch (UnsupportedEncodingException ex) {
            return "Something went wrong!";
        }

    }
    private String generateEmployeeId(String name) throws UnsupportedEncodingException {
        String source = "EMP" + name + System.currentTimeMillis();
        byte[] bytes = source.getBytes("UTF-8");
        UUID uuid = UUID.nameUUIDFromBytes(bytes);
        return uuid.toString().replace("-","").substring(0, 13);
    }

}
