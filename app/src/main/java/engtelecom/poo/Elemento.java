package engtelecom.poo;

import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;

import javax.swing.ImageIcon;

import edu.princeton.cs.algs4.Draw;

public class Elemento {

    private double x;
    private double y;
    private String primeiraImagem;
    private String segundaImagem;
    private boolean qualImagem;
    private int largura;
    private int altura;

    public Elemento(double x, double y, String primeiraImagem, String segundaImagem) {
        this.x = x;
        this.y = y;
        this.primeiraImagem = primeiraImagem;
        this.segundaImagem = segundaImagem;
        this.qualImagem = true;
        Image imagem = carregarImagem(primeiraImagem);
        this.altura = imagem.getHeight(null);
        this.largura = imagem.getWidth(null);
    }

    private Image carregarImagem(String arquivo) {
        ImageIcon ii = new ImageIcon(arquivo);

        if ((ii == null) || (ii.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            URL url = Draw.class.getResource("/" + arquivo);
            if (url == null)
                throw new IllegalArgumentException("imagem " + arquivo + " não encontrada");
            ii = new ImageIcon(url);
        }

        Image image = ii.getImage();
        return image;
    }

    public void desenhar(Draw draw) {
        if (this.qualImagem) {
            draw.picture(this.x, this.y, this.primeiraImagem);
        } else {
            draw.picture(this.x, this.y, this.segundaImagem);
        }
    }

    /**
     * Verifica se as coordenadas do clique do mouse estão contidas dentro dos
     * limites da carta. O método draw.picture desenha a imagem a partir do centro (x,y)
     * 
     * @param px -- coordenada X do clique
     * @param py -- coordenada Y do clique
     * @return true se o clique foi dentro da area da carta
     */
    public boolean clicouDentro(double px, double py) {
        // TODO precisa ser implementado
        return true;
    }

    public void virar() {
        this.qualImagem = !this.qualImagem;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
}
