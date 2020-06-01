package cst438.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
	
	Transcript findById(int id);

}
