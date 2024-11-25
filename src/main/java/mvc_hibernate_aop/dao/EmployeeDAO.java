package mvc_hibernate_aop.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import mvc_hibernate_aop.entity.Employee;

@Service
public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
