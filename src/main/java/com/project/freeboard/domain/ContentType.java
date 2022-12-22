package com.project.freeboard.domain;

public enum ContentType {
    TYPE_JSON("TYPE_JSON"),
    TYPE_STRING("TYPE_STRING");

    private String type;


    ContentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
