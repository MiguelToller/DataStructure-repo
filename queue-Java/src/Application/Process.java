package Application;

import java.util.Objects;

/**
 * Represents a Process with an ID and description.
 * This class provides methods for getting, setting, and comparing process data.
 * It also includes a custom string representation of the Process object.
 */

public class Process {
	
	int id;
	String description;
	
	 /**
     * Default constructor that creates an empty Process object.
     */
	
	public Process() {}
	
	/**
     * Constructs a Process with the specified ID and description.
     * 
     * @param id The unique identifier for the process.
     * @param description A brief description of the process.
     */
	
	public Process(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	 /**
     * Returns a string representation of the process, including its ID and description.
     * This is helpful for debugging and logging purposes.
     * 
     * @return A string representation of the process.
     */
	
	@Override
	public String toString() {
		return "Process [id=" + id + ", description=" + description + "]";
	}
	
	 /**
     * Compares this process to another object for equality. Two processes are considered
     * equal if their IDs and descriptions are the same.
     * 
     * @param obj The object to compare this process with.
     * @return true if the processes are equal, false otherwise.
     */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Process other = (Process) obj;
		return Objects.equals(description, other.description) && id == other.id;
	}
}