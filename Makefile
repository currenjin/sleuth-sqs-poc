## COMMANDS

start-app:
	docker-compose up -d zipkin-server
	docker-compose up -d publisher
	docker-compose up -d consumer

stop-app:
	docker-compose down

start-zipkin:
	docker-compose up -d zipkin-server

stop-zipkin:
	docker-compose down