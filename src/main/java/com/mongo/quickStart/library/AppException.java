package com.mongo.quickStart.library;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Slf4j
@ResponseStatus
public class AppException extends RuntimeException {
    private HttpStatus status;
    private String message;
    private LocalDateTime time;

    private String msgSuggestion;

    public AppException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
        this.time = time.now();
        log.error("[{}] {} request threw HttpStatus[{}] with message [{}]", time, status, message);
    }
    public AppException(HttpStatus status, String message, String msgSuggestion) {
        super(message);
        this.status = status;
        this.message = message;
        this.msgSuggestion = msgSuggestion;
        this.time = time.now();
        log.error("[{}] {} request threw HttpStatus[{}] with message [{}] and  message suggestion [{}]", time, status, message, msgSuggestion);
    }

}
