package com.example.Entity;

public enum Role {
    USER("STUDENT"),
    USER2("TEACHER"),
    ADMIN("ADMIN");
    public String displayValue;

    Role(String displayValue){
        this.displayValue = displayValue;
    }

}
