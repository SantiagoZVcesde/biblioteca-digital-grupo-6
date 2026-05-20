# === FASE 1: Compilación ===
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar solo el pom para descargar las dependencias primero
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente del proyecto
COPY src ./src

# Compilar el archivo JAR saltándose los tests para ahorrar tiempo en Render
RUN mvn clean package -DskipTests

# === FASE 2: Ejecución ===
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copiar el JAR generado en la fase anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto estándar
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]