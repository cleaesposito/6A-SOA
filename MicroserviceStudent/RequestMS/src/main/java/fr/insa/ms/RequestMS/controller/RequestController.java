package fr.insa.ms.RequestMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ms.RequestMS.model.Request;


@RestController
public class RequestController {
	String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_069";
	String login = "projet_gei_069";
	String pwd = "ceeZu7ee";
	
	@GetMapping("/request/{id}")
	public Request getRequest(@PathVariable int id) {
		//non implementee
		return null;
	}
	
	@PostMapping("/request")
	public Request createRequest(@RequestBody Request request) {
		//non implementee
		return request;
	}
	
	@GetMapping("/request")
	public List<Request> getAllRequests() {
		List<Request> r = new ArrayList<>();
		//non implementee
		return r;
	}
	
	@PutMapping("/request/status/{id}")
	public Request editRequest(@RequestBody Request request) {
		//non implementee
		return request;
	}
	
	@DeleteMapping("/student/{id}")
	public Request deleteRequest(@PathVariable int id) {
		//non implementee
		return null;
	}
	
}
