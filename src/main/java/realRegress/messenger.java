package realRegress;



import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import routine.ArgumentManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class messenger {

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
    public void a_OpenMessnger() throws InterruptedException, MalformedURLException {

        // Переход в мессенджер

        driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
        driver.launchApp();

        Thread.sleep(5000);

        // Закрыть шторку с программой лояльности
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Программа лояльности от LOOKY!')]"))
                .isEmpty()){
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Сторис')]"))
                    .click();
            Thread.sleep(1000);
        }

        // Переходим в мессенджер
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        if (driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]"))
                .isDisplayed()){
            System.out.print("DONE Переход в мессенджер \n");
        }

    }

    @Test
    public void b_CreateChatMessenger() throws InterruptedException, MalformedURLException {

        Random random = new Random();

        // Генерируйте случайное целое число в диапазоне от 1 до 100 (включительно)
        int randomNumber = random.nextInt(1000000000) + 1;

        String randomNumberString = Integer.toString(randomNumber);

        // создание чата из мессенджера

        driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
        driver.launchApp();

        Thread.sleep(2000);


// Переходим в мессенджер
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        // удаляем чат если он есть
        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Новый чат')]"))
                .isEmpty()) {
            // лонг тап по диалогу
            WebElement dialog = driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));

            TouchAction touchAction = new TouchAction(driver)
                    .longPress(LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(dialog))
                            .withDuration(Duration.ofSeconds(3)) // Пример: долгий тап в течение 2 секунд
                    );

            // Выполнить долгий тап
            touchAction.perform();

            Thread.sleep(1000);

            driver.findElement(new By.ById("com.looky.app:id/md_button_negative"))
                    .click();
            Thread.sleep(2000);
        }

        //создаем чат
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Новый чат')]"))
                .click();
        Thread.sleep(1000);

        // проверяем наличие подсказки о скрытых подписках
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Ок, спасибо!')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Ок, спасибо!')]"))
                    .click();
        }


        // тапаем на профиль с которым хотим создать чат
        driver.findElement(new By.ByXPath("//*[contains(@text, '@ajkornej')]")).click();
        Thread.sleep(1000);

        // создаем чат с профилем
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(2000);

        // вводим текст
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Сообщение...')]"))
                .sendKeys(randomNumberString);


// жмем на отправить сообщение  "самолет"
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"))
                .click();
        Thread.sleep(1000);

        // Тап назад
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        // Тап назад
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        // Тап назад
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        //Проверяем отправилось ли сообщение
        if (driver.findElement(By.xpath("//*[contains(@text, '" + randomNumberString + "')]")).isDisplayed()) {
            System.out.print("DONE  создание чата из мессенджера\n");
        }
        Thread.sleep(1000);


// проверяем удаление чата
        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Новый чат')]"))
                .isEmpty()) {
            // лонг тап по диалогу
            WebElement dialog = driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));

            TouchAction touchAction = new TouchAction(driver)
                    .longPress(LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(dialog))
                            .withDuration(Duration.ofSeconds(3)) // Пример: долгий тап в течение 2 секунд
                    );

            // Выполнить долгий тап
            touchAction.perform();

            Thread.sleep(1000);

            driver.findElement(new By.ById("com.looky.app:id/md_button_negative"))
                    .click();
            Thread.sleep(2000);

            if (driver.findElement(new By.ByXPath("//*[contains(@text, 'Новый чат')]"))
                    .isDisplayed()){

                System.out.print("DONE удаление чата из мессенджера\n");
            }
        }
    }

    @Test
    public void c_CreateChatDiscovery() throws InterruptedException, MalformedURLException {

        // Создание чата (в мессенджере уже есть ранее созданные чаты)

        driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
        driver.launchApp();

        Thread.sleep(5000);

        // убираем подсказку их фида если она есть
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Ок, спасибо!')]"))
                .isEmpty()){
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Ок, спасибо!')]")).
                    click();
            System.out.print("DONE Подсказка в Discovery\n");
        }

        // идем в дискавери
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[2]"))
                .click();
        Thread.sleep(2000);

        // tap on input area
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText"))
                .click();

        Thread.sleep(2000);


// вводим в поиск имя акка с которым хотим создать чат
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText"))
                .sendKeys("Kornej 333455445");

        Thread.sleep(6000);

        //тап на иконку самолетика
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]"))
                .click();

        Thread.sleep(2000);


        Random random = new Random();

        // Генерируйте случайное целое число в диапазоне от 1 до 100 (включительно)
        int randomNumber1 = random.nextInt(1000000000) + 1;

        String randomNumberString1 = Integer.toString(randomNumber1);

        // вводим текст
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.widget.EditText"))
                .sendKeys( randomNumberString1 );

        // жмем на отправить сообщение  "самолет"
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"))
                .click();

        Thread.sleep(1000);


