package com.example.OrchestratorMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.OrchestratorMS.model.Request;
import com.example.OrchestratorMS.model.SignInInfo;
import com.example.OrchestratorMS.model.SignUpInfo;
import com.example.OrchestratorMS.model.Student;

@RestController
@RequestMapping("/orchestrator")
public class OrchestratorController {

	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@PostMapping("/request")
	public String createRequest(@RequestBody Request request) {
		Request r = restTemplate.postForObject("http://RequestMS/request", request, Request.class);
		return r.toString();
	}

	@PostMapping("/login")
	public String signIn(@RequestBody SignInInfo signInInfo) {

		if (signInInfo.getEmail() == null || signInInfo.getPassword() == null) {
			return "Login et mot de passe requis";
		}

		try {
			String realPwd = restTemplate.getForObject("http://AuthMS/auth/email/{email}", String.class, signInInfo.getEmail());

			if (signInInfo.getPassword().equals(realPwd)) {
				return "Login successful";		
			} else {
				return "Login et/ou mot de passe incorrect.s";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Erreur survenue pendant login";
		}

	}

	@PostMapping("/signup")
	public String signUp(@RequestBody SignUpInfo info) {
		// Validate input
		if (info.getNom() == null || info.getPrenom() == null ||
				info.getEmail() == null || info.getEtablissement() == null ||
				info.getFiliere() == null || info.getCompetences() == null ||
				info.getDisponibilites() == null || info.getPassword() == null){
			return "All fields are required";
		}

		try {

			//TODO : creer user student sans ID cf Tibo creer constr vide, set le rest, param db pour que autoincremente, voir comment ils recuperent le body du student pourpasser en param de auth
			//Student student = new Student();

			//ajouter student a la database
			//Student stCreated = restTemplate.postForObject("http://StudentMS/student", student, Student.class);

			//TODO : creer auth sans ID
			//Auth auth = new Auth();

			//Auth authCreated = restTemplate.postForObject("http://AuthMS/auth", auth, Auth.class);
			return "User successfully created :";//+student + auth quand ils seront crees

		} catch (Exception e) {
			e.printStackTrace();
			return "Erreur survenue pendant signin";
		}
	}

}

