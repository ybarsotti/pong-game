package cena;

import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import input.Teclado;
import som.Som;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {
    private static GLWindow window = null;
    private static Som som;

    public static void init(){
        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);

        window = GLWindow.create(caps);
        window.setFullscreen(true);
        window.setTitle("PONG");
        window.setResizable(false);

        Scene scene = new Scene();

        window.addGLEventListener(scene);
        window.addKeyListener(new Teclado(scene));
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

        // create the cursor
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Cursor noCursor = t.createCustomCursor(i, new Point(0, 0), "none");

        // try it with a normal frame
        Frame f = new Frame();

        // create the GLCanvas and add it to the frame
        GLCanvas canvas = new GLCanvas();
        f.add(canvas);

        f.setCursor(noCursor);
        f.setSize(400, 200);
        f.setVisible(true);

        window.setVisible(true);


//        new Som().intro("src/sound/intro.wav");

    }

    public static void main(String[] args){
        init();

    }
}
