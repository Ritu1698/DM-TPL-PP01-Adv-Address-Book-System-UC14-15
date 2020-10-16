package com.bridgelabz.addressbook;

public class Contact {

    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String number;
    public String email;

    public Contact(String firstname, String lastname, String address, String city, String state, String zip, String number,
                   String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.number = number;
        this.email = email;
    }

    public Contact() {

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address book");
    }


}
