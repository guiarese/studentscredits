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

import br.com.fiap.studentscredits.dto.CreateDetailCardDTO;
import br.com.fiap.studentscredits.dto.DetailCardDTO;
import br.com.fiap.studentscredits.service.DetailCardService;

@RestController
@RequestMapping("/studentscredits/detail")
public class DetailCardController {

	private final DetailCardService service;

	public DetailCardController(DetailCardService service) {
		this.service = service;
	}

	@GetMapping(path = "/{identification}")
	public DetailCardDTO findById(@PathVariable int identification) {
		return service.findById(identification);
	}

	@GetMapping
	public List<DetailCardDTO> getAll() {
		return service.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetailCardDTO create(@RequestBody @Valid CreateDetailCardDTO createDetailCardDTO) {
		return service.create(createDetailCardDTO);
	}
	
	@GetMapping(path = "studentdetail/{identification}")
	public List<DetailCardDTO> findAllByStudentId(@PathVariable String identification) {
		return service.findAllByStudentId(identification);
	}
	
	@GetMapping(path = "/download/{identification}")
	public ResponseEntity<Object> downloadFile(@PathVariable String identification) throws IOException {
		return service.downloadFile(identification);
		
	}
}