// жмем кнопку назад
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]"))
                .click();

        Thread.sleep(1000);

        // идем в фид
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[1]"))
                .click();

        // переходим в мессенджер
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]"))
                .click();
        Thread.sleep(2000);

        if (randomNumberString1.isEmpty()){
            driver.findElement(new By.ByXPath("хуй")).click();
        } else {
            System.out.print("DONE Создание чата (в мессенджере уже есть ранее созданные чаты)\n");
            System.out.print("DONE Создание чата (в мессенджере уже есть ранее созданные чаты)\n");
        }

        // лонг тап по диалогу
        WebElement dialog = driver.findElement(MobileBy.xpath("//*[contains(@text, '" + randomNumberString1 + "')]"));

        TouchAction touchAction = new TouchAction(driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(dialog))
                        .withDuration(Duration.ofSeconds(3)) // Пример: долгий тап в течение 2 секунд
                );

        // Выполнить долгий тап
        touchAction.perform();

        //жмем да в системном алерте
        driver.findElement(new By.ById("com.looky.app:id/md_button_negative")).click();

    }

    @Test
    public void d_ChangeProfileInMessenger() throws InterruptedException, MalformedURLException {

        // Смена профиля в мессенджере

        driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
        driver.launchApp();

        Thread.sleep(5000);


// Переходим в мессенджер
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        // Тапаем на другой профиль
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).isEmpty()){
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).click();
            Thread.sleep(1000);
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Auto kornej')]")).click();
            Thread.sleep(3000);
            if (driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej 333455445')]"))
                    .isDisplayed()) {
                System.out.print("DONE Смена профиля в мессенджере \n");
            }
        }else {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Auto kornej')]")).click();
            Thread.sleep(1000);
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).click();
            Thread.sleep(2000);

            driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).click();
            Thread.sleep(1000);
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Auto kornej')]")).click();
            Thread.sleep(3000);
            if (driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej 333455445')]"))
                    .isDisplayed()) {
                System.out.print("DONE Смена профиля в мессенджере \n");
            }

        }

        driver.findElement(new By.ByXPath("//*[contains(@text, 'Auto kornej')]")).click();
        Thread.sleep(1000);
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Kornej Auto')]")).click();
        Thread.sleep(2000);
    }

    @Test
    public void f_MessageWithLink() throws InterruptedException, MalformedURLException {

        // Сообщение со ссылкой

        driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));
        driver.launchApp();

        Thread.sleep(5000);

        // Переходим в мессенджер
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);


// удаляем чат если он есть
        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Новый чат')]"))
                .isEmpty()) {
            // лонг тап по диалогу
            WebElement dialog = driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));

            TouchAction touchAction = new TouchAction(driver)
                    .longPress(LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(dialog))
                            .withDuration(Duration.ofSeconds(3)) // Пример: долгий тап в течение 2 секунд
                    );

            // Выполнить долгий тап
            touchAction.perform();

            Thread.sleep(1000);

            driver.findElement(new By.ById("com.looky.app:id/md_button_negative"))
                    .click();
            Thread.sleep(2000);
        }

        //создаем чат
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Новый чат')]"))
                .click();
        Thread.sleep(1000);

        // проверяем наличие подсказки о скрытых подписках
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Ок, спасибо!')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Ок, спасибо!')]"))
                    .click();
        }


        // тапаем на профиль с которым хотим создать чат
        driver.findElement(new By.ByXPath("//*[contains(@text, '@ajkornej')]")).click();
        Thread.sleep(1000);

        // создаем чат с профилем
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(2000);

        // вводим текст
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Сообщение...')]"))
                .sendKeys("Lorem Ipsum - это текст-рыба, часто используемый в печати и вэб-дизайне. https://www.looky.com Lorem Ipsum является стандартной рыбой для текстов на латинице с начала XVI века.");

        // жмем на отправить сообщение  "самолет"
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"))
                .click();
        Thread.sleep(1000);


        driver.findElement(new By.ByXPath("//*[contains(@text, 'https://www.looky.com')]")).click();
        Thread.sleep(2000);

        if (driver.findElement(new By.ByXPath("//*[contains(@text, 'looky.com')]"))
                .isDisplayed())

            driver.navigate().back();
        Thread.sleep(2000);

        // вводим текст
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Сообщение...')]"))
                .sendKeys("https://www.google.com");

        // жмем на отправить сообщение  "самолет"
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup[1]"))
                .click();
        Thread.sleep(2000);

        driver.findElement(new By.ByXPath("//*[contains(@text, 'https://www.google.com')]")).click();
        Thread.sleep(3000);

        if (driver.findElement(new By.ByXPath("//*[contains(@text, 'google.com')]"))
                .isDisplayed()){
            System.out.print("DONE Сообщение со ссылкой \n");
            driver.navigate().back();
            Thread.sleep(2000);
        }


        // Тап назад
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        // Тап назад
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);

        // Тап назад
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"))
                .click();
        Thread.sleep(1000);


// проверяем удаление чата
        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'Новый чат')]"))
                .isEmpty()) {
            // лонг тап по диалогу
            WebElement dialog = driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));

            TouchAction touchAction = new TouchAction(driver)
                    .longPress(LongPressOptions.longPressOptions()
                            .withElement(ElementOption.element(dialog))
                            .withDuration(Duration.ofSeconds(3)) // Пример: долгий тап в течение 2 секунд
                    );

            // Выполнить долгий тап
            touchAction.perform();

            Thread.sleep(1000);

            driver.findElement(new By.ById("com.looky.app:id/md_button_negative"))
                    .click();
            Thread.sleep(2000);

        }
    }

}