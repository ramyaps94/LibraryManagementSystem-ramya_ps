package com.twu.biblioteca;

public class User {
    private String userName;
    private String emailId;
    private String contactNumber;
    private String libraryId;
    private String password;

    public User(String libraryId, String password, String userName, String emailId, String contactNumber) {
        this.libraryId = libraryId;
        this.password = password;
        this.userName = userName;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
    }

    public User(String id, String password) {
        this.libraryId = id;
        this.password = password;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public String getPassword() {
        return password;
    }

    public String getDetails() {
        return libraryId + "      " + userName + "       " + emailId + "     " + contactNumber;
    }


}