package com.example.project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.project.model.User;

@Component
public class UserJDBCDao implements UserDaoRepository {
	
	@Autowired JdbcTemplate jdbcTemplate;

	@Override
	public void insert(User user) {
		System.out.println(user);
		String sql = "INSERT INTO public.user (name, lastname, city, age, email) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, 
				user.getName(), 
				user.getLastname(), 
				user.getCity(), 
				user.getAge(), 
				user.getEmail());
		
//		String sql = "INSERT INTO user (name, lastname, city, age, email) "
//				+ "VALUES ('"+user.getName()+"','"
//							+user.getLastname()+"','"
//							+user.getCity()+"',"
//							+user.getAge()+",'"
//							+user.getEmail()+"')";
//		jdbcTemplate.update(sql);
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE public.user SET name=?, lastname=?, city=?, age=?, email=? "
					+"WHERE id=?";
		jdbcTemplate.update(sql, 
				user.getName(), 
				user.getLastname(), 
				user.getCity(), 
				user.getAge(), 
				user.getEmail(),
				user.getId());

	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM public.user WHERE id=? ";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public User getById(Long id) {
		String sql = "SELECT * FROM public.user WHERE id=? ";
		User u = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
		return u;
	}

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM public.user ";
		List<User> lista = jdbcTemplate.query(sql, new UserRowMapper());
		return lista;
	}

}
