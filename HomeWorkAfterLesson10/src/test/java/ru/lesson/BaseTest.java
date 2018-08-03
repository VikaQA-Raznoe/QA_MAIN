package ru.lesson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.lesson.utills.PropertyHelper;
import java.util.concurrent.TimeUnit;

abstract public class BaseTest {
    public static int implicitWaitTimeout = 10;
    public static int explicitWaitTimeout = 10;
    public static ThreadLocal<WebDriver> driverContainer = new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> waitContainer = new ThreadLocal<>();

    public static WebDriver createFirefoxDriver (){
        driverContainer.set(new FirefoxDriver());
        return driverContainer.get();
    }


    //Запуск теста в Chrome без мордочки
    public static WebDriver createChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        if(System.getProperty("webdriver.chrome.headless")!=null && System.getProperty("webdriver.chrome.headless").equals("on")){
            options.addArguments("--headless");
        }
        driverContainer.set(new ChromeDriver(options));
        return driverContainer.get();
    }

    public static WebDriver createOperaDriverWithHeadless(){
        OperaOptions oo = new OperaOptions();
        //Пример использования драйвера, когда драйвер на диске, а не в проекте
        oo.setBinary("C:\\Program Files\\Opera\\52.0.2871.40\\opera.exe");
        driverContainer.set(new OperaDriver(oo));
        return driverContainer.get();
    }

    public static WebDriver createOperaDriver(){
        OperaOptions oo = new OperaOptions();
        //Пример использования драйвера, когда драйвер на диске, а не в проекте
        oo.setBinary("C:\\Program Files\\Opera\\52.0.2871.40\\opera.exe");
        driverContainer.set(new OperaDriver(oo));
        return driverContainer.get();
    }

    public static WebDriver createEdgeDriver(){
        driverContainer.set(new EdgeDriver());
        return driverContainer.get();
    }

    public static WebDriver getDriver(){
        if(driverContainer.get() == null){
            String value =  PropertyHelper.getProperty("application.properties","webdriver");
            if (value == null) value = "chrome";
            switch (value){
                case "chrome":
                    createChromeDriver();
                    break;
                case "firefox":
                    createFirefoxDriver();
                    break;
                case "opera":
                    createOperaDriver();
                    break;
                case "edge":
                    createEdgeDriver();
                    break;
                default:
                    createChromeDriver();
                    break;
            }
            waitContainer.set(new WebDriverWait(driverContainer.get(), explicitWaitTimeout));
            driverContainer.get().manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.SECONDS);
        }
        return driverContainer.get();
    }
    public static WebDriverWait getWait(){
        return waitContainer.get();
    }

    @BeforeClass
    public void prepare(){
        getDriver();
    }

    @AfterClass
    public void quit(){
        driverContainer.get().quit();
        driverContainer.set(null);
    }
}