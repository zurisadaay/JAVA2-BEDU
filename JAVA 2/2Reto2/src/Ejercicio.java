public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String título, String autor) {
        super(título, autor);
        this.revisado = false;
    }

    public void marcarRevisado() {
        revisado = true;
    }

    public boolean isRevisado() {
        return revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📘 Ejercicio: " + título + " - Autor: " + autor + " - Revisado: " + revisado);
    }
}
