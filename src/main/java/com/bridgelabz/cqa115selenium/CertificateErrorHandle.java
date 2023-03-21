package com.bridgelabz.cqa115selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CertificateErrorHandle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suche\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");

     //   ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://wrong.host.badssl.com/");
        Thread.sleep(5000);

        driver.close();

    }
}
