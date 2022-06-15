package ru.Calculator.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.Calculator.pages.Google;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    private Google google;

    public Google google() {
        return google;
    }

    public void start() {
        // Используется JDK 8
        // Прописать путь к исполняемому файлу chromedriver.exe
        File file = new File("C:/Tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        google = new Google(driver);
    }

    public void stop() {
        driver.quit();
    }

    @Before
    public void beforeTest() throws Exception {
        start();
    }

    @After
    public void afterTest() {
        stop();
    }
}
