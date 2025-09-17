package kr.co.mdi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kr.co.mdi.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

	@Query("""
			    SELECT d FROM Device d
			    JOIN FETCH d.deviceType
			    JOIN FETCH d.deviceManf
			    JOIN FETCH d.cpu
			""")
	List<Device> findAllWithDetails();

	@Query("""
			    SELECT d FROM Device d
			    JOIN FETCH d.deviceType
			    JOIN FETCH d.deviceManf
			    JOIN FETCH d.cpu
			    WHERE d.id = :id
			""")
	Optional<Device> findByIdWithDetails(Long id);
}
