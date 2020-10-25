package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the collaborator database table.
 * 
 */
@Entity
@NamedQuery(name="Collaborator.findAll", query="SELECT c FROM Collaborator c ORDER BY c.createdAt")
public class Collaborator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCollab;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String email;

	private String firstName;

	private String gender;

	private String lastName;

	//bi-directional many-to-one association to CollabTaskPlan
	@OneToMany(mappedBy="collaborator")
	private Set<CollabTaskPlan> collabTaskPlans;

	//bi-directional many-to-many association to Competence
	@ManyToMany
	@JoinTable(
		name="collaborator_competence"
		, joinColumns={
			@JoinColumn(name="idCollab")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idComp")
			}
		)
	private Set<Competence> competences;
	
	
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	
	public Collaborator() {
	}
	
	public Collaborator(Collaborator collabToCopy) {
		this.idCollab = collabToCopy.idCollab;
		this.firstName = collabToCopy.firstName;
		this.lastName = collabToCopy.lastName;
		this.email = collabToCopy.email;
		this.gender = collabToCopy.gender;
	
	}

	public int getIdCollab() {
		return this.idCollab;
	}

	public void setIdCollab(int idCollab) {
		this.idCollab = idCollab;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<CollabTaskPlan> getCollabTaskPlans() {
		return this.collabTaskPlans;
	}

	public void setCollabTaskPlans(Set<CollabTaskPlan> collabTaskPlans) {
		this.collabTaskPlans = collabTaskPlans;
	}

	public CollabTaskPlan addCollabTaskPlan(CollabTaskPlan collabTaskPlan) {
		getCollabTaskPlans().add(collabTaskPlan);
		collabTaskPlan.setCollaborator(this);

		return collabTaskPlan;
	}

	public CollabTaskPlan removeCollabTaskPlan(CollabTaskPlan collabTaskPlan) {
		getCollabTaskPlans().remove(collabTaskPlan);
		collabTaskPlan.setCollaborator(null);

		return collabTaskPlan;
	}

	public Set<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	/* HASHCODE - EQUALS */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + idCollab;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Collaborator other = (Collaborator) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (idCollab != other.idCollab)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	} 
}