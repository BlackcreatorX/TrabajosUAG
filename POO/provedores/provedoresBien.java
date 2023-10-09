
//importar librerias
import java.util.ArrayList;
import java.util.Scanner;

//clase main
class Agenda {
    // declaracion de variables
    ArrayList<ProvedoresCliente> listaProvedores = new ArrayList<>();
    int id = 0;

    // metodo para agregar provedor
    void addProvedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Telefono: ");
        String telefono = scanner.nextLine();
        ProvedoresCliente provedor = new ProvedoresCliente(nombre, telefono, new ArrayList<>());
        listaProvedores.add(provedor);
        System.out.println("Provedor agregado");
        menu();
    }

    // metodo para mostrar lista de provedores
    void getProvedor() {
        for (int i = 0; i < listaProvedores.size(); i++) {
            System.out.println((i + 1) + ". " + listaProvedores.get(i));
        }
        menu();
    }

    // metodo para modificar provedor
    void setProvedor() {
        // mostrar lista de provedores
        System.out.println("Lista de Provedores:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaProvedores.size(); i++) {
            System.out.println((i + 1) + ". " + listaProvedores.get(i));
        }
        // pedir nombre del provedor a modificar
        System.out.print("Nombre del Provedor a modificar: ");
        String nombre = scanner.nextLine();
        int indiceModificarprov = -1;
        for (int i = 0; i < listaProvedores.size(); i++) {
            if (listaProvedores.get(i).nombre.equals(nombre)) {
                indiceModificarprov = i + 1;
                break;
            }
        }
        // si el provedor existe
        if (indiceModificarprov >= 1 && indiceModificarprov <= listaProvedores.size()) {
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo Telefono: ");
            String nuevoTelefono = scanner.nextLine();
            ProvedoresCliente provedorModificar1 = listaProvedores.get(indiceModificarprov - 1);
            provedorModificar1.nombre = nuevoNombre;
            provedorModificar1.telefono = nuevoTelefono;
            System.out.println("Provedor modificado correctamente.");
        }
        // si el provedor no existe

        else {
            System.out.println("Provedor no encontrado.");
        }
        menu();
    }

    // metodo para eliminar provedor
    void removeProvedor() {
        System.out.println("Lista de Provedores:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaProvedores.size(); i++) {
            System.out.println((i + 1) + ". " + listaProvedores.get(i));
        }
        // pedir nombre del provedor a eliminar
        System.out.print("Nombre del Provedor a eliminar: ");
        String nombre = scanner.nextLine();
        int indiceModificarprov = -1;
        for (int i = 0; i < listaProvedores.size(); i++) {
            // si el provedor existe
            if (listaProvedores.get(i).nombre.equals(nombre)) {
                indiceModificarprov = i + 1;
                break;
            }
        }
        // si el provedor existe
        if (indiceModificarprov >= 1 && indiceModificarprov <= listaProvedores.size()) {
            listaProvedores.remove(indiceModificarprov - 1);
            System.out.println("Provedor eliminado correctamente.");

        }
        // si el provedor no existe

        else {
            System.out.println("Provedor no encontrado.");
        }
        menu();
    }

    // metodo para agregar producto
    void addProducto(int indiceProvedor) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del Producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del Producto: ");
        String precio = scanner.nextLine();
        System.out.print("Cantidad del Producto: ");
        String cantidad = scanner.nextLine();
        Producto producto = new Producto(precio, nombre, cantidad, id);
        listaProvedores.get(indiceProvedor).Producto_Lista.add(producto);
        System.out.println("Producto agregado");
        id++;
        menu();

    }

    // metodo para modificar producto
    void setProducto(int indiceProvedor) {
        // mostrar lista de productos

        System.out.println("Lista de Productos:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaProvedores.get(indiceProvedor).Producto_Lista.size(); i++) {
            System.out.println((i + 1) + ". " + listaProvedores.get(indiceProvedor).Producto_Lista.get(i));
        }
        // pedir nombre del producto a modificar
        System.out.print("Nombre del Producto a modificar: ");
        String nombre = scanner.nextLine();
        int indiceModificarprov = -1;
        for (int i = 0; i < listaProvedores.get(indiceProvedor).Producto_Lista.size(); i++) {
            // si el producto existe
            if (listaProvedores.get(indiceProvedor).Producto_Lista.get(i).producto.equals(nombre)) {
                indiceModificarprov = i + 1;
                break;
            }
        }
        // si el producto existe
        if (indiceModificarprov >= 1
                && indiceModificarprov <= listaProvedores.get(indiceProvedor).Producto_Lista.size()) {
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nuevo Precio: ");
            String nuevoPrecio = scanner.nextLine();
            System.out.print("Nueva Cantidad: ");
            String nuevaCantidad = scanner.nextLine();
            Producto productoModificar1 = listaProvedores.get(indiceProvedor).Producto_Lista
                    .get(indiceModificarprov - 1);
            productoModificar1.producto = nuevoNombre;
            productoModificar1.precio = nuevoPrecio;
            productoModificar1.cantidad = nuevaCantidad;
            System.out.println("Producto modificado correctamente.");
        }
        // si el producto no existe
        else {
            System.out.println("Producto no encontrado.");
        }
        menu();

    }

    // metodo para eliminar producto
    void removeProducto(int indiceProvedor) {
        // mostrar lista de productos
        System.out.println("Lista de Productos:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaProvedores.get(indiceProvedor).Producto_Lista.size(); i++) {
            System.out.println((i + 1) + ". " + listaProvedores.get(indiceProvedor).Producto_Lista.get(i));
        }
        // pedir nombre del producto a eliminar
        System.out.print("Nombre del Producto a eliminar: ");
        String nombre = scanner.nextLine();
        // si el producto existe
        int indiceModificarprov = -1;
        for (int i = 0; i < listaProvedores.get(indiceProvedor).Producto_Lista.size(); i++) {
            if (listaProvedores.get(indiceProvedor).Producto_Lista.get(i).producto.equals(nombre)) {
                indiceModificarprov = i + 1;
                break;
            }
        }

    }

    // metodo para seleccionar provedor
    void menuProducto(int indiceProvedor) {
        // mostrar lista de productos
        System.out.println("Lista de Productos:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaProvedores.get(indiceProvedor).Producto_Lista.size(); i++) {
            System.out.println((i + 1) + ". " + listaProvedores.get(indiceProvedor).Producto_Lista.get(i));
        }

        System.out.println("1. Agregar Producto");
        System.out.println("2. Modificar Producto");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        // switch para seleccionar opcion
        switch (opcion) {
            case 1:
                addProducto(indiceProvedor);
                break;
            case 2:
                setProducto(indiceProvedor);
                break;
            case 3:
                removeProducto(indiceProvedor);
                break;
            case 4:
                menu();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

    }

    // metodo para seleccionar provedor
    void menuProvedor() {
        // mostrar lista de provedores
        System.out.println("Lista de Provedores:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listaProvedores.size(); i++) {
            System.out.println((i + 1) + ". " + listaProvedores.get(i));
        }
        // pedir nombre del provedor a seleccionar
        System.out.print("Nombre del Provedor a seleccionar: ");
        String nombre = scanner.nextLine();
        int indiceModificarprov = -1;
        for (int i = 0; i < listaProvedores.size(); i++) {
            if (listaProvedores.get(i).nombre.equals(nombre)) {
                indiceModificarprov = i + 1;
                break;
            }
        }
        // si el provedor existe
        if (indiceModificarprov >= 1 && indiceModificarprov <= listaProvedores.size()) {
            menuProducto(indiceModificarprov - 1);
        }
        // si el provedor no existe
        else {
            System.out.println("Provedor no encontrado.");
        }
        menu();
    }

    // metodo para mostrar menu
    void menu() {
        System.out.println("Menú:");
        System.out.println("1. Agregar Provedor");
        System.out.println("2. Mostrar Lista de Provedores");
        System.out.println("3. Modificar Provedor");
        System.out.println("4. Eliminar Provedor");
        System.out.println("5. Seleccionar Provedor");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        // switch para seleccionar opcion
        switch (opcion) {
            case 1:
                addProvedor();
                break;
            case 2:
                getProvedor();
                break;
            case 3:
                setProvedor();
                break;
            case 4:
                removeProvedor();
                break;
            case 5:
                menuProvedor();
                break;
            case 6:
                System.exit(0);
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    // metodo principal
    public static void main(String[] args) {
        // crear objeto agenda
        Agenda agenda = new Agenda();
        // mostrar menu
        agenda.menu();

    }
}

// clase provedor
class ProvedoresCliente {
    // declaracion de variables
    String nombre;
    String telefono;
    ArrayList<Producto> Producto_Lista = new ArrayList<>();

    // constructor
    public ProvedoresCliente(String nombre, String telefono, ArrayList<Producto> Producto_Lista) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.Producto_Lista = Producto_Lista;
    }

    // getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Producto> getProducto_Lista() {
        return Producto_Lista;
    }

    public void setProducto_Lista(ArrayList<Producto> Producto_Lista) {
        this.Producto_Lista = Producto_Lista;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Telefono: " + telefono + ",Productos: " + Producto_Lista;
    }

    // añadir producto
    public void addProducto(Producto producto) {
        Producto_Lista.add(producto);
    }

    // eliminar producto
    public void removeProducto(int id) {
        Producto_Lista.remove(id);
    }

    // modificar producto
    public void setProducto(int id, Producto producto) {
        Producto_Lista.set(id, producto);
    }

    // mostrar lista de productos
    public void getProducto() {
        for (int i = 0; i < Producto_Lista.size(); i++) {
            System.out.println(Producto_Lista.get(i));
        }
    }

}

// clase producto
class Producto {
    // declaracion de variables
    String precio;
    String producto;
    String cantidad;
    int id;

    /**
     * constructor secundario en caso de no usar id
     * public Producto(String precio, String producto, String cantidad) {
     * this.producto = producto;
     * this.precio = "$" + precio;
     * this.cantidad = cantidad;
     * }
     */

    // constructor
    public Producto(String precio, String producto, String cantidad, int id) {
        this.producto = producto;
        this.precio = "$" + precio;
        this.cantidad = cantidad;
        this.id = id;
    }

    // metodo toString para mostrar producto en lista de provedores y en lista de
    // productos de cada provedor

    public String toString() {
        return "Producto: " + producto + ", Cantidad: " + cantidad + ",Precio: " + precio;
    }

    // getter y setter
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

}
