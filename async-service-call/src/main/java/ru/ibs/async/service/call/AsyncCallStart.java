package ru.ibs.async.service.call;

import com.ibs.report.controller.bean.OperationType;
import com.ibs.report.controller.bean.ReportCreateDto;
import com.ibs.report.controller.bean.ReportParameter;
import com.ibs.report.controller.bean.ReportParameterBean;
import com.ibs.report.controller.bean.ReportResponseBean;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import ru.element.async.service.dto.operation.OperationTypeDto;

public class AsyncCallStart {

    public static void main(String[] args) throws Exception {
        AsyncCallStart asyncCallStart = new AsyncCallStart();
//        String token = sendAuthRequest(asyncCallStart);
//        LinkedHashMap<String, String> map = getAuthMap(token);
        String token = sendAuthTestRequest(asyncCallStart);
        LinkedHashMap<String, String> map = getAuthTestMap(token);
//		sendUsingSockets();
//		LinkedHashMap<String, String> map = getAuthMap("developer", "GIcauW7ObTl198v4Xr9Q", "Basic", token);
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"GET_CHANGES_EVENT\",\n" + "    \"data\": \"{\\\"dtFrom\\\":\\\"2023-01-10\\\",\\\"dtTo\\\":\\\"2023-01-12\\\",\\\"terr\\\":\\\"34000\\\",\\\"smo\\\":\\\"44003\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"GET_CHANGES_EVENT_CSV\",\n" + "    \"data\": \"{\\\"dtFrom\\\":\\\"2024-10-02\\\",\\\"dtTo\\\":\\\"2024-10-04\\\",\\\"terr\\\":\\\"34000\\\",\\\"eventList\\\":[\\\"ВЕРИФ\\\",\\\"1П\\\"]}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"GET_VIEW_DATA_SOC_STATUS\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2022-07-01\\\",\\\"terr\\\":\\\"01000\\\",\\\"smo\\\":\\\"22000\\\",\\\"quarter\\\":\\\"true\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"GET_VIEW_DATA_SOC_STATUS\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2022-07-01\\\",\\\"terr\\\":\\\"01000\\\",\\\"quarter\\\":\\\"true\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"GET_VIEW_DATA_SOC_STATUS\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-03-01\\\",\\\"terr\\\":\\\"01000\\\",\\\"quarter\\\":\\\"false\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"GET_VIEW_DATA_INSURANCE\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-03-24\\\",\\\"terr\\\":\\\"01000\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"GET_VIEW_DATA_SOC_STATUS\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-03-24\\\",\\\"terr\\\":\\\"01000\\\",\\\"quarter\\\":\\\"false\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES\",\n" + "    \"data\": \"{\\\"user\\\":\\\"user\\\",\\\"dt\\\":\\\"2023-03-01\\\",\\\"source\\\":\\\"t-foms\\\",\\\"accountId\\\":\\\"accountId\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES_AND_SMO\",\n" + "    \"data\": \"{\\\"user\\\":\\\"user\\\",\\\"dt\\\":\\\"2023-03-01\\\",\\\"source\\\":\\\"t-foms\\\",\\\"accountId\\\":\\\"accountId\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES_AND_SMO\",\n" + "    \"data\": \"{\\\"user\\\":\\\"user\\\",\\\"dt\\\":\\\"2024-04-04\\\",\\\"source\\\":\\\"t-foms\\\",\\\"accountId\\\":\\\"accountId\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_CITIZENSHIP\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-08-01\\\",\\\"okatoList\\\":\\\"\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_CITIZENSHIP\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-08-01\\\",\\\"okatoList\\\":\\\"24000,29000,34000,67000\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_CITIZENSHIP\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-08-01\\\",\\\"okatoList\\\":[\\\"24000\\\",\\\"29000\\\",\\\"34000\\\",\\\"67000\\\"]}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_CITIZENSHIP\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-09-28\\\",\\\"okatoList\\\":\\\"\\\",\\\"okatoNameList\\\":\\\"\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_MO_ATTACHMENT_COUNT\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-09-28\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendCitizenshipQuery(asyncCallStart);
//		createExampleReport(asyncCallStart, map);
//		createAttachedAndInsuredPersonsReport("http://localhost:8082/api/mpi-report/operation/start", asyncCallStart, map); // 1
//		createAttachedAndInsuredPersonsReport("https://erzl-dev.element-lab.ru/api/reporter/operation/start", asyncCallStart, map);
//		createInsuredByAgeReport(asyncCallStart, map); // 2
//        createAttachedAndInsuredPersonsAndSmoReport("http://localhost:8082/api/mpi-report/operation/start", asyncCallStart, map); // 3
//        createCitizenshipReport("http://localhost:8082/api/mpi-report/operation/start", asyncCallStart, map); // 4
//		createMpiEventsStatisticsReport("http://localhost:8082/api/mpi-report/operation/start", asyncCallStart, map); // 5
        createStatisticsReport(asyncCallStart, map); // 6
//        createIncidentReport(asyncCallStart, map); // 7
//		createNewTerritoriesReport(asyncCallStart, map); // 8
//        createGenderAndAgeReport(asyncCallStart, map); // 9
//        createMoAttachmentCountReport(asyncCallStart, map); // 10
//        createAttachmentProfileDistributionReport(asyncCallStart, map); // 11
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"UNDISTRIBUTED_INSURED_UNLOADING\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-09-01\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 12
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"UNDISTRIBUTED_INSURED_UNLOADING\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-09-01\\\", \\\"district\\\":\\\"43000\\\", \\\"areaType\\\":\\\"2\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 12
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_INSURED_DISTRIBUTION\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-12-01\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 13
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_INSURED_DISTRIBUTION\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2023-12-01\\\", \\\"district\\\":\\\"43000\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 13
//        createInsuredDistributionReport(asyncCallStart, map); // 13
//        createInsuredAmountReport(asyncCallStart, map); // 14
//        createInsuredAmountAttachedToInsuranceOrganizationsReport(asyncCallStart, map); // 15
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_INSURED_AMOUNT_ATTACHED_TO_INSURANCE_ORGANIZATIONS\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2024-06-01\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 15
//        createWorkingAndIdleReport(asyncCallStart, map); // 16;
//        createDictionariesErrorsIncidentStatisticsReport(asyncCallStart, map); // 17
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_ONE_TERRITORY_ATTACHMENT\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2024-04-15\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 18
//        createOneTerritoryAttachmentReport(asyncCallStart, map); // 18
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"CREATE_INCIDENT_SLOW\",\n" + "    \"data\": \"{\\\"incidentType\\\":\\\"_\\\", \\\"createDate\\\":\\\"2023-12-01\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); //
//		pollReportData(asyncCallStart, map, "3c8b3123-ea0c-4849-b461-2bdc002ae706");
//        createInsuredPersonsByAgeAndRegionsReport(asyncCallStart, map); // 19
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_NIL_IDENTIFICATION_REQUESTS\",\n" + "    \"data\": \"{\\\"dtFrom\\\":\\\"2024-01-01\\\",\\\"dtTo\\\":\\\"2024-04-15\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 20
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_NIL_IDENTIFICATION_REQUESTS\",\n" + "    \"data\": \"{\\\"decision\\\":\\\"\\\",\\\"decisionName\\\":\\\"\\\",\\\"dtFrom\\\":\\\"2024-08-01\\\",\\\"dtTo\\\":\\\"2024-08-30\\\",\\\"moNames\\\":\\\"____________\\\",\\\"moCodes\\\":\\\"440030\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 20
//        sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"REPORT_NIL_IDENTIFICATION_REQUESTS\",\n" + "    \"data\": \"{\\\"decision\\\":\\\"\\\",\\\"decisionName\\\":\\\"\\\",\\\"dtFrom\\\":\\\"2024-08-01\\\",\\\"dtTo\\\":\\\"2024-08-30\\\",\\\"moNames\\\":\\\"____________\\\",\\\"moCodes\\\":\\\"440030\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}"); // 20
//        createInsuredForeignersByRegionsReport(asyncCallStart, map); // 21
//        createNilIdentificationRequestsReport(asyncCallStart, map); // 22
//        createSemdRequestsReport(asyncCallStart, map); // 23
//        getReportList(map, asyncCallStart);
//        String incident = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/incident/statistic/udm?dtFrom=2023-01-01&dtTo=2023-10-29", RequestMethod.GET, map, null);
//		String incident = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/incident/statistic/udm?reason", RequestMethod.GET, map, null);
//		String incident = asyncCallStart.sendPost("http://incident-service-test-svc.erzl-test.svc.cluster.local/api/incident/statistic/udm?dtFrom=2023-01-01&dtTo=2023-10-29", RequestMethod.GET, map, null);
//        System.out.println(incident);
//        String region = asyncCallStart.sendPost("http://erzl-dev.element-lab.ru/api/nsi/ref-russian-regions?page=0&size=1&okatoCategoryTwo=21000", RequestMethod.GET, Map.of("Authorization", "Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR"), null);
//        System.out.println(region);
//        String region2 = asyncCallStart.sendPost("http://erzl-test.element-lab.ru/api/nsi/ref-russian-regions?page=0&size=1&okatoCategoryTwo=21000", RequestMethod.GET, Map.of("Authorization", "Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR"), null);
//        System.out.println(region2);
//		getOrganizationNameList(map, asyncCallStart);
//		getUserNameList(map, asyncCallStart);
//        System.out.println(map.toString());
//        String organizations = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/auth/organizations?types=&pageNumber=1&pageSize=25&searchText=%D0%A2%D0%A4%D0%9E%D0%9C%D0%A1", RequestMethod.GET, map, null);
//        String organizations2 = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/auth/organizations/638073db-e8e3-4b11-bda2-cb84dfe89f70", RequestMethod.GET, map, null);
//        String organizations = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/auth/organizations?types=TFOMS&pageNumber=1&pageSize=25", RequestMethod.GET, map, null);
//        String organizations2 = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/auth/organizations?types=TFOMS_UNTRUSTED&pageNumber=1&pageSize=25", RequestMethod.GET, map, null);
//        System.out.println(organizations);
//        System.out.println(organizations2);
//		getStatistics(asyncCallStart, token, new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-01"));
//		getStatisticsInALoop2(asyncCallStart, token);
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"SUSPEND_OMS_POLICY\",\n" + "    \"data\": \"{"
//				+ "\\\"request\\\":{\\\"suspendOmsPolicyRequestType\\\":[{\\\"oip\\\":null,\\\"localPersonIndex\\\":\\\"644cef5c-ba22-4f01-b9d3-2af8c1b26222\\\","
//				+ "\\\"p\\\":{\\\"firstName\\\":\\\"" + r("Алексей") + "\\\",\\\"surname\\\":\\\"" + r("Мышкин") + "\\\",\\\"patronymic\\\":\\\"" + r("Олегович") + "\\\",\\\"birthDay\\\":\\\"1998-02-17\\\"},"
//				+ "\\\"dudl\\\":{\\\"dudlType\\\":\\\"14\\\",\\\"dudlSer\\\":\\\"23 76\\\",\\\"dudlNum\\\":\\\"898419\\\"},"
//				+ "\\\"snils\\\":null,"
//				+ "\\\"milSvc\\\":{\\\"startDate\\\":\\\"2022-05-02\\\",\\\"endDate\\\":\\\"2023-05-02\\\",\\\"termInMonths\\\":12}"
//				+ "}]}}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		sendQueryAndGetResult(asyncCallStart, map, "{\n" + "    \"type\": \"SUSPEND_OMS_POLICY\",\n" + "    \"data\": \"{\\\"dt\\\":\\\"2022-07-01\\\",\\\"terr\\\":\\\"01000\\\",\\\"quarter\\\":\\\"true\\\"}\",\n" + "    \"source\": \"t-foms\"\n" + "}");
//		getReportStatus("0cd6aef2-978f-4285-a3b4-df44b29d2e38", map, asyncCallStart);
//        getReportMetaInfo(map, asyncCallStart);
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

    private static String sendAuthRequest(AsyncCallStart asyncCallStart) throws Exception {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR");
//        String ss = "https://erzl-dev.rtk-element.ru/erzl/";
//        String sendPost = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/auth/user/technical", RequestMethod.POST, map, "{\"login\":\"async.service@rtk-element.ru\",\"password\":\"mJN~GVm~\"}");
        String sendPost = asyncCallStart.sendPost("https://erzl-dev.rtk-element.ru/api/auth/user/technical", RequestMethod.POST, map, "{\"login\":\"async.service@rtk-element.ru\",\"password\":\"mJN~GVm~\"}");
        String token = getToken(sendPost);
        System.out.println(token);
        return token;
    }

    private static String sendAuthTestRequest(AsyncCallStart asyncCallStart) throws Exception {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR");
        String sendPost = asyncCallStart.sendPost("https://erzl-test.rtk-element.ru/api/auth/user/technical", RequestMethod.POST, map, "{\"login\":\"async.service@rtk-element.ru\",\"password\":\"mJN~GVm~\"}");
        String token = getToken(sendPost);
        System.out.println(token);
        return token;
    }
    private static final String TOKEN_HEAD = "{\"token\":\"";

    private static String getToken(String sendPost) {
        int indexOf = sendPost.indexOf(TOKEN_HEAD) + TOKEN_HEAD.length();
        int lastIndexOf = sendPost.indexOf("\"}");
        String token = sendPost.substring(indexOf, lastIndexOf);
        return token;
    }

    private static final int bufferSize = 1024 * 1024;

    private static void sendUsingSockets() throws IOException {
        byte[] buffer = new byte[bufferSize];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (Socket socket = new Socket("erzl-dev.element-lab.ru", 80); //
                BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream(), bufferSize); //
                BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream(), bufferSize);) {
            outputStream.write(("POST https://erzl-dev.element-lab.ru/api/auth/user/technical HTTP/1.1\n"
                    + "Authorization: Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR\n"
                    + "Content-Length: 62\n"
                    + "Content-Type: application/json\n"
                    + "\n"
                    + "{\"login\":\"async.service@rtk-element.ru\",\"password\":\"mJN~GVm~\"}").getBytes());
            outputStream.flush();
            int read = 2;
            while (read > 0) {
                read = inputStream.read(buffer);
                int available = inputStream.available();
                byteArrayOutputStream.write(buffer, 0, read);
                if (read < bufferSize || available == 0) {
                    break;
                }
            }
        }
        System.out.println(new String(byteArrayOutputStream.toByteArray()));
    }

    private static String r(String str) {
        return URLEncoder.encode(str, Charset.forName("utf-8"));
    }

    private static LinkedHashMap<String, String> getAuthMap(String token) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Authorization", "Bearer eyJ2ZXIiOjEsInR5cCI6IkpXVCIsInNidCI6ImFjY2VzcyIsImFsZyI6IlJTMjU2In0.eyJuYmYiOjE2NDkxNjg1NTUsInNjb3BlIjoiaHR0cDpcL1wvZXNpYS5nb3N1c2x1Z2kucnVcL3Vzcl90cm0_bW9kZT13Jm9pZD0xMDAwNTQ2NjcyIGh0dHA6XC9cL2VzaWEuZ29zdXNsdWdpLnJ1XC91c3JfaW5mP21vZGU9dyZvaWQ9MTAwMDU0NjY3MiBvcGVuaWQgaHR0cDpcL1wvZXNpYS5nb3N1c2x1Z2kucnVcL3Vzcl9zZWM_bW9kZT13Jm9pZD0xMDAwNTQ2NjcyIiwiaXNzIjoiaHR0cDpcL1wvZXNpYS1wb3J0YWwxLnRlc3QuZ29zdXNsdWdpLnJ1XC8iLCJ1cm46ZXNpYTpzaWQiOiI2OWFmMDhlOS0wZTFlLTQzNjUtODgyMy1iMDE2NGUzMDNmMWEiLCJ1cm46ZXNpYTpzYmpfaWQiOjEwMDA1NDY2NzIsImV4cCI6MTY0OTE3OTM1NSwiaWF0IjoxNjQ5MTY4NTU1LCJjbGllbnRfaWQiOiJQR1UifQ.Q6ydWZ_7WiNhQgUA8atK2TjYwXsmPkin8sz-lC8huR9iQ0xFXmbgDOaA58Y4ZfZf1_VuuiwHPJ4YXE3K5deEfvOWaUQES95VfA4btq94K5tpWn1ugF4WqcZW3cf_MWCaBSvFH6dM06qAsrrTO2idpyVHYbot2nQTsi0a0wIgLT6dMAsKIO_uV_6SNnfkv4FETLGLgi-FQu2zA6RFuPHp3UyqagyWZeA0L7AWOntxa2vjDGte1IuIttPr_CO0TCmsQCivknW6H8CgOK2JkIxtdIb7gVbWljo2LCTVg9VdYtFFmopHyNU_P_hApwizprhmw_Bkqx-oGVE87_o5taiBRA");
        map.put("Content-Type", "application/json");
        map.put("User-Agent", USER_AGENT);
