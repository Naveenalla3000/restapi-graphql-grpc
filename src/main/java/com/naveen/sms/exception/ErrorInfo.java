package com.naveen.sms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {
    private LocalDateTime timeStamp;
    private  String message;
    private String url;
    private String validationMessage;
}