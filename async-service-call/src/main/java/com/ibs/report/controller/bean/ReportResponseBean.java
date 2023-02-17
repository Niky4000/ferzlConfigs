package com.ibs.report.controller.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ru.element.async.service.dto.operation.OperationTypeDto;

/**
 * Внимание! Внимание! Это разделяемый объект, который не был помещён в
 * разделяемую библиотеку! При изменении данного объекта надо поискать его в
 * других проектах и там тоже его поменять!!!
 */
public class ReportResponseBean {

	private String id;
	private Status status;
	private Date created;
	private String opToken;
	private String fileName;
	private OperationTypeDto type;
	private String fileType;
	private String source;
	private List<ReportParameterBean> reportParameterBeanList;

	public enum Status {
		NEW, PROCESSING, FINISHED, COMPLETED, ERROR, HTTP_ERROR, REMOVE_FILE_HTTP_ERROR, PROCESSING_EXCEPTION, ERROR2, HTTP_ERROR2, HTTP_ERROR3, UNZIP_ERROR, PROCESSING_EXCEPTION2, CREATE_REPORT_ERROR, FILE_UPLOAD_ERROR, UNKNOWN_REPORT_TYPE
	}

	public ReportResponseBean() {
	}

	public ReportResponseBean(String id, ReportResponseBean.Status status, Date created, String opToken, String fileName, OperationTypeDto type, String fileType, String source, List<ReportParameterBean> reportParameterBeanList) {
		this.id = id;
		this.status = status;
		this.created = created;
		this.opToken = opToken;
		this.fileName = fileName;
		this.type = type;
		this.fileType = fileType;
		this.source = source;
		this.reportParameterBeanList = reportParameterBeanList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ReportResponseBean.Status getStatus() {
		return status;
	}

	public void setStatus(ReportResponseBean.Status status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getOpToken() {
		return opToken;
	}

	public void setOpToken(String opToken) {
		this.opToken = opToken;
	}

	public String getFileName() {
		return fileName != null ? fileName : "";
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public OperationTypeDto getType() {
		return type;
	}

	public void setType(OperationTypeDto type) {
		this.type = type;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<ReportParameterBean> getReportParameterBeanList() {
		return reportParameterBeanList;
	}

	public void setReportParameterBeanList(List<ReportParameterBean> reportParameterBeanList) {
		this.reportParameterBeanList = reportParameterBeanList;
	}

	public String serializeAsKeyValue() {
		try {
			Map<String, String> map = reportParameterBeanList.stream().sorted((o1, o2) -> o1.getId().compareTo(o2.getId())).collect(Collectors.groupingBy(ReportParameterBean::getName, LinkedHashMap::new, Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0).getValue())));
			return new ObjectMapper().writeValueAsString(map).replace("\"", "\\\"");
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	public String toPost() {
		StringBuilder sb = new StringBuilder("{\n")
				.append("    \"id\": \"").append(id).append("\",\n")
				.append("    \"status\": \"").append(status.name()).append("\",\n")
				.append("    \"created\": \"").append(new SimpleDateFormat("yyyy-MM-dd").format(created)).append("\",\n")
				.append("    \"opToken\": \"").append(opToken).append("\",\n")
				.append("    \"type\": \"").append(type.name()).append("\",\n")
				.append("    \"fileType\": \"").append(fileType).append("\",\n")
				.append("    \"source\": \"").append(source).append("\"");
		if (reportParameterBeanList != null && !reportParameterBeanList.isEmpty()) {
			sb.append(",\n\"reportParameterBeanList\":[");
			for (int i = 0; i < reportParameterBeanList.size(); i++) {
				sb.append("{");
				ReportParameterBean bean = reportParameterBeanList.get(i);
				sb.append("\"reportId\": \"").append(bean.getReportId()).append("\",");
				sb.append("\"id\": \"").append(bean.getId()).append("\",");
				sb.append("\"name\": \"").append(bean.getName()).append("\",");
				sb.append("\"value\": \"").append(bean.getValue()).append("\"");
				sb.append("}");
				if (i < reportParameterBeanList.size() - 1) {
					sb.append(",");
				}
			}
			sb.append("]");
		}
		sb.append("}");
		return sb.toString();
	}
}
