export MPI_COMMON_SECURITY_HAZELCAST_ADDRESS=10.10.21.7:32035;
export MPI_COMMON_SECURITY_HAZELCAST_MAP_NAME=sessionMap;
export MPI_COMMON_SECURITY_JWT_SECRET=secret_dev;
export MPI_COMMON_SECURITY_IGNITE_ADDRESS=10.10.21.10:31987;
export MPI_COMMON_SECURITY_IGNITE_MAP_NAME=devSessionMap;
export MPI_COMMON_SECURITY_IGNITE_PASSWORD=ignite;
export MPI_COMMON_SECURITY_IGNITE_USERNAME=ignite;
export MPI_COMMON_SECURITY_SPRING_PROFILES_ACTIVE=gostech
/usr/lib/jvm/jdk-11/bin/java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=21045 -jar -Dspring.config.location=/home/me/GIT/ferzl/ferzlConfigs/mpi_reporter.properties -Dlog.fileBaseDir=/home/me/tmp/logs/mpi-report -Dlog.console=true /home/me/GIT/ferzl/mpi-reporter/target/mpi-reporter-0.0.1.jar --server.port=8082
