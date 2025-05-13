import java.util.ArrayList;
import java.io.*;

public class ArrayListAutos implements Contabilidad {
    private ArrayList<Autos1> inventarioAutos = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private static final String INVENTARIO_FILE = "inventario.txt";
    private static final String CLIENTES_FILE = "clientes.txt";

    // Constructor que carga los datos al iniciar
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

    public void venderAuto(int indice, String nombreCliente) {
        if (indice >= 0 && indice < inventarioAutos.size()) {
            Autos1 auto = inventarioAutos.remove(indice);
            listaClientes.add(new Cliente(nombreCliente, auto, auto.getPrecioVenta()));
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
            System.out.println("-------------------------------------------------");
            System.out.printf("%-20s %-30s %-15s\n", "Nombre del Cliente", "Unidad Comprada", "Precio de Compra");
            System.out.println("-------------------------------------------------");
            for (Cliente cliente : listaClientes) {
                System.out.printf("%-20s %-30s %-15.2f\n",
                        cliente.getNombre(),
                        cliente.getUnidadComprada(),
                        cliente.getPrecioCompra());
            }
            System.out.println("-------------------------------------------------");
        }
    }

    @Override
    public void trabajoContable() {
        double totalIngresos = 0;
        double totalCostos = 0;
        double gananciasPorVentas = 0;

        for (Cliente cliente : listaClientes) {
            totalIngresos += cliente.getPrecioCompra();
        }

        for (Autos1 auto : inventarioAutos) {
            totalCostos += auto.getPrecioCompra();
        }

        for (Cliente cliente : listaClientes) {
            totalIngresos += cliente.getPrecioCompra();
            for (Autos1 auto : inventarioAutos) {
                if (cliente.getUnidadComprada().contains(auto.getMarca()) && cliente.getUnidadComprada().contains(auto.getVersion())) {
                    gananciasPorVentas += cliente.getPrecioCompra() - auto.getPrecioCompra();
                    break;
                }
            }
        }

        System.out.println("\nContabilidad:");
        System.out.println("-------------------------------------------------");
        System.out.printf("Total de ingresos por ventas: %.2f\n", totalIngresos);
        System.out.printf("Costo total de autos en inventario: %.2f\n", totalCostos);
        System.out.printf("Ganancias por ventas: %.2f\n", gananciasPorVentas);
        System.out.println("-------------------------------------------------");
    }

    public void mostrarContabilidad() {
        trabajoContable();
    }

    public ArrayList<Autos1> getInventarioAutos() {
        return inventarioAutos;
    }

    // Método para guardar el inventario en un archivo
    private void guardarInventario() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVENTARIO_FILE))) {
            for (Autos1 auto : inventarioAutos) {
                if (auto instanceof Nuevos) {
                    Nuevos nuevo = (Nuevos) auto;
                    writer.println("NUEVO," + auto.getNserie() + "," + auto.getMarca() + "," + auto.getModelo() + ","
                            + auto.getVersion() + "," + auto.getColor() + "," + auto.getAño() + ","
                            + auto.getPrecioCompra() + "," + auto.getPrecioVenta() + "," + nuevo.getGarantia() + ","
                            + nuevo.getAccesorios() + "," + nuevo.getEnganche() + "," + auto.getNombrepers());
                } else if (auto instanceof Seminuevos) {
                    Seminuevos seminuevo = (Seminuevos) auto;
                    writer.println("SEMINUEVO," + auto.getNserie() + "," + auto.getMarca() + "," + auto.getModelo() + ","
                            + auto.getVersion() + "," + auto.getColor() + "," + auto.getAño() + ","
                            + auto.getPrecioCompra() + "," + auto.getPrecioVenta() + "," + seminuevo.getKilometraje() + ","
                            + seminuevo.getCantidadDueños() + "," + seminuevo.getNacionalidad() + ","
                            + auto.getNombrepers());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    // Método para cargar el inventario desde un archivo
    private void cargarInventario() {
        File file = new File(INVENTARIO_FILE);
        if (!file.exists()) {
            return; // Si el archivo no existe, no hay datos que cargar
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 12) continue; // Ignorar líneas mal formadas

                String tipo = parts[0];
                String nserie = parts[1];
                String marca = parts[2];
                String modelo = parts[3];
                String version = parts[4];
                String color = parts[5];
                double año = Double.parseDouble(parts[6]);
                double precioCompra = Double.parseDouble(parts[7]);
                double precioVenta = Double.parseDouble(parts[8]);
                String nombrepers = parts[parts.length - 1];

                if (tipo.equals("NUEVO") && parts.length == 13) {
                    int garantia = Integer.parseInt(parts[9]);
                    String accesorios = parts[10];
                    double enganche = Double.parseDouble(parts[11]);
                    Nuevos auto = new Nuevos(garantia, accesorios, marca, modelo, version, enganche, nombrepers, nserie,
                            color, precioVenta, año, precioCompra);
                    inventarioAutos.add(auto);
                } else if (tipo.equals("SEMINUEVO") && parts.length == 13) {
                    double kilometraje = Double.parseDouble(parts[9]);
                    int cantidadDueños = Integer.parseInt(parts[10]);
                    String nacionalidad = parts[11];
                    Seminuevos auto = new Seminuevos(kilometraje, año, cantidadDueños, nacionalidad, nombrepers, nserie,
                            marca, modelo, version, color, precioVenta, precioCompra);
                    inventarioAutos.add(auto);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos del inventario: " + e.getMessage());
        }
    }

    // Método para guardar la lista de clientes en un archivo
    private void guardarClientes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CLIENTES_FILE))) {
            for (Cliente cliente : listaClientes) {
                writer.println(cliente.getNombre() + "," + cliente.getUnidadComprada() + ","
                        + cliente.getPrecioCompra());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la lista de clientes: " + e.getMessage());
        }
    }

    // Método para cargar la lista de clientes desde un archivo
    private void cargarClientes() {
        File file = new File(CLIENTES_FILE);
        if (!file.exists()) {
            return; // Si el archivo no existe, no hay datos que cargar
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) continue; // Ignorar líneas mal formadas

                String nombre = parts[0];
                String unidadComprada = parts[1];
                double precioCompra = Double.parseDouble(parts[2]);

                // Crear un objeto Autos1 genérico para el cliente
                Autos1 auto = new Autos1("", "", "", "", "", "", 0, 0, precioCompra) {
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
                listaClientes.add(new Cliente(nombre, auto, precioCompra));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar la lista de clientes: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos de clientes: " + e.getMessage());
        }
    }
}