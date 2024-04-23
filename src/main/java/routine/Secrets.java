package routine;

import io.github.cdimascio.dotenv.Dotenv;

public class Secrets {
    static Dotenv dotenv = Dotenv.load();
    public class SMSCenter{
        public static String login = dotenv.get("SMSC_LOGIN");
        public static String password = dotenv.get("SMSC_PASS");
        public static String phones = dotenv.get("SMSC_PHONES");
        public static int minutesToCall = Integer.parseInt(dotenv.get("MINUTES_TO_CALL"));
    }
    public class Telegram{
        public static String botToken = dotenv.get("TELEGRAM_BOT_TOKEN");
        public static String chatID = dotenv.get("TELEGRAM_CHAT_ID");
    }
    public class Environment{
        public static String filePath = dotenv.get("ENVIRONMENT_FILE_PATH");
        public static String screenshotPath = dotenv.get("ENVIRONMENT_SCREENSHOT_PATH");
    }
    public class Device{
        public static String deviceName = "default";
    }
    public class Appium{
        public static String appiumJS = dotenv.get("APPIUM_JS");
        public static String node = dotenv.get("NODE");
    }

}
