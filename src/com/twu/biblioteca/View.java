package com.twu.biblioteca;

import java.util.*;

public class View {
    public void display() {
        System.out.println("Welcome to Bibilioteca -- the library management system");
    }
    public void display(ArrayList<HashMap <String , String >> bookList) {
        System.out.println("List of books are");
        //System.out.print(bookList);
        ArrayList<String> header = new ArrayList<String>();
        header.add("title");
        header.add("year");
        header.add("author");
        for(int i=0;i<header.size();i++)
        System.out.print("    |"+header.get(i)+"    |");
        System.out.print("\n");

        for (int index = 0; index<bookList.size();index++)
        {
            HashMap<String, String> tmpData = bookList.get(index);
            Set<String> key = tmpData.keySet();
            Iterator it = key.iterator();
            while (it.hasNext()) {
                String hmKey = (String)it.next();
                String hmData = tmpData.get(hmKey);

                System.out.printf("    |"+hmData+"    |");
                it.remove();
            }
            System.out.print("\n");
        }
    }
}
