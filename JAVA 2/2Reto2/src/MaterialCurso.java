public abstract class MaterialCurso {
    protected String título;
    protected String autor;

    public MaterialCurso(String título, String autor) {
        this.título = título;
        this.autor = autor;
    }

    public abstract void mostrarDetalle();
}
