# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/*.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
