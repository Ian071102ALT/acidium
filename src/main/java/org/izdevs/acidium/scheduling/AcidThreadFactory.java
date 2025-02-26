package org.izdevs.acidium.scheduling;

import jakarta.validation.constraints.NotNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class AcidThreadFactory implements ThreadFactory {
    public static final AcidThreadFactory INSTANCE = new AcidThreadFactory();
    private final AtomicInteger threadCounter = new AtomicInteger();

    @Override
    public Thread newThread(@NotNull Runnable runnable) {
        return new Thread(runnable, "Acidium-scheduler-" + threadCounter.getAndIncrement());
    }
}
