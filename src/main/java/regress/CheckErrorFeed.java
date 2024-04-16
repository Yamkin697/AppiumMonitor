package regress;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import routine.ArgumentManager;
import routine.LogoPasses;

import static regress.checkErrorMain.alertManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class CheckErrorFeed {

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
                //.setLocale("RU")
                .setNoReset(true);
        String avd = ArgumentManager.getAvd();
        String appiumport = Integer.toString(ArgumentManager.getAppiumPort());
        if (avd != null) {
            options.setAvd(avd);
        }

        driver = new AndroidDriver(new URL("http://127.0.0.1:" + appiumport + "/"), options.setAppPackage("com.looky.app"));
        LogoPasses.Device.deviceName = driver.getCapabilities().getCapability("deviceName").toString();

    }

    //.setNoReset(false);


    @After
    public void afterMethod() {

        driver.quit();
    }


    @Test
    public void a_Test() throws InterruptedException, MalformedURLException {

        //   driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
        //driver.launchApp();

        Thread.sleep(30000);


        // Закрыть шторку про неронку
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                    .click();
            Thread.sleep(2000);
        }


        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView"))
                .isEmpty()) {
            Thread.sleep(20000);
        }

        // переходим в ленту фида
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]"))
                    .click();
        }
        Thread.sleep(3000);

        // reccomendation
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup"))
                    .click();
            Thread.sleep(2000);
        }


        // Сама проверка
        // ищем есть ли стори
        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView"))
                .isEmpty()) {


            Thread.sleep(10000);


            try {
                // Создание скриншота
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Сохранение скриншота в файл
                // Генерировать уникальное имя для скриншота
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String screenshotPath = LogoPasses.Environment.screenshotPath + "screen_" + timestamp + ".png";
                File destinationFile = new File(screenshotPath);
                FileUtils.copyFile(screenshot, destinationFile);


                myTelegramBotScreen bot = new myTelegramBotScreen();
                String chatId = LogoPasses.Telegram.chatID; // Укажите ID чата, куда вы хотите отправить скриншот


                bot.sendScreenshot(chatId, screenshotPath);
                alertManager.sendAlert();


                // Далее можно отправить этот скриншот в Телеграм или выполнить другие действия по необходимости
            } catch (Exception e) {
                e.printStackTrace();
            }


            driver.findElement(new By.ByXPath("MarkerOfSheet"))
                    .click();
        }

        // Ошибка от метро
        // закрываем метро
        while (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Dismiss')]")).isEmpty()) {

            driver.findElement(new By.ByXPath("//*[contains(@text, 'Dismiss')]")).click();
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
    }
}




/*


        // Дискавери
        // Переходим в дискавери
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[2]"))
                .click();
        Thread.sleep(1000);

        // Подсказка в дискавери
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Ok, thank you!')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Ok, thank you!')]"))
                    .click();

        }

        Thread.sleep(10000);

        // Сама проверка
        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]"))
                .isEmpty()){
            System.out.println("Eror Discovery");
            // Запуск MyTelrgramBot

//                myTelegramBotDiscovery teleg = new myTelegramBotDiscovery();
//                String chatId = "-1001863064350";
//                teleg.sendErrorMessageToChannel(chatId);

        }





        // Activity
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[4]"))
                .click();
        Thread.sleep(1000);


        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Ok, thank you!')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Ok, thank you!')]"))
                    .click();

        }
        Thread.sleep(5000);

        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"))
                .isEmpty()){
            System.out.println("Eror Activity");
            // Запуск MyTelrgramBot
//
//                myTelegrammBotActivity teleg = new myTelegrammBotActivity();
//                String chatId = "-1001863064350";
//                teleg.sendErrorMessageToChannel(chatId);

            Thread.sleep(2000);
        }







        // MyProfile
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[5]"))
                .click();
        Thread.sleep(2000);


        // Убрать подсказку
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup"))
                .isEmpty()){
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup"))
                    .click();
            Thread.sleep(2000);
        }
        Thread.sleep(10000);

        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"))
                .isEmpty()){
            System.out.println("Error Profile");
            // Запуск MyTelrgramBot
//
//                myTelegrammBotMyProfile teleg = new myTelegrammBotMyProfile();
//                String chatId = "-1001863064350";
//
//                teleg.sendErrorMessageToChannel(chatId);

        }




        //
//        //авторизация
//        // Разрешение на отправку уведомлений
//        if (!driver.findElements(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
//                .isEmpty()){
//            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
//                    .click();
//            Thread.sleep(2000);
//        }
//
//        // ожидание если приложение не может прогрузиться
//        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Sign In with Google')]"))
//                .isEmpty()){
//
//            driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
//            driver.launchApp();
//
//            Thread.sleep(20000);
//        }
//
//        // Тап на кнопку гугл
//        driver.findElement(new By.ByXPath("//*[contains(@text, 'Sign In with Google')]"))
//                .click();
//        Thread.sleep(2000);
//
//        // Тап по аккаунту
//        driver.findElement(new By.ByXPath("//*[contains(@text, 'aw.kornej@gmail.com')]"))
//                .click();


//        Thread.sleep(15000);


// ожидание если приложение не может прогрузиться
        if (driver.findElements(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                .isEmpty()){

            driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
            driver.launchApp();

            Thread.sleep(20000);
        }
 */
