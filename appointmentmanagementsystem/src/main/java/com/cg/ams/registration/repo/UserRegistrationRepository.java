package com.cg.ams.registration.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ams.registration.entity.UserRegistration;


/**
 * @author Arpan Adhikary AADHIKAR
 *interface for User Registration repository
 *
 */

@Repository
public interface UserRegistrationRepository extends CrudRepository<UserRegistration, Integer>{
	
	
	@Query(value="select public.useradmin_inserts(?1,?2,?3,?4,?5,?6)",nativeQuery=true)
	public int insertUsers(String emailId,String mobileNo,String name,String userName,
						   String role,String password);

@Query(value="call public.useradmin_delete(?1,0)",nativeQuery=true)
public int deleteUsers(int userId);
}