# Getting Started

## GraalVM Native Support

Материалы:
- https://www.graalvm.org
- https://github.com/graalvm/graalvm-demos/blob/master/spring-native-image/README.md
- https://luna.oracle.com/lab/268ea851-2f09-43e6-8d70-40a10cb4de03/steps
- https://habr.com/ru/articles/755550/
- https://sdkman.io/sdks
- https://medium.com/codex/optimising-performance-with-graalvm-running-spring-boot-native-image-on-kubernetes-b20942726530
 
План демо:
1.Развернуть проект springboot 3 и сделать users endpoint с базой постгрес
https://start.spring.io/

2.Добавить plugin
```xml
           <plugin> 
                 <groupId>org.graalvm.buildtools</groupId> 
                <artifactId>native-maven-plugin</artifactId> 
             </plugin>  
```

3.Установить GraalVm sdk on Windows https://www.graalvm.org/downloads/

Очень важно установить для виндоус
Visual Studio Build Tools and Windows SDK + Desktop development with C++ по инструкции
https://www.graalvm.org/latest/docs/getting-started/windows/#prerequisites-for-native-image-on-windows
https://medium.com/graalvm/using-graalvm-and-native-image-on-windows-10-9954dc071311

Проверяем установку
java -version
native-image --version

4. Потренироваться собирать нативный образ проект использую maven и посмотреть папку target
```
./mvnw -Pnative native:compile 
```
или
```
  mvn -Pnative native:compile
```

или
```
 mvn -Pnative spring-boot:build-image
```
Последний способ не рабоьает. 403 - блочиться скачивание

запустить локально target/graalvm


5. Собрать и развернуть нативный проект через docker-compose.yml
```
docker-compose up -d
```

### GET API endpoints examples 

1. http://localhost:8080/api/users/1

2. http://localhost:8080/api/users/2

3. http://localhost:8080/api/users/1000 