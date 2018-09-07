package com.d3vw3b;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HelloWorld {

    public static void main(String[] args) {
        final DriverService driverService = new DriverService();
        driverService.startService();

        final ChromeOptions options = configureChromeOptions();
        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        final WebDriver driver =
                new RemoteWebDriver(driverService.getService().getUrl(), capabilities);

        driver.get("http://www.google.com/xhtml");

        try {
            Thread.sleep(5000);  // Let the user actually see something!
        } catch (InterruptedException e) {
            // nothing
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement logo = driver.findElement(By.id("hplogo"));
        final String logoAltText = logo.getAttribute("alt");
        System.out.println("Google logo alt text: " + logoAltText);

        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();

        System.out.println("JUST DID SOME WEB DRIVIN MY DOODS~");

        try {
            Thread.sleep(5000);  // Let the user actually see something!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
        driverService.stopService();
    }

    private static ChromeOptions configureChromeOptions() {
        final ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--no-sandbox");

        return options;
    }

    private static void setupDriverSystemPath() {
        final DriverService driverSetup = new DriverService();
        driverSetup.startService();
    }
}
