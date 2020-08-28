import java.util.Scanner;
public class Video {
    private int ID, length, dueDate, minDaysOnHold; //dueDate in format MMDDYYYY, length is minutes
    private static int currentID = 100000000;
    private boolean checkedOut;
    private String title;

    public Video() {
        this("Video", 0, false);
    }

    public Video(String t, int l, boolean c) {
        title = t;
        ID = createID();
        length = l;
        minDaysOnHold = 0;
        checkedOut = c;
        if(c)
            setDueDate();
    }
    private int createID() {
        currentID++;
        return currentID;
    }
    public String toString() {
        if(checkedOut) {
            return ("Title: " + title + "\nLength: " + length + "\nID: " + ID + "\nDue: " + dueDate
                    + "\nChecked out: " + checkedOut);
        }
        else {
            return ("Title: " + title + "\nLength: " + length + "\nID: " + ID + "\nDue: " + dueDate
                    + "\nChecked out: " + checkedOut + "\nDays on hold: " + minDaysOnHold);
        }
    }
    //Getter methods
    public String getTitle() {
        return title;
    }
    public int getID() {
        return ID;
    }
    public int getLength() {
        return length;
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
    public void setID(int _id) {
        ID = _id;
    }
    public void setLength(int p) {
        length = p;
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
            System.out.println("You can't put a video on hold for less than a day.");
        else
            minDaysOnHold = noDaysOnHold;
    }
    public void putOnHold(String t, String l, int noDaysOnHold) {
        if(noDaysOnHold <= 0)
            System.out.println("You can't put a video on hold for less than a day.");
        else
            minDaysOnHold = noDaysOnHold;
    }

}
