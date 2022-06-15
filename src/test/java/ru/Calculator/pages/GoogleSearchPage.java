package ru.Calculator.pages;

import org.openqa.selenium.WebDriver;
import ru.Calculator.components.Element;
import ru.Calculator.components.SearchBar;

public class GoogleSearchPage extends Element {

    public GoogleSearchResultPage googleSearchResultPage;
    public SearchBar searchBar;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);

        googleSearchResultPage = new GoogleSearchResultPage(driver);
        searchBar = new SearchBar(driver);

    }
}
