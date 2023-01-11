package com.lhu.corsconfig.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cors-config")
// @CrossOrigin(origins = "http://localhost:4201,http://localhost:4444")
public class CorsController {

  @GetMapping("test/get")
  public ResponseEntity<String> testMethodWithGet(
      @RequestHeader(name = "clientId") String clientId,
      @RequestParam(name = "id", defaultValue = "") String id) {
    return ResponseEntity.ok(
        "CORS-test-get.ClientId from RequestHeader : "
            + clientId
            + " ,id from RequestParam : "
            + id);
  }

  @PostMapping("test/post")
  // @CrossOrigin(origins = "http://localhost:4200")
  public ResponseEntity<String> testMethodPost(
      @RequestHeader(name = "clientId") String clientId,
      @RequestParam(name = "id", defaultValue = "") String id) {
    return ResponseEntity.ok(
        "CORS-test-post.ClientId from RequestHeader : "
            + clientId
            + " ,id from RequestParam : "
            + id);
  }
}
