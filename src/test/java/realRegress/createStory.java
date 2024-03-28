package realRegress;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;


import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import regress.ArgumentManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class createStory {

    private AndroidDriver driver;
    private Object addAction;


    @Before
    public void beforeMethod() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("a010c185")
                .setAppPackage("com.looky.app")
                .setAppActivity("com.looky.app.MainActivity")
                .setLocale("RU")
                .setNoReset(true);
        String avd = ArgumentManager.getAvd();
        if(avd != null){
            options.setAvd(avd);
        }
        driver = new AndroidDriver(new URL("http://localhost:4723/"), options.setAppPackage("com.looky.app"));

    }

    @After
    public void afterMethod() {

        driver.quit();
    }

    @Test
    public void a_ChangeProfile() throws InterruptedException, MalformedURLException {

        //cмена профиля

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        // go to my profile
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[5]"))
                .click();
        Thread.sleep(1000);

        // Меняем профиль
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).click();
            Thread.sleep(1000);
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Auto kornej')]")).click();
            Thread.sleep(3000);
        }
    }

    @Test
    public void b_CreateStoryOnePhoto() throws InterruptedException, MalformedURLException {

        //Создание истории с 1 фото без редактирования

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        // open gallary
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[3]"))
                .click();

        Thread.sleep(3000);

        // разрешение на чтение галереи
        if (!driver.findElements(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                .isEmpty()) {
            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                    .click();
        }

        Thread.sleep(3000);

        // tap on стори

        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView"))
                .isEmpty()) {
            System.out.println("");
        } else {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView"))
                    .click();
        }
        Thread.sleep(3000);

        // tap om continue
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Продолжить')]")).click();

        Thread.sleep(3000);

        // tap on next
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Далее')]"))
                .click();
        Thread.sleep(2000);

        // tap on Public
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Опубликовать')]")).click();
        Thread.sleep(10000);

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(10000);

        if (driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup"))
                .isEmpty()) {
            System.out.print("История создалась \n");
        }
    }

    @Test
    public void c_CreateStoryThreePhoto() throws InterruptedException, MalformedURLException {

        //Создание истории с несколькими видео без редактирования

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);


// open gallary
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[3]"))
                .click();
        Thread.sleep(3000);

        // разрешение на чтение галереи
        if (!driver.findElements(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                .isEmpty()) {
            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                    .click();
        }
        Thread.sleep(3000);

        // tap on стори
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView"))
                .isEmpty()) {
            System.out.println("");
        } else {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView"))
                    .click();
        }
        Thread.sleep(3000);

        // тап на мультиселект
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"))
                .click();
        Thread.sleep(1000);


// Тап по второму фото
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"))
                .click();
        Thread.sleep(1000);

        // тап по третьему фото
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView"))
                .click();

        // tap om continue
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Продолжить')]")).click();

        Thread.sleep(3000);

        // tap on next
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Далее')]"))
                .click();
        Thread.sleep(2000);

        // tap on Public
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Опубликовать')]")).click();
        Thread.sleep(10000);

        // проверяем наличие ошибки в фиде
        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Что-то пошло не так')]"))
                .isEmpty()
                & driver.findElements(new By.ByXPath("//*[contains(@text, 'ПОВТОР')]"))
                .isEmpty()) {
            System.out.print("DONE Создание истории с несколькими видео без редактирования \n");
        } else {
            driver.findElement(new By.ByXPath("Хуй")).click();
        }
    }

    @Test
    public void c_CreateStoryPhotoStiker() throws InterruptedException, MalformedURLException {

        //Создание истории с несколькими видео без редактирования

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        // open gallary
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[3]"))
                .click();
        Thread.sleep(3000);


// разрешение на чтение галереи
        if (!driver.findElements(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                .isEmpty()) {
            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                    .click();
        }
        Thread.sleep(3000);

        // tap on стори
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView"))
                .isEmpty()) {
            System.out.println("");
        } else {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView"))
                    .click();
        }
        Thread.sleep(3000);

        // tap om continue
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Продолжить')]")).click();

        Thread.sleep(3000);

        // тап на стикер с текстом
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"))
                .click();
        Thread.sleep(2000);

        // Ввод текста
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText"))
                .sendKeys("Test text to stiker");
        Thread.sleep(2000);

        // Тап по ок
        driver.findElement(new By.ByXPath("//*[contains(@text, 'ОК')]"))
                .click();
        Thread.sleep(2000);


        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Test text to stiker')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("")).click();
        }

        // тап по кнопке стикеров
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]"))
                .click();
        Thread.sleep(2000);

        // Тап по стикеру меншена
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup"))
                .click();
        Thread.sleep(2000);

        // ввод имени того кого хотим заменшенить
        driver.findElement(new By.ByClassName("android.widget.EditText")).sendKeys("mkycha");
        Thread.sleep(5000);

        // Тап по пользователю
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(2000);

        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'MKYCHA')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("")).click();
        }

        // тап по кнопке стикеров
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]"))
                .click();
        Thread.sleep(2000);


