package br.com.fiap.studentscredits.dto;

public class CreateStudentsCreditsDTO {
	
	private String studentId;
	private String studentName;
	private String studentClassId;
	
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
	public String getStudentClassId() {
		return studentClassId;
	}
	public void setStudentClassId(String studentClassId) {
		this.studentClassId = studentClassId;
	}
	
	

}
