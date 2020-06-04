package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

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
	@CreationTimestamp
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

	public Competence() {
	}

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

}