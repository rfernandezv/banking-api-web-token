/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.user.api.controller;

import banking.user.domain.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users/")
public class UserController {
    
    
  //@RequestMapping("")
  @RequestMapping(method = RequestMethod.GET, path = "listado", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
  public @ResponseBody String getUsers() {
    return "{\"users\":[{\"firstname\":\"Richar\", \"lastname\":\"Fernandez\"}" ;
  }
  
  @RequestMapping("/listado2")
  public @ResponseBody String getUsersListado2() {
    return "{\"users\":[{\"firstname\":\"Richar\", \"lastname\":\"Fernandez\"}" ;
  }
  
  @PostMapping("/listado3")
  public @ResponseBody String getUsersListado3() {
    return "{\"users\":[{\"firstname\":\"Richar\", \"lastname\":\"Fernandez\"}" ;
  }
  
  @GetMapping("/getcustomer")
  public @ResponseBody String getAllCustomer() {
    return "{\"users\":[{\"firstname\":\"Richar\", \"lastname\":\"Fernandez\"}" ;
  }
  
  @GetMapping("/getAllUsers")
  public List<User> getAllUsers() {
    List<User> lista = new ArrayList();
    User usuario = new User();
    usuario.setUsername("richar");
    usuario.setPassword("richar");
    usuario.setEmail("richar@rfv.com");
    lista.add(usuario);
    return lista;
  }
}
