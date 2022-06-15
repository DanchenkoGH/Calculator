package ru.Calculator.components;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import ru.Calculator.pages.GoogleSearchPage;
import ru.Calculator.pages.GoogleSearchResultPage;

public class SearchBar extends Element {

    private EntryField entryField;
    private Button button;

    public SearchBar(WebDriver driver) {
        super(driver);

        entryField = new EntryField(driver);
        button = new Button(driver);
    }

    public GoogleSearchResultPage search(String soughtData) {
        System.out.println("Выполняется поиск: \"" + soughtData + "\"");
        entryField.type(soughtData);
        button.click(By.xpath("//form[@action='/search']//div[@class='CqAVzb lJ9FBc']//input[@name='btnK']"));
        checkPageHeader("Калькулятор");
        System.out.println("Поиск \"" + soughtData + "\" выполнен успешно.");

        return new GoogleSearchResultPage(driver);
    }

    private GoogleSearchPage checkPageHeader(String searchData) {
        try {
            waitVisiblityOfElement(By.xpath("//div[@id='searchform']//input[@class='gLFyf gsfi'][@value='" + searchData + "']"));
        } catch (TimeoutException error) {
            System.out.println("Переход на страницу не был выполнен.\n" + error.getMessage());
            throw error;
        }
        return new GoogleSearchPage(driver);
    }
}
