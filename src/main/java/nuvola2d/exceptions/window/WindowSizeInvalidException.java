package nuvola2d.exceptions.window;

public class WindowSizeInvalidException extends RuntimeException {
    public WindowSizeInvalidException(int width, int height) {
        super("Width and height of the window should be positive. They were (" + width + ", " + height + ").");
    }
}