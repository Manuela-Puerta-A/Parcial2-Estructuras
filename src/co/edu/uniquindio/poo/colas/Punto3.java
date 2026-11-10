package co.edu.uniquindio.poo.colas;


public class Punto3 {

    public static Cola<Solicitud> seleccionarSolicitudes(Cola<Solicitud> pendientes, int minutos) {
        Cola<Solicitud> seleccionadas = new Cola<>(pendientes.getSize());

      
        if (minutos <= 0) {
            return seleccionadas;
        }

        int restante = minutos;

   
        String[] prioridades = {"ALTA", "NORMAL"};

        for (int p = 0; p < prioridades.length; p++) {
            int cantidad = pendientes.getSize(); 
            for (int i = 0; i < cantidad; i++) {
                Solicitud s = pendientes.desencolar();
                if (s.getPrioridad().equals(prioridades[p]) && s.getDuracion() <= restante) {
                    seleccionadas.encolar(s);       
                    restante = restante - s.getDuracion();
                } else {
                    pendientes.encolar(s);       
                }
            }
        }
       
        return seleccionadas;
    }

    public static void main(String[] args) {
        Cola<Solicitud> pendientes = new Cola<>(100);
        pendientes.encolar(new Solicitud("S1", "NORMAL", 10));
        pendientes.encolar(new Solicitud("S2", "ALTA", 30));
        pendientes.encolar(new Solicitud("S3", "ALTA", 15));
        pendientes.encolar(new Solicitud("S4", "NORMAL", 5));

        System.out.print("Pendientes al inicio: ");
        pendientes.imprimir();
        System.out.println();

        Cola<Solicitud> seleccionadas = seleccionarSolicitudes(pendientes, 25);

        System.out.print("Seleccionadas (25 min): ");
        seleccionadas.imprimir();
        System.out.println();
        System.out.print("Pendientes al final: ");
        pendientes.imprimir();
        System.out.println();

        System.out.println("Con 0 minutos, cuantas selecciona: "
                + seleccionarSolicitudes(pendientes, 0).getSize()
                + " y pendientes sigue con " + pendientes.getSize());
    }
}
