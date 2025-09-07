# Базовый образ с Java 17
FROM eclipse-temurin:17-jdk-alpine

# Создаем рабочую директорию
WORKDIR /app

# Копируем Gradle wrapper и build.gradle
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Копируем весь проект
COPY . .

# Делаем gradlew исполняемым
RUN chmod +x gradlew

# Собираем jar
RUN ./gradlew clean bootJar

# Указываем порт
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java","-jar","build/libs/kursach2-0.0.1-SNAPSHOT.jar"]
