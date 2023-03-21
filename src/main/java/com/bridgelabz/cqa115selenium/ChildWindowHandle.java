package com.bridgelabz.cqa115selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Set;

public class ChildWindowHandle {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suche\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.naukri.com/");
        Thread.sleep(2000);

        String parentWindowHandleId = driver.getWindowHandle();
        System.out.println("parent window handle id: " + parentWindowHandleId);
        System.out.println("parent window title:" + driver.getTitle());

        driver.findElement(By.xpath("//span[contains(text(),'Fortune 500')]")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        String firstChildWindow = null;

        for (String windowHandle : windowHandles) {
            System.out.println("window handle Id: " + windowHandle);

            if (!windowHandle.equals(parentWindowHandleId)) {
                firstChildWindow = windowHandle;
                driver.switchTo().window(windowHandle);
                Thread.sleep(6000);
                driver.findElement(By.xpath("//a[contains(text(),'Internal Audit Analyst Finance & Operations')]")).click();
                Thread.sleep(4000);
            }
        }
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String allWindowHandle : allWindowHandles) {

            //to close all window except parent window
            if (!allWindowHandle.equals(parentWindowHandleId)) {
                if (allWindowHandle.equals(firstChildWindow)) {
                    driver.close();
                } else if (!allWindowHandle.equals(firstChildWindow)) {
                    driver.switchTo().window(allWindowHandle);
                    Thread.sleep(2000);
                    driver.close();
                }
            }

            //to close the parent window
            else if (allWindowHandle.equals(parentWindowHandleId)) {
                //    driver.close


            }

        }
    }
}




