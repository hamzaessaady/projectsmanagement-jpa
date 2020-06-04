package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the collab_task_plan database table.
 * 
 */
@Entity
@Table(name="collab_task_plan")
@NamedQuery(name="CollabTaskPlan.findAll", query="SELECT c FROM CollabTaskPlan c")
public class CollabTaskPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CollabTaskPlanPK id;

	private int assignedHours;

	//bi-directional many-to-one association to Collaborator
	@ManyToOne
	@JoinColumn(name="idCollab")
	private Collaborator collaborator;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idProject", referencedColumnName="idProject"),
		@JoinColumn(name="idTask", referencedColumnName="idTask")
		})
	private Task task;

	public CollabTaskPlan() {
	}

	public CollabTaskPlanPK getId() {
		return this.id;
	}

	public void setId(CollabTaskPlanPK id) {
		this.id = id;
	}

	public int getAssignedHours() {
		return this.assignedHours;
	}

	public void setAssignedHours(int assignedHours) {
		this.assignedHours = assignedHours;
	}

	public Collaborator getCollaborator() {
		return this.collaborator;
	}

	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}