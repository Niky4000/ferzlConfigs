export ASYNC_SERVICE_HOST=https://erzl-test.rtk-element.ru
export AUTH_SERVICE_HOST=https://erzl-test.rtk-element.ru
export AUTH_SERVICE_PRIVATE_URL_PREFIX=/api/auth
export AUTH_SERVICE_TECHNICAL_URL_LOGIN=/user/technical
export DOC_SERVICE_HOST=https://erzl-test.rtk-element.ru/api
export FEIGN_CONNECT_TIMEOUT=20000
export FILE_KEEPER_SERVICE_HOST=https://erzl-test.rtk-element.ru
export HEADER_AUTHORIZATION=Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR
export LK_MPI_APPOINTMENT_ENABLED=true
export LK_MPI_APPORTIONMENT_ENABLED=true
export LK_MPI_NSI_SERVICE_FRMO_ENABLED=true
export MPI_COMMON_SECURITY_CONFIG=dataline_hz
export MPI_COMMON_SECURITY_EXPIRES_IN_SECS=600
export MPI_COMMON_SECURITY_HAZELCAST_ADDRESS=10.10.21.9:32035
export MPI_COMMON_SECURITY_HAZELCAST_MAP_NAME=testSessionMap
export MPI_COMMON_SECURITY_IGNITE_ADDRESS=10.10.21.10:31987
export MPI_COMMON_SECURITY_IGNITE_MAP_NAME=testSessionMap
export MPI_COMMON_SECURITY_IGNITE_PASSWORD=ignite
export MPI_COMMON_SECURITY_IGNITE_USERNAME=ignite
export MPI_COMMON_SECURITY_JWT_SECRET=secret_test
export MPI_COMMON_SECURITY_SPRING_PROFILES_ACTIVE=default
export MPI_OLAP_EMP_SERVICE_HOST=https://erzl-test.rtk-element.ru
export MPI_SERVICE_READ_HOST=https://erzl-test.rtk-element.ru
export NOTIFICATION_SERVICE_SERVER_HOST=https://erzl-test.rtk-element.ru/api
export NSI_SERVICE_NEXT_HOST=https://erzl-test.rtk-element.ru
export SWAGGER_UI_CLASSPATH=C:/Users/nmironova/.m2/repository/org/webjars/swagger-ui/4.18.2/swagger-ui-4.18.2.jar

/usr/lib/jvm/jdk-11/bin/java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21047 -jar /home/me/GIT/ferzl/lk-mpi-facade/target/lk-mpi-facade-null.jar --server.port=8086
