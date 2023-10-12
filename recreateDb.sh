sudo docker stop as
sudo docker stop re
sudo docker rm as
sudo docker rm re
sudo docker volume prune -af
sudo docker run --name as -e POSTGRES_DB=async-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres:14.5-alpine
sudo docker run --name re -e POSTGRES_DB=report -e POSTGRES_USER=report -e POSTGRES_PASSWORD=report -d -p 5433:5432 postgres:14.5-alpine
