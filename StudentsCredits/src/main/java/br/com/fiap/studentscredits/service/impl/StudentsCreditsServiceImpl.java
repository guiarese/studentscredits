package br.com.fiap.studentscredits.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.studentscredits.dto.CreateStudentsCreditsDTO;
import br.com.fiap.studentscredits.dto.StudentsCreditsDTO;
import br.com.fiap.studentscredits.entity.StudentsCredits;
import br.com.fiap.studentscredits.repository.StudentsCreditsRepository;
import br.com.fiap.studentscredits.service.StudentsCreditsService;

@Service
public class StudentsCreditsServiceImpl implements StudentsCreditsService{
	
	private StudentsCreditsRepository studentsCreditsRepository;
	
	public StudentsCreditsServiceImpl(StudentsCreditsRepository studentsCreditsRepository) {
		this.studentsCreditsRepository = studentsCreditsRepository;
	}

	@Override
	public StudentsCreditsDTO findById(String id) {
		return saveAndGetStudentsCreditsDTO(getStudentsCredits(id));
	}

	@Override
	public StudentsCreditsDTO create(CreateStudentsCreditsDTO createStudentsCreditsDTO) {
		StudentsCredits studentsCredits = new StudentsCredits(createStudentsCreditsDTO);
		return saveAndGetStudentsCreditsDTO(studentsCredits);
	}

	private StudentsCreditsDTO saveAndGetStudentsCreditsDTO(StudentsCredits studentsCredits) {
		StudentsCredits savedStudentsCredits = studentsCreditsRepository.save(studentsCredits);
		return new StudentsCreditsDTO(savedStudentsCredits);
	}
	
	private StudentsCredits getStudentsCredits(String id) {
		return studentsCreditsRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<StudentsCreditsDTO> findAll() {
		return studentsCreditsRepository.findAll().stream().map(StudentsCreditsDTO::new).collect(Collectors.toList());
	}
	
	@Override
	public ResponseEntity<Object> downloadFile(String id) throws IOException {
		
		FileWriter filewriter = null;
		try {

			List<StudentsCreditsDTO> txtDataList = findAll();

			StringBuilder filecontent = new StringBuilder("ID;NAME;CLASSID\n");
			for (StudentsCreditsDTO txt : txtDataList) {
				filecontent.append(txt.getStudentId()).append(";").append(txt.getStudentName()).append(";")
						.append(txt.getStudentClassId()).append("\n");
			}

			String filename = "C:\\Users\\ADM\\Desktop\\Java\\StudentsCredits\\StudentsCredits\\txtdata.txt";

			filewriter = new FileWriter(filename);
			filewriter.write(filecontent.toString());
			filewriter.flush();

			File file = new File(filename);

			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
					.contentType(MediaType.parseMediaType("application/txt")).body(resource);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<>("error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			if (filewriter != null)
				filewriter.close();
		}
		
	}

}
