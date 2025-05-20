import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ArrayListAutos {
    private ArrayList<Autos1> inventarioAutos = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static final String INVENTARIO_FILE = "inventario.txt";
    private static final String CLIENTES_FILE = "clientes.txt";

    public ArrayListAutos() {
        cargarInventario();
        cargarClientes();
    }

    public void agregarAuto(Autos1 auto) {
        inventarioAutos.add(auto);
        guardarInventario();
    }

    public void mostrarInventario() {
        if (inventarioAutos.isEmpty()) {
            System.out.println("No hay autos en el inventario.");
        } else {
            for (int i = 0; i < inventarioAutos.size(); i++) {
                Autos1 auto = inventarioAutos.get(i);
                System.out.println(i + ". " + auto.getMarca() + " - " + auto.getVersion() + " - " + auto.getColor());
            }
        }
    }

    public void venderAuto(int indice, String nombreCliente, LocalDate fechaCompra) {
        if (indice >= 0 && indice < inventarioAutos.size()) {
            Autos1 auto = inventarioAutos.remove(indice);
            listaClientes.add(new Cliente(nombreCliente, auto, auto.getPrecioCompra(), auto.getPrecioVenta(), fechaCompra));
            System.out.println("Auto vendido a " + nombreCliente + ": " + auto.getMarca() + " " + auto.getVersion());
            guardarInventario();
            guardarClientes();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void mostrarListaClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("\nLista de clientes:");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-20s %-30s %-15s %-15s\n", "Nombre del Cliente", "Unidad Comprada", "Precio de Venta", "Fecha Compra");
            System.out.println("-------------------------------------------------------------");
            for (Cliente cliente : listaClientes) {
                System.out.printf("%-20s %-30s %-15.2f %-15s\n",
                        cliente.getNombre(),
                        cliente.getUnidadComprada(),
                        cliente.getPrecioVenta(),
                        cliente.getFechaCompra().toString());
            }
            System.out.println("-------------------------------------------------------------");
        }
    }

    public void mostrarContabilidad() {
        double totalIngresos = 0;
        double totalCostos = 0;
        double gananciasPorVentas = 0;

        for (Cliente cliente : listaClientes) {
            totalIngresos += cliente.getPrecioVenta();
            gananciasPorVentas += cliente.getGanancia();
        }

        for (Autos1 auto : inventarioAutos) {
            totalCostos += auto.getPrecioCompra();
        }

        System.out.println("\nContabilidad:");
        System.out.println("-------------------------------------------------");
        System.out.printf("Total de ingresos por ventas: %.2f\n", totalIngresos);
        System.out.printf("Costo total de autos en inventario: %.2f\n", totalCostos);
        System.out.printf("Ganancias por ventas: %.2f\n", gananciasPorVentas);
        System.out.println("-------------------------------------------------");
    }

    public ArrayList<Autos1> getInventarioAutos() {
        return inventarioAutos;
    }

    private void guardarInventario() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVENTARIO_FILE))) {
            writer.println(String.format("%-10s|%-18s|%-15s|%-15s|%-15s|%-10s|%-6s|%-12s|%-12s|%-10s|%-20s|%-12s|%-20s",
                    "Tipo", "N. Serie", "Marca", "Modelo", "Version", "Color", "Año", "P. Compra", "P. Venta", 
                    "Extra1", "Extra2", "Extra3", "Nombre Pers."));
            writer.println("-".repeat(174));

            for (Autos1 auto : inventarioAutos) {
                if (auto instanceof Nuevos) {
                    Nuevos nuevo = (Nuevos) auto;
                    writer.println(String.format("%-10s|%-18s|%-15s|%-15s|%-15s|%-10s|%-6.0f|%-12.2f|%-12.2f|%-10d|%-20s|%-12.2f|%-20s",
                            "NUEVO", auto.getNserie(), auto.getMarca(), auto.getModelo(), auto.getVersion(), 
                            auto.getColor(), auto.getAño(), auto.getPrecioCompra(), auto.getPrecioVenta(),
                            nuevo.getGarantia(), nuevo.getAccesorios(), nuevo.getEnganche(), auto.getNombrepers()));
                } else if (auto instanceof Seminuevos) {
                    Seminuevos seminuevo = (Seminuevos) auto;
                    writer.println(String.format("%-10s|%-18s|%-15s|%-15s|%-15s|%-10s|%-6.0f|%-12.2f|%-12.2f|%-10.2f|%-20s|%-12s|%-20s",
                            "SEMINUEVO", auto.getNserie(), auto.getMarca(), auto.getModelo(), auto.getVersion(), 
                            auto.getColor(), auto.getAño(), auto.getPrecioCompra(), auto.getPrecioVenta(),
                            seminuevo.getKilometraje(), seminuevo.getCantidadDueños(), seminuevo.getNacionalidad(), 
                            auto.getNombrepers()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    private void cargarInventario() {
        File file = new File(INVENTARIO_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true;
            boolean secondLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                if (secondLine) {
                    secondLine = false;
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length < 13) continue;

                String tipo = parts[0].trim();
                String nserie = parts[1].trim();
                String marca = parts[2].trim();
                String modelo = parts[3].trim();
                String version = parts[4].trim();
                String color = parts[5].trim();
                double año = Double.parseDouble(parts[6].trim());
                double precioCompra = Double.parseDouble(parts[7].trim());
                double precioVenta = Double.parseDouble(parts[8].trim());
                String nombrepers = parts[12].trim();

                try {
                    if (tipo.equals("NUEVO") && parts.length == 13) {
                        int garantia = Integer.parseInt(parts[9].trim());
                        String accesorios = parts[10].trim();
                        double enganche = Double.parseDouble(parts[11].trim());
                        Nuevos auto = new Nuevos(garantia, accesorios, marca, modelo, version, enganche, nombrepers, 
                                nserie, color, precioVenta, año, precioCompra);
                        inventarioAutos.add(auto);
                    } else if (tipo.equals("SEMINUEVO") && parts.length == 13) {
                        double kilometraje = Double.parseDouble(parts[9].trim());
                        int cantidadDueños = Integer.parseInt(parts[10].trim());
                        String nacionalidad = parts[11].trim();
                        Seminuevos auto = new Seminuevos(kilometraje, año, cantidadDueños, nacionalidad, nombrepers, 
                                nserie, marca, modelo, version, color, precioVenta, precioCompra);
                        inventarioAutos.add(auto);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error en el formato de los datos en línea: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario: " + e.getMessage());
        }
    }

    private void guardarClientes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CLIENTES_FILE))) {
            writer.println(String.format("%-20s|%-30s|%-15s|%-15s|%-15s", 
                    "Nombre", "Unidad Comprada", "Costo Dealership", "Precio Venta", "Fecha Compra"));
            writer.println("-".repeat(98));

            for (Cliente cliente : listaClientes) {
                writer.println(String.format("%-20s|%-30s|%-15.2f|%-15.2f|%-15s",
                        cliente.getNombre(), cliente.getUnidadComprada(), cliente.getCostoDealership(), 
                        cliente.getPrecioVenta(), cliente.getFechaCompra().toString()));
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la lista de clientes: " + e.getMessage());
        }
    }

    private void cargarClientes() {
        File file = new File(CLIENTES_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean firstLine = true;
            boolean secondLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                if (secondLine) {
                    secondLine = false;
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length < 4) continue;

                String nombre = parts[0].trim();
                String unidadComprada = parts[1].trim();
                double costoDealership;
                double precioVenta;
                LocalDate fechaCompra = null;
                try {
                    costoDealership = Double.parseDouble(parts[2].trim());
                    precioVenta = parts.length > 3 ? Double.parseDouble(parts[3].trim()) : costoDealership * 0.77;
                    if (parts.length > 4) {
                        fechaCompra = LocalDate.parse(parts[4].trim());
                    } else {
                        fechaCompra = LocalDate.now(); // Default to today for old records
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error en el formato del precio en línea: " + line);
                    continue;
                } catch (DateTimeParseException e) {
                    System.out.println("Error en el formato de la fecha en línea: " + line);
                    continue;
                }

                Autos1 auto = new Autos1("", "", "", "", "", "", 0, costoDealership, precioVenta) {
                    @Override
                    public String getMarca() {
                        return unidadComprada.split(" ")[0];
                    }

                    @Override
                    public String getVersion() {
                        return unidadComprada.split(" ")[1].split(" \\(")[0];
                    }

                    @Override
                    public String getColor() {
                        return unidadComprada.split("\\(")[1].replace(")", "");
                    }
                };
                listaClientes.add(new Cliente(nombre, auto, costoDealership, precioVenta, fechaCompra));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar la lista de clientes: " + e.getMessage());
        }
    }
}