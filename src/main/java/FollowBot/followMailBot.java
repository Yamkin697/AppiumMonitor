package FollowBot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import routine.ArgumentManager;
import routine.LogoPasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Random;


public class followMailBot {

    private AndroidDriver driver;

    @Before
    public void beforeMethod() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("Android")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .setNewCommandTimeout(Duration.ofMillis(600000))
                //.setLocale("RU")
                .setNoReset(true);
        String avd = ArgumentManager.getAvd();
        String appiumport = Integer.toString(ArgumentManager.getAppiumPort());
        if(avd != null){
            options.setAvd(avd);
        }


        driver = new AndroidDriver(new URL("http://127.0.0.1:"+appiumport+"/"), options.setAppPackage("com.android.chrome"));
    }

    @After
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException, MalformedURLException, IOException {
        String filePath = LogoPasses.Environment.filePath+"mails.txt"; // Путь к вашему файлу с учетными данными

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length == 3) {
                    String email = credentials[0];
                    String password = credentials[1];
                    String phoneNum = credentials[2].substring(credentials[2].length() - 4);

                    executeTest(email, password, phoneNum);
                } else {
                    System.out.println("Invalid credentials format: " + line);
                }
            }
        }
    }

    private void executeTest(String email, String password, String phoneNum) throws InterruptedException {





        driver.launchApp();

        Random random = new Random();
        int waitTime = 1 + random.nextInt(1);
        System.out.println("Waiting for " + waitTime + " minutes before the next run...");
       // Thread.sleep(waitTime * 60 * 1000);

        Thread.sleep(5000);

        if (!driver.findElements(new By.ById("com.android.chrome:id/tab_switcher_button")).isEmpty()) {
            driver.findElement(new By.ById("com.android.chrome:id/tab_switcher_button")).click();
            Thread.sleep(2000);
        }

        if (!driver.findElements(new By.ById("com.android.chrome:id/menu_button")).isEmpty()) {
            driver.findElement(new By.ById("com.android.chrome:id/menu_button")).click();
            Thread.sleep(2000);
        }
        if (!driver.findElements(new By.ById("com.android.chrome:id/title")).isEmpty()) {
            driver.findElement(new By.ById("com.android.chrome:id/title")).click();
            Thread.sleep(2000);
        }

        if (!driver.findElements(new By.ById("com.android.chrome:id/url_bar")).isEmpty()) {
            driver.findElement(new By.ById("com.android.chrome:id/url_bar")).click();
            Thread.sleep(2000);
        }

        if (!driver.findElements(new By.ById("com.android.chrome:id/url_bar")).isEmpty()){
        driver.findElement(new By.ById("com.android.chrome:id/url_bar")).sendKeys("https://www.sostav.ru/vote/59/311/8374/view/shared");
        Thread.sleep(2000);
        }

        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]"))
                    .click();
            Thread.sleep(10000);
        }


        WebElement ele01 = driver.findElement(By.id("android:id/content"));

        int centerX = ele01.getRect().x + (ele01.getSize().width / 2);

        double startY = ele01.getRect().y + (ele01.getSize().height * 0.1);  //эта хуйня отвечает за параиетры свайпа

        double endY = ele01.getRect().y + (ele01.getSize().height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int) startY));

        swipe.addAction(finger.createPointerDown(0));

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int) endY));

        swipe.addAction(finger.createPointerUp(0));

        driver.perform(Arrays.asList(swipe));


        Thread.sleep(4000);


        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[2]")).isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View/android.widget.Button[2]"))
                    .click();
        }


        Thread.sleep(5000);


        // email
        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.EditText"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View/android.widget.EditText"))
                    .sendKeys(email);
            Thread.sleep(2000);
        }

        if (!driver.findElements(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.widget.EditText"))
                .isEmpty()) {
            // password
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.widget.EditText"))
                    .sendKeys(password);
            Thread.sleep(2000);
        }

        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Войти и разрешить')]")).isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Войти и разрешить')]")).click();
            Thread.sleep(5000);
        }

        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Это точно вы? Дополните свой номер телефона, чтобы войти в аккаунт')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.EditText"))
                    .sendKeys(phoneNum);
            Thread.sleep(5000);
            driver.findElement(new By.ByXPath("//*[contains(@text, 'Продолжить')]"))
                    .click();
        }

        Thread.sleep(6000);

        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'Спасибо. Ваш голос принят.')]"))
                .isEmpty()) {
            System.out.println("голос засчитан");
        } else {
            System.out.println("Error  голос не засчитан");
        }

        if (!driver.findElements(new By.ByXPath("//*[contains(@text, 'OK')]"))
                .isEmpty()) {
            driver.findElement(new By.ByXPath("//*[contains(@text, 'OK')]"))
                    .click();

            driver.terminateApp((String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE));

        }
    }
}
