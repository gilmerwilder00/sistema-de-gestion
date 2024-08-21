import java.util.Scanner;
import modelos.Empleado;
import java.util.ArrayList;

public class Application {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {

        // instanciar el arreglo de empledos
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Crear e inicializar empleados
        empleados.add(new Empleado("Pedro Picapiedra", 25, 2500, "Lima"));
        empleados.add(new Empleado("Ana García", 30, 3000, "Arequipa"));
        empleados.add(new Empleado("Pedro Pérez", 28, 2800, "Cusco"));

        // Mostrar empleados
        System.out.println("Mostrar empleados:");
        mostrarEmpleados(empleados);
        System.out.println();

        // Mostrar empleados filtrados
        System.out.println("Filtrar empleados por edad");
        ArrayList<Empleado> filtrados1 = filtrarEmpleados(empleados, "edad", 26, 30);
        mostrarEmpleados(filtrados1);
        System.out.println("Filtrar empleados por nombre");
        ArrayList<Empleado> filtrados2 = filtrarEmpleados(empleados, "nombre", "Pedro");
        mostrarEmpleados(filtrados2);
        System.out.println();

        // Buscar un empleado por nombre
        System.out.println("Buscar por nombre (Ana):");
        Empleado empleadoEncontrado = buscarEmpleadoPorNombre(empleados, "Ana García");

        System.out.println();
        if (empleadoEncontrado != null) {
            System.out.println("Empleado encontrado:");
            System.out.print(empleadoEncontrado.formatoEmpleado(1)); // Mostramos el empleado con el formato adecuado
        } else {
            System.out.println("Empleado no encontrado.");
        }
        System.out.println();


        // Incrementar salario de un empleado específico
        System.out.println("Incrementar salario");
        Empleado empleado = empleados.get(0); //primer empleado
        double porcentajeAumento = 10; // 10% 

        incrementarSalario(empleado, porcentajeAumento);

        System.out.println("Empleado con salario actualizado:");
        System.out.print(empleado.formatoEmpleado(1)); 
        System.out.println();

    }

    public static void mostrarEmpleados(ArrayList<Empleado> empleados) {

        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-5s %-10s %-10s%n", "Nº", "Nombre", "Edad", "Salario", "Departamento");
        System.out.println("--------------------------------------------------------------");

        // Imprimir cada empleado en formato de tabla
        for (int i = 0; i < empleados.size(); i++) {
            // Se obtiene el empleado
            Empleado empleado = empleados.get(i); 
            // Se imprimero en el formato
            System.out.print(empleado.formatoEmpleado(i + 1));

        }
        System.out.println("--------------------------------------------------------------");
    }

    public static ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> empleados, String criterio,
            String filtroTexto) {
        ArrayList<Empleado> empleadosFiltrados = new ArrayList<>();

        for (Empleado empleado : empleados) {
            switch (criterio.toLowerCase()) {
                case "nombre":
                    if (empleado.getNombre().toLowerCase().contains(filtroTexto.toLowerCase())) {
                        empleadosFiltrados.add(empleado);
                    }
                    break;
                case "departamento":
                    if (empleado.getDepartamento().toLowerCase().contains(filtroTexto.toLowerCase())) {
                        empleadosFiltrados.add(empleado);
                    }
                    break;
                default:
                    System.out.println("Criterio de filtrado no válido.");
            }
        }

        return empleadosFiltrados;
    }

    public static ArrayList<Empleado> filtrarEmpleados(ArrayList<Empleado> empleados, String criterio, Integer min,
            Integer max) {
        ArrayList<Empleado> empleadosFiltrados = new ArrayList<>();

        for (Empleado empleado : empleados) {
            switch (criterio.toLowerCase()) {

                case "edad":
                    if (empleado.getEdad() >= min && empleado.getEdad() <= max) {
                        empleadosFiltrados.add(empleado);
                    }
                    break;
                case "salario":
                    if (empleado.getSalario() >= min && empleado.getSalario() <= max) {
                        empleadosFiltrados.add(empleado);
                    }
                    break;

                default:
                    System.out.println("Criterio de filtrado no válido.");
            }
        }

        return empleadosFiltrados;
    }

    // Método para buscar un empleado por el nombre
    public static Empleado buscarEmpleadoPorNombre(ArrayList<Empleado> empleados, String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                return empleado; // Devuelve el primer empleado que coincide, ya no es necesario continuar
            }
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Método para incrementar el salario de un empleado
    public static Empleado incrementarSalario(Empleado empleado, double porcentaje) {//20 
        double salarioActual = empleado.getSalario();
        double aumento = salarioActual * (porcentaje / 100);
        empleado.setSalario(salarioActual + aumento); // Actualiza el salario con el aumento
        return empleado; // Devuelve el objeto del empleado actualizado
    }

}
