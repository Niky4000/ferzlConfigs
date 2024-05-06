package com.ibs.report.controller.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ru.element.async.service.dto.operation.OperationTypeDto;

public class ReportResponseBean2 {

	private String id;
	private ReportResponseBean.Status status;
	private Date created;
	private String opToken;
	private OperationTypeDto type;
	private String data;
	private String source;
	private List<ReportParameterBean> reportParameterBeanList;

	public ReportResponseBean2() {
	}

	public ReportResponseBean2(String id, ReportResponseBean.Status status, Date created, String opToken, OperationTypeDto type, String data, String source, List<ReportParameterBean> reportParameterBeanList) {
		this.id = id;
		this.status = status;
		this.created = created;
		this.opToken = opToken;
		this.type = type;
		this.data = data;
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

	public OperationTypeDto getType() {
		return type;
	}

	public void setType(OperationTypeDto type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public String toPost() {
		StringBuilder sb = new StringBuilder("{\n")
				.append("    \"id\": \"").append(id).append("\",\n")
				.append("    \"status\": \"").append(status.name()).append("\",\n")
				.append("    \"created\": \"").append(new SimpleDateFormat("yyyy-MM-dd").format(created)).append("\",\n")
				.append("    \"opToken\": \"").append(opToken).append("\",\n")
				//				.append("    \"reportParameterBeanList\": \"").append(reportParameterBeanList).append("\"\n")
				.append("    \"type\": \"").append(type.name()).append("\",\n")
				.append("    \"data\": \"").append(data).append("\",\n")
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
