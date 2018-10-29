package framework;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BrowserFactory {

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();
    private static String exe = "";
    private static String dirDowlFileOnBrowser = "src/test/resources";
    private static final String driverPath = BrowserFactory.class.getClassLoader().getResource(getDriverName()).getPath();
    private static String nameBrowserDriver;
    private static String WEBDRIVERVER ;
    private static String path;
    private static String win = "win";
    private static String nux = "nux";
    private static String URL = "URL";

    private BrowserFactory(){};

    public static FirefoxOptions initFirFoxDriver() {
        String canonicalPathForDownload = getCanonicalPathToDriver(dirDowlFileOnBrowser);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", canonicalPathForDownload);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/x-debian-package, application/download, application/octet-stream");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return options;
    }

    public static DesiredCapabilities initChromeDriver() {
        String canonicalPathForDownload = getCanonicalPathToDriver(dirDowlFileOnBrowser);
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", canonicalPathForDownload);
        chromePrefs.put("safebrowsing.enabled", "true");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        return cap;
    }



    public static String getCanonicalPathToDriver(String pathTo){
        File file = new File(pathTo);
        try {
            path = file.getCanonicalPath();
        }catch (IOException e){
            logger.info("FIle not found");
        }
        return path;
    }

    public static String getDriverName() {
        switch (PropertyReader.getTestProperty("browser")) {
            case "chrome":
                nameBrowserDriver = "chromedriver";
                WEBDRIVERVER = "webdriver.chrome.driver";
                break;
            case "firefox":
                nameBrowserDriver = "geckodriver";
                WEBDRIVERVER = "webdriver.gecko.driver";
                break;
        }
        return nameBrowserDriver;
    }

    public static String getFileExtension(){
        if(OS.contains(win)){
            exe = ".exe";
        } else if(OS.contains(nux)){
            exe = exe;
        }
        return exe;
    }

    public static WebDriver getDriver(){
        if (driver == null){
            switch (getDriverName()) {
                case "chromedriver":
                    System.setProperty(WEBDRIVERVER, getCanonicalPathToDriver(driverPath) + getFileExtension());
                    driver = new ChromeDriver(initChromeDriver());
                    break;
                case "geckodriver":
                    System.setProperty(WEBDRIVERVER, getCanonicalPathToDriver(driverPath) + getFileExtension());
                    driver = new FirefoxDriver(initFirFoxDriver());
                    break;
            }
            driver.manage().window().maximize();
            driver.get(PropertyReader.getTestProperty(URL));
            logger.info("Browser started");
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
