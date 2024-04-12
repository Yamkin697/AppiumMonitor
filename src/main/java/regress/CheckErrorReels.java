package regress;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import routine.ArgumentManager;
import routine.LogoPasses;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;


public class CheckErrorReels {


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
                .setNoReset(true);
        String avd = ArgumentManager.getAvd();
        String appiumport = Integer.toString(ArgumentManager.getAppiumPort());
        if (avd != null) {
            options.setAvd(avd);
        }
        driver = new AndroidDriver(new URL("http://127.0.0.1:" + appiumport + "/"), options.setAppPackage("com.looky.app"));

    }

    @After
    public void afterMethod() {

        driver.quit();
    }

    @Test
    public void ErrorReels() throws InterruptedException, MalformedURLException {


        Thread.sleep(2000);

        // убираем ошибку 504 если она есть
        if (!driver.findElements(new By.ById("com.looky.app:id/md_button_positive"))
                .isEmpty()) {
            driver.findElement(new By.ById("com.looky.app:id/md_button_positive")).click();
            Thread.sleep(5000);
        }


        // выходим из мессенджера
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]"))
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


        // переходим в ленту фида
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]"))
                    .click();
        }
        Thread.sleep(10000);

        // переходим в плеер Reels
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Посмотреть другие рилс')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Посмотреть другие рилс')]"))
                    .click();
        } else {
            Thread.sleep(30333);
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Посмотреть другие рилс')]"))
                    .click();
        }

        Thread.sleep(10000);


        //  scrollDown

        WebElement ele01 = driver.findElement(By.id("android:id/content"));

        int centerX = ele01.getRect().x + (ele01.getSize().width / 2);

        double startY = ele01.getRect().y + (ele01.getSize().height * 0.9);  //чем значение выше тем сильнее свайп

        double endY = ele01.getRect().y + (ele01.getSize().height * 0.1);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));

        swipe.addAction(finger.createPointerDown(0));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int) endY));

        swipe.addAction(finger.createPointerUp(0));

        driver.perform(Arrays.asList(swipe));


        Thread.sleep(10000);


        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Test Appium')]"))
                .isEmpty() | driver.findElements(new By.ByXPath("//*[contains(@text, 'Подписаться')]"))
                .isEmpty()) {
            Thread.sleep(1000);
            System.out.println("Reels Error");

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

                // Далее можно отправить этот скриншот в Телеграм или выполнить другие действия по необходимости
            } catch (Exception e) {
                e.printStackTrace();
            }

            driver.closeApp();

            driver.findElement(new By.ByXPath("MarkerOfSheet"))
                    .click();


        }

        driver.closeApp();
    }
}
