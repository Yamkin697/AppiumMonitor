package regress;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import routine.Secrets;


public class myTelegramBotMessenger extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "LookyTest_bot";
    }

    @Override
    public String getBotToken() {
        return Secrets.Telegram.botToken;
    }

    public void sendErrorMessageToChannel(String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId); // Указываем ID чата, куда отправить сообщение
        message.setText("Ошибка в messenger\nDevice: " + Secrets.Device.deviceName); // Текст сообщения

        try {
            execute(message); // Отправляем сообщение
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        myTelegramBotMessenger bot = new myTelegramBotMessenger();

        // Здесь вы должны указать ID чата (например, ваш собственный ID или ID пользователя "kornejjj")
        String chatId = Secrets.Telegram.chatID;

        bot.sendErrorMessageToChannel(chatId);
    }


    @Override
    public void onUpdateReceived(Update update) {

    }
}

