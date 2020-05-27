package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@NamedQuery( 
		name="User.selectUsernamePassword",
		query="SELECT u FROM User u where u.userName=:username and u.password=:password")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	private String role;

	private String userGroup;

	private String userName;

	public User() {
		super();
	}
	
	/* Default methods*/
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}