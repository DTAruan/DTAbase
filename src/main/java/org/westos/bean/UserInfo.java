package org.westos.bean;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

public class UserInfo extends ActionSupport implements Serializable{

	private static final long serialVersionUID = 8965438050533774114L;
	private int id ;
    private String username ;
    private String password ;
	
    public UserInfo() {
		super();
	}

	public UserInfo( String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public String execute() throws Exception {
		
		Configuration cof = new Configuration().configure() ;
		SessionFactory sf = cof.buildSessionFactory() ;
		Session session = sf.openSession() ;
		Transaction bg = session.beginTransaction() ;
		UserInfo u = new UserInfo(username, password) ;
		System.out.println(u);
		session.save(u) ;
		bg.commit(); 
		session.close();
		if(!"".equals(username)&&!"".equals(password)) {
			return SUCCESS ;
		}
		
		return ERROR;
	}
    
	
    
}
