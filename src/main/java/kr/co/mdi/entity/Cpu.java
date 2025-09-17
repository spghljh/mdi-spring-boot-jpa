package kr.co.mdi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mcl")
public class Cpu {

	@Id
	@Column(name = "id_cpu")
	private Long id;

	@Column(name = "name_cpu")
	private String name;

	@Column(name = "release_cpu")
	private Long release;

	@Column(name = "core_cpu")
	private Float core;

	@Column(name = "thread_cpu")
	private Long thread;

	@Column(name = "maxghz_cpu")
	private Float maxGHz;

	@Column(name = "minghz_cpu")
	private Float minGHz;

	@Column(name = "choice_cpu")
	private Long choice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpu_type_code")
	private CpuType cpuType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpu_manf_code")
	private CpuManf cpuManf;

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

	public Long getRelease() {
		return release;
	}

	public void setRelease(Long release) {
		this.release = release;
	}

	public Float getCore() {
		return core;
	}

	public void setCore(Float core) {
		this.core = core;
	}

	public Long getThread() {
		return thread;
	}

	public void setThread(Long thread) {
		this.thread = thread;
	}

	public Float getMaxGHz() {
		return maxGHz;
	}

	public void setMaxGHz(Float maxGHz) {
		this.maxGHz = maxGHz;
	}

	public Float getMinGHz() {
		return minGHz;
	}

	public void setMinGHz(Float minGHz) {
		this.minGHz = minGHz;
	}

	public Long getChoice() {
		return choice;
	}

	public void setChoice(Long choice) {
		this.choice = choice;
	}

	public CpuType getCpuType() {
		return cpuType;
	}

	public void setCpuType(CpuType cpuType) {
		this.cpuType = cpuType;
	}

	public CpuManf getCpuManf() {
		return cpuManf;
	}

	public void setCpuManf(CpuManf cpuManf) {
		this.cpuManf = cpuManf;
	}

	@Override
	public String toString() {
		return "Cpu [id=" + id + ", name=" + name + ", release=" + release + ", core=" + core + ", thread=" + thread
				+ ", maxGHz=" + maxGHz + ", minGHz=" + minGHz + ", choice=" + choice + ", cpuType=" + cpuType
				+ ", cpuManf=" + cpuManf + "]";
	}

}
