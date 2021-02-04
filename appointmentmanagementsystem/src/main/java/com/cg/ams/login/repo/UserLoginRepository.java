package com.cg.ams.login.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.login.entity.UserLogin;


/**
 * @author Arpan Adhikary AADHIKAR
 *interface for login repository
 *
 */

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer>{

	public UserLogin findAllByUsernameAndPassword(String username,String Password);
}
