package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Contact implements ICallActions{

    private String name;

    public String getName() {
        return this.name;
    }

    public String getSurnames() {
        return this.surname;
    }

    public Contact(String nombre, String apellidos, String telefono) {
        this.name = nombre;
        this.surname = apellidos;
        this.phone = telefono;
        this.code = getCode();
    }

    private String surname;

    public String getPhone() {
        return this.phone;
    }

    private String phone;
    private String code;

    public String getCode(){
        String codigo;
        String nombre=this.getName().toLowerCase();
        String apellidos=this.getSurnames().toLowerCase();

        nombre=eliminarSignos(nombre);
        apellidos=eliminarSignos(apellidos);

        String[] partesDeApellidos=apellidos.split("\\s+");

        if(partesDeApellidos.length!=1){
            String firstInitial = partesDeApellidos[0].substring(0, 1);
            String restOfLastName=new String();
            for (int i=0;i<partesDeApellidos.length;i++){
                if(i!=0){
                    restOfLastName+=partesDeApellidos[i];
                }
            }

            apellidos=firstInitial+restOfLastName;
        }

        nombre=nombre.charAt(0)+"";

        return nombre+apellidos;



    }

    public String eliminarSignos(String palabra){
        String normalized = Normalizer.normalize(palabra, Normalizer.Form.NFD);


        Pattern pattern = Pattern.compile("\\p{M}");
        return pattern.matcher(normalized).replaceAll("");
    }

    @Override
    public void callMyNumber() {
        System.out.println("Te estas llamando a ti mismo y tu numero es: "+this.getPhone()+" .Y tu nombre es: "+this.getName()+" .Y tu/s apellido/s son: "+this.getSurnames());
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Estas llamando al siguiente numero: "+number+" .Y tu nombre es: "+this.getName()+" .Y tu/s apellido/s son: "+this.getSurnames());
    }

    @Override
    public void showContactDetails() {
        System.out.println("Contact{" +
                "nombre='" + this.getName() + '\'' +
                ", apellidos='" + this.getSurnames() + '\'' +
                ", telefono='" + this.getPhone() + '\'' +
                ", codigo='" + this.getCode() + '\'' +
                '}');
    }

    public void showContactMenu(){
        Scanner sc = new Scanner(System.in);
        int option;



            System.out.println("Escoge una opcion:");
            System.out.println("1. Llamar a mi propio numero");
            System.out.println("2. Llamar otro numero");
            System.out.println("3. Mostrar detalles del contacto");

            option = sc.nextInt();
            switch (option){
                case 1:
                    this.callMyNumber();
                    break;
                case 2:
                    System.out.println("A que numero quieres llamar");
                    String numeroALlamar = sc.nextLine();
                    this.callOtherNumber(numeroALlamar);
                    break;
                case 3:
                    this.showContactDetails();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }



    }



}
