/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ae.hct.admc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name="event")
public class Event extends BaseEntity{
    
    @Column(name="description")
    private String description;
    
    @Column(name="event_type")
    private EventType eventType;
    
    @Column(name="login_name")
    private int NumberOfAttendees;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getNumberOfAttendees() {
        return NumberOfAttendees;
    }

    public void setNumberOfAttendees(int NumberOfAttendees) {
        this.NumberOfAttendees = NumberOfAttendees;
    }
    
    public enum EventType{
        Exam,Seminar,Confirance
    }
}
