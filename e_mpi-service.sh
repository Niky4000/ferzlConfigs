export AUTH_SERVICE_HOST=https://erzl-dev.element-lab.ru
export AUTH_SERVICE_PRIVATE_URL_PREFIX=/api/auth
export AUTH_SERVICE_TECHNICAL_URL_LOGIN=/user/technical
export HEADER_AUTHORIZATION="Basic ZGV2ZWxvcGVyOkdJY2F1VzdPYlRsMTk4djRYcjlR"
export MPI_COMMON_SECURITY_HAZELCAST_ADDRESS=10.10.21.7:32035
export MPI_COMMON_SECURITY_HAZELCAST_MAP_NAME=sessionMap
export MPI_COMMON_SECURITY_JWT_SECRET=secret_dev
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21046 -jar -Dspring.config.location=/home/me/GIT/ferzl/ferzlConfigs/mpi_service.properties -Dlog.fileBaseDir=/home/me/tmp/logs/mpi-report -Dlog.console=true /home/me/GIT/ferzl/mpi-service/target/mpi-service-0.0.1-SNAPSHOT.jar --server.port=8084
