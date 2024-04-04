
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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static regress.checkErrorMain.alertManager;

public class checkErrorMessenger {


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
        if(avd != null){
            options.setAvd(avd);
        }

        driver = new AndroidDriver(new URL("http://127.0.0.1:"+appiumport+"/"), options.setAppPackage("com.looky.app"));

    }

    @After
    public void afterMethod() {

        driver.quit();
    }

    @Test
    public void a_PostFeed() throws InterruptedException, MalformedURLException {


//
//        driver.closeApp();
//        driver.launchApp();

//        Thread.sleep(5000);

        // переходим в мессенджер
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]"))
                .isEmpty()){
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]"))
                    .click();
            Thread.sleep(5000);
        }


        // Сама проверка
        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup"))
                .isEmpty()){


            Thread.sleep(10000);

            try {
                // Создание скриншота
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Сохранение скриншота в файл
                // Генерировать уникальное имя для скриншота
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String screenshotPath = "D:\\!Alex\\bot_logs\\screenshot\\screen_" + timestamp + ".png";
                File destinationFile = new File(screenshotPath);
                FileUtils.copyFile(screenshot, destinationFile);


                myTelegramBotScreen bot = new myTelegramBotScreen();
                String chatId = "-1002050408046"; // Укажите ID чата, куда вы хотите отправить скриншот


                bot.sendScreenshot(chatId, screenshotPath);
                alertManager.sendAlert();

            } catch (Exception e) {
                e.printStackTrace();
            }

            //driver.closeApp();

            driver.findElement(new By.ByXPath("MarkerOfSheet"))
                    .click();
        }
        //driver.closeApp();

    }
}




