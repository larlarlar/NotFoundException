package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smatphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private int nonexistentID = 666;
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product firstBook = new Book(1, "Book1", 28, "Author1");
    private Product secondBook = new Book(2, "Book2", 307, "Author2");
    private Product firstSmatphone = new Smatphone(3, "Telephone1", 10, "Manufacturer1");
    private Product secondSmatphone = new Smatphone(4, "Telephone2", 101010101, "Manufacturer2");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmatphone);
        manager.add(secondSmatphone);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmatphone, secondSmatphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByName() {

        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByAutthor() {

        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{secondBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmatphoneByName() {
        Product[] actual = manager.searchBy("Telephone2");
        Product[] expected = new Product[]{secondSmatphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmatphoneByManufacturer() {
        Product[] actual = manager.searchBy("Manufacturer1");
        Product[] expected = new Product[]{firstSmatphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByID() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.findByID(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByNonexistentID() {
        assertThrows(NotFoundException.class, () -> manager.findByID(nonexistentID));
    }

    @Test
    public void shouldRemoveByID() {
        manager.removeByID(4);
        Product[] expected = new Product[]{firstBook, secondBook, firstSmatphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByNonexistentID() {
        manager.removeByID(nonexistentID);
        Product[] expected = new Product[]{firstBook, secondBook, firstSmatphone, secondSmatphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}