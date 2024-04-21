package regress;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import routine.Secrets;

import java.io.File;

public class myTelegramBotLog extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "LookyTest_bot";
    }

    @Override
    public String getBotToken() {
        return Secrets.Telegram.botToken;
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
        String chatId = Secrets.Telegram.chatID;
        String filePath = Secrets.Environment.filePath + "log.txt"; // Замените на путь к вашему файлу

        bot.uploadFileToTelegram(chatId, filePath);
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Обработка входящих обновлений (если необходимо)
    }
}