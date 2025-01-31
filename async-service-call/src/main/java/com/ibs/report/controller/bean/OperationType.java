package com.ibs.report.controller.bean;

/**
 * Внимание!!! Внимание!!! Это разделяемый объект из async-service!!! При
 * изменении этого объекта надо менять аналогичный объект и на async-service!!!
 */
public enum OperationType {

    GET_ALL_CURRENT_ENP,
    GET_INSURANCE_STATUS_CHANGES,
    SUSPEND_OMS_POLICY,
    PROCESS_BIRTH_DATA,
    PROCESS_DEATH_DATA,
    RESTORE_OMS_POLICY,
    EPGU_IDENTIFY_CONSENTED_PERSONS,
    EPGU_PROCESS_POLICY_APPLICATIONS,
    EPGU_IDENTIFY_PERSONS_WITH_CHANGES,
    EPGU_GET_MAILING_DATA,
    GET_VIEW_DATA_ATTACH,
    REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES,
    REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES_AND_SMO,
    REPORT_CHANGES_EVENT_STAT,
    TFOMS_CALL_METHOD_STATISTICS_REPORT,
    REPORT_CALL_METHOD_STATISTICS,
    REPORT_FOMS_INSURED_PERSONS_BY_AGE,
    REPORT_CITIZENSHIP,
    REPORT_INCORRECT_DUDLS_FROM_MASTER_SYSTEMS,
    REPORT_FOMS_INSURED_PERSONS_IN_NEW_REGIONS,
    REPORT_GENDER_AND_AGE,
    REPORT_MO_ATTACHMENT_COUNT,
    REPORT_ATTACHMENT_PROFILE_DISTRIBUTION,
    REPORT_INSURED_DISTRIBUTION,
    REPORT_INSURED_AMOUNT,
    REPORT_INSURED_AMOUNT_ATTACHED_TO_INSURANCE_ORGANIZATIONS,
    REPORT_WORKING_AND_IDLE,
    REPORT_DICTIONARIES_ERRORS_INCIDENT_STATISTICS,
    REPORT_ONE_TERRITORY_ATTACHMENT,
    REPORT_INSURED_PERSONS_BY_AGE_AND_REGIONS,
    REPORT_NIL_IDENTIFICATION_REQUESTS,
    REPORT_INSURED_FOREIGNERS_BY_REGIONS,
    REPORT_SEMD,
    REPORT_DEDUPLICATION_INCIDENTS
}