// Тап по стикеру локации
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.View"))
                .click();
        Thread.sleep(2000);

        // ввод локации
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Найти место')]"))
                .sendKeys("sity");
        Thread.sleep(5000);

        // тап по локации
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Сити, хинкальная')]"))
                .click();
        Thread.sleep(2000);

        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'СИТИ, ХИНКАЛЬНАЯ')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("")).click();
        }

        // тап по кнопке стикеров
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[3]"))
                .click();
        Thread.sleep(2000);

        // Тап по стикеру ссылки
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.View"))
                .click();
        Thread.sleep(2000);

        // ввод Заголовка ссылки
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Заголовок')]"))
                .sendKeys("Looky Test");
        Thread.sleep(2000);

        // ввод Заголовка ссылки
        driver.findElement(new By.ByXPath("//*[contains(@text, 'https://')]"))
                .sendKeys("looky.com");
        Thread.sleep(2000);


        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(2000);

        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'LOOKY TEST')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("")).click();
        }

        // tap on next
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Далее')]"))
                .click();
        Thread.sleep(2000);

        // tap on Public
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Опубликовать')]")).click();
        Thread.sleep(10000);


// проверяем наличие ошибки в фиде
        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Что-то пошло не так')]"))
                .isEmpty()
                & driver.findElements(new By.ByXPath("//*[contains(@text, 'ПОВТОР')]"))
                .isEmpty()) {
            System.out.print("DONE Создание истории с 1 фото с редактированием и добавлением стикера текст/локация/отметка \n");
        } else {
            driver.findElement(new By.ByXPath("Хуй")).click();
        }
    }

    @Test
    public void d_CreateStoryVideo() throws InterruptedException, MalformedURLException {

        //Создание истории с видео без редактирования

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        // open gallary
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[3]"))
                .click();
        Thread.sleep(3000);

        // разрешение на чтение галереи
        if (!driver.findElements(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                .isEmpty()) {
            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_button"))
                    .click();
        }
        Thread.sleep(3000);

        // tap on стори Tap
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView"))
                .isEmpty()) {
            System.out.println("");
        } else {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView"))
                    .click();
        }
        Thread.sleep(3000);

// запись видео с камеры
        // тап на иконку камеры
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup"))
                .click();
        Thread.sleep(2000);

        // разрешить использовать камеру
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Разрешить приложению LOOKY снимать фото и видео?')]"))
                .isEmpty()) {
            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
            Thread.sleep(2000);
            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
            Thread.sleep(3000);
        }

        // лонг тап по диалогу
        WebElement dialog = driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView"));

        TouchAction touchAction = new TouchAction(driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(dialog))
                        .withDuration(Duration.ofSeconds(60))
                );

        // Выполнить долгий тап
        touchAction.perform();

        Thread.sleep(3000);

        driver.findElement(new By.ByXPath("//*[contains(@text, 'Далее')]"))
                .click();
        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//*[contains(@text, 'Опубликовать')]"))
                .click();

        Thread.sleep(60000);

        // проверяем наличие ошибки в фиде
        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Что-то пошло не так')]"))
                .isEmpty()
                & driver.findElements(new By.ByXPath("//*[contains(@text, 'ПОВТОР')]"))
                .isEmpty()) {
            System.out.print("DONE Создание истории с видео без редактирования \n");
        } else {
            driver.findElement(new By.ByXPath("Хуй")).click();
        }


    }


    @Test
    public void a_ChangeProfile2() throws InterruptedException, MalformedURLException {

        // cмена профиля

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);


// go to my profile
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[5]"))
                .click();
        Thread.sleep(1000);

        driver.findElement(new By.ByXPath("//*[contains(@text, 'Auto kornej')]")).click();
        Thread.sleep(1000);
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).click();
        Thread.sleep(2000);

    }


}
