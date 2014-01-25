package ae.iemq.vims.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "meeting")
@NamedQueries( { @NamedQuery(name = "Meeting.meeting", query = "from Meeting order by createDateTime") })
public class Meeting extends BaseEntity {

	@Column(name = "start_time")
	private String startTime;
	
	
	@OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<MeetingAttendee> attendees;
	
	
	@OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<AgendaItem> agendaItems;
	
	@Column(name = "end_time")
	private String endTime;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "location")
	private String location;

	@Column(name = "meeting_type")
	private String meetingType;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMeetingType() {
		return meetingType;
	}

	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Set<AgendaItem> getAgendaItems() {
		return agendaItems;
	}

	public void setAgendaItems(Set<AgendaItem> agendas) {
		this.agendaItems = agendas;
	}

	public void addAgendaItem(AgendaItem agendaItem) {
		if (agendaItems == null)
			agendaItems = new LinkedHashSet<AgendaItem>();

		agendaItems.add(agendaItem);
	}

	@Override
	public String toString() {
		return location + ", starting " + startTime + ", ending " + endTime;
	}

	public Set<MeetingAttendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<MeetingAttendee> attendees) {
		this.attendees = attendees;
	}

}
