export ASYNC_SERVICE_DB_ASYNC_JDBC_URL="jdbc:postgresql://localhost:5432/async-db?currentSchema=public&user=postgres&password=postgres"
export ASYNC_SERVICE_DB_MPI_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mpi?currentSchema=mpi&user=mpi&password=H7ZHE30CYRs1"
export ASYNC_SERVICE_DB_MPI_MASTER_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mpi?currentSchema=mpi&user=mpi&password=H7ZHE30CYRs1"
export ASYNC_SERVICE_DB_OLAP_JDBC_URL="jdbc:postgresql://192.168.100.55:5432/mpi_olap_service?currentSchema=public&user=mpi_olap_service_async_service_user&password=BUBiDbq1cgDnSZa0K1Iy"
export ASYNC_URL_PREFIX=/api/async
export ASYNC_PRIVATE_URL_PREFIX=/async
export MPI_COMMON_SECURITY_IGNITE_ADDRESS=10.10.21.10:31987
export MPI_COMMON_SECURITY_IGNITE_USERNAME=ignite
export MPI_COMMON_SECURITY_IGNITE_PASSWORD=ignite
export MPI_COMMON_SECURITY_IGNITE_MAP_NAME=devSessionMap
export MPI_COMMON_SECURITY_SPRING_PROFILES_ACTIVE=gostech
export MPI_COMMON_SECURITY_JWT_SECRET=secret_dev
export MPI_SERVICE_HOST=https://erzl-dev.element-lab.ru
export LEGAL_REP_SERVICE_HOST=https://erzl-dev.element-lab.ru
export LEGAL_REP_SERVICE_PRIVATE_URL_PREFIX=/api/legal-rep
export SHVR_SERVICE_HOST=https://erzl-dev.element-lab.ru
export NSI_SERVICE_NEXT_HOST=https://erzl-dev.element-lab.ru
export INCIDENT_SERVICE_HOST=https://erzl-dev.element-lab.ru
export INCIDENT_SERVICE_PRIVATE_URL_PREFIX=/api/incident
export ASYNC_INTERCEPTOR=ru.elementlab.common.http.base.interceptor.AuthorizationHeaderInterceptor
export HEADER_AUTHORIZATION="Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR"
export MPI_COMMON_SECURITY_CONFIG=dataline_ignite
#export ASYNC_AUTHENTICATION_SERVICE_ACCOUNT_LOGIN="async.service@rtk-element.ru"
#export ASYNC_AUTHENTICATION_SERVICE_ACCOUNT_PASSWORD="mJN~GVm~"
/usr/lib/jvm/jdk-11/bin/java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21044 -jar /home/me/GIT/ferzl/async-service/target/async-service-0.0.1.jar
