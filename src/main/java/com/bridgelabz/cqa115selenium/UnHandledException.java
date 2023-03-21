package com.bridgelabz.cqa115selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnHandledException {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suche\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");

        driver.findElement(By.xpath("//input[@value='Say my name!']")).click();

        driver.findElement(By.xpath("//a[contains(text(),'HTML Tutorial')]")).click();
        driver.close();
    }
}