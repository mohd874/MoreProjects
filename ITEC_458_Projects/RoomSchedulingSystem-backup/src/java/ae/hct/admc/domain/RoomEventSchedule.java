/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ae.hct.admc.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name="room_event_schedule")
public class RoomEventSchedule extends BaseEntity {

    @JoinColumn(name = "from_time", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private Period fromTime;
    
    @JoinColumn(name = "to_time", referencedColumnName = "id", nullable = true)
    @ManyToOne
    private Period toTime;
    
    @Column(name="schedule_date")
    @Temporal(TemporalType.DATE)
    private Date scheduledDate;

    @JoinColumn(name = "event", referencedColumnName = "id")
    @ManyToOne
    private Event event;
    
    @JoinColumn(name = "room", referencedColumnName = "id")
    @ManyToOne
    private Room room;
    
    public Period getFromTime() {
        return fromTime;
    }

    public void setFromTime(Period fromTime) {
        this.fromTime = fromTime;
    }

    public Period getToTime() {
        return toTime;
    }

    public void setToTime(Period toTime) {
        this.toTime = toTime;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
