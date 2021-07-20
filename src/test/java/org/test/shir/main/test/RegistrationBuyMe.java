package org.test.shir.main.test;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationBuyMe extends BasePage
{
    public RegistrationBuyMe()
    {
        super();
    }

    public RegistrationBuyMe(WebDriver driverInstance)
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
                writeLog(Status.FAIL, "enterLogin"+e.getMessage());
            }

 //enterRegistration
            try
            {
            enterRegistration();
                writeLog(Status.PASS, "enterRegistration");
            }
            catch (Exception e)
            {
                createScreenShot("enterRegistration.png");
                writeLog(Status.FAIL, "enterRegistration" + e.getMessage());
            }

 //inputRegistration
            try
            {
                inputRegistration();
                writeLog(Status.PASS, "inputRegistration");
            }
            catch (Exception e)
            {
                createScreenShot("inputRegistration.png");
                writeLog(Status.FAIL, "inputRegistration" + e.getMessage());
            }

 //pressRegistration
            try
            {
                pressRegistration();
                writeLog(Status.PASS, "pressRegistration");
            }
            catch (Exception e)
            {
                createScreenShot("pressRegistration.png");
                writeLog(Status.FAIL, "pressRegistration" + e.getMessage());
            }
        }

        private void enterLogin()
        {
            By xpath = By.xpath("//*[contains(text(), 'כניסה')]");
            clickElement(xpath);
        }

        private void enterRegistration()
        {
            final By xpath = By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/div[1]/span");
            clickElement(xpath);
        }

        private void inputRegistration()
        {
            sendKeysToElement(By.xpath( "//input[@placeholder='שם פרטי']"), "shir");
            sendKeysToElement(By.xpath( "//input[@placeholder='מייל']"), "shit@gmail.com");
            sendKeysToElement(By.xpath( "//input[@placeholder='סיסמה']"), "Tt123456");
            sendKeysToElement(By.xpath( "//input[@placeholder='אימות סיסמה']"), "Tt123456");

            Assert.assertEquals(getTextFromElement(By.xpath("//input[@placeholder='שם פרטי']")) ,"shir");
            Assert.assertEquals(getTextFromElement(By.xpath("//input[@placeholder='מייל']")) ,"shit@gmail.com");
            Assert.assertEquals(getTextFromElement(By.xpath("//input[@placeholder='סיסמה']")) ,"Tt123456");
            Assert.assertEquals(getTextFromElement(By.xpath("//input[@placeholder='אימות סיסמה']")) ,"Tt123456");

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember1443")));
            clickElement(By.id("ember1443"));
        }

        private void pressRegistration()
        {
            final By xpath = By.xpath( "//button[@gtm='הרשמה ל-BUYME']");
            clickElement(xpath);
        }
    }



