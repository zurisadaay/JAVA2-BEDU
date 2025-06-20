import java.util.List;

public class UtilidadesCurso {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("📚 Materiales del curso:");
        for (MaterialCurso m : lista) {
            m.mostrarDetalle();
        }
    }

    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista) {
            total += v.getDuracion();
        }
        System.out.println("\n⏱ Duración total de videos: " + total + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object o : lista) {
            if (o instanceof Ejercicio e) {
                e.marcarRevisado();
                System.out.println("✅ Ejercicio '" + e.título + "' marcado como revisado.");
            }
        }
    }
}
