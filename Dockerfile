FROM eclipse-temurin:17-jdk AS build

WORKDIR /SandBox/kata-foo-bar-quix/app


# Use a writable directory for output
VOLUME output


COPY target/kata-foo-bar-quix-0.0.1-SNAPSHOT.jar app.jar

COPY input.txt input.txt

ENTRYPOINT ["java", "-jar", "app.jar"]


