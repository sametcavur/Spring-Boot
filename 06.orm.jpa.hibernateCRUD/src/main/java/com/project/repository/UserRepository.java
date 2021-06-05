package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	//Eğer CrudRepository interfacesinde bulunmayan hazır bir sorgu yoksa
	//O sorguyu alttaki gibi kendimiz oluşturabiliriz.
	
	@Query("SELECT u FROM User u WHERE userName= :userName")
	List<User> findByUserName(@Param(value = "userName") String userName);
	
}
