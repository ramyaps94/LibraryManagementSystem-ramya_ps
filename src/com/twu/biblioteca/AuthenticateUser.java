package com.twu.biblioteca;

import java.util.ArrayList;

public class AuthenticateUser {

    private ArrayList<User> registeredLibrarian;
    private ArrayList<User> allRegisteredUsers;

    public AuthenticateUser(ArrayList<User> allRegisteredUsers, ArrayList<User> registeredLibrarian) {
        this.allRegisteredUsers = allRegisteredUsers;
        this.registeredLibrarian = registeredLibrarian;
    }

    public User isLibrarian(User user) {
        for (User aRegisteredLibrarian : registeredLibrarian) {
            if (user.getLibraryId().equals(aRegisteredLibrarian.getLibraryId()) && user.getPassword().equals(aRegisteredLibrarian.getPassword()))
                return aRegisteredLibrarian;
        }
        return null;
    }

    public User isNormalUser(User user) {
        for (User allRegisteredUser : allRegisteredUsers) {
            if (user.getLibraryId().equals(allRegisteredUser.getLibraryId()) && user.getPassword().equals(allRegisteredUser.getPassword()))
                return allRegisteredUser;
        }
        return null;
    }

    public User getDetailsOfAllUsers(int index) {
        return allRegisteredUsers.get(index);
    }

    public ArrayList<User> getAllRegisteredUsers() {
        return allRegisteredUsers;
    }
}