# Usa una imagen base de Maven para construir el JAR
FROM maven:3.8.8-openjdk-17 AS build

# Copia el código fuente al contenedor
WORKDIR /app
COPY . .

# Ejecuta el comando de Maven para construir el JAR
RUN mvn clean package -DskipTests

# Usa una imagen más liviana para ejecutar el JAR
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR generado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
