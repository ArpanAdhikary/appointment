package com.cg.ams.appointment.repo;

//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.cg.ams.appointment.entity.Appointment;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Arpan Adhikary AADHIKAR
 *interface for Appointment repository
 *
 */

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{
	
	/** function to find appointment by date and time  **/
	public List<Appointment> findAllByDateAndTime(String date,String time);

	/** function to find appointment by user id **/
	public List<Appointment> findAllByUserId(Integer userId);
	

	/** function to delete on basis of appointment id and user id  **/
	@Transactional
	@Query(value="call public.appointment_deletes(?1,?2,0)",nativeQuery=true)
	public int deleteByUserId(Integer userId,Integer appointmentId);
	
	/** function to update appointment  **/
	@Transactional
	@Query(value="call public.appointment_update(?1,?2,?3,?4,?5,?6,0)",nativeQuery=true)
	public int updateAppointment(Integer appointmentId,Integer userId,Integer creatorId,String date,String time,String description);
	
	/** function to book appointment  **/
	@Query(value="call public.appointment_insert(?1,?2,?3,?4,?5,0)",nativeQuery=true)
	public int insertAppointment(Integer creatorId,String date,String time,String description,Integer userId);
	
}
