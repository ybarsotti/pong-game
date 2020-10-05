package input;

import cena.Cena;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import gameObject.Bastao;

public class Teclado implements KeyListener {
    private Cena cena;

    public Teclado(Cena cena) {
        this.cena = cena;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        short pressed = e.getKeyCode();

        switch (pressed) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_RIGHT:
                cena.bastao.movimentarParaDireita();
                break;
            case KeyEvent.VK_LEFT:
                cena.bastao.movimentarParaEsquerda();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
