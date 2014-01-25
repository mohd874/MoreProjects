/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ae.hct.admc.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name="period")
public class Period extends BaseEntity {

    @Column(name="period_segment")
    private String periodSegment;

    @OneToMany(mappedBy = "period", fetch=FetchType.EAGER)
    private Set<RoomClassScedule> classSchedules;
    
    public String getPeriodSegment() {
        return periodSegment;
    }

    public void setPeriodSegment(String periodSegment) {
        this.periodSegment = periodSegment;
    }

    public Set<RoomClassScedule> getClassSchedules() {
        return classSchedules;
    }

    public void setClassSchedules(Set<RoomClassScedule> classSchedule) {
        this.classSchedules = classSchedules;
    }
    
}
