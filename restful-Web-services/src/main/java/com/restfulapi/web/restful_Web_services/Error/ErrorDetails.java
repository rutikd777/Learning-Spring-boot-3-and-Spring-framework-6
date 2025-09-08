package com.restfulapi.web.restful_Web_services.Error;

//import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timeStamp;
    private String msg;
    private String details;

    public ErrorDetails(LocalDateTime timeStamp, String msg, String details) {
        this.timeStamp = timeStamp;
        this.msg = msg;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMsg() {
        return msg;
    }


    public String getDetails() {
        return details;
    }

}
