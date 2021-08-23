## DOKCERISE MYSQL 
{HOSTPORT:CONTAINERPORT}

`run!`
	
	 docker run --detach --env MYSQL_ROOT_PASSWORD=root --env MYSQL_DATABASE=url_shortener --env MYSQL_PASSWORD=root --env MYSQL_USER=admin --name localhost --publish 3306:3306 mysql:8.0
	 
`for debug`
	
	docker container ps -a
	docker container stop 
	docker container prune
	docker volume prune

`for aws cli`

	sudo su
	service docker start
	
`stop & remove all running proceses`

	docker rm $(docker ps -a -q) -f

`remove all images`

	docker rmi -f $(docker images -a -q)

`run mysql in cli using docker`

	docker exec -it localhost bash

`connect to mysql`

	mysql -u admin -proot
	
`test`

	show databases;
	use url_shortener;
	show tables;
	desc url;
	select * from url;
	
	
## DOKCERISE SPRING APP

	add maven plugin for docker in pom
	add dockerfile with config
	make sure jdk from spring & dockerfile is same 
	change jdbc url: https://stackoverflow.com/questions/51527683/java-net-unknownhostexception-dockerized-mysql-from-spring-boot-application

`create docker`

	mvn clean
	use maven package

`push to docker hub`

	docker push norulshahlam/url-shortener:0.0.1-SNAPSHOT

`run!`

	docker run -d -p 8000:8000 --name url_shortener --link localhost:mysql norulshahlam/url-shortener:0.0.1-SNAPSHOT

## DOKCERISE REACT APP

	https://www.youtube.com/watch?v=DSIC3JTQnPs
	create Dockerfile and configure
	add in main folder
	docker ignore

`build`

	docker build -t norulshahlam/url-shortener-frontend .

`push to docker hub`

	docker push norulshahlam/url-shortener-frontend
	
`run` 

	docker run -it -p 3000:3000 --name login-app-frontend norulshahlam/login-app-frontend:latest
	
