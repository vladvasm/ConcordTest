package com.concord.springRestPostJSONTest.model;

/**
 *
 * @author Vladimir
 */

public class Person {
	private int id;
	private String fio;

	public Person() {
	}

	public Person(int id, String fio) {
		this.id=id;
		this.fio=fio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getFio() {
		return fio;
	}

	public void setFio(String fio) {
		this.fio=fio;
	}

	public String toString() {
		return "{\"id\": "+id+", \"fio\": \""+fio+"\"}";
	}
}
