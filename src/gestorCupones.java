public class GestorCupones {
    private Cupon[] cupones;

    public GestorCupones(Cupon[] cupones) {
        this.cupones = cupones;
    }

    public int contarActivos() {
        if (cupones == null) {
            return 0;
        }
        int contador = 0;
        for (Cupon c : cupones) {
            if (c != null && c.isActivo()) {
                contador++;
            }
        }
        return contador;
    }

    public String buscarPorCodigo(String codigoBuscado) {
        if (cupones == null || codigoBuscado == null) {
            return "No se encontró ningún cupón con el código: " + codigoBuscado;
        }
        for (Cupon c : cupones) {
            if (c != null && c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                return c.describir();
            }
        }
        return "No se encontró ningún cupón con el código: \"" + codigoBuscado + "\".";
    }

    public double calcularPromedioDescuento() {
        if (cupones == null || cupones.length == 0) {
            return 0.0;
        }
        double suma = 0.0;
        int validos = 0;
        for (Cupon c : cupones) {
            if (c != null) {
                suma += c.getPorcentaje();
                validos++;
            }
        }
        if (validos == 0) {
            return 0.0;
        }
        return suma / validos;
    }

    public String listarPorCategoria(String categoriaBuscada) {
        if (cupones == null || categoriaBuscada == null) {
            return "No hay cupones para la categoría: " + categoriaBuscada;
        }
        StringBuilder sb = new StringBuilder();
        int encontrados = 0;
        for (Cupon c : cupones) {
            if (c != null && c.getCategoria() != null && c.getCategoria().equalsIgnoreCase(categoriaBuscada)) {
                encontrados++;
                if (encontrados > 1) {
                    sb.append("\n");
                }
                sb.append(encontrados).append(". ").append(c.describir());
            }
        }
        if (encontrados == 0) {
            return "No se encontraron cupones en la categoría \"" + categoriaBuscada + "\".";
        }
        return sb.toString();
    }
}