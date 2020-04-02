package br.com.fiap.studentscredits.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.studentscredits.entity.DetailCard;

@Repository
public interface DetailCardRepository extends JpaRepository<DetailCard,Integer> {
	
	List<DetailCard> findAllByStudentId(String studentId);
	
}
