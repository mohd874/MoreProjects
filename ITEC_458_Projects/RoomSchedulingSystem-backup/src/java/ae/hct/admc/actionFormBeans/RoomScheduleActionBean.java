/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ae.hct.admc.actionFormBeans;

import ae.hct.admc.domain.Course;
import ae.hct.admc.domain.Period;
import ae.hct.admc.domain.Room;
import ae.hct.admc.domain.RoomClassScedule;
import ae.hct.admc.domain.Semester;
import ae.hct.admc.domain.User;
import ae.hct.admc.service.HibernateService;
import ae.hct.admc.util.DateTimeUtil;
import ae.hct.admc.util.RoomSchedulingSystemUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Saeed
 */
public class RoomScheduleActionBean extends org.apache.struts.action.ActionForm {

    Logger LOG = Logger.getLogger(RoomScheduleActionBean.class);
    private String reservationWeeks;
    private int selectedCourse;
    private Integer semesterWeek;
    private Integer numberOfWeeksForSemester;
    private Integer semester;
    private Integer room;
    private List<Course> courses;
    private String[] periodDay;

    /**
     *
     */
    public RoomScheduleActionBean() {
        super();
    // TODO Auto-generated constructor stub
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        pageDebug(request);

        String action = request.getParameter("action");

        if ("Reserve".equalsIgnoreCase(action)) {
            if (reservationWeeks == null) {
                errors.add("reservationWeeks", new ActionMessage("error.roomSchedule.reservationWeeks.required"));
            }
            if (getSelectedCourse() == 0) {
                errors.add("course", new ActionMessage("error.roomSchedule.course.required"));
            }
            if (getPeriodDay() == null) {
                errors.add("period", new ActionMessage("error.roomSchedule.period.required"));
            }
            if (errors.size() == 0) {
                addReservation(request);
            }
        } else if ("Next Week >>".equalsIgnoreCase(action)) {
            setSemesterWeek(getSemesterWeek() + 1);
            request.setAttribute("semesterWeek", getSemesterWeek());
        } else if ("<< Prev Week".equalsIgnoreCase(action)) {
            setSemesterWeek(getSemesterWeek() - 1);
            request.setAttribute("semesterWeek", getSemesterWeek());
        }

        request.setAttribute("courses", HibernateService.getAllCourses());
//        if (request.getParameter("room") != null) {
        if (getRoom() != null) {
//            request.setAttribute("room", Integer.parseInt(request.getParameter("room")));
            request.setAttribute("room", getRoom());
        } else {
            request.setAttribute("room", 0);
            setRoom(0);
        }
        
        Semester currentSemester = null;
        if (getSemester() != null) {
            currentSemester = (Semester) HibernateService.getEntityById(Semester.class, getSemester());
        } else {
            currentSemester = HibernateService.getCurrentSemester();
        }
        
        request.setAttribute("semester", currentSemester.getId());
        setSemester(currentSemester.getId());
        
        if (getSemesterWeek() != null) {
            request.setAttribute("semesterWeek", getSemesterWeek());
        } else {
            setSemesterWeek(DateTimeUtil.getNumberOfWeeksBetweenDates(currentSemester.getDateFrom(),
                    new Date()));
            request.setAttribute("semesterWeek", getSemesterWeek());
        }
        if(getNumberOfWeeksForSemester() != null){
            request.setAttribute("numberOfWeeksForSemester", getNumberOfWeeksForSemester());
        }else{
            setNumberOfWeeksForSemester(currentSemester.getNumberOfWeeks());
            request.setAttribute("numberOfWeeksForSemester", currentSemester.getNumberOfWeeks());
        }
//        RoomSchedulingSystemUtil.getCurrentScheduleForRoom(request);
        RoomSchedulingSystemUtil.getScheduleForRoom(
                (Semester) HibernateService.getEntityById(Semester.class, getSemester()),
                (Room) HibernateService.getEntityById(Room.class, getRoom()),
                getSemesterWeek(),
                request);
        
        return errors;
    }

    public String getReservationWeeks() {
        return reservationWeeks;
    }

    public void setReservationWeeks(String reservationWeeks) {
        this.reservationWeeks = reservationWeeks;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public int getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(int selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    private void pageDebug(HttpServletRequest request) {
        LOG.debug("reservationWeeks: " + getReservationWeeks());
        LOG.debug("selectedCourse: " + getSelectedCourse());
        LOG.debug("courses: " + getCourses());
        LOG.debug("action: " + request.getParameter("action"));
        LOG.debug("room: " + getRoom());
        LOG.debug("semesterWeek: " + getSemesterWeek());
        LOG.debug("periodDay: " + getPeriodDay());
    }

    public String[] getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(String[] periodDay) {
        this.periodDay = periodDay;
    }

    public Integer getSemesterWeek() {
        return semesterWeek;
    }

    public void setSemesterWeek(Integer semesterWeek) {
        this.semesterWeek = semesterWeek;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    private void addReservation(HttpServletRequest request) {
        Semester semester = HibernateService.getSemesterById(Integer.parseInt(request.getParameter("semester")));
        Course course = (Course) HibernateService.getEntityById(Course.class, Integer.parseInt(request.getParameter("selectedCourse")));
        Room room = (Room) HibernateService.getEntityById(Room.class, Integer.parseInt(request.getParameter("room")));
        User user = (User) request.getSession().getAttribute("userSession");
        String semesterWeek = request.getParameter("semesterWeek");

        String[] periodDay = request.getParameterValues("periodDay");
        
        

        if ("ThisWeek".equalsIgnoreCase(getReservationWeeks())) {
            saveReservation(periodDay,course,semester,user,semesterWeek,room,request);
        } else {
            Date startDate = semester.getDateFrom();
            Date endDate = semester.getDateTo();
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            int week = 1;
            while(cal.getTime().before(endDate)){
                saveReservation(periodDay, course, semester, user, week, room, request);
                DateTimeUtil.addDaysToCalendar(cal, 7);
                week++;
            }
        }

    }

    private void saveReservation(String[] periodDay, Course course, Semester semester, User user, String semesterWeek, Room room, HttpServletRequest request) {
        saveReservation(periodDay, course, semester, user, Integer.parseInt(semesterWeek), room, request);
    }
    
    private void saveReservation(String[] periodDay, Course course, Semester semester, User user, int semesterWeek, Room room, HttpServletRequest request) {
        RoomClassScedule rcs = null;
        StringTokenizer st = null;
        for (String s : periodDay) {
                rcs = new RoomClassScedule();
                st = new StringTokenizer(s, "-");
                String periodId = st.nextToken();
                String dayOfWeek = st.nextToken();

                rcs.setCourse(course);
                rcs.setSemester(semester);
                rcs.setReserver(user);
                rcs.setDayOfWeek(Integer.parseInt(dayOfWeek));
                rcs.setPeriod((Period) HibernateService.getEntityById(Period.class, Integer.parseInt(periodId)));
                rcs.setReservationStatus(rcs.PENDING_STATUS);
                rcs.setSemesterWeek(semesterWeek);
                rcs.setRoom(room);
                HibernateService.saveEntity(rcs, (User) request.getSession().getAttribute("userSession"));
            }
    }

    public Integer getNumberOfWeeksForSemester() {
        return numberOfWeeksForSemester;
    }

    public void setNumberOfWeeksForSemester(Integer numberOfWeeksForSemester) {
        this.numberOfWeeksForSemester = numberOfWeeksForSemester;
    }
    
}
