package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t ORDER BY t.createdAt")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TaskPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String description;
	
	private int duration;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	private String title;

	//bi-directional many-to-one association to CollabTaskPlan
	@OneToMany(mappedBy="task")
	private Set<CollabTaskPlan> collabTaskPlans;

	//bi-directional many-to-many association to Competence
	@ManyToMany(mappedBy="tasks")
	private Set<Competence> competences;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="idProject")
	private Project project;
	
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	public Task() {
	}

	public TaskPK getId() {
		return this.id;
	}

	public void setId(TaskPK id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<CollabTaskPlan> getCollabTaskPlans() {
		return this.collabTaskPlans;
	}

	public void setCollabTaskPlans(Set<CollabTaskPlan> collabTaskPlans) {
		this.collabTaskPlans = collabTaskPlans;
	}

	public CollabTaskPlan addCollabTaskPlan(CollabTaskPlan collabTaskPlan) {
		getCollabTaskPlans().add(collabTaskPlan);
		collabTaskPlan.setTask(this);

		return collabTaskPlan;
	}

	public CollabTaskPlan removeCollabTaskPlan(CollabTaskPlan collabTaskPlan) {
		getCollabTaskPlans().remove(collabTaskPlan);
		collabTaskPlan.setTask(null);

		return collabTaskPlan;
	}

	public Set<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(Set<Competence> competences) {
		this.competences = competences;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}