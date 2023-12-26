# 베이스 이미지는 JDK:17
FROM openjdk:17-jdk-slim

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# 컨테이너를 실행할 때마다
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]