package de.laliluna.library.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import de.laliluna.library.Book;
import de.laliluna.library.Customer;
import de.laliluna.library.HibernateSessionFactory;

public class LibraryTest {
	private Session session;

	private Logger log;

	public static void main(String[] args) {
		/*
		 * hibernate needs log4j. Either create a log4j.properties file in the
		 * source directory * or alternatively make the following to create a
		 * standard configuration BasicConfigurator.configure();
		 */
		LibraryTest libraryTest = new LibraryTest();
		try {
			libraryTest.setUp();
			libraryTest.testCreateDomains();
			libraryTest.testAddRemoveRelation();
			libraryTest.listBooks();
			libraryTest.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void testCreateDomains() {
		Transaction tx = session.beginTransaction();
		Book book = new Book();
		book.setAuthor("Sebastian");
		book.setTitle("Hibernation in winter");
		book.setBorrowallowed(true);
		session.save(book);
		tx.commit();
		tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setLastname("Liebzeit");
		customer.setFirstname("Carsten");
		customer.setAge(25);
		session.save(customer);
		tx.commit();

	}

	private void testAddRemoveRelation() {
		log.info("Adding and removing relations");
		Transaction tx = session.beginTransaction();
		
		// create two books and a customer
		Book book = new Book();
		book.setAuthor("Sebastian's");
		book.setTitle("Hibernation in the summer");
		book.setBorrowallowed(true);
		session.save(book);
		Book book2 = new Book();
		book2.setAuthor("Karl May");
		book2.setTitle("Wildes Kurdistan");
		book2.setBorrowallowed(true);
		session.save(book2);

		Customer customer = new Customer();
		customer.setLastname("Meier");
		customer.setFirstname("John");
		customer.setAge(25);
		session.save(customer);
		
		//customer borrows  books
		customer.getBooks().add(book);
		customer.getBooks().add(book2);
		session.flush();

		session.refresh(customer);
		session.refresh(book);
		session.refresh(book2);
		Set books = customer.getBooks();
		log.info("list books of customer");
		for (Iterator iter = books.iterator(); iter.hasNext();) {
			Book element = (Book) iter.next();
			log.info(element);
		}
		//first book is returned
		book.setCustomer(null);
		customer.getBooks().remove(book);
		session.flush();
		session.refresh(customer);
		log.info("list books of customer");
		books = customer.getBooks();
		for (Iterator iter = books.iterator(); iter.hasNext();) {
			Book element = (Book) iter.next();
			log.info(element);
		}

		tx.commit();
		tx = session.beginTransaction();
		session.delete(customer);
		session.delete(book);
		session.delete(book2);
		tx.commit();

	}

	protected void setUp() throws Exception {
		session = HibernateSessionFactory.currentSession();
		log = Logger.getLogger(this.getClass());
	}

	protected void tearDown() throws Exception {
		HibernateSessionFactory.closeSession();
	}

	/**
	 * creates a book and saves it to the db.
	 * 
	 */

	/**
	 * lists all books in the db
	 * 
	 */
	private void listBooks() {
		log.info("####### list customers");

		Transaction tx = session.beginTransaction();
		List customers = session.createQuery("select c from Customer as c")
				.list();
		for (Iterator iter = customers.iterator(); iter.hasNext();) {
			Customer element = (Customer) iter.next();
			Set books = element.getBooks();
			System.out.println(element);
			if (books == null)
				log.info("no books");
			else {
				for (Iterator iterator = books.iterator(); iterator.hasNext();) {
					Book book = (Book) iterator.next();
					log.info("  - " + book);
				}
			}
			log.info(element);
		}
		tx.commit();

		log.info("####### list books");

		tx = session.beginTransaction();
		List books = session.createQuery("select b from Book as b").list();
		for (Iterator iter = books.iterator(); iter.hasNext();) {
			System.out.println((Book) iter.next());
		}
		tx.commit();

	}

	/**
	 * @return Returns the session.
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session
	 *            The session to set.
	 */
	public void setSession(Session session) {
		this.session = session;
	}
}
