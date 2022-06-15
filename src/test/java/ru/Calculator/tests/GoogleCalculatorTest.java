package ru.Calculator.tests;

import org.junit.Test;

public class GoogleCalculatorTest extends BaseTest {

    @Test()
    public void Test_01() {
        google().googleSearchPage.searchBar.search("Калькулятор");
        google().googleSearchResultPage.calculator.execute("1 × 2 − 3 + 1", "0");
    }
}



