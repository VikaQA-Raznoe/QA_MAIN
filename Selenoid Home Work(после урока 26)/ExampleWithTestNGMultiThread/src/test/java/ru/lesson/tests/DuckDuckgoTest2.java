package ru.lesson.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.lesson.BaseTest;


public class DuckDuckgoTest2 extends BaseTest {
    @Test(description = "Фиктивный тест #2")
    public void test(){
        getDriver().get("http://duckduckgo.com/");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement input = getDriver().findElement(By.cssSelector("input#search_form_input_homepage"));
        input.sendKeys("selenium", Keys.ENTER);
    }
}