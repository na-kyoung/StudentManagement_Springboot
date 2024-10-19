package com.springboot.webStudent.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDao {
	// DB 연동을 위한 기본 정보
	String id = "root";
	String pwd = "111111";
	String url = "jdbc:mysql://localhost:3306/springdb?characterEncoding=utf-8";
	
	// jdbc 구현을 위한 객체 생성
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// DB 연동 함수
	public Connection getConn() {
		try {
			// #1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 완료!");
			
			return DriverManager.getConnection(url, id, pwd);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// DB 연동 종료 함수
	public void closeConn(ResultSet rs, Connection conn, PreparedStatement pstmt) {
		if(rs != null) {
			try {
				if(!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				rs = null;
			}
		}
		if(conn != null) {
			try {
				if(!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				conn = null;
			}
		}
		if(pstmt != null) {
			try {
				if(!pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				pstmt = null;
			}
		}
	}
	
	// DB 데이터 저장 함수
	public void insertStudent(StudentDto pdto) {
		System.out.println("--- INSERT 시작");
		
		// #1. DB 연동
		conn = getConn();
		
		// #2. SQL문 작성
		String sql = "INSERT INTO student VALUES(NULL, ?, ?, ?)";
		
		// #3. 값 맵핑 및 SQL문 실행
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pdto.getSname());
			pstmt.setInt(2, pdto.getSage());
			pstmt.setString(3, pdto.getSdept());
			
			pstmt.executeUpdate();
			closeConn(rs, conn, pstmt);
			
			System.out.println("--- INSERT 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DB 데이터 전체 조회 함수
	public ArrayList<StudentDto> getStudentList() {
		System.out.println("--- 전체 데이터 SELECT 시작");
		
		// #0. 배열 선언
		ArrayList<StudentDto> sList = new ArrayList<>();
		
		// #1. DB 연동
		conn = getConn();
		
		// #2. SQL문 작성
		String sql = "SELECT * FROM student";
		
		// #3. SQL문 실행
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDto sdto = new StudentDto();
				sdto.setSid(rs.getInt(1));
				sdto.setSname(rs.getString(2));
				sdto.setSage(rs.getInt(3));
				sdto.setSdept(rs.getString(4));
				sList.add(sdto);
			}
			closeConn(rs, conn, pstmt);
			
			System.out.println("--- 전체 데이터 SELECT 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}
	
	// DB 데이터 1개의 레코드 조회
	public StudentDto getStudent(StudentDto temp) {
		System.out.println("--- 1개의 데이터 SELECT 시작");
		
		// #0. 변수 선언
		StudentDto sdto = new StudentDto();
		
		// #1. DB 연동
		conn = getConn();
		
		// #2. SQL문 작성
		String sql = "SELECT * FROM student WHERE sid = ?";
		
		// #3. SQL문 실행
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, temp.getSid()); // SQL문 ? 설정
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				sdto.setSid(rs.getInt(1));
				sdto.setSname(rs.getString(2));
				sdto.setSage(rs.getInt(3));
				sdto.setSdept(rs.getString(4));
			}
			closeConn(rs, conn, pstmt);
			
			System.out.println("--- 1개의 데이터 SELECT 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sdto;
	}
	
	// DB 데이터 수정
	public void modifyStudent(StudentDto bdto) {
		System.out.println("--- MODIFY 시작");
		
		// #1. DB 연동
		conn = getConn();
		
		// #2. SQL문 작성
		String sql = "UPDATE student SET sname = ?, sage = ?, sdept = ? WHERE sid = ?";
		
		// #3. 값 맵핑 및 SQL문 실행
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getSname());
			pstmt.setInt(2, bdto.getSage());
			pstmt.setString(3, bdto.getSdept());
			pstmt.setInt(4, bdto.getSid());
			
			pstmt.executeUpdate();
			closeConn(rs, conn, pstmt);
			
			System.out.println("--- MODIFY 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// DB 데이터 삭제
	public void deleteStudent(StudentDto sdto) {
		System.out.println("--- DELETE 시작");
		
		// #1. DB 연동
		conn = getConn();
		
		// #2. SQL문 작성
		String sql = "DELETE FROM student WHERE sid = ?";
		
		// #3. 값 맵핑 및 SQL문 실행
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sdto.getSid());
			
			pstmt.executeUpdate();
			closeConn(rs, conn, pstmt);
			
			System.out.println("--- DELETE 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
