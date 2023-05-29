package engtelecom.poo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;

import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

public class App implements DrawListener {

    private Draw draw;
    private Elemento elemento;

    public App(char naipe, char valor) {
        this.draw = new Draw("Jogo de cartas");
        draw.setXscale(0, 1600);
        draw.setYscale(0, 800);
        this.draw.addListener(this);

        // Para evitar piscar na tela ao desenhar os componentes
        // Veja mais em
        // https://docs.oracle.com/javase/tutorial/extra/fullscreen/doublebuf.html
        this.draw.enableDoubleBuffering();

        this.draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String carta = String.format("cartas/%c%c.png", valor, naipe);
        this.elemento = new Elemento(400, 300, carta, "cartas/fundoa.png");
    }

    /**
     * Limpa a área de desenho não visível, pede para o elemento se desenhar e
     * depois essa área é exibida
     */
    public void desenhar() {
        // Limpa a área de desenho
        this.draw.clear(Color.DARK_GRAY);
        // Pede para o elemento se desenhar
        elemento.desenhar(this.draw);
        // Com double buffering é necessário invocar o show para exibir a área de
        // desenho onde o elemento foi desenhado
        this.draw.show();
    }

    @Override
    public void mousePressed(double x, double y) {
        if (elemento.clicouDentro(x, y)) {
            elemento.virar();
        }
        this.desenhar();
    }

    @Override
    public void mouseDragged(double x, double y) {
    }

    @Override
    public void mouseReleased(double x, double y) {
    }

    @Override
    public void mouseClicked(double x, double y) {
    }

    @Override
    public void keyTyped(char c) {
    }

    @Override
    public void keyPressed(int keycode) {

        // A classe java.awt.event.KeyEvent apresenta constantes para cada tecla. O
        // VSCode por padrão deixa o pacote java.awt.* desabilitado. Você pode habilitar
        // por meio da paleta de comandos (CTRL+SHIFT+P), buscando por Java: Help Center
        // e na aba Student clicando em Enable AWT Development
        if (keycode == KeyEvent.VK_S) {
            this.draw.setPenColor(Color.WHITE);
            this.draw.text(400, 200, "Tecla S foi pressionada");
            // com double buffering é necessário invocar o método show
            this.draw.show();
        }

    }

    @Override
    public void keyReleased(int keycode) {
    }

    public static void main(String[] args) {
        String valor = "123456789qjk";
        String naipe = "oecp";
        Random r = new Random();

        App app = new App(naipe.charAt(r.nextInt(4)), valor.charAt(r.nextInt(13)));
        app.desenhar();

    }

}
