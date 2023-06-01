package com.example.project.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.project.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setLastname(rs.getString("lastname"));
		user.setCity(rs.getString("city"));
		user.setAge(rs.getInt("age"));
		user.setEmail(rs.getString("email"));
		return user;
	}

}
