package com.ibs.report.controller.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreateDto {

	private OperationType type;
	private String source;
	private String fileType;
	private List<ReportParameter> parameters;

	public ReportCreateDto(OperationType type, String source, String fileType, List<ReportParameter> parameters) {
		this.type = type;
		this.source = source;
		this.fileType = fileType;
		this.parameters = parameters;
	}

	public OperationType getType() {
		return type;
	}

	public String getSource() {
		return source;
	}

	public String getFileType() {
		return fileType;
	}

	public List<ReportParameter> getParameters() {
		return parameters;
	}

	public String serializeAsKeyValue() {
		try {
			Map<String, String> map = parameters.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.groupingBy(ReportParameter::getName, LinkedHashMap::new, Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0).getValue())));
			return new ObjectMapper().writeValueAsString(map).replace("\"", "\\\"");
		} catch (JsonProcessingException ex) {
			throw new RuntimeException(ex);
		}
	}

	public String toPost() {
		StringBuilder sb = new StringBuilder("{\n")
				.append("    \"type\": \"").append(type.name()).append("\",\n")
				.append("    \"source\": \"").append(source).append("\",\n")
				.append("    \"fileType\": \"").append(fileType).append("\"");
		if (parameters != null && !parameters.isEmpty()) {
			sb.append(",\n\"parameters\":[");
			for (int i = 0; i < parameters.size(); i++) {
				sb.append("{");
				ReportParameter bean = parameters.get(i);
				sb.append("\"name\": \"").append(bean.getName()).append("\",");
				sb.append("\"value\": \"").append(bean.getValue()).append("\"");
				sb.append("}");
				if (i < parameters.size() - 1) {
					sb.append(",");
				}
			}
			sb.append("]");
		}
		sb.append("}");
		return sb.toString();
	}
}
