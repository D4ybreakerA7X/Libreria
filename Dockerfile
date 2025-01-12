# Usa una imagen base de Maven con OpenJDK 17 para construir el JAR
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el código fuente al contenedor
COPY . .

# Ejecuta el comando de Maven para construir el JAR
RUN mvn clean package -DskipTests

# Usa una imagen más ligera de OpenJDK para ejecutar el JAR
FROM eclipse-temurin:17-jdk-jammy

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR generado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
