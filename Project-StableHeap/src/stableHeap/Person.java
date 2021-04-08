package stableHeap;

public class Person implements Comparable<Person>{
	private String identifier;
	private int priority;
	public Person(String identifier, int priority) {
		this.identifier = identifier;
		this.priority = priority;
	}
	public String getID() {
		return identifier;
	}
	public int getPriority() {
		return priority;
	}
	public int compareTo(Person that) {
		return this.priority - that.priority;
	}
	public String toString() {
		return "ID:" + identifier + ",priority:" + priority;
	}
}
