package library;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Member member;
    private LocalDate loanDate;
    private LocalDate dueDate;

    public Loan(Book book, Member member, int loanDays) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(loanDays);
    }

    /* Getters */
    public Book getBook()       { return book; }
    public Member getMember()   { return member; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate()  { return dueDate; }

    @Override
    public String toString() {
        return String.format("%s loaned to %s on %s (due %s)",
                book.getTitle(), member.getName(), loanDate, dueDate);
    }
}
