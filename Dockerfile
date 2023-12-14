FROM openjdk:17
#VOLUME /tmp
WORKDIR /app
EXPOSE 8080
COPY target/manage-file-1.jar manage-file-1.jar
ENTRYPOINT ["java","-jar","manage-file-1.jar"]
