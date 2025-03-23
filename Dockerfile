# Użyj oficjalnego obrazu JDK
FROM openjdk:17-jdk-slim

# Ustaw katalog roboczy w kontenerze
WORKDIR /app

# Skopiuj pliki projektu
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Pobierz zależności i skompiluj aplikację
RUN chmod +x mvnw && ./mvnw package -DskipTests

# Ustal port aplikacji (zmień, jeśli aplikacja używa innego)
EXPOSE 8080

# Uruchom aplikację
CMD ["java", "-jar", "target/*.jar"]
