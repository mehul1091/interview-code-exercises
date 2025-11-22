package org.self.lld.ratelimiter.slidingwindow;

public class Window {
    private int numberOfRequests;

    public Window(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public int getNumberOfRequests() {
        return numberOfRequests;
    }
}
