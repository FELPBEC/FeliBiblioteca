package MODEL;

import java.time.LocalDateTime;

public class Loan {
   private int id;
   private Book book;
   private LocalDateTime loanTime;
   public Loan(int id, Book book) {
      this.id = id;
      this.book = book;
      this.loanTime=LocalDateTime.now();
   }
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public Book getBook() {
      return book;
   }
   public void setBook(Book book) {
      this.book = book;
   }
   public LocalDateTime getLoanTime() {
      return loanTime;
   }
   public void setLoanTime(LocalDateTime loanTime) {
      this.loanTime = loanTime;
   } 
   
   
}
