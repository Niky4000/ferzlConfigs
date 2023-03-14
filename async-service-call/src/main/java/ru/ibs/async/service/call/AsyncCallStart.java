package ru.ibs.async.service.call;

import com.ibs.report.controller.bean.ReportParameterBean;
import com.ibs.report.controller.bean.ReportResponseBean;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import ru.element.async.service.dto.operation.OperationTypeDto;

public class AsyncCallStart {

	public static void main(String[] args) throws Exception {
		AsyncCallStart asyncCallStart = new AsyncCallStart();
		LinkedHashMap<String, String> map = getAuthMap();
		getEventChanges(asyncCallStart, map);
//		createReport(asyncCallStart, map);
//		LinkedHashMap<String, String> map = getAuthMap("developer", "GIcauW7ObTl198v4Xr9Q", "Basic");
//		String startResult = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/start", RequestMethod.POST, map, "{\n"
//				+ "    \"type\": \"GET_ALL_CURRENT_ENP\",\n"
//				+ "    \"data\": \"{ \\\"usr\\\": \\\"user1\\\", \\\"terr\\\": \\\"76000\\\",\\\"dt\\\": \\\"2022-09-04\\\",\\\"source\\\": \\\"t-foms\\\",\\\"accountId\\\": \\\"-1\\\"}\",\n"
//				+ "    \"source\": \"t-foms\"\n"
//				+ "}");
//		System.out.println(startResult);

//		String startResult2 = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/start", RequestMethod.POST, map, "{\n"
//				+ "    \"type\": \"GET_ALL_CURRENT_ENP\",\n"
//				+ "    \"data\": \"{\\\"id\\\":\\\"uuuu\\\",\\\"status\\\":\\\"NEW\\\",\\\"created\\\":1673902800000}\"\n"
//				+ "}");
//		System.out.println(startResult2);
//		String startResult3 = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/start", RequestMethod.POST, map, "{\n"
//				+ "    \"type\": \"GET_INSURANCE_STATUS_CHANGES\",\n"
//				+ "    \"data\": \"{\\\"dtFrom\\\":\\\"2022-12-01\\\",\\\"dtTo\\\":\\\"2022-12-02\\\",\\\"terr\\\":\\\"45000\\\",\\\"smo\\\":\\\"30\\\"}\",\n"
//				+ "    \"source\": \"t-foms\"\n"
//				+ "}");
//		System.out.println(startResult3);
//		String runtasksResult = asyncCallStart.sendPost("http://localhost:8080/api/async/test/runtasks", RequestMethod.GET, map);
//		System.out.println(runtasksResult);
//		String runpendingtasksResult = asyncCallStart.sendPost("http://localhost:8080/api/async/test/runpendingtasks", RequestMethod.GET, map);
//		System.out.println(runpendingtasksResult);
//		String addResult = asyncCallStart.sendPost("http://localhost:8080/api/async/pendingtask/add", RequestMethod.POST, map, "{\n"
//				+ "    \"type\": \"GET_ALL_CURRENT_ENP\",\n"
//				+ "    \"data\": \"GET_ALL_CURRENT_ENP\",\n"
//				+ "    \"executeDate\": \"2022-01-12T22:22:22\",\n"
//				+ "    \"source\": \"t-foms\"\n"
//				+ "}");
//		System.out.println(addResult);
//		String pendingResult = asyncCallStart.sendPost("http://localhost:8080/api/async/view/pending-task-list", RequestMethod.POST, map, "{\n"
////				+ "    \"opUuid\": \"6F9619FF-8B86-D011-B42D-00CF4FC964FF\"\n"
//				+ "    \"opType\": \"GET_ALL_CURRENT_ENP\"\n"
////				+ "    \"createDateFrom\": \"2023-01-01\",\n"
////				+ "    \"createDateTo\": \"2023-01-12\"\n"
//				+ "}");
//		System.out.println(pendingResult);
//		String operationResult = asyncCallStart.sendPost("http://localhost:8080/api/async/view/operation-result-list", RequestMethod.POST, map, "{\n"
//				+ "    \"opType\": \"GET_ALL_CURRENT_ENP\"\n"
//				+ "}");
//		System.out.println(operationResult);
//		String operationListResult = asyncCallStart.sendPost("http://localhost:8080/api/async/view/operation-list", RequestMethod.POST, map, "{\n"
//				+ "    \"opType\": \"GET_ALL_CURRENT_ENP\"\n"
//				+ "}");
//		String operationListResult = asyncCallStart.sendPost("http://localhost:8080/api/async/view/operation-list", RequestMethod.POST, map, "{\n"
//				+ "  \"pageNum\": 1,\n"
//				+ "  \"limit\": 15,\n"
//				+ "  \"opToken\": \"2ca1a7fb-46ed-4728-a294-8d167b061933\",\n"
//				+ "  \"opType\": null,\n"
//				+ "  \"createDateFrom\": null,\n"
//				+ "  \"createDateTo\": null,\n"
//				+ "  \"organizationName\": null,\n"
//				+ "  \"source\": null,\n"
//				+ "  \"status\": null,\n"
//				+ "  \"sortInfo\": {\n"
//				+ "    \"sortField\": \"create_date\",\n"
//				+ "    \"sortOrder\": \"DESC\"\n"
//				+ "  }"
//				+ "}");
//		System.out.println(operationListResult);
//		String operationDetailsResult = asyncCallStart.sendPost("http://localhost:8080/api/async/view/operations-details", RequestMethod.POST, map, "\n"
//				+ "    [\"6F9619FF-8B86-D011-B42D-00CF8FC964FF\", \"6F9619FF-8B88-D011-B42D-00CF4FC964FF\", \"6F9619FF-8B86-D011-B42D-00CF4FC964FF\"]\n"
//				+ "");
//		System.out.println(operationDetailsResult);
//		String auth = "developer:GIcauW7ObTl198v4Xr9Q";
//		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
//		AsyncCallStart asyncCallStart = new AsyncCallStart();
//		LinkedHashMap<String, String> map = new LinkedHashMap<>();
////		map.put("Authorization", "Bearer eyJ2ZXIiOjEsInR5cCI6IkpXVCIsInNidCI6ImFjY2VzcyIsImFsZyI6IlJTMjU2In0.eyJuYmYiOjE2NDkxNjg1NTUsInNjb3BlIjoiaHR0cDpcL1wvZXNpYS5nb3N1c2x1Z2kucnVcL3Vzcl90cm0_bW9kZT13Jm9pZD0xMDAwNTQ2NjcyIGh0dHA6XC9cL2VzaWEuZ29zdXNsdWdpLnJ1XC91c3JfaW5mP21vZGU9dyZvaWQ9MTAwMDU0NjY3MiBvcGVuaWQgaHR0cDpcL1wvZXNpYS5nb3N1c2x1Z2kucnVcL3Vzcl9zZWM_bW9kZT13Jm9pZD0xMDAwNTQ2NjcyIiwiaXNzIjoiaHR0cDpcL1wvZXNpYS1wb3J0YWwxLnRlc3QuZ29zdXNsdWdpLnJ1XC8iLCJ1cm46ZXNpYTpzaWQiOiI2OWFmMDhlOS0wZTFlLTQzNjUtODgyMy1iMDE2NGUzMDNmMWEiLCJ1cm46ZXNpYTpzYmpfaWQiOjEwMDA1NDY2NzIsImV4cCI6MTY0OTE3OTM1NSwiaWF0IjoxNjQ5MTY4NTU1LCJjbGllbnRfaWQiOiJQR1UifQ.Q6ydWZ_7WiNhQgUA8atK2TjYwXsmPkin8sz-lC8huR9iQ0xFXmbgDOaA58Y4ZfZf1_VuuiwHPJ4YXE3K5deEfvOWaUQES95VfA4btq94K5tpWn1ugF4WqcZW3cf_MWCaBSvFH6dM06qAsrrTO2idpyVHYbot2nQTsi0a0wIgLT6dMAsKIO_uV_6SNnfkv4FETLGLgi-FQu2zA6RFuPHp3UyqagyWZeA0L7AWOntxa2vjDGte1IuIttPr_CO0TCmsQCivknW6H8CgOK2JkIxtdIb7gVbWljo2LCTVg9VdYtFFmopHyNU_P_hApwizprhmw_Bkqx-oGVE87_o5taiBRA");
//		map.put("Authorization", "Basic " + new String(encodedAuth));
//		map.put("Content-Type", "application/json");
//		map.put("User-Agent", USER_AGENT);
//		String operationDetailsResult = asyncCallStart.sendGet("https://erzl-dev.element-lab.ru/api/file-keeper/download?id=036930f5-c3b1-4123-a2d7-abea5dc28b46", RequestMethod.GET, map);
//		System.out.println(operationDetailsResult);
//		String testResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/kk", RequestMethod.POST, map, "23cf063b-d18c-42e3-a38b-7bfd5562319d");
//		System.out.println(testResult);
//		ReportResponseBean2 reportResponseBean2 = new ReportResponseBean2("777", ReportResponseBean.Status.NEW, new Date(), "token", OperationTypeDto.GET_ALL_CURRENT_ENP, "data", "some", Arrays.asList(new ReportParameterBean(null, 1, "usr", "user1"), new ReportParameterBean(null, 2, "terr", "76000"), new ReportParameterBean(null, 3, "dt", "2022-09-04"), new ReportParameterBean(null, 4, "source", "t-foms"), new ReportParameterBean(null, 5, "accountId", "-1")));
//		System.out.println(reportResponseBean2.toPost());
//		String testResult2 = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/kk2", RequestMethod.POST, map, reportResponseBean2.toPost());
//		System.out.println(testResult2);
//		String createReportResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/kk", RequestMethod.POST, map, "\"23cf063b-d18c-42e3-a38b-7bfd5562319d\"");
//		System.out.println(createReportResult);
//		String createReportResult = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/kk", RequestMethod.POST, map, "\"23cf063b-d18c-42e3-a38b-7bfd5562319d\"");
//		System.out.println(createReportResult);
//
//
//		String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/isReady?id=23cf063b-d18c-42e3-a38b-7bfd5562319d", RequestMethod.GET, map, null);
//		System.out.println(startResult);
//		String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/getReportList?userId=user1&daysToLookPast=4&pageNumber=0", RequestMethod.GET, map, null);
//		System.out.println(startResult);
//
//		String uploadResult = asyncCallStart.sendPost("http://localhost:8081/api/file-keeper/upload", RequestMethod.POST, map, "{\n"
//				+ "    \"fileName\": \"fileName\",\n"
//				+ "    \"contentType\": \"contentType\"\n"
////				+ "    \"stream\": \"zzzzzzzzzzzzzzzzz\"\n"
//				+ "}");
//		String kkResult = asyncCallStart.sendPost("http://localhost:8081/api/file-keeper/kk", RequestMethod.POST, map, "{\"str\": \"qwerty\"}");
//		System.out.println(kkResult);
	}

