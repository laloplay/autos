import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayListAutos listaAutos = new ArrayListAutos();
        System.out.println("Datos cargados desde los archivos de inventario y clientes.");

        while (true) {
            try {
                System.out.println("\n¿Qué desea realizar?");
                System.out.println("1. Comprar auto (agregar al inventario)");
                System.out.println("2. Vender auto");
                System.out.println("3. Contabilidad");
                System.out.println("4. Lista de clientes");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        boolean reiniciarFormulario;
                        do {
                            reiniciarFormulario = false;
                            try {
                                // Nombre
                                String nombrePersona = null;
                                int intentosNombre = 5;
                                while (intentosNombre > 0) {
                                    try {
                                        System.out.println("Ingrese su nombre: ");
                                        nombrePersona = scanner.nextLine().trim();
                                        if (nombrePersona.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")
                                                && !nombrePersona.isBlank()) {
                                            break;
                                        } else {
                                            intentosNombre--;
                                            System.out.println(
                                                    "Error: El nombre solo puede contener letras y espacios, y no puede estar vacío.\n"
                                                            + intentosNombre + " intentos restantes.");
                                            if (intentosNombre == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        intentosNombre--;
                                        System.out.println("Error inesperado: " + e.getMessage() + "\n" + intentosNombre
                                                + " intentos restantes.");
                                        if (intentosNombre == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Número de serie
                                String nserie = null;
                                int intentosNserie = 5;
                                while (intentosNserie > 0) {
                                    try {
                                        System.out.println(
                                                "Ingrese número de serie del auto (17 caracteres, solo letras y números): ");
                                        nserie = scanner.nextLine();
                                        if (nserie.matches("[a-zA-Z0-9]{17}")) {
                                            break;
                                        } else {
                                            intentosNserie--;
                                            System.out.println(
                                                    "Error: El número de serie debe tener exactamente 17 caracteres y solo contener letras y números.\n"
                                                            + intentosNserie + " intentos restantes.");
                                            if (intentosNserie == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        intentosNserie--;
                                        System.out.println("Error inesperado: " + e.getMessage() + "\n" + intentosNserie
                                                + " intentos restantes.");
                                        if (intentosNserie == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Marca
                                String marca = null;
                                int intentosMarca = 5;
                                while (intentosMarca > 0) {
                                    try {
                                        System.out.println("Ingrese la marca del auto (ej. Ram): ");
                                        marca = scanner.nextLine();
                                        if (marca.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                                            break;
                                        } else {
                                            intentosMarca--;
                                            System.out
                                                    .println("Error: La marca solo puede contener letras y espacios.\n"
                                                            + intentosMarca + " intentos restantes.");
                                            if (intentosMarca == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        intentosMarca--;
                                        System.out.println("Error inesperado: " + e.getMessage() + "\n" + intentosMarca
                                                + " intentos restantes.");
                                        if (intentosMarca == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Modelo
                                String modelo = null;
                                int intentosModelo = 5;
                                while (intentosModelo > 0) {
                                    try {
                                        System.out.println("Ingrese el modelo del auto (ej. 1500): ");
                                        modelo = scanner.nextLine();
                                        if (modelo.matches("[a-zA-Z0-9]+")) {
                                            break;
                                        } else {
                                            intentosModelo--;
                                            System.out
                                                    .println("Error: El modelo solo puede contener letras y números.\n"
                                                            + intentosModelo + " intentos restantes.");
                                            if (intentosModelo == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        intentosModelo--;
                                        System.out.println("Error inesperado: " + e.getMessage() + "\n" + intentosModelo
                                                + " intentos restantes.");
                                        if (intentosModelo == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Versión
                                String version = null;
                                int intentosVersion = 5;
                                while (intentosVersion > 0) {
                                    try {
                                        System.out.println("Ingrese la versión del auto (ej. laramie): ");
                                        version = scanner.nextLine();
                                        if (version.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                                            break;
                                        } else {
                                            intentosVersion--;
                                            System.out.println(
                                                    "Error: La versión solo puede contener letras y espacios.\n"
                                                            + intentosVersion + " intentos restantes.");
                                            if (intentosVersion == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        intentosVersion--;
                                        System.out.println("Error inesperado: " + e.getMessage() + "\n"
                                                + intentosVersion + " intentos restantes.");
                                        if (intentosVersion == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Color
                                String color = null;
                                int intentosColor = 5;
                                while (intentosColor > 0) {
                                    try {
                                        System.out.println("Ingrese el color del auto: ");
                                        color = scanner.nextLine();
                                        if (color.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                                            break;
                                        } else {
                                            intentosColor--;
                                            System.out
                                                    .println("Error: El color solo puede contener letras y espacios.\n"
                                                            + intentosColor + " intentos restantes.");
                                            if (intentosColor == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (Exception e) {
                                        intentosColor--;
                                        System.out.println("Error inesperado: " + e.getMessage() + "\n" + intentosColor
                                                + " intentos restantes.");
                                        if (intentosColor == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Año
                                double año = 0;
                                int intentosAño = 5;
                                while (intentosAño > 0) {
                                    try {
                                        System.out.println("Ingrese el año del auto (entre 1950 y 2026): ");
                                        año = Double.parseDouble(scanner.nextLine());
                                        if (año >= 1950 && año <= 2026) {
                                            break;
                                        } else {
                                            intentosAño--;
                                            System.out.println("Error: El año debe estar entre 1950 y 2026.\n"
                                                    + intentosAño + " intentos restantes.");
                                            if (intentosAño == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        intentosAño--;
                                        System.out.println("Error: Ingrese un valor numérico válido para el año.\n"
                                                + intentosAño + " intentos restantes.");
                                        if (intentosAño == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Precio de compra
                                double precioCompra = 0;
                                int intentosPrecioCompra = 5;
                                while (intentosPrecioCompra > 0) {
                                    try {
                                        System.out.println("Ingrese el precio de compra: ");
                                        precioCompra = Double.parseDouble(scanner.nextLine());
                                        if (precioCompra > 0) {
                                            break;
                                        } else {
                                            intentosPrecioCompra--;
                                            System.out
                                                    .println("Error: El precio de compra debe ser un valor positivo.\n"
                                                            + intentosPrecioCompra + " intentos restantes.");
                                            if (intentosPrecioCompra == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        intentosPrecioCompra--;
                                        System.out.println(
                                                "Error: Ingrese un valor numérico válido para el precio de compra.\n"
                                                        + intentosPrecioCompra + " intentos restantes.");
                                        if (intentosPrecioCompra == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Precio de venta
                                double precioVenta = 0;
                                int intentosPrecioVenta = 5;
                                while (intentosPrecioVenta > 0) {
                                    try {
                                        System.out.println("Ingrese el precio de venta: ");
                                        precioVenta = Double.parseDouble(scanner.nextLine());
                                        if (precioVenta < precioCompra) {
                                            throw new PrecioInvalidoException(
                                                    "El precio de venta no puede ser menor al precio de compra.");
                                        }
                                        break;
                                    } catch (NumberFormatException e) {
                                        intentosPrecioVenta--;
                                        System.out.println(
                                                "Error: Ingrese un valor numérico válido para el precio de venta.\n"
                                                        + intentosPrecioVenta + " intentos restantes.");
                                        if (intentosPrecioVenta == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    } catch (PrecioInvalidoException e) {
                                        intentosPrecioVenta--;
                                        System.out.println("Error: " + e.getMessage() + "\n" + intentosPrecioVenta
                                                + " intentos restantes.");
                                        if (intentosPrecioVenta == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                // Menú (nuevo o seminuevo)
                                int menu = 0;
                                int intentosMenu = 5;
                                while (intentosMenu > 0) {
                                    try {
                                        System.out.println("¿Es un auto nuevo? (1: Sí, 2: No): ");
                                        menu = Integer.parseInt(scanner.nextLine());
                                        if (menu == 1 || menu == 2) {
                                            break;
                                        }
                                        intentosMenu--;
                                        System.out.println(
                                                "Error: Seleccione 1 o 2.\n" + intentosMenu + " intentos restantes.");
                                        if (intentosMenu == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    } catch (NumberFormatException e) {
                                        intentosMenu--;
                                        System.out.println("Error: Ingrese un valor numérico válido (1 o 2).\n"
                                                + intentosMenu + " intentos restantes.");
                                        if (intentosMenu == 0) {
                                            System.out.println(
                                                    "Reiniciando el formulario...");
                                            reiniciarFormulario = true;
                                            break;
                                        }
                                    }
                                }
                                if (reiniciarFormulario)
                                    continue;

                                if (menu == 1) {
                                    // Auto nuevo
                                    int garantia = 0;
                                    int intentosGarantia = 5;
                                    while (intentosGarantia > 0) {
                                        try {
                                            System.out.println("Ingrese la garantía en años (entre 1 y 5): ");
                                            garantia = Integer.parseInt(scanner.nextLine());
                                            if (garantia >= 1 && garantia <= 5) {
                                                break;
                                            } else {
                                                intentosGarantia--;
                                                System.out.println("Error: La garantía debe estar entre 1 y 5 años.\n"
                                                        + intentosGarantia + " intentos restantes.");
                                                if (intentosGarantia == 0) {
                                                    System.out.println(
                                                            "Reiniciando el formulario...");
                                                    reiniciarFormulario = true;
                                                    break;
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            intentosGarantia--;
                                            System.out.println(
                                                    "Error: Ingrese un valor numérico válido para la garantía.\n"
                                                            + intentosGarantia + " intentos restantes.");
                                            if (intentosGarantia == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (reiniciarFormulario)
                                        continue;

                                    String accesorios = null;
                                    int intentosAccesorios = 5;
                                    while (intentosAccesorios > 0) {
                                        try {
                                            System.out.println("Ingrese el equipamiento: ");
                                            accesorios = scanner.nextLine().trim();
                                            if (accesorios.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")
                                                    && !accesorios.isBlank()) {
                                                break;
                                            } else {
                                                intentosAccesorios--;
                                                System.out.println(
                                                        "Error: El equipamiento solo puede contener letras y espacios.\n"
                                                                + intentosAccesorios + " intentos restantes.");
                                                if (intentosAccesorios == 0) {
                                                    System.out.println(
                                                            "Reiniciando el formulario...");
                                                    reiniciarFormulario = true;
                                                    break;
                                                }
                                            }
                                        } catch (Exception e) {
                                            intentosAccesorios--;
                                            System.out.println("Error inesperado: " + e.getMessage() + "\n"
                                                    + intentosAccesorios + " intentos restantes.");
                                            if (intentosAccesorios == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (reiniciarFormulario)
                                        continue;

                                    double enganche = 0;
                                    int intentosEnganche = 5;
                                    while (intentosEnganche > 0) {
                                        try {
                                            System.out
                                                    .println("Ingrese el enganche (máximo 15% del precio de venta): ");
                                            enganche = Double.parseDouble(scanner.nextLine());
                                            if (enganche > 0 && enganche <= (precioVenta * 0.15)) {
                                                break;
                                            } else {
                                                intentosEnganche--;
                                                System.out.println(
                                                        "Error: El enganche debe ser un valor positivo y no puede superar el 15% del precio de venta.\n"
                                                                + intentosEnganche + " intentos restantes.");
                                                if (intentosEnganche == 0) {
                                                    System.out.println(
                                                            "Reiniciando el formulario...");
                                                    reiniciarFormulario = true;
                                                    break;
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            intentosEnganche--;
                                            System.out.println(
                                                    "Error: Ingrese un valor numérico válido para el enganche.\n"
                                                            + intentosEnganche + " intentos restantes.");
                                            if (intentosEnganche == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (reiniciarFormulario)
                                        continue;

                                    Nuevos autoNuevo = new Nuevos(garantia, accesorios, marca, modelo, version,
                                            enganche,
                                            nombrePersona, nserie, color, precioVenta, año, precioCompra);
                                    listaAutos.agregarAuto(autoNuevo);
                                } else {
                                    // Auto seminuevo
                                    double kilometraje = 0;
                                    int intentosKilometraje = 5;
                                    while (intentosKilometraje > 0) {
                                        try {
                                            System.out.println("Ingrese el kilometraje: ");
                                            kilometraje = Double.parseDouble(scanner.nextLine());
                                            if (kilometraje >= 0) {
                                                break;
                                            } else {
                                                intentosKilometraje--;
                                                System.out.println("Error: El kilometraje no puede ser negativo.\n"
                                                        + intentosKilometraje + " intentos restantes.");
                                                if (intentosKilometraje == 0) {
                                                    System.out.println(
                                                            "Reiniciando el formulario...");
                                                    reiniciarFormulario = true;
                                                    break;
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            intentosKilometraje--;
                                            System.out.println(
                                                    "Error: Ingrese un valor numérico válido para el kilometraje.\n"
                                                            + intentosKilometraje + " intentos restantes.");
                                            if (intentosKilometraje == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (reiniciarFormulario)
                                        continue;

                                    int cantidadDueños = 0;
                                    int intentosDueños = 5;
                                    while (intentosDueños > 0) {
                                        try {
                                            System.out.println("Ingrese la cantidad de dueños anteriores: ");
                                            cantidadDueños = Integer.parseInt(scanner.nextLine());
                                            if (cantidadDueños >= 0) {
                                                break;
                                            } else {
                                                intentosDueños--;
                                                System.out
                                                        .println("Error: La cantidad de dueños no puede ser negativa.\n"
                                                                + intentosDueños + " intentos restantes.");
                                                if (intentosDueños == 0) {
                                                    System.out.println(
                                                            "Reiniciando el formulario...");
                                                    reiniciarFormulario = true;
                                                    break;
                                                }
                                            }
                                        } catch (NumberFormatException e) {
                                            intentosDueños--;
                                            System.out.println(
                                                    "Error: Ingrese un valor numérico válido para la cantidad de dueños.\n"
                                                            + intentosDueños + " intentos restantes.");
                                            if (intentosDueños == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (reiniciarFormulario)
                                        continue;

                                    String nacionalidad = null;
                                    int intentosNacionalidad = 5;
                                    while (intentosNacionalidad > 0) {
                                        try {
                                            System.out.println("Ingrese la nacionalidad: ");
                                            nacionalidad = scanner.nextLine().trim();
                                            if (nacionalidad.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")
                                                    && !nacionalidad.isBlank()) {
                                                break;
                                            } else {
                                                intentosNacionalidad--;
                                                System.out.println(
                                                        "Error: La nacionalidad solo puede contener letras y espacios.\n"
                                                                + intentosNacionalidad + " intentos restantes.");
                                                if (intentosNacionalidad == 0) {
                                                    System.out.println(
                                                            "Reiniciando el formulario...");
                                                    reiniciarFormulario = true;
                                                    break;
                                                }
                                            }
                                        } catch (Exception e) {
                                            intentosNacionalidad--;
                                            System.out.println("Error inesperado: " + e.getMessage() + "\n"
                                                    + intentosNacionalidad + " intentos restantes.");
                                            if (intentosNacionalidad == 0) {
                                                System.out.println(
                                                        "Reiniciando el formulario...");
                                                reiniciarFormulario = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (reiniciarFormulario)
                                        continue;

                                    Seminuevos autoSeminuevo = new Seminuevos(kilometraje, año, cantidadDueños,
                                            nacionalidad, nombrePersona, nserie, marca, modelo, version, color,
                                            precioVenta,
                                            precioCompra);
                                    listaAutos.agregarAuto(autoSeminuevo);
                                }
                                System.out.println("Auto agregado exitosamente.");
                            } catch (Exception e) {
                                System.out.println("Error inesperado: " + e.getMessage());
                            }
                        } while (reiniciarFormulario);
                        break;

                    case 2:
                        listaAutos.mostrarInventario();
                        if (!listaAutos.getInventarioAutos().isEmpty()) {
                            System.out.println("\nLista de autos registrados:");
                            System.out.println("-------------------------------------------------");
                            System.out.printf("%-10s %-15s %-15s %-15s %-15s\n", "Índice", "Marca", "Modelo", "Versión",
                                    "Precio Venta");
                            System.out.println("-------------------------------------------------");

                            for (int i = 0; i < listaAutos.getInventarioAutos().size(); i++) {
                                Autos1 auto = listaAutos.getInventarioAutos().get(i);
                                System.out.printf("%-10d %-15s %-15s %-15s %-15.2f\n",
                                        i,
                                        auto.getMarca(),
                                        auto.getModelo(),
                                        auto.getVersion(),
                                        auto.getPrecioVenta());
                            }
                            System.out.println("-------------------------------------------------");

                            try {
                                int indice = 0;
                                while (true) {
                                    try {
                                        System.out.println(
                                                "Seleccione el índice del auto a vender (o ingrese -1 para cancelar): ");
                                        indice = Integer.parseInt(scanner.nextLine());
                                        if (indice == -1) {
                                            System.out.println("Operación cancelada.");
                                            break;
                                        }
                                        if (indice >= 0 && indice < listaAutos.getInventarioAutos().size()) {
                                            break;
                                        } else {
                                            Autos1 auto = listaAutos.getInventarioAutos().get(indice);
                                            System.out.println(auto.getMarca());
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Error: Ingrese un índice válido.");
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        System.out.println("Error: Índice fuera de los límites del arreglo");
                                        continue;
                                    }
                                }

                                if (indice != -1) {
                                    System.out.println("Ingrese el nombre del cliente: ");
                                    String nombreCliente = scanner.nextLine();
                                    try {
                                        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
                                            throw new IllegalArgumentException(
                                                    "El nombre del cliente no puede estar vacío.");
                                        }
                                        listaAutos.venderAuto(indice, nombreCliente);
                                        System.out.println("Auto vendido exitosamente a " + nombreCliente + ".");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Error: " + e.getMessage());
                                    } catch (Exception e) {
                                        System.out.println("Error inesperado: " + e.getMessage());
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error inesperado: " + e.getMessage());
                            }
                        } else {
                            System.out.println("No hay autos registrados en el inventario.");
                        }
                        break;

                    case 3:
                        try {
                            listaAutos.mostrarContabilidad();
                            System.out.println("Contabilidad mostrada exitosamente.");
                        } catch (ArithmeticException e) {
                            System.out.println("Error: Operación aritmética inválida (ej: división por cero)");
                        } catch (Exception e) {
                            System.out.println("Error inesperado: " + e.getMessage());
                        }
                        break;

                    case 4:
                        listaAutos.mostrarListaClientes();
                        break;

                    case 5:
                        System.out.println("Saliendo del programa...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Índice fuera de los límites del arreglo");
            } catch (NullPointerException e) {
                System.out.println("Error: Referencia nula detectada");
            } catch (ArithmeticException e) {
                System.out.println("Error: Operación aritmética inválida (ej: división por cero)");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
}