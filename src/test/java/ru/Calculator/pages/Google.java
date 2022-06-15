package ru.Calculator.pages;

import org.openqa.selenium.WebDriver;

public class Google {

    WebDriver driver;

    public GoogleSearchPage googleSearchPage;
    public GoogleSearchResultPage googleSearchResultPage;

    public Google(WebDriver driver) {
        this.driver = driver;

        googleSearchPage = new GoogleSearchPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
    }
}