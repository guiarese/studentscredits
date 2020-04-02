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

import br.com.fiap.studentscredits.dto.CreateDetailCardDTO;
import br.com.fiap.studentscredits.dto.DetailCardDTO;
import br.com.fiap.studentscredits.entity.DetailCard;
import br.com.fiap.studentscredits.repository.DetailCardRepository;
import br.com.fiap.studentscredits.service.DetailCardService;

@Service
public class DetailCardServiceImpl implements DetailCardService{
	
	private DetailCardRepository detailCardRepository;
	
	public DetailCardServiceImpl(DetailCardRepository detailCardRepository) {
		this.detailCardRepository = detailCardRepository;
	}

	@Override
	public DetailCardDTO findById(int id) {
		return saveAndGetDetailCardDTO(getDetailCard(id));
	}

	@Override
	public DetailCardDTO create(CreateDetailCardDTO createDetailCardDTO) {
		DetailCard detailCard = new DetailCard(createDetailCardDTO);
		return saveAndGetDetailCardDTO(detailCard);
	}

	private DetailCardDTO saveAndGetDetailCardDTO(DetailCard detailCard) {
		DetailCard savedDetailCard = detailCardRepository.save(detailCard);
		return new DetailCardDTO(savedDetailCard);
	}
	
	private DetailCard getDetailCard(int id) {
		return detailCardRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<DetailCardDTO> findAll() {
		return detailCardRepository.findAll().stream().map(DetailCardDTO::new).collect(Collectors.toList());
	}

	@Override
	public List<DetailCardDTO> findAllByStudentId(String studentId) {
		List<DetailCard> detailCardList;
		detailCardList = detailCardRepository.findAllByStudentId(studentId);
		return detailCardList
                .stream()
                .map(DetailCardDTO::new)
                .collect(Collectors.toList());
	}
	
	@Override
	public ResponseEntity<Object> downloadFile(String id) throws IOException {
		
		FileWriter filewriter = null;
		try {

			List<DetailCardDTO> txtDataList = findAllByStudentId(id);

			StringBuilder filecontent = new StringBuilder("ID_OPERACAO;TIPO_OPERACAO;DESCRICAO_OPERACAO;DATA_OPERACAO;VALOR_OPERACAO\n");
			for (DetailCardDTO txt : txtDataList) {
				filecontent.append(txt.getOperationId())
						   .append(";")
						   .append(txt.getTypeOperation())
						   .append(";")
						   .append(txt.getDescriptionOperation())
						   .append(";")
						   .append(txt.getDateOperation())
						   .append(";")
						   .append(txt.getValueOperation())
						   .append("\n");
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
