package objetoJogo;

import com.jogamp.opengl.util.awt.TextRenderer;

import java.awt.*;

public class Jogador {
    private int vidas = 3;
    private int pontos = 0;
    private boolean fimDeJogo = false;

    public Jogador() {

    }

    public void perderVida() {
        this.vidas -= 1;
    }

    public void adicionarPontos() {
        this.pontos += 1;
    }

    public void renderizarTexto() {
        TextRenderer textRenderer = new TextRenderer(new Font("Verdana", Font.BOLD, 12));
        textRenderer.beginRendering(900, 1000);
        textRenderer.setColor(Color.WHITE);
        textRenderer.setSmoothing(true);

        textRenderer.draw("Vidas: [*] [*] [*]", (int) (18), (int) (50));
        textRenderer.draw("Pontos: " + String.format("%07d", this.pontos), (int) (18), (int) (18));
        textRenderer.endRendering();
    }
}
