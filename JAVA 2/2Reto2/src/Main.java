import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();

        // Videos
        Video v1 = new Video("Introducción a Java para gatitos", "Sundiata", 80);
        Video v2 = new Video("POO en Java I", "Alika", 90);

        // Artículos
        Articulo a1 = new Articulo("Historia de michis", "Galio", 1200);
        Articulo a2 = new Articulo("Tipos de datos para michis", "Jenestasio", 80000);

        // Ejercicios
        Ejercicio e1 = new Ejercicio("Variables y tipos de gatitos", "Pedrito");
        Ejercicio e2 = new Ejercicio("Condicionales II", "Elena");

        // Agregar a lista general
        materiales.add(v1);
        materiales.add(v2);
        materiales.add(a1);
        materiales.add(a2);
        materiales.add(e1);
        materiales.add(e2);

        // Usar métodos genéricos
        UtilidadesCurso.mostrarMateriales(materiales);

        List<Video> videos = List.of(v1, v2);
        UtilidadesCurso.contarDuracionVideos(videos);

        List<MaterialCurso> ejercicios = List.of(e1, e2);
        UtilidadesCurso.marcarEjerciciosRevisados(ejercicios);

        // Filtrar por autor
        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (MaterialCurso m : materiales) {
            if (m.autor.equals("Galio")) {
                m.mostrarDetalle();
            }
        }
    }
}
