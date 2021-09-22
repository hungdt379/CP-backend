package com.example.cpbackend.apiresponse;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ApiResponse {
    ResponseObject responseObject;
    ResponseError responseError;
    ResponseArrayWithPaging responseArrayWithPaging;

    public ResponseEntity<?> successResponse(Object obj, String message, boolean success) {
        responseObject = new ResponseObject(obj, message, success);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    public ResponseEntity<?> errorResponse(String message, HttpStatus httpStatus, boolean success){
        responseError = new ResponseError(success, message);
        return new ResponseEntity<>(responseError, httpStatus);
    }


    public ResponseEntity<?> successResponseArrayWithPaging(List<?> list, String message, int pageIndex, int pageSize, int total, boolean success){
        responseArrayWithPaging = new ResponseArrayWithPaging(success,message, list, pageIndex, pageSize, total);
        return new ResponseEntity<>(responseArrayWithPaging, HttpStatus.OK);
    }
}
