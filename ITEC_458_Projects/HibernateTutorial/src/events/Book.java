/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package events;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Saeed
 */
@Entity
@Table(name="book")
public class Book {
    
    @Id
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="book_type")
    @Enumerated
    private BookType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookType getType() {
        return type;
    }

    public void setType(BookType type) {
        this.type = type;
    }
    
    public enum BookType{
        Horror,Comedy,Drama,History
    }
}
