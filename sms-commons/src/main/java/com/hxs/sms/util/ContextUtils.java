package com.hxs.sms.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;


public class ContextUtils {

    private static Properties props = null;

    static {
        props = new Properties();
        try {
            InputStream in = ContextUtils.class.getClassLoader()
                    .getResourceAsStream("resources.properties");
            props.load(in);
        } catch (Exception e) {
        }
    }

    /**
     * 获取配置文件配置信息
     *
     * @param propertiesName 配置节名称
     * @return String 配置节值
     */
    public static String getProperty(String propertiesName) {
        return props.getProperty(propertiesName);
    }

    /**
     * 获取配置文件配置信息
     *
     * @param propertiesName 配置节名称
     * @return String 配置节值
     */
    public static String getPropertyUTF8(String propertiesName) {
        String properties = getProperty(propertiesName);
        try {
            properties = new String(properties.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
