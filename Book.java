import java.util.Scanner;
public class Book {
    private int ID, pages, dueDate, minDaysOnHold; //dueDate in format MMDDYYYY
    private static int currentID = 100000000;
    private boolean checkedOut;
    private String title, author, genre;

    public Book() {
        this("Book", "Author", "Genre", 0, false);
    }

    public Book(String t, String a, String g, int p, boolean c) {
        title = t;
        author = a;
        genre = g;
        ID = createID();
        pages = p;
        checkedOut = c;
        minDaysOnHold = 0;
        dueDate = 00000000;
        if(c)
            setDueDate();
    }
    private int createID() {
        currentID++;
        return currentID;
    }
    public String toString() {
        if(checkedOut) {
            return ("Title: " + title +"\nAuthor: " + author + "\nGenre: " + genre + "\nPages: " + pages + "\nID: " + ID + "\nDue: " + dueDate
                    + "\nChecked out: " + checkedOut);
        }
        else {
            return ("Title: " + title + "\nAuthor: " + author + "\nGenre: " + genre + "\nPages: " + pages + "\nID: " + ID + "\nDue: " + dueDate
                    + "\nChecked out: " + checkedOut + "\nDays on hold: " + minDaysOnHold);
        }
    }
    //Getter methods
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }
    public int getID() {
        return ID;
    }
    public int getPages() {
        return pages;
    }
    public int getDueDate() {
        return dueDate;
    }
    public int getMinDaysOnHold() {
        return minDaysOnHold;
    }
    public boolean isCheckedOut() {
        return checkedOut;
    }
    //Setter methods
    public void setTitle(String t) {
        title = t;
    }
    public void setAuthor(String a) {
        author = a;
    }
    public void setGenre(String g) {
        genre = g;
    }
    public void setID(int _id) {
        ID = _id;
    }
    public void setPages(int p) {
        pages = p;
    }
    public void setDueDate() {
        Scanner scan = new Scanner(System.in);
        System.out.println("When is " + title + " due? (MMDDYYYY)");
        dueDate = scan.nextInt();
    }
    public void setMinDaysOnHold(int m) {
        minDaysOnHold= m;
    }
    public void CheckIn() {
        if(checkedOut) {
            System.out.println("Thank you for returning " + title + ".");
            checkedOut = false;
        }
        else {
            System.out.println(title + "is already checked in.");
        }
    }
    public void CheckOut() {
        if(minDaysOnHold > 0) {
            System.out.println("Sorry! " + title + "is on hold for " + minDaysOnHold + " days.");
        } else if(checkedOut) {
            System.out.println("Sorry! " + title + "is already checked out!");
        }
        else {
            System.out.println("Thank you for checking out " + title + ".\nPlease return it by " + dueDate + ".");
            checkedOut = true;
        }
    }

    public void putOnHold(int noDaysOnHold) {
        if(noDaysOnHold <= 0)
            System.out.println("You can't put a book on hold for less than a day.");
        else
            minDaysOnHold = noDaysOnHold;
    }
    public void putOnHold(String t, String p, String a, String g, int noDaysOnHold) {
        if(noDaysOnHold <= 0)
            System.out.println("You can't put a book on hold for less than a day.");
        else
            minDaysOnHold = noDaysOnHold;
    }

}
