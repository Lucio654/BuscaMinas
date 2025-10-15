import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.JOptionPane;

public class BuscaminasGUI extends JFrame {
    private Tablero tablero;
    private JButton[][] botones;
    
    public BuscaminasGUI() {
        tablero = new Tablero(8, 8, 10); // 8x8 con 10 minas
        botones = new JButton[8][8];
        inicializarGUI();
    }
    
    private void inicializarGUI() {
        setTitle("Buscaminas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(50, 50));
                final int fila = i;
                final int columna = j;
                
                boton.addActionListener(e -> descubrirCelda(fila, columna));
                botones[i][j] = boton;
                add(boton);
            }
        }
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void descubrirCelda(int fila, int columna) {
    Celda celda = tablero.getCelda(fila, columna);
    JButton boton = botones[fila][columna];
    
    if (celda.isTieneMina()) {
        boton.setText("💣");
        boton.setBackground(Color.RED);
        JOptionPane.showMessageDialog(this, "¡Perdiste! Había una mina.");
    } else {
        int minasAlrededor = celda.getMinasAlrededor();
        if (minasAlrededor > 0) {
            boton.setText(String.valueOf(minasAlrededor));
        }
        boton.setBackground(Color.LIGHT_GRAY);
    }
    boton.setEnabled(false);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BuscaminasGUI();
        });
    }
}