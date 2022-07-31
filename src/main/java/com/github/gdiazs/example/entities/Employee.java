
package com.github.gdiazs.example.entities;

public class Employee {

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
    
    private String name;
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
