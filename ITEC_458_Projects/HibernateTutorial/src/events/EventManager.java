package events;

import org.hibernate.Session;

import java.util.Date;

import java.util.List;
import util.HibernateUtil;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();
        String action = "tryAnnotation";
        if (action.equals("store")) {
            mgr.createAndStoreEvent("My Party", new Date());
            mgr.createAndStoreEvent("Trip", new Date());
            mgr.createAndStoreEvent("Sleep", new Date());
        } else if (action.equals("list")) {
            List events = mgr.listEvents();
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                System.out.println("Event: " + theEvent.getTitle() +
                        " Time: " + theEvent.getDate());
            }
        } else if (action.equals("addpersontoevent")) {
            Long eventId = mgr.createAndStoreEvent("Cool event", new Date());
            Long personId = mgr.createAndStorePerson("Foo", "Bar", 21);
            mgr.addPersonToEvent(personId, eventId);
            System.out.println("Added person " + personId + " to event " + eventId);
        } else if(action.equals("addEmailToPerson")){
            mgr.addEmailToPerson(1L,"mail@m.com");
        } else if(action.equals("tryAnnotation")){
            Book b = new Book();
            b.setName("First Book");
            b.setType(Book.BookType.Comedy);
            mgr.addBook(b);
            mgr.listBooks();
        }
        HibernateUtil.getSessionFactory().close();
    }

    private long createAndStoreEvent(String title, Date theDate) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);

        session.save(theEvent);

        session.getTransaction().commit();
        return theEvent.getId();
    }

    private long createAndStorePerson(String firstName, String lastName, int age) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Person person = new Person();
        person.setFirstname(firstName);
        person.setLastname(lastName);
        person.setAge(age);

        session.save(person);

        session.getTransaction().commit();
        return person.getId();
    }

    private void listBooks() {
        Session session = HibernateUtil.getAnnotationFactory().getCurrentSession();

        session.beginTransaction();

        List<Book> result = session.createQuery("from Book").list();

        session.getTransaction().commit();

        for(Book b : result){
            System.out.println("Book id: "+b.getId());
            System.out.println("Book name: "+b.getName());
            System.out.println("Book type: "+b.getType());
        }
    }

    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        List result = session.createQuery("from Event").list();

        session.getTransaction().commit();

        return result;
    }

    private void addPersonToEvent(Long personId, Long eventId) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);
        Event anEvent = (Event) session.load(Event.class, eventId);

        aPerson.getEvents().add(anEvent);

        session.getTransaction().commit();
    }

    private void addEmailToPerson(Long personId, String emailAddress) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person aPerson = (Person) session.load(Person.class, personId);

        // The getEmailAddresses() might trigger a lazy load of the collection
        aPerson.getEmailAddresses().add(emailAddress);

        session.getTransaction().commit();
    }
    
    private void addBook(Book book){
        Session session = HibernateUtil.getAnnotationFactory().getCurrentSession();
        session.beginTransaction();

        session.save(book);
        
        session.getTransaction().commit();
    }
}
