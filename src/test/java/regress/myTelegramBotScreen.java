package regress;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static regress.checkErrorMain.alertManager;

public class myTelegramBotScreen extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "LookyTest_bot";
    }

    @Override
    public String getBotToken() {
        return "6392779184:AAGTCa5Y9sujF0cWjXCCLNvSi9dUHUf9V1k";
    }

    public void sendScreenshot(String chatId, String filePath) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(new File(filePath)));

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myTelegramBotScreen bot = new myTelegramBotScreen();

        // Здесь вы должны указать ID чата (например, ваш собственный ID или ID пользователя "kornejjj")
        String chatId = "-1001863064350";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = "/Users/SergeyV/Documents/screenshot_" + timestamp + ".png";

        bot.sendScreenshot(chatId, screenshotPath);
        //alertManager.sendAlert();
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Обработка входящих обновлений (если необходимо)
    }
}