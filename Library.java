package library;

import java.util.*;

public class Library {
    private Map<Integer, Book>   books   = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private List<Loan> loans = new ArrayList<>();
    private static final int LOAN_DAYS = 14;

    // CRUD for Books
    public void addBook(Book b)             { books.put(b.getId(), b); }
    public Book findBook(int id)            { return books.get(id); }
    public Collection<Book> listBooks()     { return books.values(); }

    // CRUD for Members
    public void addMember(Member m)         { members.put(m.getId(), m); }
    public Member findMember(int id)        { return members.get(id); }
    public Collection<Member> listMembers() { return members.values(); }

    // Lending operations
    public boolean lendBook(int bookId, int memberId) {
        Book b = findBook(bookId);
        Member m = findMember(memberId);
        if (b != null && m != null && b.isAvailable()) {
            b.setAvailable(false);
            loans.add(new Loan(b, m, LOAN_DAYS));
            return true;
        }
        return false;
    }

    public boolean returnBook(int bookId) {
        for (Loan l : loans) {
            if (l.getBook().getId() == bookId) {
                l.getBook().setAvailable(true);
                loans.remove(l);
                return true;
            }
        }
        return false;
    }

    public List<Loan> listLoans() {
        return Collections.unmodifiableList(loans);
    }
}
