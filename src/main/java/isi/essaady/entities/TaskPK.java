package isi.essaady.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the task database table.
 * 
 */
@Embeddable
public class TaskPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idProject;

	private int idTask;

	public TaskPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TaskPK)) {
			return false;
		}
		TaskPK castOther = (TaskPK)other;
		return 
			(this.idProject == castOther.idProject)
			&& (this.idTask == castOther.idTask);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProject;
		hash = hash * prime + this.idTask;
		
		return hash;
	}
}