package regress;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import routine.LogoPasses;

public class MyTelegrammBotOK extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "LookyTest_bot";
    }

    @Override
    public String getBotToken() {
        return LogoPasses.Telegram.botToken;
    }

    public void sendErrorMessageToChannel(String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId); // Указываем ID чата, куда отправить сообщение
        message.setText("<БОТ>\nJava бот запущен"); // Текст сообщения
        try {
            execute(message); // Отправляем сообщение
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTelegrammBotOK bot = new MyTelegrammBotOK();

        // Здесь вы должны указать ID чата (например, ваш собственный ID или ID пользователя "kornejjj")
        String chatId = LogoPasses.Telegram.chatID;

        bot.sendErrorMessageToChannel(chatId);
    }


    @Override
    public void onUpdateReceived(Update update) {

    }
}
