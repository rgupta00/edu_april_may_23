package com.demo;

public class Foo {

    private String message;

    public  Foo(){
        System.out.println("foo ctr");
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
