package management;

import entities.Agente;
import utils.ConsoleUtils;

import java.util.ArrayList;



public class AgenteManager {
    private ArrayList<Agente> agentes;
    int nivel;

    

    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        int nivel= ConsoleUtils.leerEntero("ingrese el nivel del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");
        
        aumentarnivel();


        Agente nuevoAgente = new Agente(id, nombre, habilidad, nivel);
        agentes.add(nuevoAgente);
        
        System.out.println("Agente registrado con éxito.");
        
    }

    public void aumentarnivel(){
        
       String opcion="";
        do{
            
            opcion= ConsoleUtils.leerTexto("¿Desea aumentar nivel? (Si/No)");
            nivel+=1;

        } while(opcion.equalsIgnoreCase("si"));{

        }
        
    }
    

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
            System.out.print("nivel: "+nivel);
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();
                case 3 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}