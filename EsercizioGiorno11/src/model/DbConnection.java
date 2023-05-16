package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public class DbConnection {
	
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "eserciziojdbc";
	String user = "postgres";
	String pass = "root";
	Connection conn;
	Statement st;
	
	public DbConnection() throws SQLException {
		conn = DriverManager.getConnection(url+dbName, user, pass);
		st = conn.createStatement();
		System.out.println("DB Connesso!!");
	}
	
	public void insertStudent(Studenti s) throws SQLException {
		String sql = "INSERT INTO school_students "
				+ "(name, lastname, gender, birthdate, avg, min_vote, max_vote) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, s.getName());
		ps.setString(2, s.getLastname());
		ps.setString(3, s.getGender().toString());
		ps.setDate(4, Date.valueOf(s.getBirthdate()));
		ps.setDouble(5, s.getAvg());
		ps.setInt(6, s.getMin_vote());
		ps.setInt(7, s.getMax_vote());
		ps.executeUpdate();
		System.out.println( s.getName() + " " + s.getLastname() + " salvato nel DB!!");
	}
	
	public void updateStudent(Studenti s) throws SQLException {
		String sql = "UPDATE school_students SET "
				+ "name = ?, lastname = ?, gender = ?, birthdate = ?, "
				+ "avg = ?, min_vote = ?, max_vote = ? "
				+ "WHERE id =  ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, s.getName());
		ps.setString(2, s.getLastname());
		ps.setString(3, s.getGender().toString());
		ps.setDate(4, Date.valueOf(s.getBirthdate()));
		ps.setDouble(5, s.getAvg());
		ps.setInt(6, s.getMin_vote());
		ps.setInt(7, s.getMax_vote());
		ps.setInt(8, s.getId());
		ps.executeUpdate();
		System.out.println("Studente modificato nel DB!!");
	}
	
	public Studenti getStudentById(int id) throws SQLException  {
		String sql = "SELECT * FROM school_students WHERE id = " + id;
		ResultSet rs = st.executeQuery(sql);
		
		Studenti s = null;
		if(rs.next()) {
			Gender g = rs.getString("gender").equals("M") ? Gender.M : Gender.F;
			s = new Studenti(
					rs.getInt("id"), 
					rs.getString("name"), 
					rs.getString("lastname"), 
					g,
					LocalDate.parse(rs.getString("birthdate")), 
					rs.getDouble("avg"), 
					rs.getInt("min_vote"), rs.getInt("max_vote"));
		}
		return s;
	}
	
	public void deleteStudent(int id) throws SQLException  {
		String sql = "DELETE FROM school_students WHERE id = " + id;
		st.executeUpdate(sql);
	}
	
	public Studenti getBest()  {
		
		return null;
	}
	
	public List<Studenti> getVoteRange(int min, int max) {
		
		return null;
	}
	
}
