import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // Datos de prueba
        Sucursal centro = new Sucursal("Centro", Arrays.asList(
                new Encuesta("Sundiata", "No me gusto la atención", 2),
                new Encuesta("Galio", null, 2),
                new Encuesta("Alika", "Ok", 5)
        ));

        Sucursal norte = new Sucursal("Norte", Arrays.asList(
                new Encuesta("Sara", "Estuvo ok, pero no me gustó la decoracn", 3),
                new Encuesta("Elena", null, 4),
                new Encuesta("Gus", "No me gusto nada", 1)
        ));

        List<Sucursal> sucursales = Arrays.asList(centro, norte);

        List<String> mensajes = sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(encuesta -> encuesta.getCalificacion() <= 3)
                                .map(encuesta -> encuesta.getComentario()
                                        .map(c -> "Sucursal " + sucursal.getNombre() + ": Seguimiento a paciente con comentario: \"" + c + "\"")
                                )
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                )
                .collect(Collectors.toList());

        // Imprimir resultados
        mensajes.forEach(System.out::println);
    }
}
