package br.com.fiap.studentscredits.dto;

import br.com.fiap.studentscredits.entity.StudentsCredits;

public class StudentsCreditsDTO {
	
	private String studentId;
	private String studentName;
	private String studentClassId;
	
	public StudentsCreditsDTO(CreateStudentsCreditsDTO createStudentsCreditsDTO) {
		super();
		this.studentId = createStudentsCreditsDTO.getStudentId();
		this.studentName = createStudentsCreditsDTO.getStudentName();
		this.studentClassId = createStudentsCreditsDTO.getStudentClassId();
	}
	
	public StudentsCreditsDTO(StudentsCredits studentsCredits) {
		this.studentId = studentsCredits.getStudentId();
		this.studentName = studentsCredits.getStudentName();
		this.studentClassId = studentsCredits.getStudentClassId();
	}
	
	public String getStudentClassId() {
		return studentClassId;
	}
	public void setStudentClassId(String studentClassId) {
		this.studentClassId = studentClassId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}	

}