//        map.put("X-Auth-Token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzZXNzaW9uLWlkIjoiYXN5bmMuc2VydmljZUBydGstZWxlbWVudC5ydSJ9.6N6eAoQjDgyOL8rjIH3hARFFwl3CZ9H7DEb9QfmPfcA");
        map.put("X-Auth-Token", token);
//		map.put("username", "user");
//		map.put("password", "3b914de3-7b03-4bab-80f3-337ea48b6407");
        return map;
    }

    private static LinkedHashMap<String, String> getAuthTestMap(String token) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("accept", "*/*");
//        map.put("X-Auth-Token", "yJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpbnRlcm5hbCI6dHJ1ZSwic2Vzc2lvbi1pZCI6ImFzeW5jLnNlcnZpY2VAcnRrLWVsZW1lbnQucnUifQ.5CeiaASIu4Yel_mBcr1XGEOOh7H19-aGYTS13Gr7xDs");
        map.put("X-Auth-Token", token);
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR");
        map.put("User-Agent", USER_AGENT);
        return map;
    }

    private static LinkedHashMap<String, String> getAuthMap2(String token) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("accept", "*/*");
        map.put("X-Auth-Token", token);
        return map;
    }

    private static LinkedHashMap<String, String> getBasicAuthMap(String token) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String auth = "developer:GIcauW7ObTl198v4Xr9Q";
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        map.put("Authorization", "Basic " + new String(encodedAuth));
        map.put("Content-Type", "application/json");
        map.put("User-Agent", USER_AGENT);
        map.put("X-Auth-Token", token);
        return map;
    }

    private static final String PROCESSING = "PROCESSING";
    private static final String NEW_VALUE = "NEW";

    private static void sendQueryAndGetResult(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map, String data) throws Exception {
        //		Это тестовый пример!
        String startResult4 = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/start", RequestMethod.POST, map, data);
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

    private static void getStatisticsInALoop(AsyncCallStart asyncCallStart, String token) throws Exception {
        Date baseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01");
        for (int i = 0; i < 24; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(baseDate);
            cal.add(Calendar.MONTH, i);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) + ":");
            getStatistics(asyncCallStart, token, cal.getTime());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
        }
    }

    private static void getStatisticsInALoop2(AsyncCallStart asyncCallStart, String token) throws Exception {
        Date baseDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-03-01");
        for (int i = 0; i < 28; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(baseDate);
            cal.add(Calendar.DAY_OF_MONTH, i);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()) + ":");
            getStatistics(asyncCallStart, token, cal.getTime());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
        }
    }

    private static void getStatistics(AsyncCallStart asyncCallStart, String token, Date period) throws Exception {
        LinkedHashMap<String, String> map = getBasicAuthMap(token);
        String startResult4 = asyncCallStart.sendPost("http://erzl-dev.element-lab.ru/api/t-foms/requests/stats?dateReq=" + new SimpleDateFormat("yyyy-MM-dd").format(period), RequestMethod.GET, map, null);
//		String startResult4 = asyncCallStart.sendPost("http://erzl-test.element-lab.ru/api/t-foms/requests/stats?dateReq=" + new SimpleDateFormat("yyyy-MM-dd").format(period), RequestMethod.GET, map, null);
        System.out.println(startResult4);
    }

    private static void createExampleReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
        ReportResponseBean reportResponseBean = new ReportResponseBean("44", ReportResponseBean.Status.NEW, new Date(), "sdd", null, OperationTypeDto.GET_ALL_CURRENT_ENP, "pdf", "t-foms", Arrays.asList(new ReportParameterBean(null, 1, "usr", "user1"), new ReportParameterBean(null, 2, "terr", "76000"), new ReportParameterBean(null, 3, "dt", "2022-09-04"), new ReportParameterBean(null, 4, "source", "t-foms"), new ReportParameterBean(null, 5, "accountId", "-1")));
        String post = reportResponseBean.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/createReport", RequestMethod.POST, map, post);
        System.out.println(startResult);
