package com.ibs.report.controller.bean;

public class ReportParameter {

    private final String name;
    private final String value;

	public ReportParameter(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
