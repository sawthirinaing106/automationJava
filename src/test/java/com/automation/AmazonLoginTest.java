package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonLoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @Test
    public void amazonLoginTest() {

        // Click Sign in
        WebElement signInBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList"))
        );
        signInBtn.click();

        // Enter email
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login"))
        );
        emailField.sendKeys("STRNaing@student.calmu.edu");

        // Click Continue
        driver.findElement(By.id("continue")).click();

        // Enter password
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))
        );
        passwordField.sendKeys("aa");

        // Click Sign In
        driver.findElement(By.id("signInSubmit")).click();
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(5000); // see result
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // driver.quit(); // keep commented if OTP/CAPTCHA appears
    }
}

