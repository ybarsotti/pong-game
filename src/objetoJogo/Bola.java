package objetoJogo;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Bola {
    private GLAutoDrawable drawable;
    private GL2 gl;

    // Posição do objeto na cena
    private float posicaoX = 0f;
    private float posicaoY = -0.77f;

    private boolean direcaoCima = true;
    private boolean direcaoDireita = true;
    private float velocidade = 0.02f;

    private float limiteX = 1.68f;
    private float limiteY = 0.9f;

    public Bola(GLAutoDrawable drawable) {
        this.drawable = drawable;
        this.gl = this.drawable.getGL().getGL2();
    }

    public void gerar() {
        int numVertices = 60;
        double radius = 0.08;

        this.gl.glPushMatrix();

        this.gl.glTranslatef(this.posicaoX, this.posicaoY, 0);
        this.gl.glColor3f(1, 1, 1);

        this.gl.glBegin(GL2.GL_POLYGON);
        {
            double angle = 0;
            double angleIncrement = 2 * Math.PI / numVertices;
            for (int i = 0; i < numVertices; i++) {
                angle = i * angleIncrement;
                double x = radius * Math.cos(angle);
                double y = radius * Math.sin(angle);
                this.gl.glVertex2d(x, y);
            }
        }
        this.gl.glEnd();
        this.gl.glPopMatrix();

        this.movimentar();

        System.out.println("Bola X: " + this.posicaoX);
        System.out.println("Bola Y: " + this.posicaoY);
    }

    public void movimentar() {
        this.movimentarParaCima();
        this.movimentarParaBaixo();
        this.movimentarParaDireita();
        this.movimentarParaEsquerda();
    }

    public void movimentarParaCima() {
        if (this.direcaoCima) {
            if (this.posicaoY >= this.limiteY) {
                this.direcaoCima = false;
            } else {
                this.posicaoY += this.velocidade;
            }
        }
    }

    public void movimentarParaBaixo() {
        if (!this.direcaoCima) {
            if (this.posicaoY <= -1 * this.limiteY) {
                this.direcaoCima = true;
            } else {
                this.posicaoY -= this.velocidade;
            }
        }
    }

    public void movimentarParaDireita() {
        if (this.direcaoDireita) {
            if (this.posicaoX >= this.limiteX) {
                this.direcaoDireita = false;
            } else {
                this.posicaoX += this.velocidade;
            }
        }
    }

    public void movimentarParaEsquerda() {
        if (!this.direcaoDireita) {
            if (this.posicaoX <= -1 * this.limiteX) {
                this.direcaoDireita = true;
            } else {
                this.posicaoX -= this.velocidade;
            }
        }
    }
}
