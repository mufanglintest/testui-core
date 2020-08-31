package com.jorge.testui;

import com.acooly.core.common.BootApp;
import com.acooly.core.common.boot.Apps;
import org.springframework.boot.SpringApplication;

/**
 * @author acooly
 */
@BootApp(sysName = "jorge-testui", httpPort = 8999)
public class Main {
    public static void main(String[] args) {
        Apps.setProfileIfNotExists("dev");
        new SpringApplication(Main.class).run(args);
    }
}