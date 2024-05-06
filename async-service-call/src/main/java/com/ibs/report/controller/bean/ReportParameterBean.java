package com.ibs.report.controller.bean;

/**
 * Внимание! Внимание! Это разделяемый объект, который не был помещён в
 * разделяемую библиотеку! При изменении данного объекта надо поискать его в
 * других проектах и там тоже его поменять!!!
 */
public class ReportParameterBean {

	private final String reportId;
	private final Integer id;
	private final String name;
	private final String value;

	public ReportParameterBean(String reportId, Integer id, String name, String value) {
		this.reportId = reportId;
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public String getReportId() {
		return reportId;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
