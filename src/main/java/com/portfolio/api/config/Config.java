package com.portfolio.api.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        String env = System.getProperty("env", "dev");
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(env + ".properties")) {
            if (in != null) props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String baseUrl()  { return props.getProperty("base.url",  "https://api.example.com"); }
    public static String authUser() { return props.getProperty("auth.user", "test@example.com"); }
    public static String authPwd()  { return props.getProperty("auth.pwd",  "test"); }
}
