public class Main {
    public static void main(String[] args) {
        // Crear al menos 6 cupones de 3 categorías ("Moda", "Tecnologia", "Hogar")
        Cupon c1 = new Cupon("MODA10", 10.0, "Moda", true);
        Cupon c2 = new Cupon("TECH25", 25.0, "Tecnologia", true);
        Cupon c3 = new Cupon("HOGAR15", 15.0, "Hogar", false);
        Cupon c4 = new Cupon("MODA20", 20.0, "Moda", true);
        Cupon c5 = new Cupon("TECH30", 30.0, "Tecnologia", false);
        Cupon c6 = new Cupon("HOGAR05", 5.0, "Hogar", true);

        Cupon[] arregloCupones = { c1, c2, c3, c4, c5, c6 };
        GestorCupones gestor = new GestorCupones(arregloCupones);

        // 1. Conteo activo
        System.out.println("=== 1. CONTEO ACTIVO ===");
        System.out.println("Cupones activos: " + gestor.contarActivos());

        // 2. Promedio
        System.out.println("\n=== 2. PROMEDIO DE DESCUENTO ===");
        System.out.printf("Promedio de descuento: %.2f%%%n", gestor.calcularPromedioDescuento());

        // 3. Código existente / inexistente
        System.out.println("\n=== 3. BUSCAR CÓDIGO EXISTENTE ===");
        System.out.println(gestor.buscarPorCodigo("TECH25"));

        System.out.println("\n=== 4. BUSCAR CÓDIGO INEXISTENTE ===");
        System.out.println(gestor.buscarPorCodigo("NOEXISTE99"));

        // 4. Listado por categoría con resultados y sin resultados (probando dos categorías diferentes)
        System.out.println("\n=== 5. LISTAR CATEGORÍA CON RESULTADOS (Moda) ===");
        System.out.println(gestor.listarPorCategoria("Moda"));

        System.out.println("\n=== 6. LISTAR OTRA CATEGORÍA CON RESULTADOS (Tecnologia) ===");
        System.out.println(gestor.listarPorCategoria("Tecnologia"));

        System.out.println("\n=== 7. LISTAR CATEGORÍA SIN RESULTADOS (Deportes) ===");
        System.out.println(gestor.listarPorCategoria("Deportes"));
    }
}