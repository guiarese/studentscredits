package br.com.fiap.studentscredits.controller;

import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.studentscredits.dto.CreateStudentsCreditsDTO;
import br.com.fiap.studentscredits.dto.StudentsCreditsDTO;

import br.com.fiap.studentscredits.service.StudentsCreditsService;

@RestController
@RequestMapping("/studentscredits/students")
public class StudentsCreditsController {

	private final StudentsCreditsService service;

	public StudentsCreditsController(StudentsCreditsService service) {
		this.service = service;
	}

	@GetMapping(path = "/{identification}")
	public StudentsCreditsDTO findById(@PathVariable String identification) {
		return service.findById(identification);
	}

	@GetMapping
	public List<StudentsCreditsDTO> getAll() {
		return service.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public StudentsCreditsDTO create(@RequestBody @Valid CreateStudentsCreditsDTO createStudentsCreditsDTO) {
		return service.create(createStudentsCreditsDTO);
	}

	@GetMapping(path = "/download/{identification}")
	public ResponseEntity<Object> downloadFile(String identification) throws IOException {
		return service.downloadFile(identification);
		
	}

}
