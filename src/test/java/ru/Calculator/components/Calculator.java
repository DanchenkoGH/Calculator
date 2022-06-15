package ru.Calculator.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Calculator extends Element {

    InformationPanel informationPanel = new InformationPanel(driver);
    Button button = new Button(driver);

    public Calculator(WebDriver driver) {
        super(driver);
    }

    public void execute(String testData, String expectedResult) {
        System.out.println("Выполняется вычисление выражения - " + testData);
        String[] subString = testData.split(" ");

        for (int i = 0; i < subString.length; i++) {
            button.click(By.xpath("//div[@class='card-section']//div[contains(@class,'PaQdxb')]//div[.='" + subString[i] + "']"));
        }
        button.click(By.xpath("//div[@class='card-section']//div[contains(@class,'PaQdxb')]//div[.='=']"));

        // replace() - 'Минус' в строке памяти (строка над результатом), по какой-то причине
        //                                     не равен вводимому 'минусу'. Приводим их к одному виду.
        // concat() - Добавим для сравнения со строкой результатом символ '='.
        String resultTestData = testData.concat(" =").replace('−', '-');

        assertEquals(resultTestData, informationPanel.getHistoryText());
        assertEquals(expectedResult, informationPanel.getResultStringText());

        System.out.println("Вычисление выполненно успешно.");
    }
}
