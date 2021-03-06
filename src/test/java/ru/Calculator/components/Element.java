package ru.Calculator.components;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class Element {
    public WebDriver driver;
    WebDriverWait wait;

    protected Element(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected void wait(int milliseconds) throws InterruptedException {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitVisiblityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementPresence(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex) {
            System.out.println("Указан неккоректный локатор. Исправьте и повторите.");
            throw ex;
        } catch (NoSuchElementException ex) {
            System.out.println("Элемент на странице не найден.");
            return false;
        }
    }

    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void waitElementEnable(By locator) {
        if (!isElementEnable(locator)) {
            new Exception("Не удалось дождаться доступность элемента: " + locator);
        }
    }

    private boolean isElementEnable(By locator) {
        try {
            driver.findElement(locator).isEnabled();
            return true;
        } catch (InvalidSelectorException ex) {
            System.out.println("Указан неккоректный локатор. Исправьте и повторите.");
            throw ex;
        } catch (NoSuchElementException ex) {
            System.out.println("Элемент на странице не найден.");
            return false;
        }
    }

}
