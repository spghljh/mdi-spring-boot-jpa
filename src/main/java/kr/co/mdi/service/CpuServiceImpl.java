package kr.co.mdi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kr.co.mdi.dto.CpuDTO;
import kr.co.mdi.entity.Cpu;
import kr.co.mdi.repository.CpuRepository;

@Service
public class CpuServiceImpl implements CpuService {

	private final CpuRepository cpuRepository;

	public CpuServiceImpl(CpuRepository cpuRepository) {
		this.cpuRepository = cpuRepository;
	}

	@Override
	public List<CpuDTO> getCpuList() {
		List<Cpu> cpus = cpuRepository.findAllWithDetails(); // JOIN FETCH 포함
		return cpus.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public CpuDTO getCpuById(Long cpuId) {
		Cpu cpu = cpuRepository.findByIdWithDetails(cpuId).orElseThrow(() -> new RuntimeException("CPU not found"));
		return convertToDto(cpu);
	}

	private CpuDTO convertToDto(Cpu cpu) {
		CpuDTO dto = new CpuDTO();
		dto.setIdCpu(cpu.getId());
		dto.setNameCpu(cpu.getName());
		dto.setReleaseCpu(cpu.getRelease());
		dto.setCoreCpu(cpu.getCore());
		dto.setThreadCpu(cpu.getThread());
		dto.setMaxghzCpu(cpu.getMaxGHz());
		dto.setMinghzCpu(cpu.getMinGHz());
		dto.setChoiceCpu(cpu.getChoice());
		dto.setCpuTypeCode(cpu.getCpuType().getCode());
		dto.setTypeCpu(cpu.getCpuType().getName());
		dto.setCpuManfCode(cpu.getCpuManf().getCode());
		dto.setManfCpu(cpu.getCpuManf().getName());
		return dto;
	}
}
