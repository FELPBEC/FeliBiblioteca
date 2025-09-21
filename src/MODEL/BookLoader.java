package MODEL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class BookLoader {
    public static ArrayList<Book> bookLoader(String pathFile){
        ArrayList<Book> booklList=new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line=bufferedReader.readLine())!=null) {
                String[]values = line.split(",");
                if (line=="") {
                    
                }else{
                String id = values[0];
                String name = values[1];
                String author = values[2];
                int stock = Integer.parseInt(values[3]);

                booklList.add(new Book(id, name, author, stock));
                }
                
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el archvio");
        }
        return booklList;
    }
}
