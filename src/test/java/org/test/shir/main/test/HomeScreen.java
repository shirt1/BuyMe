package org.test.shir.main.test;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeScreen extends BasePage
{
    public HomeScreen()
    {
        super();
    }

    public HomeScreen(WebDriver driverInstance)
    {
         super(driverInstance);
    }

    public void login()
    {
 //enterLogin
        try
        {
            enterLogin();
            writeLog(Status.PASS, "enterLogin");
        }
        catch (Exception e)
        {
            createScreenShot("enterLogin.png");
            writeLog(Status.FAIL, "enterLogin" + e.getMessage());
        }

//enterCredentials
        try {
            enterCredentials();
            writeLog(Status.PASS, "enterCredentials");
        }
        catch (Exception e)
        {
            createScreenShot("enterCredentials.png");
            writeLog(Status.FAIL, "enterCredentials" + e.getMessage());
        }

//pressLogin
        try
        {
            pressLogin();
            writeLog(Status.PASS, "pressLogin");
        }
        catch (Exception e)
        {
            createScreenShot("pressLogin.png");
            writeLog(Status.FAIL, "pressLogin" + e.getMessage());
        }

//selectPrincePoint
        try
        {
            selectPricePoint();
            writeLog(Status.PASS, "selectPricePoint");
        }
        catch (Exception e)
        {
            createScreenShot("selectPricePoint.png");
            writeLog(Status.FAIL, "selectPricePoint" + e.getMessage());
        }

//pickPricePoint
        try
        {
            pickPricePoint();
            writeLog(Status.PASS, "pickPricePoint");
        }
        catch (Exception e)
        {
            createScreenShot("pickPricePoint.png");
            writeLog(Status.FAIL, "pickPricePoint" + e.getMessage());
        }

//selectRegion
        try
        {
            selectRegion();
            writeLog(Status.PASS, "selectRegion");
        }
        catch (Exception e)
        {
            createScreenShot("selectRegion.png");
            writeLog(Status.FAIL, "selectRegion" + e.getMessage());
        }

//pickRegion
        try
        {
            pickRegion();
            writeLog(Status.PASS, "pickRegion");
        }
        catch (Exception e)
        {
            createScreenShot("pickRegion.png");
            writeLog(Status.FAIL, "pickRegion" + e.getMessage());
        }

//selectCategory
        try
        {
            selectCategory();
            writeLog(Status.PASS, "selectCategory");
        }
        catch (Exception e)
        {
            createScreenShot("selectCategory.png");
            writeLog(Status.FAIL, "selectCategory" + e.getMessage());
        }

//pickCategory
        try
        {
            pickCategory();
            writeLog(Status.PASS, "pickCategory");
        }
        catch (Exception e)
        {
            createScreenShot("pickCategory.png");
            writeLog(Status.FAIL, "pickCategory" + e.getMessage());
        }

//pressGetFift
        try
        {
        pressGetGift();
        writeLog(Status.PASS, "pressGetGift");
        }
        catch (Exception e)
        {
            createScreenShot("pressGetGift.png");
            writeLog(Status.FAIL, "pressGetGift"+e.getMessage());
        }
    }

    private void enterLogin()
    {
        final By xpath = By.xpath("//*[contains(text(), 'כניסה')]");
        clickElement(xpath);
    }

//Enter by mail and password
    private void enterCredentials()
    {
        sendKeysToElement(By.xpath( "//input[@placeholder='מייל']"), "shirt10j@gmail.com");
        sendKeysToElement(By.xpath( "//input[@placeholder='סיסמה']"), "Shir1234");
    }

    private void pressLogin()
    {
        final By xpath = By.xpath( "//button[@gtm='כניסה ל-BUYME']");
        clickElement(xpath);
    }


// select price
    private void selectPricePoint()
    {
        final By byclass = By.className( "chosen-container-single");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byclass));

        clickOnSelect(byclass,0);//0 -index of price selector
    }

    private void pickPricePoint()
    {
        final By xpath = By.xpath( "//li[@data-option-array-index='1']");
        clickElement(xpath);
    }

//select region
    private void selectRegion()
    {
        final By byclass = By.className( "chosen-container-single");
        clickOnSelect(byclass,1);//1 -index of Region selector
    }

    private void pickRegion()
    {
        final By xpath = By.xpath( "//li[@data-option-array-index='1']");
        clickElement(xpath);
    }

//select category
    private void selectCategory()
    {
        final By byclass = By.className( "chosen-container-single");
        clickOnSelect(byclass,2);//2 -index of Category selector
    }

    private void pickCategory()
    {
        final By xpath = By.xpath( "//li[@data-option-array-index='1']");
        clickElement(xpath);
    }

//click the button and search a gift
    private void pressGetGift()
    {
        final By xpath = By.cssSelector( "a[rel=nofollow]");// "//*[contains(text(), 'כניסה')]"
        clickElement(xpath);
    }
}
