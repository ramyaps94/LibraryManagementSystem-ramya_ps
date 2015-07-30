package com.twu.biblioteca;

import java.util.*;

public class View {
    public void display() {
        System.out.println("Welcome to Bibilioteca -- the library management system");
    }
    public void display(ArrayList<HashMap <String , String > > bookList) {
        System.out.println("List of books are");
        String header = String.format("%30s%30s%30s\n","title","author","year");
        System.out.println(header);
//        for (int index = 0; index<bookList.size();index++)
//        {
//            HashMap<String, String> tmpData = bookList.get(index);
//            Set<String> key = tmpData.keySet();
//            Iterator it = key.iterator();
//            while (it.hasNext()) {
//                String hmKey = (String)it.next();
//                String hmData = tmpData.get(hmKey);
//
//                System.out.printf("    |"+hmData+"    |");
//                it.remove();
//            }
//            System.out.print("\n");
//        }
        System.out.println("=========================================================================================");
        for (HashMap<String , String> book : bookList) {
            String FormattedBook=String.format("%30s%30s%30s", book.get("Title"), book.get("Author"), book.get("year"));
            System.out.println(FormattedBook);
        }
    }
}
