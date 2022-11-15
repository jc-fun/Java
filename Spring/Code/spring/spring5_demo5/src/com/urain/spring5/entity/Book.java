package com.urain.spring5.entity;

import java.time.LocalDateTime;

/**
 * @author: urain
 * @date: 2022/4/24 17:42
 * @description:
 * @version: 1.0
 */

public class Book {
    private String userId;
    private String username;
    private String ustatus;
    private LocalDateTime pubDate;

    public Book() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public LocalDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Book{" +
            "userId='" + userId + '\'' +
            ", username='" + username + '\'' +
            ", ustatus='" + ustatus + '\'' +
            ", pubDate=" + pubDate +
            '}';
    }
}
