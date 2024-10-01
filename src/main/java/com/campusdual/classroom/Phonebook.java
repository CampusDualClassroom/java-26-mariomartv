package com.campusdual.classroom;



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    Map<String,Contact> agenda;

    public Phonebook() {
        this.agenda = new HashMap<>();
    }

    public Map<String,Contact> getData() {
    return this.agenda;
    }


    public void addContact(Contact c) {
        this.agenda.put(c.getCode(),c);
    }

    public void deleteContact(String codigo){
        this.agenda.remove(codigo);
    }

    public void showPhonebook() {
        for(Contact c: this.agenda.values()){
            System.out.println(c);
        }
    }

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Phonebook Menu ---");
            System.out.println("1. Anadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Seleccionar contacto y mostrar acciones");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

                    System.out.print("Escribe el nombre del contacto: ");
                    String name = scanner.nextLine();
                    System.out.println("Escribe el apellido/s del contacto: ");
                    String apellidos = scanner.nextLine();
                    System.out.println("Escribe el telefono: ");
                    String telefono = scanner.nextLine();
                    Contact contact = new Contact(name,apellidos,telefono);
                    addContact(contact);
                    System.out.println("Contacto anadido");
                    break;

                case 2:
                    System.out.println("\n--- Contactos en la Agenda ---");
                    showPhonebook();
                    break;

                case 3:
                    System.out.print("Escribe un codigo para seleccionar el contacto ");
                    String codigoSleccionado = scanner.nextLine();
                    Contact contactoSeleccionado = agenda.get(codigoSleccionado);
                    if (contactoSeleccionado != null) {
                        contactoSeleccionado.showContactMenu();
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el codigo del contacto que quieras eliminar: ");
                    String deleteCode = scanner.nextLine();
                    if (agenda.containsKey(deleteCode)) {
                        deleteContact(deleteCode);
                        System.out.println("Contacto eliminado");
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del menu");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (option != 5);

        scanner.close();
    }
}
