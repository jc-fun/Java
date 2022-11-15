package com.urain.qqzone.pojo;

import java.time.LocalDateTime;

/**
 * @Author: supertain
 * @Date: 2022/4/11 14:25
 * @Description:
 */
public class HostReply {
    private Integer id;
    private String content;
    private LocalDateTime hostReplyDate;
    private UserBasic author;  //M:1
    private Reply reply;  //1:1

    public HostReply() {
    }

    public HostReply(String content, LocalDateTime hostReplyDate, UserBasic author, Reply reply) {
        this.content = content;
        this.hostReplyDate = hostReplyDate;
        this.author = author;
        this.reply = reply;
    }

    public HostReply(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(LocalDateTime hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
