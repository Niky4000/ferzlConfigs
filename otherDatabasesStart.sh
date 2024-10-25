sudo docker run --name datamart -e POSTGRES_DB=datamart -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d -p 5434:5432 postgres:14.5-alpine

sudo docker run --name doms -e POSTGRES_DB=doms_adapter -e POSTGRES_USER=doms_adapter_user -e POSTGRES_PASSWORD=doms_adapter_password -d -p 5430:5432 postgres:14.5-alpine

sudo docker run --name dmp -e POSTGRES_DB=dmp_adapter -e POSTGRES_USER=dmp_adapter_user -e POSTGRES_PASSWORD=dmp_adapter_password -d -p 5428:5432 postgres:14.5-alpine


