package com.github.dolphin.client.event;

/**
 * @author ste7en.liu@gmail.com
 * @version 1.0.0
 * @since 2017/7/9
 */
public interface ConfigurationListener {

    /**
     *
     * @param event
     */
    void configurationChanged(ConfigurationEvent event);
}
