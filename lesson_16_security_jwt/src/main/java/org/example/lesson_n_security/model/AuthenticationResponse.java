package org.example.lesson_n_security.model;

public class AuthenticationResponse {
  private final String jwt;

  public AuthenticationResponse(String jwt) {
    this.jwt = jwt;
  }

  public String getJwt() {
    return jwt;
  }
}
