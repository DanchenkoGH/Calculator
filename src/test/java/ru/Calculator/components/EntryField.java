package ru.Calculator.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryField extends Element {
    EntryField(WebDriver driver) {
        super(driver);
    }

    public void type(String soughtData) {
        System.out.println(" - Выполняется ввод текста - " + soughtData);
        driver.findElement(By.xpath("//form[@action='/search']//input[@name='q']")).sendKeys(soughtData);
        System.out.println(" - Ввод выполнен успешно");
    }
}
