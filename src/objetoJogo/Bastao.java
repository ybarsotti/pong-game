package objetoJogo;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Bastao {
    private GLAutoDrawable drawable;
    private GL2 gl;
    private float limiteNaTela = 1.6000001f;

    // Posição do objeto na cena
    private float[] inferiorEsquerdo = {-0.2f, -0.95f};
    private float[] superiorEsquerdo = {-0.2f, -0.85f};
    private float[] superiorDireito = {0.2f, -0.85f};
    private float[] inferiorDireito = {0.2f, -0.95f};
    private float posicaoX = 0f;

    public Bastao(GLAutoDrawable drawable) {
        this.drawable = drawable;
        this.gl = this.drawable.getGL().getGL2();
    }

    public void gerar() {

        this.gl.glPushMatrix();

        this.gl.glColor3f(1, 1, 1);
        this.gl.glTranslatef(this.posicaoX, 0, 0);


        this.gl.glBegin(gl.GL_QUADS);
        this.gl.glVertex2f(inferiorEsquerdo[0], inferiorEsquerdo[1]);
        this.gl.glVertex2f(superiorEsquerdo[0], superiorEsquerdo[1]);
        this.gl.glVertex2f(superiorDireito[0], superiorDireito[1]);
        this.gl.glVertex2f(inferiorDireito[0], inferiorDireito[1]);
        this.gl.glEnd();

        this.gl.glPopMatrix();

        System.out.println("Bastão: " + this.posicaoX);
    }

    public void movimentarParaDireita() {
        if (this.podeMovimentarParaDireita())
            this.posicaoX += 0.1f;
    }

    public void movimentarParaEsquerda() {
        if (this.podeMovimentarParaEsquerda())
            this.posicaoX -= 0.1f;
    }

    public boolean podeMovimentarParaDireita() {
        return (this.posicaoX < this.limiteNaTela);
    }

    public boolean podeMovimentarParaEsquerda() {
        return (this.posicaoX > this.limiteNaTela * -1);
    }
}
