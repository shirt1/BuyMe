package org.test.shir.main.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverMozillaSinglton2
{
    private static WebDriver driver;

    public static WebDriver getDriverInstance()
    {
        if(driver == null)
        {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
