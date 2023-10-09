
//crear una ventana que diga hello world
//importar librerias
package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PracticaVentana {

    // crear un metodo main
    public static void main(String[] args) {
        // llamar al metodo crearVentana
        crearVentana();

    }

    // crear un metodo que cree una ventana
    public static void crearVentana() {
        // crear un objeto de tipo JFrame
        JFrame ventana = new JFrame("Mi primera ventana");
        // crear un objeto de tipo JPanel
        JPanel panel = new JPanel();
        // crear un objeto de tipo JLabel
        JLabel etiqueta = new JLabel("Hello World");
        // crear un objeto de tipo JTextField
        JTextField texto = new JTextField(20);
        // agregar el texto al JTextField
        texto.setText("Hola Mundo");
        // agregar el texto al JLabel
        etiqueta.setText(texto.getText());
        // agregar el JLabel al JPanel
        panel.add(etiqueta);
        // agregar el JPanel al JFrame
        ventana.add(panel);
        // hacer visible la ventana
        ventana.setVisible(true);
        // establecer el tamaño de la ventana
        ventana.setSize(400, 400);
        // establecer la operacion por defecto al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
