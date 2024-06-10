

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

RUN mkdir "bot_logs"

RUN mkdir "bot_logs/screenshots"

# Копируем jar файл из стадии сборки в финальный образ
COPY --from=build /app/target/*.jar app.jar
COPY .env .env
# Определяем точку входа для запуска jar файла
ENTRYPOINT ["sleep", "200", ";", "java", "-jar", "app.jar", "-appium-port", "1234", "-no-call", "1"]

# Открываем порт (если ваше приложение использует какой-то порт)
