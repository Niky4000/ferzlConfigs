sudo docker stop inc
sudo docker rm inc
sudo docker run --name inc -e POSTGRES_DB=incident_service -e POSTGRES_USER=incident_service_user -e POSTGRES_PASSWORD=incident_service_user -d -p 5435:5432 postgres:14.5-alpine
