package br.com.fiap.studentscredits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.studentscredits.entity.StudentsCredits;

@Repository
public interface StudentsCreditsRepository extends JpaRepository<StudentsCredits,String> {

}
