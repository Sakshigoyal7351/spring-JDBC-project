package com.day2.studentDao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.day2.model.Student;

public class studentDaoImpl implements studentDao {

	private JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public int insert(Student student) {
		String query= "insert into student(id,name,city) value(?,?,?)";
		int r = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}



	public int change(Student student) {
		String query="update student set name=?, city=? where id=?";
		int r = jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}



	public int delete(int studentId) {
		String query="delete from student where id=?";
		int r = jdbcTemplate.update(query,studentId);
		return r;
	}



	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = jdbcTemplate.queryForObject(query,rowMapper, studentId);
		return student;
	}



	public List<Student> getAllStudents() {
		String query= "select *from student";
		List<Student> lists = jdbcTemplate.query(query, new RowMapperImpl());
		return lists;
	}

	


	
	
	

	
	
}
