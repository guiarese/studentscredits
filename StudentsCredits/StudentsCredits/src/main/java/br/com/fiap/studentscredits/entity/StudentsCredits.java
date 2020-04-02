package br.com.fiap.studentscredits.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.studentscredits.dto.CreateStudentsCreditsDTO;

@Entity
@Table(name="Students")
public class StudentsCredits {
	
	@Id
	@Column(name="idEstudante")
	private String studentId;
	
	@Column(name="nome")
	private String studentName;
	
	@Column(name="idClasse")
	private String studentClassId;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentClassId() {
		return studentClassId;
	}
	public void setStudentClassId(String studentClassId) {
		this.studentClassId = studentClassId;
	}
	public StudentsCredits(String studentId, String studentName, String studentClassId) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClassId = studentClassId;
	}
	public StudentsCredits(CreateStudentsCreditsDTO createStudentsCreditsDTO) {
		this.studentId = createStudentsCreditsDTO.getStudentId();
		this.studentName = createStudentsCreditsDTO.getStudentName();
		this.studentClassId = createStudentsCreditsDTO.getStudentClassId();
	}
    public StudentsCredits(){
    	
    }
	

}
