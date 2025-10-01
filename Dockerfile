FROM eclipse-temurin:17-jdk

WORKDIR /app

# Устанавливаем базовые библиотеки (для нативных библиотек)
RUN apt-get update && apt-get install -y \
    libc6 \
    libgcc-s1 \
    libstdc++6 \
    libgomp1 \
    && rm -rf /var/lib/apt/lists/*

# Копируем готовый jar
COPY build/libs/kursach2-1.0-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "kursach2-1.0-SNAPSHOT.jar"]
