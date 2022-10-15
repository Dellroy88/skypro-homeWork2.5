package pro.sky.skyprohomeWork25.service;


import pro.sky.skyprohomeWork25.employee.Employee;
import org.springframework.stereotype.Service;
import pro.sky.skyprohomeWork25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skyprohomeWork25.exceptions.EmployeeNotFoundException;
import pro.sky.skyprohomeWork25.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }


    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }


    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }


}
