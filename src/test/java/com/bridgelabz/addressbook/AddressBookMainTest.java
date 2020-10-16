package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookMainTest {
    ArrayList<Contact> contacts = null;
    AddressBookMain addressBookMain = null;

    @Before
    public void initialize() {
        addressBookMain = new AddressBookMain();
        contacts = new ArrayList<>();
        Contact personOne = new Contact("a", "a", "a", "mumbai", "maharashtra", "400088", "1234567890", "a@gmail.com");
        Contact personTwo = new Contact("b", "b", "b", "pune", "maharashtra", "400001", "1234567890", "b@gmail.com");
        Contact personThree = new Contact("c", "c", "c", "mumbai", "maharashtra", "400022", "1234567890", "c@gmail.com");
        contacts.add(personOne);
        contacts.add(personTwo);
        contacts.add(personThree);
    }

    @Test
    public void given3Contacts_whenWrittenToFile_shouldReturnTrue() {
        Assert.assertTrue(addressBookMain.writeData(contacts));
        System.out.println(addressBookMain.printData());
    }

    @Test
    public void given3Contacts_whenReadFromFile_shouldReturnTotalEntriesCount() {
        long totalContacts = addressBookMain.countEntries();
        long contactSizeWhenFileRead = addressBookMain.readData();
        Assert.assertEquals(contactSizeWhenFileRead, totalContacts);
    }

    @Test
    public void given3Contacts_whenWrittenSuccessfullyToCSVFile_shouldReturnTrue() throws IOException {
        Assert.assertTrue(AddressBookMain.writeCsv(contacts));
    }

    @Test
    public void given3Contacts_whenReadSuccessfullyFromCSVFile_shouldReturnTotalsContactSize() throws IOException {
        int count = AddressBookMain.readDataFromCSV();
        Assert.assertEquals(3, count);
    }

    @Test
    public void given3Contacts_whenWrittenSuccessfullyToJsonFile_shouldReturnTrue() throws IOException {
        Assert.assertTrue(AddressBookMain.writeJSON(contacts));
    }

    @Test
    public void given3Contacts_whenReadSuccessfullyFromJsonFile_shouldReturnTotalsContactSize() throws IOException {
        int count = AddressBookMain.readFromJSON();
        Assert.assertEquals(3, count);
    }

}