	private static LinkedHashMap<String, String> getAuthMap() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("Authorization", "Bearer eyJ2ZXIiOjEsInR5cCI6IkpXVCIsInNidCI6ImFjY2VzcyIsImFsZyI6IlJTMjU2In0.eyJuYmYiOjE2NDkxNjg1NTUsInNjb3BlIjoiaHR0cDpcL1wvZXNpYS5nb3N1c2x1Z2kucnVcL3Vzcl90cm0_bW9kZT13Jm9pZD0xMDAwNTQ2NjcyIGh0dHA6XC9cL2VzaWEuZ29zdXNsdWdpLnJ1XC91c3JfaW5mP21vZGU9dyZvaWQ9MTAwMDU0NjY3MiBvcGVuaWQgaHR0cDpcL1wvZXNpYS5nb3N1c2x1Z2kucnVcL3Vzcl9zZWM_bW9kZT13Jm9pZD0xMDAwNTQ2NjcyIiwiaXNzIjoiaHR0cDpcL1wvZXNpYS1wb3J0YWwxLnRlc3QuZ29zdXNsdWdpLnJ1XC8iLCJ1cm46ZXNpYTpzaWQiOiI2OWFmMDhlOS0wZTFlLTQzNjUtODgyMy1iMDE2NGUzMDNmMWEiLCJ1cm46ZXNpYTpzYmpfaWQiOjEwMDA1NDY2NzIsImV4cCI6MTY0OTE3OTM1NSwiaWF0IjoxNjQ5MTY4NTU1LCJjbGllbnRfaWQiOiJQR1UifQ.Q6ydWZ_7WiNhQgUA8atK2TjYwXsmPkin8sz-lC8huR9iQ0xFXmbgDOaA58Y4ZfZf1_VuuiwHPJ4YXE3K5deEfvOWaUQES95VfA4btq94K5tpWn1ugF4WqcZW3cf_MWCaBSvFH6dM06qAsrrTO2idpyVHYbot2nQTsi0a0wIgLT6dMAsKIO_uV_6SNnfkv4FETLGLgi-FQu2zA6RFuPHp3UyqagyWZeA0L7AWOntxa2vjDGte1IuIttPr_CO0TCmsQCivknW6H8CgOK2JkIxtdIb7gVbWljo2LCTVg9VdYtFFmopHyNU_P_hApwizprhmw_Bkqx-oGVE87_o5taiBRA");
		map.put("Content-Type", "application/json");
		map.put("User-Agent", USER_AGENT);
		map.put("X-Auth-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzZXNzaW9uLWlkIjoiYjgzNmY5MGYtZmQyOC00YjhjLTkxMDgtMzczZDc5OTE4ZjExIn0.VPnzhgPC57LKDAVJyOLznNp0iLrWxZV7BKSfM6A7-X8");
		return map;
	}
	private static final String PROCESSING = "PROCESSING";
	private static final String NEW_VALUE = "NEW";

	private static void getEventChanges(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
		//		Это тестовый пример!
		String startResult4 = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/start", RequestMethod.POST, map, "{\n"
				+ "    \"type\": \"GET_CHANGES_EVENT\",\n"
				+ "    \"data\": \"{\\\"dtFrom\\\":\\\"2023-01-10\\\",\\\"dtTo\\\":\\\"2023-01-12\\\",\\\"terr\\\":\\\"34000\\\",\\\"smo\\\":\\\"44003\\\"}\",\n"
				+ "    \"source\": \"t-foms\"\n"
				+ "}");
		System.out.println(startResult4);
		String opToken = getValue(startResult4, "\"opToken\":\"", "\",\"errors\"");
		String status = NEW_VALUE;
		String pollResult = "";
		while (status.equals(NEW_VALUE) || status.equals(PROCESSING)) {
			Thread.sleep(2000);
			pollResult = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/poll", RequestMethod.POST, map, "{\n"
					+ "    \"opToken\": \"" + opToken + "\""
					+ "}");
			status = getValue(pollResult, ",\"status\":\"", "\",\"content\"");
			System.out.println(pollResult);
		}
		File file = new File("/home/me/tmp/pollResult");
		if (file.exists()) {
			file.delete();
		}
		Files.write(file.toPath(), pollResult.getBytes(), StandardOpenOption.CREATE_NEW);
//		Это тестовый пример!
	}

	private static void createReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
		ReportResponseBean reportResponseBean = new ReportResponseBean("44", ReportResponseBean.Status.NEW, new Date(), "sdd", null, OperationTypeDto.GET_ALL_CURRENT_ENP, "pdf", "t-foms", Arrays.asList(new ReportParameterBean(null, 1, "usr", "user1"), new ReportParameterBean(null, 2, "terr", "76000"), new ReportParameterBean(null, 3, "dt", "2022-09-04"), new ReportParameterBean(null, 4, "source", "t-foms"), new ReportParameterBean(null, 5, "accountId", "-1")));
		String post = reportResponseBean.toPost();
		System.out.println(post);
		String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/createReport", RequestMethod.POST, map, post);
		System.out.println(startResult);
