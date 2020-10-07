package input;

import cena.Scene;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class Teclado implements KeyListener {
    private Scene scene;

    public Teclado(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        short pressed = e.getKeyCode();

        switch (pressed) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_RIGHT:
                this.scene.bastao.movimentarParaDireita();
                break;
            case KeyEvent.VK_LEFT:
                this.scene.bastao.movimentarParaEsquerda();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
