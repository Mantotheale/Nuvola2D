package nuvola2d.exceptions.glfw;

public class GLFWOpenWindowFailException extends RuntimeException {
    public GLFWOpenWindowFailException() {
        super("Failed to open a window");
    }
}