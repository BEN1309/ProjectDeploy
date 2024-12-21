package com.tka.WorkforceOperationHUB.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.WorkforceOperationHUB.entity.Country;
import com.tka.WorkforceOperationHUB.entity.Employee;

@Repository
public class MainDAO {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);

			tx.commit();
			msg = "Country Added Successful";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

//================================================================================================

	public String updateCountry(Country c, int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			country = session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);

			tx.commit();
			msg = "Country name updated !";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	// ================================================================================================

	public String deleteCountry(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Country country = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);

			session.remove(country);
			tx.commit();
			msg = "Coutry Deleted Successfully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	// ================================================================================================

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> clist = null;
		String hqlQry = "from Country";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Country> query = session.createQuery(hqlQry, Country.class);
			clist = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return clist;
	}

	// ================================================================================================

	public Country get1CountrybyId(int id) {
		Session session = null;
		Transaction tx = null;

		Country country = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			country = session.get(Country.class, id);
			session.persist(country);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

//===========================================================================
//============================================================================
	public String addEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);

			tx.commit();
			msg = "Employee Added Successful";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(Employee emp, int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employee employee = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			employee = session.get(Employee.class, id);
			employee.setName(emp.getName());
			employee.setMobileno(emp.getMobileno());
			employee.setEmailid(emp.getEmailid());
			employee.setCountry(emp.getCountry());
			employee.setSalary(emp.getSalary());
			employee.setCreatedBy(emp.getCreatedBy());
			employee.setCreatedDate(emp.getCreatedDate());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdatedDate(emp.getUpdatedDate());
			session.merge(employee);

			tx.commit();
			msg = "Employee details updated !";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employee employee = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			employee = session.get(Employee.class, id);

			session.remove(employee);
			tx.commit();
			msg = "Employee Deleted Successfully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		Session session = null;
		Transaction tx = null;
		List<Employee> elist = null;
		String hqlQry = "from Employee";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQry, Employee.class);
			elist = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return elist;
	}

	public Employee get1EmployeeById(int id) {
		Session session = null;
		Transaction tx = null;

		Employee employee = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			employee = session.get(Employee.class, id);
			session.persist(employee);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	public Employee login(Employee emp) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		String hqlQuery = "from Employee where emailid=:emailid and mobileno=:mobileno";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("emailid", emp.getEmailid());
			query.setParameter("mobileno", emp.getMobileno());
			employee = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where salary between :startSal and :endSal";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("startSal", startSal);
			query.setParameter("endSal", endSal);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Employee> checkStatus() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where status in ('active', 'inactive', 'suspend')";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	public Employee changeStatus(int id) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			employee = session.get(Employee.class, id);
			if (employee.getStatus().equals("active")) {
				employee.setStatus("inactive");
			} else if (employee.getStatus().equals("inactive")) {
				employee.setStatus("inactive");
			} else {
				employee.setStatus("suspend");
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

}
