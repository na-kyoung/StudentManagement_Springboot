package com.springboot.webStudent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.webStudent.model.StudentDao;
import com.springboot.webStudent.model.StudentDto;


@Service("studentService")
public class StudentService {
	
	@Autowired
	private StudentDao sdao;
	
	public void insertStudent(StudentDto sdto) {
		sdao.insertStudent(sdto);
		
	}
	
	public ArrayList<StudentDto> getStudentList() {
		return sdao.getStudentList();
	}

}
