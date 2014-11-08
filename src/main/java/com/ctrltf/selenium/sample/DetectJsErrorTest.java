package com.ctrltf.selenium.sample;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DetectJsErrorTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "driver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAlive() throws Exception {
        driver.get("http://localhost:8080/webapp-sample_jetty");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        System.out.println(executor.executeScript("return window.javaScriptErrors"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
