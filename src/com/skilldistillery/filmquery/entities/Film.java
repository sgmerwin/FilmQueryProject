package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;

public class Film {
	
	protected int filmRental_duration;
	protected Double filmRental_rate;
	protected int filmLength;
	protected Double filmReplacement_cost;
	protected String filmRating;
	protected String filmSpecial_features;
	protected int filmId;
	protected String filmTitle;
	protected int filmLanguage_id;
	protected String filmRelease_year;
	protected List<Actor> filmActors;
	protected String filmDescription;
	protected List<String> actors;

	public Film() {
		super();
	}
	
	public String getFilmActors() {
		//return this.filmActors.toString();
		this.actors = new ArrayList<>();
		for(Actor i : this.filmActors) {
			actors.add(" "+i.getActorFirst_name()+" "+i.getActorLast_name()+" ");	
		}//for
		return actors.toString();
	}

	public int getFilmRental_duration() {
		return filmRental_duration;
	}

	public void setFilmRental_duration(int filmRental_duration) {
		this.filmRental_duration = filmRental_duration;
	}

	public Double getFilmRental_rate() {
		return filmRental_rate;
	}

	public void setFilmRental_rate(Double filmRental_rate) {
		this.filmRental_rate = filmRental_rate;
	}

	public int getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(int filmLength) {
		this.filmLength = filmLength;
	}

	public Double getFilmReplacement_cost() {
		return filmReplacement_cost;
	}

	public void setFilmReplacement_cost(Double filmReplacement_cost) {
		this.filmReplacement_cost = filmReplacement_cost;
	}

	public String getFilmRating() {
		return filmRating;
	}

	public void setFilmRating(String filmRating) {
		this.filmRating = filmRating;
	}

	public String getFilmSpecial_features() {
		return filmSpecial_features;
	}
	
	

	public void setFilmSpecial_features(String filmSpecial_features) {
		this.filmSpecial_features = filmSpecial_features;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public int getFilmLanguage_id() {
		return filmLanguage_id;
	}

	public void setFilmLanguage_id(int filmLanguage_id) {
		this.filmLanguage_id = filmLanguage_id;
	}

	public String getFilmRelease_year() {
		return filmRelease_year;
	}

	public void setFilmRelease_year(String filmRelease_year) {
		this.filmRelease_year = filmRelease_year;
	}


	public void setFilmActors(List<Actor> filmActors) {
		this.filmActors = filmActors;
	}

	public String getFilmDescription() {
		return filmDescription;
	}

	public void setFilmDescription(String filmDescription) {
		this.filmDescription = filmDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmActors == null) ? 0 : filmActors.hashCode());
		result = prime * result + ((filmDescription == null) ? 0 : filmDescription.hashCode());
		result = prime * result + filmId;
		result = prime * result + filmLanguage_id;
		result = prime * result + filmLength;
		result = prime * result + ((filmRating == null) ? 0 : filmRating.hashCode());
		result = prime * result + ((filmRelease_year == null) ? 0 : filmRelease_year.hashCode());
		result = prime * result + filmRental_duration;
		result = prime * result + ((filmRental_rate == null) ? 0 : filmRental_rate.hashCode());
		result = prime * result + ((filmReplacement_cost == null) ? 0 : filmReplacement_cost.hashCode());
		result = prime * result + ((filmSpecial_features == null) ? 0 : filmSpecial_features.hashCode());
		result = prime * result + ((filmTitle == null) ? 0 : filmTitle.hashCode());
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
		Film other = (Film) obj;
		if (filmActors == null) {
			if (other.filmActors != null)
				return false;
		} else if (!filmActors.equals(other.filmActors))
			return false;
		if (filmDescription == null) {
			if (other.filmDescription != null)
				return false;
		} else if (!filmDescription.equals(other.filmDescription))
			return false;
		if (filmId != other.filmId)
			return false;
		if (filmLanguage_id != other.filmLanguage_id)
			return false;
		if (filmLength != other.filmLength)
			return false;
		if (filmRating == null) {
			if (other.filmRating != null)
				return false;
		} else if (!filmRating.equals(other.filmRating))
			return false;
		if (filmRelease_year == null) {
			if (other.filmRelease_year != null)
				return false;
		} else if (!filmRelease_year.equals(other.filmRelease_year))
			return false;
		if (filmRental_duration != other.filmRental_duration)
			return false;
		if (filmRental_rate == null) {
			if (other.filmRental_rate != null)
				return false;
		} else if (!filmRental_rate.equals(other.filmRental_rate))
			return false;
		if (filmReplacement_cost == null) {
			if (other.filmReplacement_cost != null)
				return false;
		} else if (!filmReplacement_cost.equals(other.filmReplacement_cost))
			return false;
		if (filmSpecial_features == null) {
			if (other.filmSpecial_features != null)
				return false;
		} else if (!filmSpecial_features.equals(other.filmSpecial_features))
			return false;
		if (filmTitle == null) {
			if (other.filmTitle != null)
				return false;
		} else if (!filmTitle.equals(other.filmTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Film [filmRental_duration=" + filmRental_duration + ", filmRental_rate=" + filmRental_rate
				+ ", filmLength=" + filmLength + ", filmReplacement_cost=" + filmReplacement_cost + ", filmRating="
				+ filmRating + ", filmSpecial_features=" + filmSpecial_features + ", filmId=" + filmId + ", filmTitle="
				+ filmTitle + ", filmLanguage_id=" + filmLanguage_id + ", filmRelease_year=" + filmRelease_year
				+ ", filmActors=" + filmActors + ", filmDescription=" + filmDescription + "]";
	}



	
	
}//Class

