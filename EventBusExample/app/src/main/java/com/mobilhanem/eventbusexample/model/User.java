package com.mobilhanem.eventbusexample.model;

/**
 * Created by alper on 10/02/17.
 */

public class User {
    private String name;
    private String surname;
    private String department;
    private int age;

    public User(String name,String surname,String department,int age){
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
