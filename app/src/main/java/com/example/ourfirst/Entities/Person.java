package com.example.ourfirst.Entities;

public class Person {
    private String lastName;
    private String firstName;
    private int id;
    private String address;
    private String phoneNumber;

    public Person(){
        lastName = "Almony";
        firstName = "Plony";
        this.address = null;
        phoneNumber = null;
        id = 000000000;
    }

    public Person(String lastName, String firstName, String address, String phoneNumber, int id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;

    }
}

