package modelos;

public class Empleado {

    // atributos
    private String nombre;
    private int edad;
    private double salario;
    private String departamento;


    // Constructor
    public Empleado(String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Empleado(){

    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        }
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String formatoEmpleado(int fila) {
        return String.format("%-5d %-20s %-5d %-10.2f %-10s%n", 
            fila, 
            this.nombre, 
            this.edad, 
            this.salario, 
            this.departamento);
    }

}
