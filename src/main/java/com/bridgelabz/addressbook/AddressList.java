package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressList {

    public static HashMap<String, AddressBookMain> AddressListMap;

    public AddressList() {
        AddressListMap = new HashMap<>();
    }

    //Method to Add AddressBook
    public void AddAddressBookByName(String name) {
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program in AddressBookMain class on Master Branch \n");
        AddressBookMain a = new AddressBookMain();
        boolean flag1 = true;
        while (flag1) {
            System.out.println("\n1.Add\n2.Edit\n3.Delete\nEnter your choice : ");
            int choice = sc3.nextInt();
            switch (choice) {
                case 1:
                    a.AddDetails();
                    break;
                case 2:
                    System.out.println("Enter firstname to edit");
                    Scanner sc4 = new Scanner(System.in);
                    String a1 = sc4.nextLine();
                    a.EditDetailsByFirstName(a1);
                    break;
                case 3:
                    System.out.println("Enter firstname to delete");
                    Scanner sc5 = new Scanner(System.in);
                    String a2 = sc5.nextLine();
                    a.DeleteByFirstName(a2);
                    break;
                default:
                    System.out.println("Adding the AddressBook to AddressList");
                    flag1 = false;
                    break;
            }
        }
        AddressListMap.put(name, a);
        System.out.println("AddressBooks in AddressList:\n");
        int i = 1;
        for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
            System.out.println(i + ". AddressBook = " + entry.getKey());
            i++;
        }
    }

    //Method to Search Person
    public void SearchPersonByCityOrState(String location, int CityOrStateFlag) {
        if (CityOrStateFlag == 0) {                   //SearchByCity
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                List<Contact> contactsList = addBook.persons.stream().filter(findCity -> findCity.city.equals(location)).collect(Collectors.toList());
                for (Contact contact : contactsList) {
                    System.out.println(contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.city + " " + contact.email + " " + contact.number + " " + contact.state + " " + contact.zip + "\n");
                }
            }
        } else if (CityOrStateFlag == 1) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                List<Contact> contactsList = addBook.persons.stream().filter(findState -> findState.state.equals(location)).collect(Collectors.toList());
                for (Contact contact : contactsList) {
                    System.out.println(contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.city + " " + contact.email + " " + contact.number + " " + contact.state + " " + contact.zip + "\n");
                }
            }
        }
    }

    //Method to Search Person By HashMap
    public void SearchPersonByCityOrStateHashmap(String location, int StateOrCityFlag) {
        if (StateOrCityFlag == 0) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                ArrayList<Contact> contacts = addBook.CityPersonMap.entrySet().stream().filter(findCity -> findCity.getKey().equals(location)).findFirst().map(Map.Entry::getValue).orElse(null);
                for (Contact contact : contacts) {
                    System.out.println(contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.city + " " + contact.email + " " + contact.number + " " + contact.state + " " + contact.zip + "\n");
                }
            }
        } else if (StateOrCityFlag == 1) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                ArrayList<Contact> contacts = addBook.StatePersonMap.entrySet().stream().filter(findState -> findState.getKey().equals(location)).findFirst().map(Map.Entry::getValue).orElse(null);
                for (Contact contact : contacts) {
                    System.out.println(contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.city + " " + contact.email + " " + contact.number + " " + contact.state + " " + contact.zip + "\n");
                }
            }
        }
    }

    //Method to Count
    public void CountByCityOrState(String cityOrState, int CityOrStateFlag) {
        int countPerson = 0;
        if (CityOrStateFlag == 0) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                Integer count = addBook.CityPersonMap.entrySet().stream().filter(findCity -> findCity.getKey().equals(cityOrState)).findFirst().map(Map.Entry::getValue).orElse(null).size();
                countPerson += count;
            }
            System.out.println("Total number of people in this city: " + countPerson);
        } else if (CityOrStateFlag == 1) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                Integer count = addBook.StatePersonMap.entrySet().stream().filter(findState -> findState.getKey().equals(cityOrState)).findFirst().map(Map.Entry::getValue).orElse(null).size();
                countPerson += count;
            }
            System.out.println("Total number of people in this state: " + countPerson);
        }
    }

    //Method to Sort By Name
    public void sortPersonDetailsByName() {
        for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
            AddressBookMain addBook = entry.getValue();
            List<Contact> sortedList = addBook.persons.stream().sorted(Comparator.comparing(Contact::getFirstname)).collect(Collectors.toList());
            for (Contact contact : sortedList) {
                System.out.println(contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.city + " " + contact.email + " " + contact.number + " " + contact.state + " " + contact.zip + "\n");
            }
        }
    }

    //Method to Sort By City Or State Or Zip
    public void sortPersonDetailsByCityOrStateOrZip(int CityOrZipOrStateFlag) {
        if (CityOrZipOrStateFlag == 0) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                List<Contact> sortedList = addBook.persons.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
                for (Contact contact : sortedList) {
                    System.out.println(contact.city + " " + contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.email + " " + contact.number + " " + contact.state + " " + contact.zip + "\n");
                }
            }
        } else if (CityOrZipOrStateFlag == 1) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                List<Contact> sortedList = addBook.persons.stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
                for (Contact contact : sortedList) {
                    System.out.println(contact.state + " " + contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.email + " " + contact.number + " " + contact.city + " " + contact.zip + "\n");
                }
            }
        } else if (CityOrZipOrStateFlag == 2) {
            for (Map.Entry<String, AddressBookMain> entry : AddressListMap.entrySet()) {
                AddressBookMain addBook = entry.getValue();
                List<Contact> sortedList = addBook.persons.stream().sorted(Comparator.comparing(Contact::getZip)).collect(Collectors.toList());
                for (Contact contact : sortedList) {
                    System.out.println(contact.zip + " " + contact.firstname + " " + contact.lastname + " " + contact.address + " " + contact.email + " " + contact.number + " " + contact.city + " " + contact.state + "\n");
                }
            }
        }
    }

    //Main Method
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program in AddressList class on Master Branch \n");
        AddressList AddList = new AddressList();
        boolean flag2 = true;
        while (flag2) {
            System.out.println("Enter 1 to Add New AddressBook to AddressList\nEnter 2 to Search Person By City Or State\nEnter 3 to Search Person By City Or State HashMap\nEnter 4 to Count Contacts By City Or State\nEnter 5 to Sort Persons By Firstname\nEnter 6 to Sort Persons By City, State Or Zip");
            Scanner sc7 = new Scanner(System.in);
            int choice = sc7.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter address book name: ");
                    Scanner sc6 = new Scanner(System.in);
                    String AddBookName = sc6.nextLine();
                    if (AddressListMap.containsKey(AddBookName)) {
                        System.out.println("Already PRESENT");
                        break;
                    }
                    AddList.AddAddressBookByName(AddBookName);
                    break;
                case 2:
                    System.out.println("Enter 0 To Choose City / 1 To Choose State : ");
                    Scanner sc8 = new Scanner(System.in);
                    int cityOrStateFlag = sc8.nextInt();
                    if (cityOrStateFlag == 0) {
                        System.out.println("Enter City For Which You Want To Search Contact : ");
                        Scanner sc9 = new Scanner(System.in);
                        String city = sc9.nextLine();
                        AddList.SearchPersonByCityOrState(city, cityOrStateFlag);
                    }
                    if (cityOrStateFlag == 1) {
                        System.out.println("Enter State For Which You Want To Search Contact : ");
                        Scanner sc9 = new Scanner(System.in);
                        String state = sc9.nextLine();
                        AddList.SearchPersonByCityOrState(state, cityOrStateFlag);
                    }
                    break;
                case 3:
                    System.out.println("Enter 0 To Choose City / 1 To Choose State : ");
                    Scanner sc10 = new Scanner(System.in);
                    int cityOrStateFlag1 = sc10.nextInt();
                    if (cityOrStateFlag1 == 0) {
                        System.out.println("Enter City For Which You Want To Search Contact : ");
                        Scanner sc11 = new Scanner(System.in);
                        String city = sc11.nextLine();
                        System.out.println("Search Results:- \n");
                        AddList.SearchPersonByCityOrStateHashmap(city, cityOrStateFlag1);
                    }
                    if (cityOrStateFlag1 == 1) {
                        System.out.println("Enter State For Which You Want To Search Contact : ");
                        Scanner sc11 = new Scanner(System.in);
                        String state = sc11.nextLine();
                        System.out.println("Search Results:- \n");
                        AddList.SearchPersonByCityOrStateHashmap(state, cityOrStateFlag1);
                    }
                    break;
                case 4:
                    System.out.println("Enter 0 To Choose City / 1 To Choose State : ");
                    Scanner sc12 = new Scanner(System.in);
                    int cityOrStateFlag2 = sc12.nextInt();
                    if (cityOrStateFlag2 == 0) {
                        System.out.println("Enter City For Which You Want To Count : ");
                        Scanner sc13 = new Scanner(System.in);
                        String city = sc13.nextLine();
                        AddList.CountByCityOrState(city, cityOrStateFlag2);
                    }
                    if (cityOrStateFlag2 == 1) {
                        System.out.println("Enter State For Which You Want To Count : ");
                        Scanner sc13 = new Scanner(System.in);
                        String state = sc13.nextLine();
                        AddList.CountByCityOrState(state, cityOrStateFlag2);
                    }
                    break;
                case 5:
                    AddList.sortPersonDetailsByName();
                    break;
                case 6:
                    System.out.println("Enter 0 To Choose City / 1 To Choose State / 2 To Choose Zip : ");
                    Scanner sc14 = new Scanner(System.in);
                    int cityZipStateFlag = sc14.nextInt();
                    AddList.sortPersonDetailsByCityOrStateOrZip(cityZipStateFlag);
                    break;
                default:
                    sc7.close();
                    flag2 = false;
                    break;
            }
        }
    }
}

