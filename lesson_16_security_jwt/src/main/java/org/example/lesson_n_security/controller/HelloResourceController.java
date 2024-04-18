package org.example.lesson_n_security.controller;

import org.example.lesson_n_security.model.AuthenticationRequest;
import org.example.lesson_n_security.model.AuthenticationResponse;
import org.example.lesson_n_security.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResourceController {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private UserDetailsService userDetailsService;
  @Autowired
  private JwtUtils jwtUtils;

  @RequestMapping("/hello")
  public String hello(){
    return "hello";
  }

  @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
  public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
    } catch (BadCredentialsException ex) {
      throw new RuntimeException("Incorrect credentials", ex);
    }
    UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    String token = jwtUtils.generateToken(userDetails);
    System.out.println(token);
    return ResponseEntity.ok(new AuthenticationResponse(token));
  }
}
