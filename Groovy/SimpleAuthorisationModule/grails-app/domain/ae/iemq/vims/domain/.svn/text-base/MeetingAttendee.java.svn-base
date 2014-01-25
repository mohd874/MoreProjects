package ae.iemq.vims.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "meeting_attendee")

public class MeetingAttendee extends BaseEntity {

	@JoinColumn(name = "meeting", referencedColumnName = "id")
	@ManyToOne
	private Meeting meeting;	
	
	@JoinColumn(name = "attendee", referencedColumnName = "id")
	@ManyToOne
	private Employee attendee;
	
	/**
	 * This constructor is used to map the many to many relationship
	 * betweeen meeting and employee(attendee).
	 * @param attendee
	 * @param meeting
	 */
	public MeetingAttendee(Employee attendee, Meeting meeting) {
		this.attendee = attendee;
		this.meeting = meeting;
	}
	/*
	 * test for deleting employees(non-Javadoc)
	 * 
	 */
	public MeetingAttendee(){

	}
			
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MeetingAtendee";
	}


	public Employee getAttendee() {
		return attendee;
	}


	public void setAttendee(Employee atendee) {
		this.attendee = atendee;
	}


	public Meeting getMeeting() {
		return meeting;
	}


	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	

}
