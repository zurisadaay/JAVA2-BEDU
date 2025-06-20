import java.util.List;

public class GestorOrdenes {
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("📦 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
        System.out.println();
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("🛠 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada orden) {
                System.out.println("✅ Orden " + orden.codigo + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
        System.out.println();
    }
}
