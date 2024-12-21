package com.tka.WorkforceOperationHUB.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.WorkforceOperationHUB.entity.Country;
import com.tka.WorkforceOperationHUB.entity.Employee;
import com.tka.WorkforceOperationHUB.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;

	@PostMapping("addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c) {
		String msg = service.addCountry(c);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateCountry/{id}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c, @PathVariable int id) {
		String msg = service.updateCountry(c, id);
		return ResponseEntity.ok(msg);

	}

	@DeleteMapping("deleteCountry/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable int id) {
		String msg = service.deleteCountry(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAllCountry")
	public ResponseEntity<List<Country>> getAllCountry() {
		List<Country> msgList = service.getallCountry();
		return ResponseEntity.ok(msgList);

	}

	@GetMapping("get1CountrybyId/{id}")
	public ResponseEntity<Country> get1CountrybyId(@PathVariable int id) {
		Country msgList = service.get1CountrybyId(id);
		return ResponseEntity.status(201).body(msgList);

	}

//==========================================================================

	@PostMapping("addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp, @PathVariable int id) {
		String msg = service.updateEmployee(emp, id);
		return ResponseEntity.ok(msg);

	}

	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		String msg = service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> msgList = service.getAllEmployee();
		return ResponseEntity.ok(msgList);

	}

	@GetMapping("get1EmployeeById/{id}")
	public ResponseEntity<Employee> get1EmployeeById(@PathVariable int id) {
		Employee msgList = service.get1EmployeeById(id);
		return ResponseEntity.status(201).body(msgList);

	}

//================log-in================================================================
	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee emp) {
		Map map= service.login(emp);
		return ResponseEntity.ok(map);
	}
	
	@GetMapping("salaryRange/{startSal}/{endSal}")
	public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startSal,@PathVariable double endSal){
		List<Employee> list=service.salaryRange(startSal,endSal);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("checkStat")
	public ResponseEntity<List<Employee>> checkStatus(){
		List<Employee> list=service.checkStatus();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("changestat/{id}")
	public ResponseEntity<Employee> changeStatus(@PathVariable int id){
		Employee emp =service.changeStatus(id);
		return ResponseEntity.ok(emp);
	}
	
}