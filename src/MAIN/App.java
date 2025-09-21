package MAIN;

import MODEL.BookLoader;
import MODEL.Book;
import java.util.ArrayList;


public class App { 
    public static void main(String[] args) throws Exception {
        ArrayList<Book> bookList= new ArrayList<>();
        bookList= BookLoader.bookLoader("src\\bookList.txt");
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("ID:"+bookList.get(i).getId()+"-----nombre:"+bookList.get(i).getTitle()+"-----autor:"+bookList.get(i).getAuthor()+"-----stock:"+bookList.get(i).getStock());
        }
        
    }
}
