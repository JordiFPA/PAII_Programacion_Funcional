package View;

import Interfaces.IDrawable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {
    private PanelD panelDibujo;

    public Window() {
        setTitle("Figuras con lambdas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        panelDibujo = new PanelD();
        getContentPane().add(panelDibujo, BorderLayout.CENTER);
        JPanel panelBotones = new JPanel();
        JButton botonCirculo = new JButton("Círculo");
        JButton botonTriangulo = new JButton("Triángulo");
        JButton botonCuadrado = new JButton("Cuadrado");

        botonCirculo.addActionListener(e -> {
            panelDibujo.agregarFigura(g -> {
                int x = getWidth() / 2- 50;
                int y = getHeight() / 2-50;
                g.setColor(Color.RED);
                g.fillOval(x, y, 100, 100);
            });
        });

        botonTriangulo.addActionListener(e -> {
            panelDibujo.agregarFigura(g -> {
                int x = getWidth() / 2;
                int y = getHeight() / 2;
                int[] xPoints = {x - 50, x, x + 50};
                int[] yPoints = {y + 50, y - 50, y + 50};
                g.setColor(Color.green);
                g.fillPolygon(xPoints, yPoints, 3);
            });
        });

        botonCuadrado.addActionListener(e -> {
            panelDibujo.agregarFigura(g -> {
                int x = getWidth() / 2 - 40;
                int y = getHeight() / 2 - 40;
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 80, 80);
            });
        });

        panelBotones.add(botonCirculo);
        panelBotones.add(botonTriangulo);
        panelBotones.add(botonCuadrado);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    class PanelD extends JPanel {
        private List<IDrawable> figuras = new ArrayList<>();

        public void agregarFigura(IDrawable d) {
            figuras.clear();
            figuras.add(d);
            repaint();
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            figuras.forEach(figuras -> figuras.draw(g));
        }
    }


}
