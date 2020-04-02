package br.com.fiap.studentscredits.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.fiap.studentscredits.dto.CreateDetailCardDTO;
import br.com.fiap.studentscredits.dto.DetailCardDTO;

public interface DetailCardService {
	
	DetailCardDTO findById(int id);
	DetailCardDTO create(CreateDetailCardDTO createDetailCardDTO);
	List<DetailCardDTO> findAll();
	List<DetailCardDTO> findAllByStudentId(String studentId);
	ResponseEntity<Object> downloadFile(String id) throws IOException;

}
