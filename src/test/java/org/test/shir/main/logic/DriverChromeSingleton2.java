package org.test.shir.main.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChromeSingleton2
{
    private static WebDriver driver;

    public static WebDriver getDriverInstance()
    {
        if(driver == null)
        {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
