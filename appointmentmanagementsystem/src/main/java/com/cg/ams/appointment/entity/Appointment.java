package com.cg.ams.appointment.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.cg.validation.message.ValidationMessage;


/** class to map with appointment table  
 * fields are validated with not null or not blank    
 */

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int appointmentId;
	
	@NotNull(message = ValidationMessage.NULLUSERID)
	@Column(name = "user_id")
	private int userId;
	
	@NotNull(message = ValidationMessage.NULLCREATORID)
	@Column(name = "creator_user_id")
	private int creatorId;
	
	@NotBlank(message = ValidationMessage.BLANKDATE)
	@Column(name = "appointment_date")
	private String date;
	
	@NotBlank(message = ValidationMessage.BLANKTIME)
	@Column(name = "appointment_time")
	private String time;
	
	@NotNull(message = ValidationMessage.NULLDESCRIPTION)
	@Column(name = "description")
	private String description;

	@Column(name="flag")
	private Integer flag;
	
	public Appointment(int appointmentId,
			 int userId,
			 int creatorId,
			 String date,
			 String time,
			String description) {
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.creatorId = creatorId;
		this.date = date;
		this.time = time;
		this.description = description;
	}
	public Appointment(int appointmentId,
			 int userId,
			 int creatorId,
			 String date,
			 String time,
			String description,Integer flag) {
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.creatorId = creatorId;
		this.date = date;
		this.time = time;
		this.description = description;
		this.flag=flag;
	}

	
	public Appointment() {
		super();
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", userId=" + userId + ", creatorId=" + creatorId
				+ ", date=" + date + ", time=" + time + ", description=" + description + "]";
	}

	

}	

