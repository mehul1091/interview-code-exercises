package org.self.lld.ratelimiter.slidingwindow;

// Example supporting classes
public class RateLimitConfig {
    private int timeWindowSec;
    private int capacity;

    public RateLimitConfig(int timeWindowSec, int capacity) {
        this.timeWindowSec = timeWindowSec;
        this.capacity = capacity;
    }

    public int getTimeWindowSec() {
        return timeWindowSec;
    }

    public int getCapacity() {
        return capacity;
    }
}
