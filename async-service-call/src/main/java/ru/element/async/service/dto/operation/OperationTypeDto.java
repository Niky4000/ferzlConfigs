package ru.element.async.service.dto.operation;


/**
 * Внимание!!! Внимание!!! Это разделяемый объект из async-service!!! При
 * изменении этого объекта надо менять аналогичный объект и на async-service!!!
 *
 */
public enum OperationTypeDto {

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
	REPORT_FOMS_INSURED_PERSONS_AND_ATTACHES
}
