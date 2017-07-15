package com.github.dolphin.client.event;

import com.github.dolphin.client.util.NamedThreadFactory;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ste7en.liu@gmail.com
 * @version 1.0.0
 * @since 2017/7/9
 */
public class EventSource {

    private Collection<ConfigurationListener> listeners;
    private ExecutorService executorService = Executors.newSingleThreadExecutor(new NamedThreadFactory("config-event"));

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     *
     * Initial listeners with COW(copy-on-write) container.
     */
    private void initialListeners() {
        listeners = new CopyOnWriteArrayList<>();
    }
}
