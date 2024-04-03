package org.hillel.lesson_11_jdbc_preparation.dto;

public class Student {
    private int id;
    private String name;
    private String phone;
    private String description;


    public Student(int id, String name, String phone, String description) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.description = description;
    }

    public Student(String name, String phone, String description) {
        this.name = name;
        this.phone = phone;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
