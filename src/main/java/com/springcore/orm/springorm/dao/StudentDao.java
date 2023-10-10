package com.springcore.orm.springorm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.springcore.orm.springorm.entity.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {

		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	// get the single data(Object)

	@Transactional
	public Student getStudent(int studentId) {

		if(this.hibernateTemplate!=null) {
			Student student = this.hibernateTemplate.get(Student.class, studentId);
			return student;
		}else {
			System.out.print("hibernateTemplate is null");
			
		}
		return null;
		
	
	}

	// get All Student Object

	public List<Student> getAllStudent() {

		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		System.out.println("record has been inserted successfully");
		return students;
	}

	// to delete Student from Database

	@Transactional
	public void deleteStudent(int studentId) {

		Student student = this.hibernateTemplate.get(Student.class, studentId);

		this.hibernateTemplate.delete(student);
		System.out.println("Student for id "+studentId+" has been deleted");

	}

	@Transactional
	public void updateStudent(Student student) {
		
		this.hibernateTemplate.update(student);
		System.out.println("Updated");
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
