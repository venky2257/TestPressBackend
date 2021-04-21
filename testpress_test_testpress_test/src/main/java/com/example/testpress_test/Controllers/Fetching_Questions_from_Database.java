package com.example.testpress_test.Controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.testpress_test.DbUtils.Db_Fetch_Questions;
import com.example.testpress_test.Model.Question_Model;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class Fetching_Questions_from_Database {
	@Autowired 
	private Db_Fetch_Questions get_question;
	
	@PostMapping("/fetchQuestions")
	public List<Question_Model> GetMapping_FetchQuestion(@RequestBody Map<String, Object> start_test_Id) throws SQLException {
		System.out.println(start_test_Id);
		String testId = start_test_Id.get("testId").toString();
		System.out.println(testId);
		return(get_question.Fetch_Questions("test_01") );
		
	}
}
