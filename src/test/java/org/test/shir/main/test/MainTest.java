package org.test.shir.main.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.test.shir.main.logic.DriverChromeSingleton;
import org.test.shir.main.logic.DriverChromeSingleton2;
import org.test.shir.main.logic.DriverMozillaSinglton;
import org.test.shir.main.logic.DriverMozillaSinglton2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainTest
{
    public static WebDriver driver;
    public static WebDriver driver2;
    public static String driverUrl;
    public static String driver2Url;
    private static String browserType;
    private static String browser2Type;

    private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("BuyMeTest", "BuyMeTesting");

    @BeforeClass
    public static void runOnceBeforeClass() throws ParserConfigurationException, IOException, SAXException
    {
        getTestParameters();
        if("webdriver.chrome.driver".equals(browserType))
            driver = DriverChromeSingleton.getDriverInstance();
        else if("webdriver.gecko.driver".equals(browserType))
            driver = DriverMozillaSinglton.getDriverInstance();
            driver.get(driverUrl);
        if("webdriver.chrome.driver".equals(browser2Type))
            driver2 = DriverChromeSingleton2.getDriverInstance();
        else if("webdriver.gecko.driver".equals(browser2Type))
            driver2 = DriverMozillaSinglton2.getDriverInstance();

        driver2.manage().window().maximize();
        driver2.get(driver2Url);


        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("D:\\User\\Desktop\\qa\\SeleniumHandsOn\\SeleniumHandsOn\\screenshot\\extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before all test");

    }

    public static void getTestParameters() throws ParserConfigurationException, IOException, SAXException
    {
        File fXmlFile = new File("D:\\User\\Desktop\\qa\\SeleniumHandsOn\\SeleniumHandsOn\\src\\main\\resources\\data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        driverUrl = doc.getElementsByTagName("URL").item(0).getTextContent();
        driver2Url = doc.getElementsByTagName("URL2").item(0).getTextContent();
        browserType = doc.getElementsByTagName("browserType").item(0).getTextContent();
        String browserTypePath = doc.getElementsByTagName("browserTypePath").item(0).getTextContent();
        browser2Type = doc.getElementsByTagName("browser2Type").item(0).getTextContent();
        String browserType2Path = doc.getElementsByTagName("browserType2Path").item(0).getTextContent();
        System.setProperty(browserType, browserTypePath);
        if(!browser2Type.equals(browserType))
        {
            System.setProperty(browser2Type, browserType2Path);

        }
    }

    @Test()
    public void test01()
    {
       RegistrationBuyMe RegistrationBuyMe = new RegistrationBuyMe();
       RegistrationBuyMe.login();
       driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void test02()
    {
        HomeScreen homeScreen;
        homeScreen = new HomeScreen(DriverChromeSingleton2.getDriverInstance());
        homeScreen.login();
    }

    @Test(priority = 3)
     public void test03()
    {
        PickBusiness pickBusiness;
        pickBusiness = new PickBusiness(DriverChromeSingleton2.getDriverInstance());
        pickBusiness.processTest();
    }

    @Test(priority = 4)
    public void test04()
    {
        SenderAndReciver senderAndReciver= new SenderAndReciver(DriverChromeSingleton2.getDriverInstance());
        senderAndReciver.senderAndReciver();
    }

    @AfterClass
    public static void tearDown()
    {
      driver.quit();
      driver2.quit();
   }

}
