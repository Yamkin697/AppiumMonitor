package realRegress;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class discovery {

    private AndroidDriver driver;
    private Object addAction;


    @Before
    public void beforeMethod() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("a010c185")
                .setAppPackage("com.looky.app")
                .setAppActivity("com.looky.app.MainActivity")
                .setNoReset(true);

        driver = new AndroidDriver(new URL("http://localhost:4723/"), options.setAppPackage("com.looky.app"));

    }

    @After
    public void afterMethod() {

        driver.quit();
    }


    @Test
    public void a_discovery() throws InterruptedException, MalformedURLException {

        //проверяем работаспособность дискаревери

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        // переходим в дискавери
        driver.findElement(new By.ByXPath(""))
                .click();
        Thread.sleep(2000);

        //Проверяем наличие полсказки
        if (!driver.findElements(new By.ByXPath(""))
                .isEmpty()){
            driver.findElement(new By.ByXPath(""))
                    .click();
            System.out.println("Done Окно с подсказкой");
            Thread.sleep(1000);
        }

        // делаем лонг тап по посту
        // лонг тап по диалогу
        WebElement dialog = driver.findElement(new By.ByXPath(""));

        TouchAction touchAction = new TouchAction(driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(dialog))
                        .withDuration(Duration.ofSeconds(60))
                );

        // Выполнить долгий тап
        touchAction.perform();

        Thread.sleep(3000);


    }
}