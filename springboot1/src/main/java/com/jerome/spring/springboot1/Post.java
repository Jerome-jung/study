package com.jerome.spring.springboot1;

import java.util.Date;

public class Post {
    private String id;
    private String name;
    private String address;
    private String content;
    private String title;
    private Date created_at;
    private Date updated_at;

    public Post() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