//		Это тестовый пример!
    }

    private static void createAttachedAndInsuredPersonsReport(String url, AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-03-08"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES, "t-foms", "xlsx", Arrays.asList(new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost(url, RequestMethod.POST, map, post);
        System.out.println(startResult);
//		Это тестовый пример!
    }

    private static void createAttachedAndInsuredPersonsAndSmoReport(String url, AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES_AND_SMO, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-03-01"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES_AND_SMO, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-03-01"), new ReportParameter("okatoList", "14000,17000,20000,34000,40000,41000,88000,71000"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES_AND_SMO, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-04-16"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost(url, RequestMethod.POST, map, post);
        System.out.println(startResult);
//		Это тестовый пример!
    }

    private static void createMpiEventsStatisticsReport(String url, AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CHANGES_EVENT_STAT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dtFrom", "2023-06-01"), new ReportParameter("dtTo", "2023-06-30"), new ReportParameter("groupBySource", "false"), new ReportParameter("eventList", "EVENT1,EVENT2,EVENT3,EVENT4,EVENT5,EVENT6,EVENT7,EVENT8,EVENT9,EVENT10,EVENT11,EVENT12,EVENT13,EVENT14,EVENT15,EVENT16,EVENT17,EVENT18,EVENT19,EVENT20"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CHANGES_EVENT_STAT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dtFrom", "2023-06-01"), new ReportParameter("dtTo", "2023-06-30"), new ReportParameter("groupBySource", "false"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CHANGES_EVENT_STAT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-01"), new ReportParameter("dtFrom", "2023-06-01"), new ReportParameter("dtTo", "2023-06-30"), new ReportParameter("groupBySource", "true"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CHANGES_EVENT_STAT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dtFrom", "2023-06-01"), new ReportParameter("dtTo", "2023-06-30"), new ReportParameter("groupBySource", "true"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CHANGES_EVENT_STAT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dtFrom", "2023-06-01"), new ReportParameter("dtTo", "2023-06-30"), new ReportParameter("groupBySource", "false"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CHANGES_EVENT_STAT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dtFrom", "2023-10-01"), new ReportParameter("dtTo", "2023-10-12"), new ReportParameter("eventList", "ВЕРИФ,ИЗЕРН,ЗСМО,1П,ПРИОСТ,ИЗЕРН,ЗДАДРС,1П,НЗР"), new ReportParameter("eventNameList", "Начальная загрузка реестра"), new ReportParameter("groupBySource", "false"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CHANGES_EVENT_STAT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dtFrom", "2023-10-01"), new ReportParameter("dtTo", "2023-10-12"), new ReportParameter("eventList", "ВЕРИФ,ИЗЕРН,ЗСМО,1П,ПРИОСТ,ИЗЕРН,ЗДАДРС,1П,НЗР"), new ReportParameter("eventNameList", "Начальная загрузка реестра"), new ReportParameter("groupBySource", "true"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost(url, RequestMethod.POST, map, post);
        System.out.println(startResult);
//		Это тестовый пример!
    }

    private static void createCitizenshipReport(String url, AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CITIZENSHIP, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-09-19"), new ReportParameter("okatoList", ""), new ReportParameter("okatoNameList", ""), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CITIZENSHIP, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-27"), new ReportParameter("okatoList", ""), new ReportParameter("okatoNameList", ""), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CITIZENSHIP, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-09-19"), new ReportParameter("okatoList", "60000,61000,63000,64000,65000,66000,68000"), new ReportParameter("okatoNameList", "Ростовская область,Рязанская область,Саратовская область,Сахалинская область,Свердловская область,Смоленская область,Тамбовская область"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CITIZENSHIP, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-08-01"), new ReportParameter("okatoList", "24000,29000,34000,67000"), new ReportParameter("okatoNameList", ""), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CITIZENSHIP, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-08-01"), new ReportParameter("okatoList", "24000,29000"), new ReportParameter("okatoNameList", ""), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CITIZENSHIP, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-02-07"), new ReportParameter("okatoList", "43000,74000,55000"), new ReportParameter("okatoNameList", "Луганская Народная Республика,Херсонская область,г. Байконур"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost(url, RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createStatisticsReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-02-01"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-02-01"), new ReportParameter("docsTypes", "FIND_PERSONS_BY_CRITERIA_REQUEST,GET_ALL_CURRENT_ENP_POLL_REQUEST,GET_INSURANCE_STATUS_CHANGES_POLL_REQUEST,GET_VIEW_DATA_INSURANCE_POLL_REQUEST"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("organizationIds", "6cf1b649-13cd-4858-9438-8bf2332f9030,638073db-e8e3-4b11-bda2-cb84dfe89f70"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("organizationIds", "ffff-ffff-ffff-bda2-cb84dfe89f70"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("organizationIds", "6cf1b649-13cd-4858-9438-8bf2332f9030"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("organizationIds", "638073db-e8e3-4b11-bda2-cb84dfe89f70"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("docsTypes", "PERSON_DATA_REQUEST,SUBMIT_APPLICATION_REQUEST"), new ReportParameter("organizationIds", "6cf1b649-13cd-4858-9438-8bf2332f9030,638073db-e8e3-4b11-bda2-cb84dfe89f70"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("docsTypes", "PERSON_DATA_HISTORY_REQUEST"), new ReportParameter("organizationIds", "6cf1b649-13cd-4858-9438-8bf2332f9030,638073db-e8e3-4b11-bda2-cb84dfe89f70"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-06-20"), new ReportParameter("docsTypes", ""), new ReportParameter("organizationIds", ""), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-07-12"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-29"), new ReportParameter("organizationIds", "5b6af3a0-98c6-4dab-9084-e758548ac17b"), new ReportParameter("organizations", "ТФОМС 34000"), new ReportParameter("organizationsType", "TFOMS")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-01-29"), new ReportParameter("organizationIds", "6cf1b649-13cd-4858-9438-8bf2332f9030,638073db-e8e3-4b11-bda2-cb84dfe89f70,5b6af3a0-98c6-4dab-9084-e758548ac17b"), new ReportParameter("organizations", "ТФОМС 34000"), new ReportParameter("organizationsType", "TFOMS_UNTRUSTED,TFOMS"), new ReportParameter("organizationsTypeText", "Недоверенный ТФОМС, ТФОМС")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-05-23"), new ReportParameter("organizationIds", ""), new ReportParameter("organizations", ""), new ReportParameter("organizationsType", "TFOMS_UNTRUSTED"), new ReportParameter("organizationsTypeText", "Недоверенный ТФОМС")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.TFOMS_CALL_METHOD_STATISTICS_REPORT, "t-foms", "xlsx", true,
//                Arrays.asList(new ReportParameter("dt", "2024-06-22"),
//                        new ReportParameter("organizationIds", ""),
//                        new ReportParameter("organizations", ""),
//                        new ReportParameter("organizationsType", ""),
//                        new ReportParameter("organizationsTypeText", "")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_CALL_METHOD_STATISTICS, "t-foms", "xlsx", true,
                Arrays.asList(new ReportParameter("dt", "2024-06-22"),
                        new ReportParameter("organizationIds", "6cf1b649-13cd-4858-9438-8bf2332f9030,638073db-e8e3-4b11-bda2-cb84dfe89f70"),
                        new ReportParameter("organizations", ""),
                        new ReportParameter("organizationsType", "TFOMS,TFOMS_UNTRUSTED"),
                        new ReportParameter("organizationsTypeText", "")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
//		Это тестовый пример!
    }

    private static void createIncidentReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INCORRECT_DUDLS_FROM_MASTER_SYSTEMS, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dtFrom", "2024-02-16"), new ReportParameter("dtTo", "2024-03-15"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INCORRECT_DUDLS_FROM_MASTER_SYSTEMS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dtFrom", "2024-02-16"), new ReportParameter("dtTo", "2024-03-15"), new ReportParameter("reason", "а вот новая причина"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INCORRECT_DUDLS_FROM_MASTER_SYSTEMS, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dtFrom", "2023-10-01"), new ReportParameter("dtTo", "2023-11-30"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INCORRECT_DUDLS_FROM_MASTER_SYSTEMS, "t-foms", "xlsx", Arrays.asList(new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INCORRECT_DUDLS_FROM_MASTER_SYSTEMS, "t-foms", "xlsx", Arrays.asList(new ReportParameter("reason", ""), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
//		Это тестовый пример!
    }

    private static void createNewTerritoriesReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_IN_NEW_REGIONS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-02-01"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createGenderAndAgeReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_GENDER_AND_AGE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-01-01"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("grouping", "МО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_GENDER_AND_AGE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-12-11"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_GENDER_AND_AGE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-12-11"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_GENDER_AND_AGE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-12-11"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("okatoList", "55000"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_GENDER_AND_AGE, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-12-11"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("okatoList", "60000,61000,63000,64000,65000,66000,68000"), new ReportParameter("moCodes", "440039,010001"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_GENDER_AND_AGE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-12-11"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("okatoList", "60000,61000,63000,64000,65000,66000,68000"), new ReportParameter("moCodes", "440039"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createMoAttachmentCountReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("grouping", "МО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1"))); // Группировка по МО
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1"))); // Группировка по СМО
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("smoCodes", "44011,44003"), new ReportParameter("moCodes", "440003,440089,449911"), new ReportParameter("attachmentProfile", "1"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1"))); // Группировка по СМО, условие по СМО, профиль, по МО и регион РФ
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("smoCodes", "44011"), new ReportParameter("moCodes", "440003"), new ReportParameter("organizationsType", "МО"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1"))); // Группировка по СМО, условие по СМО, профиль, по МО и регион РФ, а тип организации МО
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("smoCodes", "44011"), new ReportParameter("moCodes", "440003"), new ReportParameter("attachmentProfile", "1"), new ReportParameter("organizationsType", "СМО"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1"))); // Группировка по СМО, условие по СМО, профиль, по МО и регион РФ, а тип организации СМО
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("organizationsType", "ТФОМС"), new ReportParameter("grouping", "СМО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1"))); // Группировка по СМО и регион РФ, а тип организации ТФОМС
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("organizationsType", "ТФОМС"), new ReportParameter("grouping", "МО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1"))); // Группировка по МО и регион РФ, а тип организации ТФОМС
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("attachmentProfile", "5"), new ReportParameter("grouping", "МО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_MO_ATTACHMENT_COUNT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("grouping", "МО"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createAttachmentProfileDistributionReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ATTACHMENT_PROFILE_DISTRIBUTION, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-11-01")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ATTACHMENT_PROFILE_DISTRIBUTION, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-11-01"), new ReportParameter("district", "34000")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ATTACHMENT_PROFILE_DISTRIBUTION, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-04-26"), new ReportParameter("district", "53000"), new ReportParameter("districtName", "Оренбургская область")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createInsuredDistributionReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_DISTRIBUTION, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-12-01")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_DISTRIBUTION, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-12-01"), new ReportParameter("district", "34000"), new ReportParameter("districtName", "Костромская область")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createInsuredAmountReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_AMOUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("year", "2023"), new ReportParameter("quarter", "2"), new ReportParameter("quarterName", "2 кв")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_AMOUNT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("year", "2023"), new ReportParameter("quarter", "3"), new ReportParameter("quarterName", "3 кв")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_AMOUNT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("district", "34000"), new ReportParameter("districtName", "Регион 34000"), new ReportParameter("year", "2023"), new ReportParameter("quarter", "0"), new ReportParameter("quarterName", "Годовая")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createInsuredAmountAttachedToInsuranceOrganizationsReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_AMOUNT_ATTACHED_TO_INSURANCE_ORGANIZATIONS, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_AMOUNT_ATTACHED_TO_INSURANCE_ORGANIZATIONS, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("okatoList", "34000,29000,42000,46000,33000,22000,76000"), new ReportParameter("okatoNameList", "34000,29000,42000,46000")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_AMOUNT_ATTACHED_TO_INSURANCE_ORGANIZATIONS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("okatoList", ""), new ReportParameter("okatoNameList", "")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createWorkingAndIdleReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_WORKING_AND_IDLE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("okatoList", "34000,97000,71140,56000"), new ReportParameter("districtName", "Имя области 34000"), new ReportParameter("year", "2023"), new ReportParameter("quarter", "3"), new ReportParameter("quarterName", "3 кв")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_WORKING_AND_IDLE, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("okatoList", ""), new ReportParameter("districtName", "Имя области 34000"), new ReportParameter("year", "2023"), new ReportParameter("quarter", "3"), new ReportParameter("quarterName", "3 кв")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_WORKING_AND_IDLE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("okatoList", "97000"), new ReportParameter("districtName", "Чувашская Республика - Чувашия"), new ReportParameter("quarter", "4"), new ReportParameter("quarterName", "4 кв"), new ReportParameter("year", "2023")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_WORKING_AND_IDLE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("okatoList", "71140"), new ReportParameter("districtName", "Ямало-Ненецкий автономный округ"), new ReportParameter("quarter", "4"), new ReportParameter("quarterName", "4 кв"), new ReportParameter("year", "2022")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_WORKING_AND_IDLE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("okatoList", "56000"), new ReportParameter("districtName", "Пензенская область"), new ReportParameter("quarter", "2"), new ReportParameter("quarterName", "2 кв"), new ReportParameter("year", "2023")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_WORKING_AND_IDLE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("okatoList", "18000"), new ReportParameter("districtName", "Волгоградская область"), new ReportParameter("quarter", "0"), new ReportParameter("quarterName", "Годовая"), new ReportParameter("year", "2022")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_WORKING_AND_IDLE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("okatoList", "80000"), new ReportParameter("districtName", "Республика Башкортостан"), new ReportParameter("quarter", "0"), new ReportParameter("quarterName", "Годовая"), new ReportParameter("year", "2022")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createDictionariesErrorsIncidentStatisticsReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_DICTIONARIES_ERRORS_INCIDENT_STATISTICS, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_DICTIONARIES_ERRORS_INCIDENT_STATISTICS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dtFrom", "2024-03-21"), new ReportParameter("dtTo", "2024-04-18"), new ReportParameter("source", "t-foms"), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createOneTerritoryAttachmentReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ONE_TERRITORY_ATTACHMENT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("okatoList", ""), new ReportParameter("districtName", "Имя области 34000")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ONE_TERRITORY_ATTACHMENT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("attachmentProfile", ""), new ReportParameter("okatoList", ""), new ReportParameter("districtName", "Имя области 34000")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ONE_TERRITORY_ATTACHMENT, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-04-15"), new ReportParameter("attachmentProfile", ""), new ReportParameter("okatoList", ""), new ReportParameter("districtName", "Имя области 34000")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createInsuredPersonsByAgeAndRegionsReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ONE_TERRITORY_ATTACHMENT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("attachmentProfile", "1,2,3,4"), new ReportParameter("okatoList", ""), new ReportParameter("districtName", "Имя области 34000")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_ONE_TERRITORY_ATTACHMENT, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2024-01-01"), new ReportParameter("attachmentProfile", ""), new ReportParameter("okatoList", ""), new ReportParameter("districtName", "Имя области 34000")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_PERSONS_BY_AGE_AND_REGIONS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dates", "2024-04-15,2024-03-01,2024-09-01,2024-07-01,2024-08-01,2024-05-22"), new ReportParameter("okatoList", "")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createInsuredForeignersByRegionsReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_FOREIGNERS_BY_REGIONS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-04-15"), new ReportParameter("okatoList", "")));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_FOREIGNERS_BY_REGIONS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-04-15"), new ReportParameter("okatoList", "14000,15000")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_INSURED_FOREIGNERS_BY_REGIONS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2024-04-15"), new ReportParameter("okatoList", "[\"14000\",\"15000\"]")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createNilIdentificationRequestsReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_NIL_IDENTIFICATION_REQUESTS, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dtFrom", "2024-01-01"), new ReportParameter("dtTo", "2024-04-15")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void createSemdRequestsReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_SEMD, "t-foms", "xlsx", true, Arrays.asList(
                new ReportParameter("dtBirthFrom", "2023-01-01"),
                new ReportParameter("dtBirthTo", "2024-04-15"),
                new ReportParameter("dtDeathFrom", "2024-01-01"),
                new ReportParameter("dtDeathTo", "2024-04-15"),
                new ReportParameter("organizationsType", "ТФОМС") //,
        //                new ReportParameter("type", "НИЛ"),
        //                new ReportParameter("type", "НР"),
        //                new ReportParameter("moCodes", "440003,440089,449911"),
        //                new ReportParameter("district", "34000")
        ));
