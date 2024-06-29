FROM ubuntu:latest
RUN apt-get update && apt-get install -y adb netcat-traditional

COPY install-apk.sh /install-apk.sh
COPY ./test_app/looky.apk /apk/test_app/looky.apk
RUN chmod +x /install-apk.sh

#FROM ubuntu:latest

# Установка необходимых пакетов
#RUN apt-get update && apt-get install -y \
 #   adb \
 #   netcat-traditional \
 #   curl \
 #   dumb-init \
 #   && apt-get clean \
  #  && rm -rf /var/lib/apt/lists/*

# Установка dumb-init как entrypoint
#ENTRYPOINT ["/usr/bin/dumb-init", "--"]

# Создание рабочей директории для приложения
#WORKDIR /app

# Копирование скрипта установки и APK файла
#COPY install-apk.sh /install-apk.sh
#COPY ./test_app/looky.apk /apk/test_app/looky.apk

# Добавление прав на исполнение для скрипта установки
#RUN chmod +x /install-apk.sh

# Копирование скрипта entry для поддержания контейнера активным
#COPY entry_script.sh /entry_script.sh
#RUN chmod +x /entry_script.sh

# Установка entry script как основной команды для выполнения
#CMD ["/entry_script.sh"]

