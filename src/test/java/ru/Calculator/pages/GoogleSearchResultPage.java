package ru.Calculator.pages;

import org.openqa.selenium.WebDriver;
import ru.Calculator.components.Calculator;
import ru.Calculator.components.Element;

public class GoogleSearchResultPage extends Element {
    public Calculator calculator;

    public GoogleSearchResultPage(WebDriver driver) {
        super(driver);

        calculator = new Calculator(driver);
    }
}
