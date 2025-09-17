package kr.co.mdi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kr.co.mdi.entity.Cpu;

public interface CpuRepository extends JpaRepository<Cpu, Long> {

	@Query("""
			    SELECT c FROM Cpu c
			    JOIN FETCH c.cpuType
			    JOIN FETCH c.cpuManf
			""")
	List<Cpu> findAllWithDetails();

	@Query("""
			    SELECT c FROM Cpu c
			    JOIN FETCH c.cpuType
			    JOIN FETCH c.cpuManf
			    WHERE c.id = :id
			""")
	Optional<Cpu> findByIdWithDetails(Long id);

}