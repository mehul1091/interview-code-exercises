package org.self.lld.ratelimiter.slidingwindow;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


//https://arpitbhayani.me/blogs/sliding-window-ratelimiter

// @1.2CR Perplexity Space === Pending Export as MD file


public class RateLimiter {


    // Nested map to store counts: Map<Key, Map<Timestamp, Count>>
    private Map<String, Map<Long, Integer>> requestsStore;

    public RateLimiter(Map<String, Map<Long, Integer>> requestsStore) {
        this.requestsStore = requestsStore;
    }


    // Stub methods for illustration (replace with actual implementations)
    private RateLimitConfig getRateLimitConfig(String key) {
        // Fetch rate limit config for the key. Return dummy for now.

        //to be fetched from NoSQL key-value store

        return new RateLimitConfig(1, 5); // Example: 1 sec window, 5 reqs allowed
    }

    // Assume these methods exist in the class or accessible services:
    // RateLimitConfig getRateLimitConfig(String key)
    // Window getCurrentWindow(String key, long startTime)
    // void registerRequest(String key, long timestamp)

    public boolean isAllowed(String key) {
        // Get current Unix time in seconds
        long currentTime = Instant.now().getEpochSecond();

        // Fetch the rate limit configuration for the key
        RateLimitConfig config = getRateLimitConfig(key);
        if (config == null) {
            // Handle missing config, here we allow by default or decide policy
            return true;
        }

        // Determine the start time of the sliding window
        long startTime = currentTime - config.getTimeWindowSec();

        // Get current sliding window data with number of requests
        Window window = getCurrentWindow(key, startTime);

        // If request count exceeds capacity, reject the request
        if (window.getNumberOfRequests() > config.getCapacity()) {
            return false;
        }

        // Register the current request as it is allowed
        registerRequest(key, currentTime);

        return true;
    }


    private Window getCurrentWindow(String key, long startTime) {
        // Retrieve current number of requests since startTime. Return dummy for now.
        Map<Long, Integer> tsData = requestsStore.get(key);
        if (tsData == null) {
            return new Window(0);
        }

        // Remove entries where timestamp <= startTime
        tsData.entrySet().removeIf(entry -> entry.getKey() <= startTime);

        // Sum counts using stream
        return new Window(tsData.values().stream().mapToInt(Integer::intValue).sum());

    }


    public void registerRequest(String key, long ts) {

        // Increment request count for the key at timestamp. Implement accordingly.
        // Get or create the inner map for the key
        Map<Long, Integer> timestampCounts = requestsStore.computeIfAbsent(key, k -> new HashMap<>());

        // Increment the count for the timestamp or initialize it to 1 if not present
        timestampCounts.put(ts, timestampCounts.getOrDefault(ts, 0) + 1);
    }

}
