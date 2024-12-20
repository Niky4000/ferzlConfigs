export DMP_ADAPTER_DB_JDBC_URL="jdbc:postgresql://localhost:5428/dmp_adapter?user=dmp_adapter_user&password=dmp_adapter_password"
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
/usr/lib/jvm/jdk-11/bin/java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21040 -jar /home/me/GIT/ferzl/other_services/dmp-adapter/target/dmp-adapter-null.jar
