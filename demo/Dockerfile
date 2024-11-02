# Usa una imagen base de Java
FROM openjdk:17-jdk-alpine

# Configura el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR que contiene la aplicación en el contenedor
COPY target/*.jar app.jar

# Expone el puerto que usará la aplicación
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
