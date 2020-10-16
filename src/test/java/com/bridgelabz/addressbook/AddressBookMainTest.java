package com.bridgelabz.addressbook;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class AddressBookMainTest {
    @Test
    public void given3Contacts_whenWrittenToFile_shouldMatchEntries() {
        Contact[] contacts = {new Contact("a", "a", "a", "mumbai", "maharashtra", "400088", "1234567890", "a@gmail.com"),
                new Contact("b", "b", "b", "pune", "maharashtra", "400001", "1234567890", "b@gmail.com"),
                new Contact("c", "c", "c", "mumbai", "maharashtra", "400022", "1234567890", "c@gmail.com")};
        ArrayList<Contact> addList = new ArrayList<>();
        addList.add(contacts[0]);
        addList.add(contacts[1]);
        addList.add(contacts[2]);
        AddressBookMain addressBook = new AddressBookMain();
        addressBook.writeData(addList);
        System.out.println(addressBook.printData());
        long totalContacts = addressBook.countEntries();
        Assert.assertEquals(3, totalContacts);
    }
}
