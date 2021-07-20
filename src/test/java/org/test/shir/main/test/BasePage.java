package org.test.shir.main.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.test.shir.main.logic.DriverChromeSingleton;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class BasePage
{
    WebDriver driver;
    ExtentTest test;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public BasePage()
    {
        driver = DriverChromeSingleton.getDriverInstance();
    }

    public void clickElement(By locator)
    {
        final WebElement webElement = getWebElement(locator);
        webElement.click();
    }

    public void sendKeysToElement(By locator, String text)
    {
        getWebElement(locator).sendKeys(text);
    }

    private WebElement getWebElement(By locator)
    {
        final WebElement element = driver.findElement(locator);
        return element;
    }

    public String  getTextFromElement(By locator)
    {
        final WebElement element = driver.findElement(locator);
        return element.getAttribute("value");
    }

    public void clickOnSelect(By locator, int index)
    {
        List<WebElement> elements = driver.findElements(locator);
        if(elements != null && !elements.isEmpty() )
        {
            if(index < elements.size() )
            {
                elements.get(index).click();
            }
            else
            {
               throw new ArrayIndexOutOfBoundsException("ClickOnSelect out of bound "+index);
            }
        }
        else
        {
          throw new ArrayIndexOutOfBoundsException("Arry element not found");
        }
    }

    public void createScreenShot(String fileName)
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(scrFile, new File("D:\\User\\Desktop\\qa\\SeleniumHandsOn\\SeleniumHandsOn\\screenshot\\"+fileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeLog(Status status, String text)
    {
         test.log(status, text);
    }
    public void setTest(ExtentTest test) {
        this.test = test;
    }
}
