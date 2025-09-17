package kr.co.mdi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cpu_type")
public class CpuType {

	@Id
	@Column(name = "cpu_type_code")
	private String code;

	@Column(name = "type_cpu")
	private String name;

	@OneToMany(mappedBy = "cpuType")
	private List<Cpu> cpus = new ArrayList<>();

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

	public List<Cpu> getCpus() {
		return cpus;
	}

	public void setCpus(List<Cpu> cpus) {
		this.cpus = cpus;
	}

	@Override
	public String toString() {
		return "CpuType [code=" + code + ", name=" + name + ", cpus=" + cpus + "]";
	}

}
