export MPI_REPORTER_SERVICE_DB_JDBC_URL="jdbc:postgresql://localhost:5433/report?currentSchema=public&user=report&password=report"
export REPORTER_URL_PREFIX=api/mpi-report
export REPORTER_PRIVATE_URL_PREFIX=api/mpi-report
export MPI_COMMON_SECURITY_IGNITE_ADDRESS=10.10.21.10:31987
export MPI_COMMON_SECURITY_IGNITE_USERNAME=ignite
export MPI_COMMON_SECURITY_IGNITE_PASSWORD=ignite
export MPI_COMMON_SECURITY_IGNITE_MAP_NAME=devSessionMap
export MPI_COMMON_SECURITY_SPRING_PROFILES_ACTIVE=gostech
export MPI_COMMON_SECURITY_JWT_SECRET=secret_dev
export MPI_SERVICE_HOST=https://erzl-dev.element-lab.ru
export REPORTER_INTERCEPTOR=ru.elementlab.common.http.base.interceptor.AuthorizationHeaderInterceptor
export HEADER_AUTHORIZATION="Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR"
export TMP_FOLDER_PATH=/home/me/tmp/reports
export AUTH_SERVICE_HOST=https://erzl-dev.element-lab.ru
export AUTH_SERVICE_PRIVATE_URL_PREFIX=/api/auth
export AUTH_SERVICE_TECHNICAL_URL_LOGIN=/user/technical
#export MPI_REPORTER_LOG_LEVEL_ROOT=TRACE
#export MPI_REPORTER_LOG_LEVEL=TRACE
#export MPI_REPORTER_LOG_LEVEL_COMMON=TRACE
/usr/lib/jvm/jdk-11/bin/java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21045 -jar /home/me/GIT/ferzl/mpi-reporter/target/mpi-reporter-0.0.1.jar --server.port=8082
