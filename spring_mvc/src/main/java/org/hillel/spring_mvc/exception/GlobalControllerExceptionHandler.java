package org.hillel.spring_mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {


  @ExceptionHandler(RandomHillelException.class)
  public ErrorBody handleCustomException(Exception e) {
    System.out.println("We have a problem!" +e.getMessage());
    e.printStackTrace();
    return new ErrorBody("custom_error", "custom_details");
  }


//  @ExceptionHandler(Exception.class)
//  public ResponseEntity<ErrorBody> handleGlobalException(Exception e) {
//    System.out.println("We have a problem!" +e.getMessage());
//    e.printStackTrace();
//    return new ResponseEntity<>(new ErrorBody("custom_error", "custom_details"), HttpStatus.INTERNAL_SERVER_ERROR);
//  }




  static class ErrorBody {
    private String errorName;
    private String errorDetails;

    public ErrorBody(String errorName, String errorDetails) {
      this.errorName = errorName;
      this.errorDetails = errorDetails;
    }

    public String getErrorName() {
      return errorName;
    }

    public String getErrorDetails() {
      return errorDetails;
    }
  }
}
