package com.example.domin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRreposity extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, PagingAndSortingRepository<User,String> {
    @Query("select u from User u where u.name='tom1'")
    List<User> findAllUser();
    @Query("select u from User u where u.id=:id")
    public User findUserById(@Param("id")int id);
    
    @Modifying
    @Query("update User set name=:name where id=:id")
    public void upUser(@Param("name")String name,@Param("id")int id);
    
    List<User> findByNameAndPassword(@Param("name") String name,@Param("password")String password);
    
}
