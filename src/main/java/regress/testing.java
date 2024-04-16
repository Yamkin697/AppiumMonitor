package regress;


import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import routine.ArgumentManager;

public class testing {
    private AndroidDriver driver;

    private Object addAction;

    @Before
    public void beforeMethod() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("Android")
                .setPlatformVersion("13")
                .setDeviceName("Pixel 7")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.looky.app")
                .setAppActivity("com.looky.app.MainActivity")
                //.setLocale("RU")
                .setNoReset(true);
        String avd = ArgumentManager.getAvd();
        String appiumport = Integer.toString(ArgumentManager.getAppiumPort());
        if (avd != null) {
            options.setAvd(avd);
        }
        driver = new AndroidDriver(new URL("http://127.0.0.1:" + appiumport + "/"),
                options.setAppPackage("com.looky.app"));

    }

    //.setNoReset(false);


    @After
    public void afterMethod() {

        driver.quit();
    }


    @Test
    public void a_Test() throws InterruptedException, MalformedURLException {


    }
}
