package fr.insa.ms.AuthMS.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ms.AuthMS.model.Auth;

@RestController
public class AuthController {

	String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_069";
	String login = "projet_gei_069";
	String pwd = "ceeZu7ee";

	//Obtenir infos d'authentification d'un etudiant
	@GetMapping("/auth/{id}")
	public Auth getAuth(@PathVariable int id) {
		Auth a = null;
		ResultSet res = null;
		Statement s = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, login, pwd);

			String cmd = "SELECT * FROM auth WHERE id = " + id + ";";
			s = conn.createStatement();
			res = s.executeQuery(cmd);

			if (res.next()) {
				a = new Auth(res.getInt("id"), res.getString("email"), res.getString("password"));
				System.out.println("auth : "+ a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null) res.close();
				if (s != null) s.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return a;
	}

	//Obtenir password d'un etudiant a partir du mail
	@GetMapping("/auth/email/{email}")
	public String getPassword(@PathVariable String email) {
		Auth a = null;
		ResultSet res = null;
		Statement s = null;
		Connection conn = null;
		String passwd = "";

		try {
			conn = DriverManager.getConnection(url, login, pwd);

			String cmd = "SELECT password FROM auth WHERE email = '"+email+"';";
			s = conn.createStatement();
			res = s.executeQuery(cmd);

			if (res.next()) {
				passwd = res.getString("password");
				System.out.println("pwd : "+ passwd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null) res.close();
				if (s != null) s.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return passwd;
	}

	//creer infos d'authentification d'un etudiant
	@PostMapping("/auth")
	public Auth createAuth(@RequestBody Auth auth) {
		Statement s = null;
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, login, pwd);

			String cmd = "INSERT INTO auth (id, email, password) VALUES ("+auth.getId()+",'"+auth.getEmail()+"' ,'"+auth.getPassword()+"' );";
			s = conn.createStatement();
			int res = s.executeUpdate(cmd);

			if (res > 0) {
				System.out.println("Auth created : "+ auth);
			} else {
				System.out.println("Error adding auth" + auth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (s != null) s.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return auth;
	}


	//modifier infos d'authentification d'un etudiant
	@PutMapping("/auth")
	public Auth updateAuth(@RequestBody Auth auth) {
		Connection conn = null;
		Statement s = null;

		try {
			conn = DriverManager.getConnection(url, login, pwd);

			String cmd = "UPDATE auth SET email = '"+auth.getEmail()+"', password = '"+auth.getPassword()+"' WHERE id = "+auth.getId()+";";
			s = conn.createStatement();

			int res = s.executeUpdate(cmd);

			if (res > 0) {
				System.out.println("Auth updated : "+ auth);
			} else {
				System.out.println("Error updating auth" + auth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (s != null) s.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return auth;
	}

	// Supprimer un etudiant
	@DeleteMapping("/auth/{id}")
	public int deleteAuth(@PathVariable int id) {
		Connection conn = null;
		Statement s = null;
		int res = -1;

		try {
			conn = DriverManager.getConnection(url, login, pwd);

			String cmd = "DELETE FROM auth WHERE id = "+id+";";
			s = conn.createStatement();
			res = s.executeUpdate(cmd);

			if (res > 0) {
				System.out.println("Auth deleted");
			} else {
				System.out.println("Error deleting auth");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (s != null) s.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
