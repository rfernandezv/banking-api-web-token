/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.user.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users/")
public class UserController {
    
    
  @RequestMapping("")
  public @ResponseBody String getUsers() {
    return "{\"users\":[{\"firstname\":\"Richar\", \"lastname\":\"Fernandez\"}" ;
  }
}
