package serpro_contact;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//opção criar uma única instância da classe de teste
@TestInstance(TestInstance.Lifecycle.PER_CLASS) //neste caso remover static dos métodos All
public class ContactManagerTest {
    
    ContactManager contactManager;
    
    //anotação beforeall, executa uma vez antes de tudo
    @BeforeAll
    public void setupAll() { //sem o testinstance colocar static
        System.out.println("Hello I am starting the tests...");
    }

    @BeforeEach
    public void setup() {
        contactManager = new ContactManager();
        //esta linha é comum a todos os testes, portanto pode ficar aqui. Cada teste cria um objeto diferente
    }

    @Test 
    public void shouldCreateContact() {
        contactManager.addContact("Josenalde", "Oliveira", "0123456789");
        // testa se após adicionar a lista (mapa, coleção) não está vazia
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        // testa se o tamanho e 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
            .filter(contact -> contact.getFirstName().equals("Josenalde") &&
                    contact.getLastName().equals("Oliveira") &&
                    contact.getPhoneNumber().equals("0123456789"))
            .findAny()
            .isPresent());
    }

    @Test
    @DisplayName("Should Not Create Contact when First Name is Null")
    public void shouldThrowRunTimeExceptionWhenFirstNameIsNull() {
        
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Oliveira", "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact when Last Name is Null")
    public void shouldThrowRunTimeExceptionWhenLastNameIsNull() {
        
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Josenalde", null, "0123456789");
        });
    }

    @Test
    @DisplayName("Should Not Create Contact when PhoneNumber is Null")
    public void shouldThrowRunTimeExceptionWhenPhoneNumberIsNull() {
        
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Josenalde", "Oliveira", null);
        });
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public void tearDownAll() { //sem o testinstance colocar static
        System.out.println("Executed at the end of the test");
    }

    @Test
    @DisplayName("Should Create Contact Only on Windows") 
    @EnabledOnOs(value=OS.WINDOWS)
    public void shouldCreateContactOnlyOnWindows() {
        contactManager.addContact("Josenalde", "Oliveira", "0123456789");
        // testa se após adicionar a lista (mapa, coleção) não está vazia
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        // testa se o tamanho e 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
            .filter(contact -> contact.getFirstName().equals("Josenalde") &&
                    contact.getLastName().equals("Oliveira") &&
                    contact.getPhoneNumber().equals("0123456789"))
            .findAny()
            .isPresent());
    }

    @Test
    @DisplayName("Should Not Create Contact Only on Linux") 
    @DisabledOnOs(value=OS.LINUX) 
    public void shouldNotCreateContactOnLinux() {
        contactManager.addContact("Josenalde", "Oliveira", "0123456789");
        // testa se após adicionar a lista (mapa, coleção) não está vazia
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        // testa se o tamanho e 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
            .filter(contact -> contact.getFirstName().equals("Josenalde") &&
                    contact.getLastName().equals("Oliveira") &&
                    contact.getPhoneNumber().equals("0123456789"))
            .findAny()
            .isPresent());
    }

    @DisplayName("Repeat Contact Creation 5 Times") 
    @RepeatedTest(value=5) 
    public void shouldTestContactCreationRepeatedly() {
        contactManager.addContact("Josenalde", "Oliveira", "0123456789");
        // testa se após adicionar a lista (mapa, coleção) não está vazia
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        // testa se o tamanho e 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @DisplayName("Parameterized Contact Creation") 
    @ParamaterizedTest
    @ValueSource(strings = {"0123456789", "0123456777", "0123446789"})
    public void shouldTestContactCreationUsingValueSource(String phone) {
        contactManager.addContact("Josenalde", "Oliveira", phone);
        // testa se após adicionar a lista (mapa, coleção) não está vazia
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        // testa se o tamanho e 1
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }



}
