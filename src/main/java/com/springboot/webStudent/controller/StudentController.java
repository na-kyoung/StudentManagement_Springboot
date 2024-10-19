package com.springboot.webStudent.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.webStudent.model.StudentDao;
import com.springboot.webStudent.model.StudentDto;

@Controller
public class StudentController {
	
	// 데이터 입력 뷰 호출
	@RequestMapping(value="/insertStudent.do")
	public String insertBoard() {
		System.out.println("insertStudent() -> ");
		
		// 뷰리졸버에 의해서
		// insertStudent.jsp 호출
		return "insertStudent";
	}
	
	// 데이터 저장 및 getStudentList 뷰 호출
	@RequestMapping(value="/insertStudentProc.do")
	public String insertStudentProc(StudentDto sDto, StudentDao sDao) {
		System.out.println("insertStudentProc() -> ");
		System.out.println("Name : " + sDto.getSname());
		System.out.println("Age : " + sDto.getSage());
		System.out.println("Dept : " + sDto.getSdept());
		
		// 입력받은 데이터 저장
		sDao.insertStudent(sDto);
		                                                                                                                                                                                                                                                                                                                                                      
//		return "getStudentList"; // getStudentList.jsp 뷰로 이동  
		return "redirect:getStudentList.do"; // getStudentList 호출
	}
	
	// 전체 데이터 조회 및 뷰 호출
	@RequestMapping(value="/getStudentList.do")
	public ModelAndView getStudentList(StudentDto sDto, StudentDao sDao, ModelAndView mav) {
		System.out.println("getStudentList() -> ");
		
		ArrayList<StudentDto> sList = sDao.getStudentList(); // 전체 데이터 조회
		
		for(StudentDto sDto1 : sList) { System.out.println("--> " + sDto1.toString()); }
		
		// 뷰어에게 데이터 전달
		mav.addObject("sList", sList); // 변수명과 데이터 전달
		mav.setViewName("getStudentList"); // jsp 뷰 호출
		
		return mav;
	}
	
	// 데이터 수정 뷰 호출 및 데이터 전달
	@RequestMapping(value="/modifyStudent.do")
	public ModelAndView modifyStudent(StudentDto sDto, StudentDao sDao, ModelAndView mav) {
		System.out.println("modifyStudent()");
		System.out.println("sid : " + sDto.getSid());
		
		// Dao의 getStudent()를 이용해 1개의 데이터 가져오기
		StudentDto student = sDao.getStudent(sDto);
		
		// 뷰어에게 데이터 전달
		mav.addObject("student", student); // 변수명과 데이터 전달
		mav.setViewName("modifyStudent"); // jsp 뷰 호출
		return mav;
	}
	
	// 데이터 수정
	@RequestMapping(value="/modifyStudentProc.do")
	public ModelAndView modifyStudentProc(StudentDto sDto, StudentDao sDao, ModelAndView mav) {
		System.out.println("modifyStudentProc()");
		System.out.println("sid : " + sDto.getSid() + ", sname : " + sDto.getSname());
		
		// Dao의 modifyStudent()를 이용해 데이터 수정
		sDao.modifyStudent(sDto);
		
		// 뷰어에게 데이터 전달
		mav.setViewName("redirect:getStudentList.do"); // 뷰 (수정 후 전체 데이터 조회)
		return mav;
	}
	
	// 데이터 삭제
	@RequestMapping(value="/deleteStudent.do")
	public ModelAndView deleteStudent(StudentDto sDto, StudentDao sDao, ModelAndView mav) {
		System.out.println("deleteStudent()");
		System.out.println("sid : " + sDto.getSid());
		
		// Dao의 deleteStudent()를 이용해 데이터 수정
		sDao.deleteStudent(sDto);
		
		// 뷰어에게 데이터 전달
		mav.setViewName("redirect:getStudentList.do"); // 뷰 (삭제 후 전체 데이터 조회)
		return mav;
	}

}
