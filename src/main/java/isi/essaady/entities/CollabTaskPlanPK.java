package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the collab_task_plan database table.
 * 
 */
@Embeddable
public class CollabTaskPlanPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idProject;

	@Column(insertable=false, updatable=false)
	private int idTask;

	@Column(insertable=false, updatable=false)
	private int idCollab;

	public CollabTaskPlanPK() {
	}
	public int getIdProject() {
		return this.idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	public int getIdTask() {
		return this.idTask;
	}
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	public int getIdCollab() {
		return this.idCollab;
	}
	public void setIdCollab(int idCollab) {
		this.idCollab = idCollab;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CollabTaskPlanPK)) {
			return false;
		}
		CollabTaskPlanPK castOther = (CollabTaskPlanPK)other;
		return 
			(this.idProject == castOther.idProject)
			&& (this.idTask == castOther.idTask)
			&& (this.idCollab == castOther.idCollab);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProject;
		hash = hash * prime + this.idTask;
		hash = hash * prime + this.idCollab;
		
		return hash;
	}
}