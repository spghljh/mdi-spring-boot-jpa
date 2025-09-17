package kr.co.mdi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kr.co.mdi.dto.DeviceDTO;
import kr.co.mdi.entity.Device;
import kr.co.mdi.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {

	private final DeviceRepository deviceRepository;

	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	@Override
	public List<DeviceDTO> getDeviceList() {
		List<Device> devices = deviceRepository.findAllWithDetails();
		return devices.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public DeviceDTO getDeviceById(Long deviceId) {
		Device device = deviceRepository.findByIdWithDetails(deviceId)
				.orElseThrow(() -> new RuntimeException("Device not found"));
		return convertToDto(device);
	}

	private DeviceDTO convertToDto(Device device) {
		DeviceDTO dto = new DeviceDTO();
		dto.setIdDevice(device.getId());
		dto.setNameDevice(device.getName());
		dto.setLineupDevice(device.getLineup());
		dto.setReleaseDevice(device.getRelease());
		dto.setWeightDevice(device.getWeight());
		dto.setChoiceDevice(device.getChoice());

		dto.setDeviceTypeCode(device.getDeviceType().getCode());
		dto.setTypeDevice(device.getDeviceType().getName());

		dto.setDeviceManfCode(device.getDeviceManf().getCode());
		dto.setManfDevice(device.getDeviceManf().getName());

		dto.setIdCpu(device.getCpu().getId());
		dto.setCpuDevice(device.getCpu().getName());

		return dto;
	}
}
