# Sleuth AWS SQS POC

해당 프로젝트는 Slueth(Zipkin) 을 통한 메시지 추적 POC(Proof of concept) 입니다.<br>
Rest API 를 통해 POST 요청을 받으면, 메시지를 발행/소비 합니다. 이 과정에서 유지되는 TraceId 를 확인합니다.<br>

## Diagram
<img width="1244" alt="image" src="https://user-images.githubusercontent.com/60500649/165676051-07aed263-8549-4e59-88da-730f4420f431.png">

## Run
### Project 클론
```
$ git clone https://github.com/currenjin/sleuth-sqs-poc
```

### Docker 컨테이너 실행
```
$ docker-compose up
```

### API 호출 명령어
```
$ curl --request POST --data 'test' http://localhost:8080/post
```