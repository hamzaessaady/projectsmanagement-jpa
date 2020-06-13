package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@NamedQuery(name="Competence.findAll", query="SELECT c FROM Competence c ORDER BY c.createdAt")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String name;

	//bi-directional many-to-many association to Collaborator
	@ManyToMany(mappedBy="competences")
	private Set<Collaborator> collaborators;

	//bi-directional many-to-many association to Task
	@ManyToMany
	@JoinTable(
		name="competence_task"
		, joinColumns={
			@JoinColumn(name="idComp")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idProject", referencedColumnName="idProject"),
			@JoinColumn(name="idTask", referencedColumnName="idTask")
			}
		)
	private Set<Task> tasks;
	
	@PrePersist
	  protected void onCreate() {
	    createdAt = new Date();
	  }
	
	/*
	 * Constructors
	 * */
	public Competence() {}
	
	public Competence(String name) {
		this.name = name;
	}
	
	/*
	 * Getters & Setters
	 * */
	public int getIdComp() {
		return this.idComp;
	}

	public void setIdComp(int idComp) {
		this.idComp = idComp;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Collaborator> getCollaborators() {
		return this.collaborators;
	}

	public void setCollaborators(Set<Collaborator> collaborators) {
		this.collaborators = collaborators;
	}

	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	/* HASHCODE - EQUALS */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idComp;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competence other = (Competence) obj;
		if (idComp != other.idComp)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}