package ru.Calculator.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends Element {

    Button(WebDriver driver) {
        super(driver);
    }

    public void click(By locator) {
        System.out.println(" - Выполняется нажатие на кнопку '" + locator + "'");
        if (isElementPresent(locator))
            driver.findElement(locator).click();
        System.out.println(" - Нажатие выполнено успешно");
    }
}
