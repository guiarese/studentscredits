package br.com.fiap.studentscredits.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.fiap.studentscredits.dto.CreateStudentsCreditsDTO;
import br.com.fiap.studentscredits.dto.StudentsCreditsDTO;

public interface StudentsCreditsService {
	
	StudentsCreditsDTO findById(String id);
	StudentsCreditsDTO create(CreateStudentsCreditsDTO createStudentsCreditsDTO);
	List<StudentsCreditsDTO> findAll();
	ResponseEntity<Object> downloadFile(String id) throws IOException;

}
