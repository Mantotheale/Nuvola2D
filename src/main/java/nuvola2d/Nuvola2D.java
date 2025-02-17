package nuvola2d;

import nuvola2d.window.Window;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Nuvola2D {
    @NotNull private final Window window;

    public Nuvola2D(@NotNull Window window) {
        this.window = Objects.requireNonNull(window);
    }

    public void run() {
        while (!window.shouldClose()) {
            window.pollEvents();

            window.swapBuffers();
        }
    }
}
