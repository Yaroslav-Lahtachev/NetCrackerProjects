package com.lahtachev.objects;

import java.util.concurrent.atomic.AtomicLong;

public class Beer {
    private static AtomicLong count = new AtomicLong(0);
    private boolean isLight;

    public Beer() {
        count.incrementAndGet();
    }

    public String toString() {
        return "A new " + (isLight ? "Light" : "Dark") + " Beer, count(" + count.get() + ")";
    }

    public void setIsLight(boolean light) {
        isLight = light;
    }
}

