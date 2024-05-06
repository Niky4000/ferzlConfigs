package ru.element.async.service.dto.operation;

public class OperationPollDto {

	private final String opToken;

	public OperationPollDto(String opToken) {
		this.opToken = opToken;
	}

	public String getOpToken() {
		return opToken;
	}

	public String toPost() {
		return new StringBuilder("{\n").append("    \"opToken\": \"").append(opToken).append("\"\n").append("}").toString();
	}
}
