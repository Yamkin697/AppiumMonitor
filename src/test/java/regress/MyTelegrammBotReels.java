package regress;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegrammBotReels extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "LookyTest_bot";
    }

    @Override
    public String getBotToken() {
        return "6392779184:AAGTCa5Y9sujF0cWjXCCLNvSi9dUHUf9V1k";
    }

    public void sendErrorMessageToChannel(String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId); // Указываем ID чата, куда отправить сообщение
        message.setText("Ошибка в Reels"); // Текст сообщения

        try {
            execute(message); // Отправляем сообщение
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyTelegrammBotReels bot = new MyTelegrammBotReels();

        // Здесь вы должны указать ID чата (например, ваш собственный ID или ID пользователя "kornejjj")
        String chatId = "-1001863064350";

        bot.sendErrorMessageToChannel(chatId);
    }





    @Override
    public void onUpdateReceived(Update update) {

    }
}
