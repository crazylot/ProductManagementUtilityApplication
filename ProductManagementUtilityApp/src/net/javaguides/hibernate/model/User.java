package net.javaguides.hibernate.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // identifies class as JPA Entity
@Table(name = "users") //specifies table name to be referenced
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id //Annotations
    @GeneratedValue(strategy = GenerationType.AUTO) //how to generate primary key
    private int id;
    
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}