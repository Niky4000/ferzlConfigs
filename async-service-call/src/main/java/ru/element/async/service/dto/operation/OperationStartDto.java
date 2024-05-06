package ru.element.async.service.dto.operation;

/**
 * Создать задачу. Внимание!!! Внимание!!! Это разделяемый объект из
 * async-service!!! При изменении этого объекта надо менять аналогичный объект и
 * на async-service!!!
 *
 * @author Sergey Parfenov
 */
public class OperationStartDto {

	private OperationTypeDto type;
	private String data;
	private String source;

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

	public String toPost() {
		return new StringBuilder("{\n").append("    \"type\": \"").append(type.name()).append("\",\n")
				.append("    \"data\": \"").append(data).append("\",\n")
				.append("    \"source\": \"").append(source).append("\"\n")
				.append("}").toString();
	}
}
