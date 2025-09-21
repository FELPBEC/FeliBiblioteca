package MODEL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loan {
   private Book book;
   private LocalDateTime loanTime;
   public Loan( Book book) {
      this.book = book;
      this.loanTime=LocalDateTime.now();
      
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
   public String showLoanInfo(){
      String info = "";
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy HH:mm");
      info="Nombre del libro: \n"+getBook().getTitle()+"\nAutor:"+getBook().getAuthor()+"\nFecha de prestamo:"+loanTime.format(formatter)+"\nFecha de devolción: "+loanTime.plusDays(8).format(formatter);
      info+="\n-------------------------------------------------------------------------";
      return info;
   }
   
}
