package fr.insa.ms.RequestMS.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
		PreparedStatement stmt = null;	
		Connection conn = null;
		Request createdRequest = new Request(request.getTitle(), request.getDescription(), request.getDemanderId(), request.getHelperId(), request.getDate(), request.getStatus());

		try {
			conn = DriverManager.getConnection(url, login, pwd);
			String cmd = "INSERT INTO request (title, description, demander_id, helper_id, timeslot, status) VALUES (?,?,?,?,?,?) ";
			stmt = conn.prepareStatement(cmd,Statement.RETURN_GENERATED_KEYS);			
			stmt.setString(1, request.getTitle());
			stmt.setString(2, request.getDescription());
			stmt.setInt(3, request.getDemanderId());
			stmt.setInt(4, request.getHelperId());
			stmt.setTimestamp(5, Timestamp.valueOf(request.getDate()));
			stmt.setString(6, request.getStatus().name());
			int resStudent = stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (resStudent >0 && generatedKeys.next()) {

				int newId = generatedKeys.getInt(1);
				createdRequest.setId(newId);

				System.out.println("request added id:"+ newId);
			} else {
				System.out.println("Error adding student ");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return createdRequest;
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
	
	@DeleteMapping("/request/{id}")
	public Request deleteRequest(@PathVariable int id) {
		//non implementee
		return null;
	}
	
}
