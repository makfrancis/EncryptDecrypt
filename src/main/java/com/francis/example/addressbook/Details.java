package com.francis.example.addressbook;

public class Details {
    private String name;
    private String location;
    private String contactNumber;
    private String email;

    public Details(String name, String location, String contactNumber, String email) {
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }
}
