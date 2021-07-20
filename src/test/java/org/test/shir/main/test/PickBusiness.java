package org.test.shir.main.test;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PickBusiness extends BasePage
{
    public void processTest()
    {
        Assert.assertEquals(driver.getCurrentUrl(), "https://buyme.co.il/search?budget=1&category=204&region=13");

//pickBusiness
        try
        {
            pickBusiness();
            writeLog(Status.PASS, "pickBusiness");
        }
        catch (Exception e)
        {
            createScreenShot("pickBusiness.png");
            writeLog(Status.FAIL, "pickBusiness"+e.getMessage());
        }

//inputPrice
        try
        {
            inputPrice();
            writeLog(Status.PASS, "inputPrice");
        }
        catch (Exception e)
        {
            createScreenShot("inputPrice.png");
            writeLog(Status.FAIL, "inputPrice"+e.getMessage());
        }

//presschoose
        try
        {
        presschoose();
            writeLog(Status.PASS, "presschoose");
        }
        catch (Exception e)
        {
            createScreenShot("presschoose.png");
            writeLog(Status.FAIL, "presschoose"+e.getMessage());
        }
    }

    public PickBusiness()
    {
        super();
    }

    public PickBusiness(WebDriver driverInstance)
    {
        super(driverInstance);
    }

    private void pickBusiness()
    {
        By className = By.className("bm-product-card-link");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(className));
        clickOnSelect(className, 0);
    }

    private void inputPrice()
    {
        By inputName = By.xpath("//input[@placeholder='הכנס סכום']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputName));
        sendKeysToElement(inputName, "100");
        Assert.assertEquals(getTextFromElement(inputName), "100");
    }

    private void presschoose()
    {
        final By xpath = By.xpath("//button[@gtm='בחירה']");
        clickElement(xpath);
    }
}
