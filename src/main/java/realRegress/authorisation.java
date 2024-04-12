package realRegress;




import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;


import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import routine.ArgumentManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class authorisation {


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
    public void a_GoToNeedHelpLink() throws InterruptedException, MalformedURLException {

        //Переход по ссылке "Have a questions or need help?"

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'РАЗРЕШИТЬ')]"))
                .isEmpty()){
            driver.findElement(new By.ById("com.android.permissioncontroller:id/permission_allow_button")).click();
            Thread.sleep(1000);
        }

        // проверяем авторизированы ли мы
        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Сторис')]"))
                .isEmpty()){

            // выходим из аккаунта (go to my profile)
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.View/android.view.View[5]"))
                    .click();
            Thread.sleep(2000);

            // проверяем подсказку профиля
            if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'ТВОЙ ПРОФИЛЬ')]"))
                    .isEmpty()){
                driver.findElement(new By.ByXPath("//*[contains(@text, 'Ок, спасибо!')]"))
                        .click();
            }

            // открываем шторку профиля
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup"))
                    .click();
            Thread.sleep(1000);

            // выходим из аккаунта
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Выйти')]"))
                    .click();
        }
        // убираем клавиатуру
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                .click();

        // тап по сслыке
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView"))
                .click();
        Thread.sleep(3000);

        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'looky.com/support')]"))
                .isEmpty()){
            driver.findElement(new By.ByXPath("Хуй")).click();
        }

        driver.navigate().back();

        System.out.print("DONE  Переход по ссылке 'Have a questions or need help?' \n");
    }

    @Test
    public void b_TermsConditionsLink() throws InterruptedException, MalformedURLException {

        //Переход по ссылке "Terms&Conditions"

        // услоаие
        // не авторизован

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        // убираем клавиатуру
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"))
                .click();

        // тап по сслыке
        driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView"))
                .click();
        Thread.sleep(3000);

        if (driver.findElements(new By.ByXPath("//*[contains(@text, 'looky.com/documents/polzovatelskoe-soglashenie-looky')]"))
                .isEmpty()){
            driver.findElement(new By.ByXPath("Хуй")).click();
        }

        driver.navigate().back();
        System.out.print("DONE  Переход по ссылке 'Terms&Conditions' \n");
    }

    @Test
    public void c_LogInGoogle() throws InterruptedException, MalformedURLException {

        //Авторизация через Google

        // услоаие
        // не авторизован

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        // тап по кнопке Вход с гугл
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Вход с Google')]"))
                .click();
        Thread.sleep(3000);

        // тап по аккаунту
        driver.findElement(new By.ByXPath("//*[contains(@text, 'Александр Корнеев')]"))
                .click();
        Thread.sleep(3000);

        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Сторис')]"))
                .isEmpty()){
            driver.findElement(new By.ByXPath("Хуй")).click();
        }

        System.out.print("DONE  Авторизация через Google \n");

    }

    @Test
    public void d_FeedHelp() throws InterruptedException, MalformedURLException {

        //Проверка подсказки в фиде

        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Создавай бесплатно контент в нашей нейросети')]"))
                .isEmpty()){
            System.out.print("Done Подсказка в Feed \n");
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Обработать фото')]"))
                    .click();
        }
    }
}