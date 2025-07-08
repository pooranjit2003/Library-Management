package library;

public class Member {
    private int id;
    private String name;
    private String email;

    public Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /* Getters */
    public int getId()       { return id; }
    public String getName()  { return name; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return String.format("#%d - %s (%s)", id, name, email);
    }
}
