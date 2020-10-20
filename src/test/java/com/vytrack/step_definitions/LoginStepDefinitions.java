package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinitions {
    WebDriver driver;

    @Given("user is on the landing")
    public void user_is_on_the_landing() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("http://qa1.vytrack.com");
    }

    @When("user logs in")
    public void user_logs_in() {
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager85");
        driver.findElement(By.id("prependedInput")).sendKeys("UserUser123");
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {
        String expected = "Dashboard";
        String actual = driver.findElement(By.className("oro-subtitle")).getText().trim();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");
        driver.quit();
    }



}
