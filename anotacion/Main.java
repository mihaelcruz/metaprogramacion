// Definimos la anotación personalizada @AutoBuilder
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // La anotación estará disponible en tiempo de ejecución
@interface AutoBuilder {}

// Aplicamos la anotación a la clase Person
@AutoBuilder
class Person {
    private String name;
    private int age;

    // Constructor de la clase Person
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Método para mostrar información de la persona
    public void showInfo() {
        System.out.println("Nombre: " + name + ", Edad: " + age);
    }
}

// Creamos un "Builder" manualmente para la clase Person
class PersonBuilder {
    private String name;
    private int age;

    // Método para asignar el nombre
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    // Método para asignar la edad
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    // Método para construir el objeto Person
    public Person build() {
        return new Person(name, age);
    }
}

// Clase principal con el método main para ejecutar el programa
public class Main {
    public static void main(String[] args) {
        // Usamos el builder para crear un objeto Person
        Person person = new PersonBuilder()
                .setName("Carlos")
                .setAge(30)
                .build();

        // Mostramos la información de la persona
        person.showInfo();
    }
}
