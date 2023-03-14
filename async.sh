export AUTH_SERVICE_HOST=https://erzl-dev.element-lab.ru
export AUTH_SERVICE_PRIVATE_URL_PREFIX=/api/auth
export AUTH_SERVICE_TECHNICAL_URL_LOGIN=/user/technical
export HEADER_AUTHORIZATION=Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR
export MPI_COMMON_SECURITY_HAZELCAST_ADDRESS=192.168.100.57
export MPI_COMMON_SECURITY_HAZELCAST_MAP_NAME=sessionMap
export MPI_COMMON_SECURITY_JWT_SECRET=secret_dev
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21044 -Dspring.config.location=/home/me/GIT/ferzl/ferzlConfigs/async-service.properties -jar /home/me/GIT/ferzl/async-service/target/async-service-0.0.1.jar
