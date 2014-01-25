package ae.iemq.vims.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "meeting_agenda")
@NamedQueries({
	@NamedQuery(name = "AgendaItem.allAgendaItems", query = "from AgendaItem")
})
public class AgendaItem extends BaseEntity {
	
	@JoinColumn(name = "meeting", referencedColumnName = "id")
	@ManyToOne
	private Meeting meeting;		
	
	@Column(name = "start_time")
	private String startTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "topic")
	private String topic;

	public Meeting getMeeting() {
		return meeting;
	}

	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}



	@Override
	public String toString() {
		return topic + ", starting "+ startTime + ", ending "+endTime;
	}
}
