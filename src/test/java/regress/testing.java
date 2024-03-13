package regress;


import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
                .setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
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
