FROM openjdk:8-jre-alpine
WORKDIR /app
ADD ./target/prpo-zvestoba-x-ponudnik-1.0.0-SNAPSHOT.jar /app
EXPOSE 8081
CMD ["java", "-jar", "prpo-zvestoba-x-ponudnik-1.0.0-SNAPSHOT.jar"]