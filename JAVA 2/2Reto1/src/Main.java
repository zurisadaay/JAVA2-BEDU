import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Órdenes en masa
        List<OrdenMasa> ordenesMasa = List.of(
                new OrdenMasa("A123", 500),
                new OrdenMasa("A124", 750)
        );

        // Órdenes personalizadas
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        // Órdenes prototipo
        List<OrdenPrototipo> ordenesPrototipo = List.of(
                new OrdenPrototipo("T789", 10, "Diseño"),
                new OrdenPrototipo("T799", 5, "Pruebas")
        );

        // Mostrar órdenes
        GestorOrdenes.mostrarOrdenes(ordenesMasa);
        GestorOrdenes.mostrarOrdenes(ordenesPersonalizadas);
        GestorOrdenes.mostrarOrdenes(ordenesPrototipo);

        // Procesar personalizadas
        GestorOrdenes.procesarPersonalizadas(ordenesPersonalizadas, 200);

        // Resumen final
        System.out.println("📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + ordenesMasa.size());
        System.out.println("🛠 Personalizadas: " + ordenesPersonalizadas.size());
        System.out.println("🧪 Prototipos: " + ordenesPrototipo.size());
    }
}
