export ASYNC_SERVICE_DB_ASYNC_JDBC_URL="jdbc:postgresql://localhost:5432/async-db?currentSchema=public&user=postgres&password=postgres"
export ASYNC_SERVICE_DB_MPI_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mpi?currentSchema=mpi&user=mpi&password=H7ZHE30CYRs1"
export ASYNC_SERVICE_DB_MPI_MASTER_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mpi?currentSchema=mpi&user=mpi&password=H7ZHE30CYRs1"
#export ASYNC_SERVICE_DB_OLAP_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mpi_olap_service?currentSchema=mpi_olap_service&user=mpi_olap_service_async_service_user&password=BUBiDbq1cgDnSZa0K1Iy"
export ASYNC_SERVICE_DB_OLAP_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mpi_olap_service?currentSchema=mpi_olap_service,mpi_olap_emp_service&user=mpi_olap_service_async_service_user&password=BUBiDbq1cgDnSZa0K1Iy"
export ASYNC_SERVICE_DB_TFOMS_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/t_foms_adapter?user=t_foms_adapter_user&password=UKKZHqLvjfbr"
export ASYNC_SERVICE_DB_SMO_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/smo_adapter?user=smo_adapter_user&password=122VbmVetOFiBe4e"
export ASYNC_SERVICE_DB_MO_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mo_adapter?user=mo_adapter_user&password=sCvt6NStjB7Xd5"
export ASYNC_URL_PREFIX=/api/async
export ASYNC_PRIVATE_URL_PREFIX=/async
export MPI_COMMON_SECURITY_IGNITE_ADDRESS=10.10.21.10:31987
export MPI_COMMON_SECURITY_IGNITE_USERNAME=ignite
export MPI_COMMON_SECURITY_IGNITE_PASSWORD=ignite
export MPI_COMMON_SECURITY_IGNITE_MAP_NAME=devSessionMap
#export MPI_COMMON_SECURITY_SPRING_PROFILES_ACTIVE=gostech
#export MPI_COMMON_SECURITY_JWT_SECRET=secret_dev
#export MPI_COMMON_SECURITY_CONFIG=dataline_ignite
#export MPI_COMMON_SECURITY_CONFIG=dataline_hz
export AUTH_SERVICE_HOST=https://erzl-dev.rtk-element.ru
export AUTH_SERVICE_PRIVATE_URL_PREFIX=/api/auth
export AUTH_SERVICE_TECHNICAL_URL_LOGIN=/user/technical
export MPI_SERVICE_HOST=https://erzl-dev.rtk-element.ru
export LEGAL_REP_SERVICE_HOST=https://erzl-dev.rtk-element.ru
export LEGAL_REP_SERVICE_PRIVATE_URL_PREFIX=/api/legal-rep
export SHVR_SERVICE_HOST=https://erzl-dev.rtk-element.ru
export NSI_SERVICE_NEXT_HOST=https://erzl-dev.rtk-element.ru
export INCIDENT_SERVICE_HOST=https://erzl-dev.rtk-element.ru
export INCIDENT_SERVICE_PRIVATE_URL_PREFIX=/api/incident
export ASYNC_INTERCEPTOR=ru.elementlab.common.http.base.interceptor.AuthorizationHeaderInterceptor
export HEADER_AUTHORIZATION="Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR"

export MPI_COMMON_SECURITY_HAZELCAST_MAP_NAME=sessionMap
export MPI_COMMON_SECURITY_HAZELCAST_ADDRESS=10.10.21.7:32035
export MPI_COMMON_SECURITY_JWT_SECRET=secret_dev
export MPI_COMMON_SECURITY_SPRING_PROFILES_ACTIVE=gostech,default
export MPI_COMMON_SECURITY_EXPIRES_IN_SECS=600
export MPI_COMMON_SECURITY_CONFIG=dataline_hz

export SWAGGER_UI_CLASSPATH="/home/me/.m2/repository/org/webjars/swagger-ui/5.10.3/swagger-ui-5.10.3.jar"
#export ASYNC_AUTHENTICATION_SERVICE_ACCOUNT_LOGIN="async.service@rtk-element.ru"
#export ASYNC_AUTHENTICATION_SERVICE_ACCOUNT_PASSWORD="mJN~GVm~"
export FILE_KEEPER_URL=http://127.0.0.1:8081/api/file-keeper
export ASYNC_SERVICE_AUTHORIZATION_TRUSTED_SERVICE_KEYS=async-service-technical-account-key-2024-12-02
export ASYNC_SERVICE_TECHNICAL_ACCOUNT_TOKEN=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpbnRlcm5hbCI6dHJ1ZSwic2Vzc2lvbi1pZCI6ImFzeW5jLXNlcnZpY2UtdGVjaG5pY2FsLWFjY291bnQta2V5LTIwMjQtMTItMDIifQ.6VM8LpM_YMeeURrM2SiV7fGmBANjSj2dOo1vnAMWi8A
/usr/lib/jvm/jdk-11/bin/java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21044 -jar /home/me/GIT/ferzl/async-service/target/async-service-0.0.1.jar
