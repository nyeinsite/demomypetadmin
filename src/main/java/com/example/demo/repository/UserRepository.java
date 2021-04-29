package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);

    @Query(value="select * from user where useroleid=? && softdelete=?",nativeQuery = true)
    public List<User> selectUserByroleId(String id,String softdelete);
    
    
}
