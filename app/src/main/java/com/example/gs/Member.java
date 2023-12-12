package com.example.gs;

public class Member {
    private int id;
    private String username;

    public Member(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}

