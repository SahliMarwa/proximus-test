package model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Canal implements Serializable {

	public Canal(Long id, String name, boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.availability = availability;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Long id;
	String name;
	// boolean to verify if canal encrypted or not
	boolean availability;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Canal [id=" + id + ", name=" + name + ", availability=" + availability + "]";
	}

}
