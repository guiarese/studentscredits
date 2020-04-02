package br.com.fiap.studentscredits.dto;

import java.time.LocalDate;

import br.com.fiap.studentscredits.entity.DetailCard;

public class DetailCardDTO {

	private int operationId;
	private String studentId;
	private String descriptionOperation;
	private LocalDate dateOperation;
	private char typeOperation;
	private float valueOperation;
		
	public DetailCardDTO(CreateDetailCardDTO createDetailCardDTO) {
		this.operationId = createDetailCardDTO.getOperationId();
		this.studentId = createDetailCardDTO.getStudentId();
		this.descriptionOperation = createDetailCardDTO.getDescriptionOperation();
		this.dateOperation = createDetailCardDTO.getDateOperation();
		this.typeOperation = createDetailCardDTO.getTypeOperation();
		this.valueOperation = createDetailCardDTO.getValueOperation();
	}
	
	public DetailCardDTO(DetailCard detailCard) {
		this.operationId = detailCard.getOperationId();
		this.studentId = detailCard.getStudentId();
		this.descriptionOperation = detailCard.getDescriptionOperation();
		this.dateOperation = detailCard.getDateOperation();
		this.typeOperation = detailCard.getTypeOperation();
		this.valueOperation = detailCard.getValueOperation();
	}
	
	public int getOperationId() {
		return operationId;
	}
	public void setOperationId(int operationId) {
		this.operationId = operationId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getDescriptionOperation() {
		return descriptionOperation;
	}
	public void setDescriptionOperation(String descriptionOperation) {
		this.descriptionOperation = descriptionOperation;
	}
	public LocalDate getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(LocalDate dateOperation) {
		this.dateOperation = dateOperation;
	}
	public char getTypeOperation() {
		return typeOperation;
	}
	public void setTypeOperation(char typeOperation) {
		this.typeOperation = typeOperation;
	}
	public float getValueOperation() {
		return valueOperation;
	}
	public void setValueOperation(float valueOperation) {
		this.valueOperation = valueOperation;
	}
	
	public DetailCardDTO() {
		
	}

}
