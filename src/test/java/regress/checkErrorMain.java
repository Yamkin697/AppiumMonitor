package regress;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.net.URLEncoder;


  public class checkErrorMain {
      public static void sendCall(String message) {
          try {
              // Замените ваш URL на тот, который вы предоставили
              String url = "https://smsc.ru/sys/send.php";

              // Параметры запроса
              String login = "looky_app";
              String password = "N.UVvfn@ekwB8wk";
              String phones = "79858699964,79167478505,79962291428,79858039795";
              //String message = "Java бот упал замертво АХТУНГ. Перезагрузите его у него лапки";
              String call = "1";

              // Кодирование параметров запроса
              String encodedMessage = URLEncoder.encode(message, "UTF-8");

              // Составление строки параметров
              String parameters = String.format("login=%s&psw=%s&phones=%s&mes=%s&call=%s",
                      login, password, phones, encodedMessage, call);

              // Формирование полного URL с параметрами
              String fullUrl = url + "?" + parameters;

              // Создание объекта URL
              URL obj = new URL(fullUrl);

              // Создание объекта HttpURLConnection
              HttpURLConnection con = (HttpURLConnection) obj.openConnection();

              // Установка метода запроса
              con.setRequestMethod("GET");

              // Получение ответа от сервера
              int responseCode = con.getResponseCode();
              System.out.println("Отправлен GET-запрос по URL: " + fullUrl);
              System.out.println("Код ответа: " + responseCode);

              // Чтение ответа
              BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
              String inputLine;
              StringBuffer response = new StringBuffer();

              while ((inputLine = in.readLine()) != null) {
                  response.append(inputLine);
              }

              in.close();

              // Вывод ответа сервера
              System.out.println("Ответ сервера: " + response.toString());
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
      public static boolean checkAppiumErrors(String failureLog)
      {

          String[] criticalErrors = {
                  "because \"this.driver\" is null",
                  "Error executing adbExec",
                  "Connection refused",
                  "Could not start a new session"
          };
          for (String iter : criticalErrors)
          {
              if (failureLog.contains(iter)){
                  return true;
              }
          }
          return false;
      }
      public static void sendExitMessageAndDie()
      {
          System.err.println("Java приложение упало замертво АХТУНГ");
          MyTelegrammBotAHTUNG teleg2 = new MyTelegrammBotAHTUNG();
          String chatId2 = "-1001863064350";
          teleg2.sendErrorMessageToChannel(chatId2);
          sendCall("Java бот упал замертво АХТУНГ. Перезагрузите его у него лапки");
          System.exit(1);
      }
      public static class AlertManager {
          private List<Long> alertTimes;

          public AlertManager() {
              this.alertTimes = new ArrayList<>();
          }

          public void sendAlert() {
              long currentTime = System.currentTimeMillis() / 1000; // Получаем текущее время в секундах
              alertTimes.add(currentTime);

              // Очищаем список от алертов, которые были отправлены более 30 минут назад
              alertTimes.removeIf(time -> currentTime - time > 1800);

              // Проверяем условие 3 и более алертов за 30 минут
              if (alertTimes.size() >= 3) {
                  sendCall("Вероятно, что-то упало на проде. Больше трёх алертов от java бота за последние 30 минут");
              }
          }
      }
      public static AlertManager alertManager = new AlertManager();
    public static void main(String[] args) throws InterruptedException {


          System.err.println("Бот запущен");
        MyTelegrammBotOK teleg = new MyTelegrammBotOK();
       String chatId = "-1001863064350";
       teleg.sendErrorMessageToChannel(chatId);
        while (true) {

            // Запускаем набор тестов
            try{
                //System.err.println(0/0);
            runTests();
            }
            catch (Exception e){
                System.err.println("Java приложение упало замертво АХТУНГ");
                MyTelegrammBotAHTUNG teleg2 = new MyTelegrammBotAHTUNG();
                String chatId2 = "-1001863064350";
                teleg2.sendErrorMessageToChannel(chatId2);
                break;
            }
            //Thread.sleep(5000);
        }
        System.exit(1);

    }


    public static void runTests() {

        // Здесь запускаем набор тестов с использованием JUnit

        // чистим фал с логами
        String fileName = "/Users/SergeyV/Documents/log.txt";

        try (BufferedWriter bf = Files.newBufferedWriter(Path.of(fileName),
                StandardOpenOption.TRUNCATE_EXISTING)) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        // start
        Result result1 = JUnitCore.runClasses(CheckErrorFeed.class);

        if (!result1.wasSuccessful()) {

            for (Failure failure : result1.getFailures()) {
                System.err.println("Ошибка в фиде \n \n" + failure.toString());
                if (checkAppiumErrors(failure.toString())){
                    sendExitMessageAndDie();
                }


                // Запуск MyTelrgramBot

                myTelegramBotFeed teleg = new myTelegramBotFeed();
                String chatId = "-1001863064350";


                teleg.sendErrorMessageToChannel(chatId);


            }
        }


        Result result2 = JUnitCore.runClasses(CheckErrorDiscovery.class);

        if (!result2.wasSuccessful()) {

            for (Failure failure : result2.getFailures()) {
                System.err.println("Ошибка в Дискавери \n \n" + failure.toString());
                if (checkAppiumErrors(failure.toString())){
                    sendExitMessageAndDie();
                }


                // Запуск MyTelrgramBot

                myTelegramBotDiscovery teleg = new myTelegramBotDiscovery();
                String chatId = "-1001863064350";
                teleg.sendErrorMessageToChannel(chatId);
            }
        }


        Result result3 = JUnitCore.runClasses(checkerroractivity.class);

        if (!result3.wasSuccessful()) {

            for (Failure failure : result3.getFailures()) {
                System.err.println("Ошибка в Активити \n \n" + failure.toString());
                if (checkAppiumErrors(failure.toString())){
                    sendExitMessageAndDie();
                }


                // Запуск MyTelrgramBot

                myTelegrammBotActivity teleg = new myTelegrammBotActivity();
                String chatId = "-1001863064350";
                teleg.sendErrorMessageToChannel(chatId);
            }
        }

        Result result4 = JUnitCore.runClasses(CheckErrorProfile.class);

        if (!result4.wasSuccessful()) {


            for (Failure failure : result4.getFailures()) {
                System.err.println("Ошибка в MyProfile \n \n" + failure.toString());
                if (checkAppiumErrors(failure.toString())){
                    sendExitMessageAndDie();
                }


                // Запуск MyTelrgramBot

                myTelegrammBotMyProfile teleg = new myTelegrammBotMyProfile();
                String chatId = "-1001863064350";

                teleg.sendErrorMessageToChannel(chatId);



            }
        }


          Result result5 = JUnitCore.runClasses(checkErrorMessenger.class);

        if (!result5.wasSuccessful()) {

            for (Failure failure : result5.getFailures()) {
                System.err.println("Ошибка в messenjer \n \n" + failure.toString());
                if (checkAppiumErrors(failure.toString())){
                    sendExitMessageAndDie();
                }


                // Запуск MyTelrgramBot

                myTelegramBotMessenger teleg = new myTelegramBotMessenger();
                String chatId = "-1001863064350";

                teleg.sendErrorMessageToChannel(chatId);



            }
        }

            Result result6 = JUnitCore.runClasses(CheckErrorReels.class);

        if (!result6.wasSuccessful()) {

            for (Failure failure : result6.getFailures()) {
                System.err.println("Ошибка в Reels \n \n" + failure.toString());
                if (checkAppiumErrors(failure.toString())){
                    sendExitMessageAndDie();
                }

                // Запуск MyTelrgramBot

                MyTelegrammBotReels teleg = new MyTelegrammBotReels();
                String chatId = "-1001863064350";

                teleg.sendErrorMessageToChannel(chatId);



            }
        }



        if (result1.wasSuccessful() && result2.wasSuccessful() && result3.wasSuccessful() && result4.wasSuccessful() && result5.wasSuccessful() && result6.wasSuccessful()) {
            System.out.println("\n Тесты пройдены успешно");
        }

        if (!result1.wasSuccessful() || !result2.wasSuccessful() || !result3.wasSuccessful() || !result4.wasSuccessful() || !result5.wasSuccessful() || !result6.wasSuccessful() ) {


            //Thread.sleep(10000);

            myTelegramBotLog bot = new myTelegramBotLog();

            String chatId = "-1001863064350";
            String filePath = "/Users/SergeyV/Documents/log.txt"; // Замените на путь к вашему файлу

            bot.uploadFileToTelegram(chatId, filePath);
        }

    }
}



// -1001863064350

// 877288317



