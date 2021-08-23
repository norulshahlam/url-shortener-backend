model
service - BaseConverter.class
service - url service
repo
controller
configure application.properties
start db

	docker run --detach --env MYSQL_ROOT_PASSWORD=root --env MYSQL_DATABASE=url_shortener --env MYSQL_PASSWORD=root --env MYSQL_USER=admin --name localhost --publish 3306:3306 mysql:8.0
	
	
`stop & remove all running proceses`

	docker rm $(docker ps -a -q) -f

`remove all images`

	docker rmi -f $(docker images -a -q)
	
`remove all volumes`
	
	docker volume rm $(docker volume ls -q)

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
	