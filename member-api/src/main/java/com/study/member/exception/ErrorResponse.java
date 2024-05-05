package com.study.member.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(
        String message,
        HttpStatus httpStatus
) {

    public static ErrorResponse fromErrorCode(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getMessage(), errorCode.getHttpStatus());
    }
}

