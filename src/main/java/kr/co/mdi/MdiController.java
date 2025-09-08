package kr.co.mdi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MdiController {

	@Controller
	public class ViewController {

	    private final CpuRepository cpuRepository;
	    private final DeviceRepository deviceRepository;

	    // 메인 페이지
	    @GetMapping("/")
	    public String index() {
	        return "index";
	    }

	    // CPU 목록 페이지
	    @GetMapping("/cpus")
	    public String cpuList(Model model) {
	        List<Cpu> cpus = cpuRepository.findAll();
	        model.addAttribute("cpus", cpus);
	        return "cpu-list";
	    }

	    // CPU 상세 페이지
	    @GetMapping("/cpus/{cpuId}")
	    public String cpuDetail(@PathVariable Long cpuId, Model model) {
	        Cpu cpu = cpuRepository.findById(cpuId)
	            .orElseThrow(() -> new IllegalArgumentException("CPU not found"));
	        model.addAttribute("cpu", cpu);
	        return "cpu-detail";
	    }

	    // 디바이스 목록 페이지
	    @GetMapping("/devices")
	    public String deviceList(Model model) {
	        List<Device> devices = deviceRepository.findAll();
	        model.addAttribute("devices", devices);
	        return "device-list";
	    }

	    // 디바이스 상세 페이지
	    @GetMapping("/devices/{deviceId}")
	    public String deviceDetail(@PathVariable Long deviceId, Model model) {
	        Device device = deviceRepository.findById(deviceId)
	            .orElseThrow(() -> new IllegalArgumentException("Device not found"));
	        model.addAttribute("device", device);
	        return "device-detail";
	    }

}
