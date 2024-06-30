# Используем официальный образ Maven для сборки
FROM maven:3.8.7-openjdk-18-slim AS build

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app
# Копируем pom.xml и все необходимые зависимости в контейнер
COPY pom.xml .
# Загружаем зависимости проекта (их можно кэшировать)
RUN mvn dependency:go-offline

# Копируем исходный код проекта в контейнер
COPY src ./src
# Сборка jar файла
RUN mvn package -DskipTests

# Создаем финальный образ, используя официальный образ OpenJDK
FROM openjdk:23-ea-18-jdk-slim-bullseye

# Устанавливаем рабочую директорию
WORKDIR /app

RUN set -x ;\
    mkdir -p /app/bot_logs/screenshots;\
	touch /app/bot_logs/log.txt

# Копируем файлы
COPY --from=build /app/target/untitled2-1.0-SNAPSHOT.jar .

COPY .env .

RUN set -x; \
	chmod +x /app/wait-for-apk-install.sh; \
	chmod +x /app/untitled2-1.0-SNAPSHOT.jar

# Команда для запуска скрипта и JAR файла
CMD ["java", "-jar", "/app/untitled2-1.0-SNAPSHOT.jar", "-appium-address", "android", "-appium-port", "4723", "-no-call", "1", "-adb-device", "android:5555"]