package kr.co.mdi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "device_manf_brand")
public class DeviceManf {

	@Id
	@Column(name = "device_manf_code")
	private String code; // 예: "HP", "ASUS", "APPLE"

	@Column(name = "manf_device")
	private String name; // 예: "hp", "asus", "apple"

	@OneToMany(mappedBy = "deviceManf")
	private List<Device> devices = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "DeviceManf [code=" + code + ", name=" + name + ", devices=" + devices + "]";
	}

}