//        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_SEMD, "t-foms", "xlsx", true, Arrays.asList(
//                new ReportParameter("dtBirthFrom", "2023-01-01"),
//                new ReportParameter("dtBirthTo", "2024-04-15"),
//                new ReportParameter("organizationsType", "МО"),
//                new ReportParameter("moCodes", "180062")
//        ));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
    }

    private static void pollReportData(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map, String opToken) throws Exception {
        String pollResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/poll/" + opToken, RequestMethod.GET, map, null);
//		String pollResult = asyncCallStart.sendPost("https://erzl-test.element-lab.ru/api/mpi-report/operation/poll/" + opToken, RequestMethod.GET, map, null);
        System.out.println(pollResult);
    }

    private static void getReportList(LinkedHashMap<String, String> map, AsyncCallStart asyncCallStart) throws Exception {
        String response = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/getReportList", RequestMethod.POST, map, "{\n"
                //				+ "\"id\": \"3c8b3123-ea0c-4849-b461-2bdc002ae706\"\n"
                + "\"createDateFrom\":\"" + "2024-01-01\","
                + "\"createDateTo\":\"" + "2024-01-17\","
                + "\"types\":[],"
                + "\"createdByManager\":\"true\""
                + "}");
//        String response = asyncCallStart.sendPost("https://erzl-test.element-lab.ru/api/reporter/operation/getReportList", RequestMethod.POST, map, "{"
//                + "\"createDateFrom\":\"" + "2024-01-01\","
//                + "\"createDateTo\":\"" + "2024-01-17\""
//                //                + "\"types\":[\"REPORT_GENDER_AND_AGE\"],"
//                //                + "\"createdByManager\":\"true\""
//                + "}");
        System.out.println(response);
    }

    private static void createInsuredByAgeReport(AsyncCallStart asyncCallStart, LinkedHashMap<String, String> map) throws Exception {
//		Это тестовый пример!
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_BY_AGE, "t-foms", "xls", Arrays.asList(new ReportParameter("dt", "2023-01-01"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_BY_AGE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-01-01"), new ReportParameter("okatoList", "24000,29000,34000,67000"), new ReportParameter("okatoNameList", "Moskow,Iceberg,Jellyfish,Dolphin,Fire"), new ReportParameter("accountId", "-1")));
//		ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_BY_AGE, "t-foms", "xlsx", Arrays.asList(new ReportParameter("dt", "2023-08-09"), new ReportParameter("okatoList", ""), new ReportParameter("okatoNameList", ""), new ReportParameter("accountId", "-1")));
        ReportCreateDto reportCreateDto = new ReportCreateDto(OperationType.REPORT_FOMS_INSURED_PERSONS_BY_AGE, "t-foms", "xlsx", true, Arrays.asList(new ReportParameter("dt", "2023-08-01"), new ReportParameter("okatoList", ""), new ReportParameter("okatoNameList", ""), new ReportParameter("accountId", "-1")));
        String post = reportCreateDto.toPost();
        System.out.println(post);
        String startResult = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/start", RequestMethod.POST, map, post);
        System.out.println(startResult);
//		Это тестовый пример!
    }

    private static void getOrganizationNameList(LinkedHashMap<String, String> map, AsyncCallStart asyncCallStart) throws Exception {
        String response = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/getOrganizationNameList", RequestMethod.POST, map, "{\"organizationName\":\"" + "ТЕ" + "\"}");
        System.out.println(response);
    }

    private static void getUserNameList(LinkedHashMap<String, String> map, AsyncCallStart asyncCallStart) throws Exception {
        String response = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/getUserNameList", RequestMethod.POST, map, "{\"userName\":\"" + "ТЕ" + "\"}");
        System.out.println(response);
    }

    private static void getReportStatus(String reportId, LinkedHashMap<String, String> map, AsyncCallStart asyncCallStart) throws Exception {
        String response = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/poll/" + reportId, RequestMethod.GET, map, null);
        System.out.println(response);
    }

    private static void getReportMetaInfo(LinkedHashMap<String, String> map, AsyncCallStart asyncCallStart) throws Exception {
        String response = asyncCallStart.sendPost("http://localhost:8082/api/mpi-report/operation/getReportListMetaInfo", RequestMethod.POST, map, "{\"types\":[\"" + "REPORT_MO_ATTACHMENT_COUNT" + "\"]}");
        System.out.println(response);
    }

    private static String getValue(String startResult4, String indexStr1, String indexStr2) {
        return startResult4.substring(startResult4.indexOf(indexStr1) + indexStr1.length(), startResult4.indexOf(indexStr2));
    }

    private static void sendCitizenshipQuery(AsyncCallStart asyncCallStart, String token) throws Exception {
        LinkedHashMap<String, String> map = getAuthMap("developer", "GIcauW7ObTl198v4Xr9Q", "Basic", token);
        String startResult4 = asyncCallStart.sendPost("https://erzl-dev.element-lab.ru/api/mpi/nsi/ref-oksm/name", RequestMethod.POST, map, "{\n" + "\"a2\": \"KGZ\"" + "\n}");
        System.out.println(startResult4);
//		String opToken = getValue(startResult4, "\"opToken\":\"", "\",\"errors\"");
//		String status = NEW_VALUE;
//		String pollResult = "";
//		while (status.equals(NEW_VALUE) || status.equals(PROCESSING)) {
//			Thread.sleep(2000);
//			pollResult = asyncCallStart.sendPost("http://localhost:8080/api/async/operation/poll", RequestMethod.POST, map, "{\n"
//					+ "    \"opToken\": \"" + opToken + "\""
//					+ "}");
//			status = getValue(pollResult, ",\"status\":\"", "\",\"content\"");
//			System.out.println(pollResult);
//		}
//		File file = new File("/home/me/tmp/pollResult");
//		if (file.exists()) {
//			file.delete();
//		}
//		Files.write(file.toPath(), pollResult.getBytes(), StandardOpenOption.CREATE_NEW);
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
//			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//				wr.writeBytes(urlParameters);
//				wr.flush();
//			}
            try (OutputStream wr = con.getOutputStream()) {
                wr.write(urlParameters.getBytes());
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

    private static LinkedHashMap<String, String> getAuthMap(String user, String password, String authType, String token) {
        String auth = user + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("Authorization", authType + " " + new String(encodedAuth));
        map.put("Content-Type", "application/json");
        map.put("User-Agent", USER_AGENT);
        map.put("X-Auth-Token", token);
        return map;
    }
}
