package com.luvcode.demo.rest;

public class StudentErrorResponse {

    private int status;
    private String message;

    private long timeStamp;

    public StudentErrorResponse(){

    }
    public StudentErrorResponse(int status, String message, long timsStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timsStamp;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timsStamp) {
        this.timeStamp = timsStamp;
    }


}
