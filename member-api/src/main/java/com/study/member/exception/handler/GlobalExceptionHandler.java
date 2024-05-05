package com.study.member.exception.handler;

import com.study.common.exception.CommonErrorCode;
import com.study.common.exception.CommonErrorResponse;
import com.study.common.exception.CommonException;
import com.study.common.exception.FeignException;
import com.study.member.exception.ErrorCode;
import com.study.member.exception.ErrorResponse;
import com.study.member.exception.MemberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CommonException.class)
    protected ResponseEntity<CommonErrorResponse> handleCommonException(CommonException e) {
        CommonErrorCode errorCode = e.getCommonErrorCode();
        CommonErrorResponse errorResponse = CommonErrorResponse.fromErrorCode(errorCode);
        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
    }

    @ExceptionHandler(FeignException.class)
    protected ResponseEntity<CommonErrorResponse> handleFeignException(FeignException e) {
        CommonErrorResponse errorResponse = e.getCommonErrorResponse();
        return new ResponseEntity<>(errorResponse, errorResponse.httpStatus());
    }

    @ExceptionHandler(MemberException.class)
    protected ResponseEntity<ErrorResponse> handleMemberException(MemberException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = ErrorResponse.fromErrorCode(errorCode);
        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
    }
}
