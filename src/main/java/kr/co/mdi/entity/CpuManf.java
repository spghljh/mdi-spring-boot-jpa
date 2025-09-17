package kr.co.mdi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cpu_manf_brand")
public class CpuManf {

	@Id
	@Column(name = "cpu_manf_code")
	private String code;

	@Column(name = "manf_cpu")
	private String name;

	@OneToMany(mappedBy = "cpuManf")
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
		return "CpuManf [code=" + code + ", name=" + name + ", cpus=" + cpus + "]";
	}

}
