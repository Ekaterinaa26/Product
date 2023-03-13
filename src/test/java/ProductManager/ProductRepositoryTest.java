package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    @Test
    public void testRemoveWhenIdExist() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter", 250, "Rowling");
        Book book2 = new Book(2, "The Lord of the Rings", 300, "Tolkien");
        Book book3 = new Book(3, "The Hobbit or There and Back again", 350, "Tolkien");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2,book3};

        Assertions.assertArrayEquals(expected, actual);


    }

}