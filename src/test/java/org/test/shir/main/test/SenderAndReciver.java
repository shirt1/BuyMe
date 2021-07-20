package org.test.shir.main.test;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SenderAndReciver extends BasePage
{
    public void senderAndReciver()
    {
//pressRadioButton
        try
        {
            pressRadioButton();
            writeLog(Status.PASS, "pressRadioButton");

        }
        catch (Exception e)
        {
            createScreenShot("pressRadioButton.png");
            writeLog(Status.FAIL, "pressRadioButton"+e.getMessage());
        }

//enterReciverName
        try
        {
            enterReciverName();
            writeLog(Status.PASS, "enterReciverName");
        }
        catch (Exception e)
        {
            createScreenShot("enterReciverName.png");
            writeLog(Status.FAIL, "enterReciverName"+e.getMessage());
        }

//pickAnEvent
        try
        {
            pickAnEvent();
            writeLog(Status.PASS, "pickAnEvent");
        }
        catch (Exception e)
        {
            createScreenShot("pickAnEvent.png");
            writeLog(Status.FAIL, "pickAnEvent"+e.getMessage());
        }

//enterABlessing
        try
        {
            enterABlessing();
            writeLog(Status.PASS, "enterABlessing");

        }
        catch (Exception e)
        {
            createScreenShot("enterABlessing.png");
            writeLog(Status.FAIL, "enterABlessing"+e.getMessage());
        }

//uploadAPicture
        try
        {
            uploadAPicture();
            writeLog(Status.PASS, "uploadAPicture");
        }
        catch (Exception e)
        {
            createScreenShot("uploadAPicture.png");
            writeLog(Status.FAIL, "uploadAPicture"+e.getMessage());
        }

//pressContinueButton
        try
        {
            pressContinueButton();
            writeLog(Status.PASS, "pressContinueButton");
        }
        catch (Exception e)
        {
            createScreenShot("pressContinueButton.png");
            writeLog(Status.FAIL, "pressContinueButton"+e.getMessage());
        }

 //pressRadioButtonNow
        try
        {
            pressRadioButtonNow();
            writeLog(Status.PASS, "pressRadioButtonNow");
        }
        catch (Exception e)
        {
            createScreenShot("pressRadioButtonNow.png");
            writeLog(Status.FAIL, "pressRadioButtonNow"+e.getMessage());
        }

 //pickEmail
        try
        {
            pickEmail();
            writeLog(Status.PASS, "pickEmail");
        }
        catch (Exception e)
        {
            createScreenShot("pickEmail.png");
            writeLog(Status.FAIL, "pickEmail"+e.getMessage());

        }

//enterEmail
        try
        {
            enterEmail();
            writeLog(Status.PASS, "enterEmail");
        }
        catch (Exception e)
        {
            createScreenShot("enterEmail.png");
            writeLog(Status.FAIL, "enterEmail"+e.getMessage());
        }

//enterSenderName
        try
        {
            enterSenderName();
            writeLog(Status.PASS, "enterSenderName");
        }
        catch (Exception e)
        {
            createScreenShot("enterSenderName.png");
            writeLog(Status.FAIL, "enterSenderName"+e.getMessage());
        }

//pressSave
        try
        {
            pressSave();
            writeLog(Status.PASS, "pressSave");
        }
        catch (Exception e)
        {
            createScreenShot("pressSave.png");
            writeLog(Status.FAIL, "pressSave"+e.getMessage());
        }
    }


    public SenderAndReciver()
    {
        super();
    }

    public SenderAndReciver(WebDriver driverInstance)
    {
        super(driverInstance);
    }

    private void pressRadioButton()
    {
        final By xpath = By.xpath("//div[@gtm='למישהו אחר']");
        clickElement(xpath);
    }

    private void enterReciverName()
    {
        final By xpath = By.xpath( "//input[@class='ember-view ember-text-field']");
        clickElement(xpath);
        sendKeysToElement(By.xpath( "//input[@class='ember-view ember-text-field']"), "Doli");
        Assert.assertEquals(getTextFromElement(By.xpath("//input[@class='ember-view ember-text-field'")) ,"Doli");
    }

    private void pickAnEvent()
    {
        final By byclass = By.className( "selected-name");
       clickElement(byclass);
       final By xpath= By.xpath("//li[contains(text(), 'מתנות סוף שנה')]");
        clickElement(xpath);
    }

    private void enterABlessing()
    {
        sendKeysToElement(By.xpath("//textarea[@data-parsley-group='voucher-greeting']"), "wow");
    }

    private void uploadAPicture()
    {
        sendKeysToElement(By.cssSelector("input[type=file") , "D:\\User\\Desktop\\qa\\pic.jpg");
    }

    private void pressContinueButton()
    {
        final By xpath = By.xpath( "//button[@gtm='המשך']");
        clickElement(xpath);
    }

    private void pressRadioButtonNow()
    {
        final By xpath = By.xpath( "//div[@gtm='עכשיו']");
        clickElement(xpath);
    }

    private void pickEmail()
    {
        final By xpath = By.xpath("//svg[@gtm='method-email']");
        clickElement(xpath);
    }

    private void enterEmail()
    {
        final By id = By.id("email");
        clickElement(id);
        sendKeysToElement(id,"doliX12345@gmail.com");
    }

    private void enterSenderName()
    {
        sendKeysToElement(By.xpath( "//input[@placeholder='שם שולח המתנה']"), "shir");
        Assert.assertEquals(getTextFromElement(By.xpath("//input[@class='ember-view ember-text-field'")) ,"Doli");
    }

    private void pressSave()
    {
      clickElement(By.xpath("//button[@type='submit']"));
    }
}
