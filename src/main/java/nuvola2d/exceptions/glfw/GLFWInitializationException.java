package nuvola2d.exceptions.glfw;

public class GLFWInitializationException extends RuntimeException {
    public GLFWInitializationException() {
        super("Couldn't initialize GLFW");
    }
}