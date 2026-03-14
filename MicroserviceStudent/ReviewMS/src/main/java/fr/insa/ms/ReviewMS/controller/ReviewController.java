package fr.insa.ms.ReviewMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.ms.ReviewMS.model.Review;



@RestController
public class ReviewController {
	String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_069";
	String login = "projet_gei_069";
	String pwd = "ceeZu7ee";
	
	//recupere tous les avis pour un aidant - utile pour calculer sa moyenne
	@GetMapping("/review/helper/{id}")
	public List<Review> getAllReviews(@PathVariable int helperId) {
		List<Review> r = new ArrayList<>();
		//non implementee
		return r;
	}
	
	
	@GetMapping("/review/request/{id}")
	public Review getReview(@PathVariable int requestId) {
		//non implementee
		return null;
	}
	@PostMapping("/review/{id}")
	public Review createReview(@RequestBody Review review) {
		//non implementee
		return review;
	}
	
	
	
}
