package kr.co.mdi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mdl")
public class Device {

	@Id
	@Column(name = "id_device")
	private Long id;

	@Column(name = "name_device")
	private String name;

	@Column(name = "lineup_device")
	private String lineup;

	@Column(name = "release_device")
	private Long release;

	@Column(name = "weight_device")
	private Float weight;

	@Column(name = "choice_device")
	private Long choice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_type_code")
	private DeviceType deviceType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_manf_code")
	private DeviceManf deviceManf;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cpu")
	private Cpu cpu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLineup() {
		return lineup;
	}

	public void setLineup(String lineup) {
		this.lineup = lineup;
	}

	public Long getRelease() {
		return release;
	}

	public void setRelease(Long release) {
		this.release = release;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Long getChoice() {
		return choice;
	}

	public void setChoice(Long choice) {
		this.choice = choice;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public DeviceManf getDeviceManf() {
		return deviceManf;
	}

	public void setDeviceManf(DeviceManf deviceManf) {
		this.deviceManf = deviceManf;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", lineup=" + lineup + ", release=" + release + ", weight="
				+ weight + ", choice=" + choice + ", deviceType=" + deviceType + ", deviceManf=" + deviceManf + ", cpu="
				+ cpu + "]";
	}

}
