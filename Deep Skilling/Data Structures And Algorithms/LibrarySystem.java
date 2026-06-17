import java.util.*;
class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID, Title, Author: ");
            int id = sc.nextInt();
            String title = sc.next();
            String author = sc.next();
            books[i] = new Book(id, title, author);
        }

        Arrays.sort(books, Comparator.comparing(b -> b.title));

        System.out.print("Enter title to search: ");
        String searchTitle = sc.next();

        System.out.println("Linear Search:");
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(searchTitle))
                System.out.println(b);
        }

        System.out.println("Binary Search:");
        int low = 0, high = books.length - 1;
        boolean found = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(searchTitle);
            if (cmp == 0) {
                System.out.println(books[mid]);
                found = true;
                break;
            } else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        if (!found) System.out.println("Book not found.");
    }
}
