package com.skilldistillery.filmquery.entities;

public class Actor {
	
	private int actorId;
	private String actorFirst_name;
	private String actorLast_name;
	
	public Actor() {
		super();
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorFirst_name=" + actorFirst_name + ", actorLast_name="
				+ actorLast_name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actorFirst_name == null) ? 0 : actorFirst_name.hashCode());
		result = prime * result + actorId;
		result = prime * result + ((actorLast_name == null) ? 0 : actorLast_name.hashCode());
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
		Actor other = (Actor) obj;
		if (actorFirst_name == null) {
			if (other.actorFirst_name != null)
				return false;
		} else if (!actorFirst_name.equals(other.actorFirst_name))
			return false;
		if (actorId != other.actorId)
			return false;
		if (actorLast_name == null) {
			if (other.actorLast_name != null)
				return false;
		} else if (!actorLast_name.equals(other.actorLast_name))
			return false;
		return true;
	}

	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorFirst_name() {
		return actorFirst_name;
	}
	public void setActorFirst_name(String actorFirst_name) {
		this.actorFirst_name = actorFirst_name;
	}
	public String getActorLast_name() {
		return actorLast_name;
	}
	public void setActorLast_name(String actorLast_name) {
		this.actorLast_name = actorLast_name;
	}

	public Actor(int actorId, String actorFirst_name, String actorLast_name) {
		super();
		this.actorId = actorId;
		this.actorFirst_name = actorFirst_name;
		this.actorLast_name = actorLast_name;
	}
	
}
