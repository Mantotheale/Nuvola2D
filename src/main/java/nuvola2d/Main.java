package nuvola2d;

import nuvola2d.window.Window;

public class Main {
    public static void main(String[] args) {
        Window window = new Window("Nuvola2D", 1080, 720);
        Nuvola2D nuvola = new Nuvola2D(window);

        nuvola.run();
    }
}