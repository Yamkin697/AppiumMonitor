package regress;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import routine.ArgumentManager;
import routine.Secrets;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static regress.checkErrorMain.alertManager;
import static regress.checkErrorMain.service;

public class CheckErrorDiscovery {

    private AndroidDriver driver;
    private Object addAction;

    @Before
    public void beforeMethod() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("Android")
                //.setPlatformVersion("13")
                //.setDeviceName("Pixel 7")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.looky.app")
                .setAppActivity("com.looky.app.MainActivity")
                .setNewCommandTimeout(Duration.ofMillis(600000))
                .setLocale("RU")
                .setLanguage("ru")
                .setNoReset(true);
        String avd = ArgumentManager.getAvd();
        String appiumport = Integer.toString(ArgumentManager.getAppiumPort());
        if (avd != null) {
            options.setAvd(avd);
        }
        int adb = ArgumentManager.getAdbPort();
        if (adb != 0){
            options.setAdbPort(adb);
        }
        String adbDevice = ArgumentManager.getAdbDeviceName();
        if (adbDevice != null){
            options.setCapability("udid", adbDevice);
        }

        driver = new AndroidDriver(new URL("http://127.0.0.1:" + appiumport + "/"), options.setAppPackage("com.looky.app"));
        //driver = new AndroidDriver(service.getUrl(), options.setAppPackage("com.looky.app"));
    }

    @After
    public void afterMethod() {

        driver.quit();
    }

    @Test
    public void a_PostFeed() throws InterruptedException, MalformedURLException {


//
//        driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
//        driver.launchApp();

//        Thread.sleep(5000);


        // Закрываем подсказку в фиде
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Get first reward')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]"))
                    .click();
            Thread.sleep(3000);
        }


        // Ошибка от метро
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView"))
                    .click();
        }
        Thread.sleep(5000);

        // закрываем метро
        // закрываем метро
        while (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Dismiss')]")).isEmpty()) {

            driver.findElement(new By.ByXPath("//*[contains(@text, 'Dismiss')]")).click();
            Thread.sleep(3000);
        }
        Thread.sleep(2000);


        // Переходим в дискавери
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[2]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[2]"))
                    .click();
        }
        Thread.sleep(1000);


        // Подсказка в дискавери
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView"))
                    .click();
            Thread.sleep(2000);
        }

        Thread.sleep(10000);

        // Сама проверка
        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]"))
                .isEmpty()) {


            Thread.sleep(10000);

            try {
                // Создание скриншота
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Сохранение скриншота в файл
                // Генерировать уникальное имя для скриншота
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String screenshotPath = Secrets.Environment.screenshotPath + "screen_" + timestamp + ".png";
                File destinationFile = new File(screenshotPath);
                FileUtils.copyFile(screenshot, destinationFile);


                myTelegramBotScreen bot = new myTelegramBotScreen();
                String chatId = Secrets.Telegram.chatID; // Укажите ID чата, куда вы хотите отправить скриншот


                bot.sendScreenshot(chatId, screenshotPath);
                alertManager.sendAlert();

                // Далее можно отправить этот скриншот в Телеграм или выполнить другие действия по необходимости
            } catch (Exception e) {
                e.printStackTrace();
            }

            driver.findElement(new By.ByXPath("MarkerOfSheet"))
                    .click();
        }

    }
}
