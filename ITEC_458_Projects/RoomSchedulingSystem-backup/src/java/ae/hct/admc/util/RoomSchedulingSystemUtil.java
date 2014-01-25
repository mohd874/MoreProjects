/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ae.hct.admc.util;

import ae.hct.admc.actionFormBeans.RoomScheduleActionBean;
import ae.hct.admc.domain.Period;
import ae.hct.admc.domain.Room;
import ae.hct.admc.domain.RoomClassScedule;
import ae.hct.admc.domain.Semester;
import ae.hct.admc.service.HibernateService;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Saeed
 */
public class RoomSchedulingSystemUtil {

    public static void getCurrentScheduleForRoom(int semesterWeek, HttpServletRequest request) {
        Semester semester = HibernateService.getCurrentSemester();
        getScheduleForRoom(semester,semesterWeek, request);
    }

    public static void getScheduleForRoom(Semester semester, int semesterWeek, HttpServletRequest request) {
        
        Room room = HibernateService.getRoomById(Integer.parseInt(request.getParameter("room")));
        
        List<Period> periods = getPeriodsForSemesterRoom(semester, room, semesterWeek);
        
        Object[] objs = new Object[6];

//            LOG.debug("periods: "+periods);
//            LOG.debug("objs: "+objs);

        request.setAttribute("periods", periods);
        request.setAttribute("objs", objs);
        request.setAttribute("room", room.getId());
        request.setAttribute("roomObj", room);
        request.setAttribute("semester", semester.getId());
        request.setAttribute("semesterWeek", semesterWeek);
    }
    
    public static void getScheduleForRoom(Semester semester, Room room, int semesterWeek, HttpServletRequest request) {
        
        List<Period> periods = getPeriodsForSemesterRoom(semester, room, semesterWeek);
        
        Object[] objs = new Object[6];

//            LOG.debug("periods: "+periods);
//            LOG.debug("objs: "+objs);

        request.setAttribute("periods", periods);
        request.setAttribute("objs", objs);
        request.setAttribute("roomObj", room);
    }
    
    public static List<Period> getPeriodsForSemesterRoom(Semester semester, Room room, int semesterWeek) {
        List<Period> periods = HibernateService.getAllPeriods();
        
        for (Period period : periods) {
            period.getClassSchedules().clear();
            period.getClassSchedules().addAll(HibernateService.getClassSchedule(
                    period, semester, semesterWeek, room));
        }
        return periods;
    }
    
}
