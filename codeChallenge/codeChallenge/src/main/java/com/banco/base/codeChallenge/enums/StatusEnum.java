package com.banco.base.codeChallenge.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StatusEnum {

	PENDIENTE(1, "pendiente"), APROBADO(2, "aprobado"), RECHAZADO(3, "rechazado"), CANCELADO(4, "cancelado"), ERROR(4, "error");

	private String name;
	private Integer stausId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStausId() {
		return stausId;
	}

	public void setStausId(Integer stausId) {
		this.stausId = stausId;
	}

	private StatusEnum(String name) {
		this.name = name;
	}

	private StatusEnum(Integer stausId, String name) {
		this.name = name;
		this.stausId = stausId;
	}

	public static Optional<StatusEnum> findByName(String name) {
		return Arrays.asList(StatusEnum.values()).stream().filter(s -> s.getName().equals(name)).findAny();
	}
}
