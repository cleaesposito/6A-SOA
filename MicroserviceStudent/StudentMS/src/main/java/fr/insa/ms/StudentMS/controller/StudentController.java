package fr.insa.ms.StudentMS.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ms.StudentMS.model.Student;

@RestController
public class StudentController {
	String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_069";
	String login = "projet_gei_069";
	String pwd = "ceeZu7ee";

	//Obtenir infos d'un etudiant
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = null;
		ResultSet resStudent = null;
		ResultSet resCompetences = null;
		ResultSet resDisponibilites = null;
		Statement sStudent = null;
		Statement sCompetences = null;
		Statement sDisponibilites = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, login, pwd);

			String cmdSt = "SELECT * FROM student WHERE id = " + id + ";";
			sStudent = conn.createStatement();
			resStudent = sStudent.executeQuery(cmdSt);

			if (resStudent.next()) {
				List<String> competences = new ArrayList<>();
				List<LocalDateTime> disponibilites = new ArrayList<>();

				String cmdComp = "SELECT competence FROM student_competence WHERE id = " + id + ";";
				sCompetences = conn.createStatement();
				resCompetences = sCompetences.executeQuery(cmdComp);
				while (resCompetences.next()) {
					competences.add(resCompetences.getString("competence"));
				}

				String cmdDispo = "SELECT disponibilite FROM student_disponibilite WHERE id =" + id + ";";
				sDisponibilites = conn.createStatement();
				resDisponibilites = sDisponibilites.executeQuery(cmdDispo);
				while (resDisponibilites.next()) {

					Timestamp ts = resDisponibilites.getTimestamp("disponibilite");
					disponibilites.add(ts.toLocalDateTime());

				}

				student = new Student(
						resStudent.getInt("id"),
						resStudent.getString("nom"),
						resStudent.getString("prenom"),
						resStudent.getString("email"),
						resStudent.getString("etablissement"),
						resStudent.getString("filiere"),
						competences,
						disponibilites,
						resStudent.getDouble("note_moyenne"));
				System.out.println("student: "+ student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resStudent != null) resStudent.close();
				if (resCompetences != null) resCompetences.close();
				if (resDisponibilites != null) resDisponibilites.close();
				if (sStudent != null) sStudent.close();
				if (sCompetences != null) sCompetences.close();
				if (sDisponibilites != null) sDisponibilites.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return student;
	}

	//creer etudiant
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		Statement sStudent = null;
		PreparedStatement psCompetence = null;
		PreparedStatement psDisponibilite = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, login, pwd);

			String cmdSt = "INSERT INTO student (id, nom, prenom, email, etablissement, filiere, note_moyenne) VALUES "
					+ "("+student.getId() + ","
					+ "'"+student.getNom()+"',"
					+ "'"+student.getPrenom()+"',"
							+ "'"+student.getEmail()+"',"
					+ "'"+student.getEtablissement()+"',"
					+ "'"+student.getFiliere()+"',"
					+ ""+student.getNoteMoyenne()+");";
			sStudent = conn.createStatement();
			int resStudent = sStudent.executeUpdate(cmdSt);

			if (resStudent >0) {
				String cmdCompetence = "INSERT INTO student_competence (id, competence) VALUES (?, ?)";

		        psCompetence = conn.prepareStatement(cmdCompetence);

		        for (String comp : student.getCompetences()) {

		            psCompetence.setInt(1, student.getId());
		            psCompetence.setString(2, comp);
		            psCompetence.executeUpdate();
		        }

		       
		        String cmdDisponibilite = "INSERT INTO student_disponibilite (id, disponibilite) VALUES (?, ?)";

		        psDisponibilite = conn.prepareStatement(cmdDisponibilite);

		        for (LocalDateTime dispo : student.getDisponibilites()) {

		            psDisponibilite.setInt(1, student.getId());
		            psDisponibilite.setTimestamp(2, Timestamp.valueOf(dispo));
		            psDisponibilite.executeUpdate();
		        }

				System.out.println("student added: "+ student);
			} else {
				System.out.println("Error adding student: "+ student);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sStudent != null) sStudent.close();
				if (psCompetence != null) psCompetence.close();
				if (psDisponibilite != null) psDisponibilite.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return student;
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudents() {
		List<Student> s = new ArrayList<>();
		//non implementee
		return s;
	}
	
	@PutMapping("/student/{id}")
	public Student editStudent(@RequestBody Student student) {
		//non implementee
		return student;
	}
	
	@DeleteMapping("/student/{id}")
	public Student deleteStudent(@RequestBody Student student) {
		//non implementee
		return student;
	}

}