//		Это тестовый пример!
	}

	private static String getValue(String startResult4, String indexStr1, String indexStr2) {
		return startResult4.substring(startResult4.indexOf(indexStr1) + indexStr1.length(), startResult4.indexOf(indexStr2));
	}

	private static final String USER_AGENT = "Apache-HttpClient/4.1.1 (java 1.5)";
	private static final int READ_TIMEOUT = 60000;

	private enum RequestMethod {
		GET, POST
	}

	@SuppressWarnings("all")
	private String sendGet(String urlStr, RequestMethod requestMethod, Map<String, String> headers) throws Exception {
		return sendPost(urlStr, requestMethod, headers, null);
	}

	// HTTP POST request
	@SuppressWarnings("all")
	private String sendPost(String urlStr, RequestMethod requestMethod, Map<String, String> headers, String urlParameters) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setReadTimeout(READ_TIMEOUT);
		con.setRequestMethod(requestMethod.name());
		headers.entrySet().forEach(entry -> con.setRequestProperty(entry.getKey(), entry.getValue()));
		con.setDoOutput(true);
		if (requestMethod.equals(RequestMethod.POST)) {
			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
				wr.writeBytes(urlParameters);
				wr.flush();
			}
		}
		int responseCode = con.getResponseCode();
		InputStream errorStream = getErrorStream(con);
		try (InputStream inputStream = (errorStream != null ? errorStream : getInputStream(con))) {
			StringBuffer response = readResponse(con, inputStream);
			if (responseCode != java.net.HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Response code = " + responseCode + "!");
			}
			return response.toString();
		}
	}

	private InputStream getInputStream(HttpURLConnection con) {
		try {
			return con.getInputStream();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private InputStream getErrorStream(HttpURLConnection con) {
		return con.getErrorStream();
	}

	private StringBuffer readResponse(HttpURLConnection con, InputStream inputStream) throws IOException {
		StringBuffer response = new StringBuffer();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		}
		return response;
	}

	private static LinkedHashMap<String, String> getAuthMap(String user, String password, String authType) {
		String auth = user + ":" + password;
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("Authorization", authType + " " + new String(encodedAuth));
		map.put("Content-Type", "application/json");
		map.put("User-Agent", USER_AGENT);
		return map;
	}
}
