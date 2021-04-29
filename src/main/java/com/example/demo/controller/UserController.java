package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/POST/param")
    public User saveUserParam(@RequestParam("username")String name, @RequestParam("password")String password,@RequestParam("company")String company,@RequestParam("email")String email, @RequestParam("phone")String phone, @RequestParam("address")String address, @RequestParam("useroleid")String roleid,@RequestParam("softdelete")String softdelete){
       User user=new User(name,password,email,address,phone,company,roleid,softdelete);
    return repository.save(user);
    }

    @PostMapping("/POST/{username}/{password}/{email}/{address}/{phone}/{company}/{useroleid}/{softdelete}")
    public User saveUserPath(@PathVariable("username")String name, @PathVariable("password")String password,@PathVariable("email")String email, @PathVariable("address")String address, @PathVariable("phone")String phone, @PathVariable("company")String company,@PathVariable("useroleid")String roleid,@PathVariable("softdelete")String softdelete){
        User user=new User(name,password,email,address,phone,company,roleid,softdelete);
       return repository.save(user);
    }
    
    @PostMapping("/POST")
    public User saveUser(@RequestBody User reqUser) {
        return repository.save(reqUser);
    }

    @GetMapping("/GET/all")
    public List<User> getAllUser(){
        return repository.findAll();
    }


    @GetMapping("/GET/useroleid/{useroleid}")
    public List<User> getById(@PathVariable("useroleid")String id){
        return repository.selectUserByroleId(id,"no");
    }

    @PutMapping("/PUT/id/{id}")
    public User overrideUser(@PathVariable("id")int id,@RequestBody User reqUser) throws UserNotFoundException {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return repository.save(reqUser);
    }

  
    @DeleteMapping("/DELETE/id/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")int id)throws UserNotFoundException{
        User user=repository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        repository.delete(user);
        return ResponseEntity.ok().build();
    }
}
