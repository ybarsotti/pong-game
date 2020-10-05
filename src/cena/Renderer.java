package cena;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import gameObject.Bastao;
import input.Teclado;

import java.awt.*;

public class Renderer {
    private static GLWindow window = null;

    public static float janelaW = 0;
    public static float janelaH = 0;

    public static void init(){
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setFullscreen(true);
        window.setTitle("PONG");
        window.setResizable(false);

        Cena cena = new Cena();

        window.addGLEventListener(cena);
        window.addKeyListener(new Teclado(cena));
        window.requestFocus();

        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start();

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent e) {
                animator.stop();
                System.exit(0);
            }
        });

        window.setVisible(true);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        janelaH = size.height;
        janelaW = size.width;
        System.out.println(janelaH);
        System.out.println(janelaW);
    }

    public static void main(String[] args) {
        init();
    }
}
