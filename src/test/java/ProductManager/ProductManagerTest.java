package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    public void testAdd() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter", 250, "Rowling");
        Book book2 = new Book(2, "The Lord of the Rings", 300, "Tolkien");
        Book book3 = new Book(3, "The Hobbit or There and Back again", 350, "Tolkien");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchByWhenFewProductsFound() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 250, "Rowling");
        Book book2 = new Book(2, "The Lord of the Rings", 300, "Tolkien");
        Book book3 = new Book(3, "Harry Potter 5", 350, "Rowling");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Potter");
        Product[] expected = {book1,book3};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testSearchByWhenNotFoundProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter", 250, "Rowling");
        Book book2 = new Book(2, "The Lord of the Rings", 300, "Tolkien");
        Book book3 = new Book(3, "The Hobbit or There and Back again", 350, "Tolkien");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("War and Peace");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);


    }
}
