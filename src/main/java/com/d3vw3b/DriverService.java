package com.d3vw3b;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;

public class DriverService {

    private static ChromeDriverService service;

    public void startService() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("chromedriver"))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopService() {
        service.stop();
    }

    public ChromeDriverService getService() {
        return service;
    }
}
