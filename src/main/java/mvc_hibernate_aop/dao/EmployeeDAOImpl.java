package mvc_hibernate_aop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc_hibernate_aop.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        return getCurrentSession().createQuery("from Employee", Employee.class)
                                  .getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        getCurrentSession().merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
