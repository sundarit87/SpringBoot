package org.com.finablr.health.entity.dto;

public class UserDto {

    private Long id;

    private String username;

    private String token;
    
    private String subject;
    
    	private String text;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", token=" + token + ", subject=" + subject + ", text="
				+ text + "]";
	}

	

}