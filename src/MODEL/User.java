package MODEL;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private ArrayList<Loan> userLoan;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.userLoan=new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Loan> getUserLoan() {
        return userLoan;
    }
    public void setUserLoan(ArrayList<Loan> userLoan) {
        this.userLoan = userLoan;
    }
    public void addLoan(Loan newLoan){
        userLoan.add(newLoan);
    }
    
}
