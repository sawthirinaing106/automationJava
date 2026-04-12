package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Open Amazon
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();

        // 2. Click "Sign in"
        WebElement signInBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList"))
        );
        signInBtn.click();

        // 3. Enter email
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login"))
        );
        emailField.sendKeys("STRNaing@student.calmu.edu");

        // 4. Click Continue
        driver.findElement(By.id("continue")).click();

        // 5. Enter password
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))
        );
        passwordField.sendKeys("aa");

        // 6. Click Sign-In
        driver.findElement(By.id("signInSubmit")).click();

        // Wait a few seconds to see result
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // driver.quit();  // comment this if Amazon shows OTP/CAPTCHA
    }
}


