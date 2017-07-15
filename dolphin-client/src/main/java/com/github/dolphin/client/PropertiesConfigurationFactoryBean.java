package com.github.dolphin.client;

import org.springframework.beans.factory.FactoryBean;

import java.util.Properties;

/**
 * @author ste7en.liu@gmail.com
 * @version 1.0.0
 * @since 2017/7/14
 */
public class PropertiesConfigurationFactoryBean implements FactoryBean<Properties> {

    public Properties getObject() throws Exception {
        return null;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
