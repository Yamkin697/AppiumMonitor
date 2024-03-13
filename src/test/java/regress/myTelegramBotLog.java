package regress;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.Webhook;

import java.io.File;

public class myTelegramBotLog extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "LookyTest_bot";
    }

    @Override
    public String getBotToken() {
        return "6392779184:AAGTCa5Y9sujF0cWjXCCLNvSi9dUHUf9V1k";
    }

    public void uploadFileToTelegram(String chatId, String filePath) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(new InputFile(new File(filePath)));
        //sendDocument.setCaption("Ваш текст к файлу");

        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myTelegramBotLog bot = new myTelegramBotLog();

        // Здесь вы должны указать ID чата (например, ваш собственный ID или ID пользователя "kornejjj")
        String chatId = "-1001863064350";
        String filePath = "/Users/SergeyV/Documents/log.txt"; // Замените на путь к вашему файлу

        bot.uploadFileToTelegram(chatId, filePath);
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Обработка входящих обновлений (если необходимо)
    }
}