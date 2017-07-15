package com.github.dolphin.client.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ste7en.liu@gmail.com
 * @version 1.0.0
 * @since 2017/7/9
 */
public class NamedThreadFactory implements ThreadFactory {

    private static final AtomicInteger POOL_SEQ = new AtomicInteger(1);
    private final AtomicInteger threadNum = new AtomicInteger(1);
    private final String prefix;
    private final boolean daemon;
    private final ThreadGroup threadGroup;

    public NamedThreadFactory() {
        this("pool-" + POOL_SEQ.getAndIncrement());
    }

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }

    public NamedThreadFactory(String prefix, boolean daemon) {
        this.prefix = prefix + "-thread-";
        this.daemon = daemon;
        SecurityManager manager = System.getSecurityManager();
        threadGroup = (manager == null) ?
                Thread.currentThread().getThreadGroup() : manager.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = prefix + threadNum.getAndIncrement();
        Thread thread = new Thread(threadGroup, runnable, name, 0);
        thread.setDaemon(daemon);
        return thread;
    }

    public ThreadGroup getThreadGroup() {
        return threadGroup;
    }
}
