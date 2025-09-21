package MAIN;

import MODEL.*;
import java.util.ArrayList;
import java.util.Scanner;


public class App { 
    
    public static void main(String[] args) throws Exception {
        ArrayList<Loan> loans = new ArrayList<>();
        ArrayList<User> userList = new ArrayList<>();
        ArrayList<Book> bookList= new ArrayList<>();
        bookList= BookLoader.bookLoader("src\\bookList.txt");
        int option =0;
        Scanner sc = new Scanner(System.in);
        do {
        System.out.println("Bienvenido al sistema de FELIBLOTECA");
        System.out.println("A continuación escriba la opcipón correpondiente a su acción");
        System.out.println("1. Listar Libros disponibles");
        System.out.println("2.Seleccionar un libro para pedir prestado");
        System.out.println("3.Mostrar prestamos realizados");
        System.out.println("4. Salir");
        option= sc.nextInt();
        switch (option) {
            case 1:
            System.out.println("ID-----------------NAME------------------------------AUTHOR-----------------------STOCK");
                for (int i = 0; i < bookList.size(); i++) {
                    System.out.println(""+bookList.get(i).getId()+"-----"+bookList.get(i).getTitle()+"-----:"+bookList.get(i).getAuthor()+"-----:"+bookList.get(i).getStock());
                }
            break;
            case 2:
            String idBook = "";
            int idUser = 0;
            boolean foundUser = false;
            System.out.println("Escriba su ID de usuario");
            idUser=sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < userList.size(); i++) {
                if (foundUser==false) {  
                    if (idUser==userList.get(i).getId()) {
                        foundUser=true;
                    }
                }   
            }
            if (foundUser==false) {
                System.out.println("su usuario no fue encontrado,\n"+ "cree un nuevo usuario para asignarle el prestamo del libro");
                System.out.println("a continuación escriba su id");
                idUser=sc.nextInt();
                sc.nextLine();
                System.out.println("ahora escriba su nombre completo");
                String userName=sc.nextLine();
                userList.add(new User(idUser, userName));

            }
            foundUser=false;
            System.out.println("Escriba la id correspondiente al libro que desea prestar");
            idBook=sc.nextLine();
            for (int i = 0; i < bookList.size(); i++) {
                if (foundUser==false) {
                    //encuentra el libro:
                    if (idBook.equals(bookList.get(i).getId())) {
                        foundUser=true;
                        //determina si hay suficientes unidades
                        if (bookList.get(i).getStock()>=1) {
                            for (int j = 0; j < userList.size(); j++) {
                            if (idUser==userList.get(j).getId()) {
                                Loan loan = new Loan(bookList.get(i));
                                userList.get(j).addLoan(loan);
                                loans.add(loan);
                                bookList.get(i).setStock(bookList.get(i).getStock()-1);
                                System.out.println("detalles del prestamo");
                                System.out.println("id USUARIO:"+userList.get(j).getId()+"\nnombre Usuario:"+userList.get(j).getName()+"\n"+loan.showLoanInfo());
                                
                        }
                        
                            }
                        }else{
                            System.out.println("no hay unidades de este libro");
                        }
                    }
                }
            }
            break;
            case 3:
                for (int i = 0; i < userList.size(); i++) {
                    System.out.println("ID Usuario:"+userList.get(i).getId()+"\nNombre: "+userList.get(i).getName());
                    for (int j = 0; j < userList.get(i).getUserLoan().size(); j++) {
                        System.out.println(userList.get(i).getUserLoan().get(j).showLoanInfo());
                    }
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                }
            break;
            default:
                break;
        }
        } while (option!=4); 
    sc.close();   
    }
}
