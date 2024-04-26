package com.IoC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
/*
 Para la tarea de la Leccion 3 me he planteado hacer lo siguiente:
     - Tengo una interfaz "Persona" que es implementada en dos clases: "Usuario" y "Empleado"
     - Dentro de estas clases implemento un objeto de tipo "GeneradorDocumentacion" que nos mostrará un
       mensaje por pantalla
*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Scanner scan = new Scanner(System.in);
        String eleccion;
        Persona persona;

        do {
            mostrarMenuInicial();
            eleccion = scan.nextLine();
            if (eleccion.equalsIgnoreCase("Usuario") || eleccion.equals("1")){
//                Mientras que en esta linea tendría que declarar un objeto de tipo Persona, mediante
//                la inversión de control puedo dejarle esa tarea a Spring
                persona = context.getBean("creacionUsuario", Usuario.class);
                mostrarMenuAccion();
                eleccion = scan.nextLine();
                eleccionAccion(eleccion, persona);
            } else  if (eleccion.equalsIgnoreCase("Empleado") || eleccion.equals("2")){
//                Y dependiendo del Bean al que haga referencia me creara un objeto de una clase u otra usando
//                el polimorfismo de la interfaz Persona.
                persona = context.getBean("creacionEmpleado", Empleado.class);
                mostrarMenuAccion();
                eleccion = scan.nextLine();
                eleccionAccion(eleccion, persona);
            } else {
                break;
            }
        }while (true);
        context.close();
    }

//    Método para mostrar un pequeño menú inicial
    public static void mostrarMenuInicial(){
        System.out.println("¿Qué tipo de persona quieres modificar?");
        System.out.println("    - 1. Usuario");
        System.out.println("    - 2. Empleado");
        System.out.println("    - Introduzca cualquier otra entrada para salir");
    }

//    Método para mostrar un segundo menú para indicar que se quiere realizar
    public static void mostrarMenuAccion(){
        System.out.println("Qué deseas hacer?");
        System.out.println("    - 1. Añadir");
        System.out.println("    - 2. Eliminar");
    }

// Método que realiza una accion u otra dependiendo de lo que introduzca el usuario. Se le ha añadido un Thread.sleep
// para facilitar la visualización del mensaje
    public static void eleccionAccion(String eleccion, Persona persona) throws InterruptedException {
        if (eleccion.equalsIgnoreCase("Añadir") || eleccion.equals("1")){
            System.out.println(persona.agregar());
        } else if (eleccion.equalsIgnoreCase("Eliminar") || eleccion.equals("2")){
            System.out.println(persona.eliminar());
        }else {
            System.out.println("Opción no contemplada. Reiniciando");
        }
        Thread.sleep(1000);
    }
}