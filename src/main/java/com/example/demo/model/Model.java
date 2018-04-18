package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company", schema = "person")
public class Model {
	@Id
	@Column(name="id", nullable = false)
	private int id;
	public int getId() {
        return id;
    }

    public void setId(int id) {
    	this.id = id;
    }
	
	@Column(name="name", nullable = false)
	private String name;
	public String getName() {
        return name;
    }

    public void setName(String name)
    {
    	this.name = name;
    }
	
	@Column(name="age", nullable = false)
	private int age;
    public int getAge()
    {
    	return age;
    }
    
    public void setAge(int age)
    {
    	this.age = age;
    }
    
    public Model(String name, int id, int age) {
    	this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public Model() {}
    
}