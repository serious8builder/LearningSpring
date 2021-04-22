package com.example.accessingdatamysql.config;


import lombok.Getter;

@Getter
public enum CacheType {

    USER("user", 20, 100);

    CacheType(String cacheName, int expiredAfterWrite, int maximumSize) {
        this.cacheName = cacheName;
        this.expiredAfterWrite = expiredAfterWrite;
        this.maximumSize = maximumSize;
    }

    private String cacheName;
    private int expiredAfterWrite;
    private int maximumSize;

}
