FROM openjdk:12 

COPY catalogue-course/target/*.jar catalogue-course.jar

EXPOSE 8080
 
CMD ["java", "-jar", "-Dserver.port=8080", "catalogue-course.jar"]
