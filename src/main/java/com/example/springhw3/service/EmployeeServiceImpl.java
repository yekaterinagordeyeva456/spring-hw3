package com.example.springhw3.service;

import com.example.springhw3.exception.EmployeeAlreadyAddedException;
import com.example.springhw3.exception.EmployeeNotFoundExeption;
import com.example.springhw3.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeelist;

    public EmployeeServiceImpl() {
        this.employeelist = new ArrayList<>();
    }

    @Override
    public Employee add(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (employeelist.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeelist.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (employeelist.contains(employee)) {
            employeelist.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundExeption();
    }

    @Override
    public Employee find(String fistName, String lastName) {
        Employee employee = new Employee(fistName, lastName);
        if (employeelist.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundExeption();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeelist);
    }

}
