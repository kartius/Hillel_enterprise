package org.hillel.spring_mvc.exception;

public class RandomHillelException extends RuntimeException{

  public RandomHillelException(String message) {
    super(message);
  }

  public RandomHillelException(String message, Throwable cause) {
    super(message, cause);
  }
}
