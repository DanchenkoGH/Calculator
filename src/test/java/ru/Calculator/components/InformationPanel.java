package ru.Calculator.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPanel extends Element {

    InformationPanel(WebDriver driver) {
        super(driver);
    }

    public String getHistoryText() {
        return getText(By.xpath("//div[@class='BRpYC']//div[@class='XH1CIc']/span"));
    }

    public String getResultStringText() {
        return getText(By.xpath(".//div[@class='z7BZJb XSNERd']/span"));
    }

    private String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
