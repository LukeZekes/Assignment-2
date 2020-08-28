
public class LibraryDriver {
    public static void main(String[] args) {
        Object[] arr = new Object[5];
        Book b1 = new Book("The Lion, the Witch and the Wardrobe", "C. S. Lewis", "Fantasy", 206, false);
        Book b2 = new Book("Goldfinger", "Ian Fleming", "Spy thriller", 315, false);
        Book b3 = new Book("Harry Potter and the Sorcerer's Stone", "J. K. Rowling", "Fantasy", 336, true);
        Video v1 = new Video("Avengers: Assemble", 143, true);
        Video v2 = new Video("Star Wars: A New Hope", 121, false);
    }
}
