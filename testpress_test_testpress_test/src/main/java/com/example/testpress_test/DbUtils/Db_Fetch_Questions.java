package com.example.testpress_test.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testpress_test.Model.Question_Model;


@Service
public class Db_Fetch_Questions {
	
	public List<Question_Model> Fetch_Questions(String testId) throws SQLException {
		Connection conn = DbUtils.getRemoteConnection();
		List<Question_Model> test_questions = new ArrayList();
		String questions_query = "select qid,question from questions where testId = '" +testId+ "' ";
		Statement questions_statment = conn.createStatement();
		ResultSet questions = questions_statment.executeQuery(questions_query);
		while(questions.next()) {
			List quesid = new ArrayList();
			List quest = new ArrayList();
			List choices = new ArrayList();
			List answers = new ArrayList();
			System.out.println(questions.getString("qid") +" " +questions.getString("question"));
			String qid = questions.getString("qid");
			
			String question = questions.getString("question");
			quesid.add(qid);
			quest.add(question);
			String choices_query = "select choice from choices where qid = '" +qid+ "' and testId = '" +testId+ "'";
			Statement choices_statement = conn.createStatement();
			ResultSet choices_rs = choices_statement.executeQuery(choices_query);
			while(choices_rs.next()) {
				//System.out.println("choices are :" +choices_rs.getString("choice"));
				choices.add(choices_rs.getString("choice"));
				
			}
			
			
			String answers_query = "select answer from answers where qid ='" +qid+ "' and testId = '" +testId+ "' ";
			Statement answers_statement = conn.createStatement();
			ResultSet answers_rs = answers_statement.executeQuery(answers_query);
			while(answers_rs.next()) {
				//System.out.println("Answer is "+answers_rs.getString("answer"));
				answers.add(answers_rs.getString("answer"));
			}
			
			test_questions.add(new Question_Model(quesid,quest,choices,answers));
		}
		
		return(test_questions);
	}
}
