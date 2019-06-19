package org.com.finablr.health.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
//@Table(name = "\"mail\"")
public class Mail {

   // @Id
  //  @GeneratedValue(strategy = GenerationType.AUTO)
   // private Long id;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   // @Email
    //@NotNull
   // @Size(min = 1, message = "Please, set an email address to send the message to it")
    private String userName;
    private String token;
   /* private String text;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
}
