package controller;

import java.sql.SQLException;
import java.time.LocalDate;

import model.DbConnection;
import model.Gender;
import model.Studenti;

public class MainProject {

	public static void main(String[] args) {
		
		try {
			
			DbConnection db = new DbConnection();
			
			//Studenti s = new Studenti("Mario", "Rossi", Gender.M , LocalDate.of(2000, 11, 10),  7.5, 6, 9);
			//db.insertStudent(s);
			
			Studenti s = db.getStudentById(1);
			System.out.println(s);
			
			//s.setBirthdate(LocalDate.of(2012, 9, 24));
			//db.updateStudent(s);
			
			db.deleteStudent(s.getId());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
