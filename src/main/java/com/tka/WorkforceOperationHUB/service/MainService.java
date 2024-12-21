package com.tka.WorkforceOperationHUB.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.WorkforceOperationHUB.dao.MainDAO;
import com.tka.WorkforceOperationHUB.entity.Country;
import com.tka.WorkforceOperationHUB.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDAO dao;

	public String addCountry(Country c) {

		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Country is not Added";
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {

		String msg = dao.updateCountry(c, id);
		if (Objects.isNull(msg)) {
			msg = "Country is not Added";
		}
		return msg;
	}

	public String deleteCountry(int id) {
		String msg = dao.deleteCountry(id);
		if (Objects.isNull(msg)) {
			msg = "Country is not Added";
		}
		return msg;
	}

	public List<Country> getallCountry() {
		List<Country> msgList = dao.getAllCountry();
		return msgList;
	}

	public Country get1CountrybyId(int id) {
		Country msgList = dao.get1CountrybyId(id);
		return msgList;
	}

	// =========================================================================

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if (Objects.isNull(msg)) {
			msg = "Employee Added to List";
		}
		return msg;
	}

	public String updateEmployee(Employee emp, int id) {
		String msg = dao.updateEmployee(emp, id);
		if (Objects.isNull(msg)) {
			msg = "Employee Added Succesfull";
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		if (Objects.isNull(msg)) {
			msg = "Employee Deleted";
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> msgList = dao.getAllEmployee();
		return msgList;
	}

	public Employee get1EmployeeById(int id) {
		Employee msgList = dao.get1EmployeeById(id);
		return msgList;
	}

	public Map login(Employee emp) {
		Employee obj = dao.login(emp);
		Map map = new HashMap();
		if (Objects.isNull(obj)) {
			map.put("msg", "Invalid User");
			map.put("user", obj);
		} else {
			map.put("msg", "Valid User");
			map.put("user", obj);
		}

		return map;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {

		List<Employee> list = dao.salaryRange(startSal, endSal);

		return list;
	}

	public List<Employee> checkStatus() {
		List<Employee> elist = dao.checkStatus();
		return elist;
	}

	public Employee changeStatus(int id) {
		Employee emp = dao.changeStatus(id);
		return emp;
	}

}
