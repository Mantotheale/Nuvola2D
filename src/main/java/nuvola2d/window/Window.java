package nuvola2d.window;

import nuvola2d.exceptions.glfw.GLFWInitializationException;
import nuvola2d.exceptions.glfw.GLFWOpenWindowFailException;
import nuvola2d.exceptions.window.WindowSizeInvalidException;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;

import java.util.Objects;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glViewport;

public class Window {
    private final long id;
    private int width;
    private int height;

    public Window(@NotNull String title, int width, int height) {
        Objects.requireNonNull(title);
        if (width <= 0 || height <= 0) throw new WindowSizeInvalidException(width, height);

        this.width = width;
        this.height = height;

        if (!glfwInit()) throw new GLFWInitializationException();

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

        id = glfwCreateWindow(width, height, title, 0, 0);

        if (id == 0) throw new GLFWOpenWindowFailException();

        glfwMakeContextCurrent(id);
        glfwSwapInterval(1);

        GL.createCapabilities();
        glViewport(0, 0, width, height);
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(id);
    }

    public void close() {
        glfwTerminate();
    }

    public void pollEvents() {
        glfwPollEvents();
    }

    public void setClearColor(float r, float g, float b, float a) {
        glClearColor(r, g, b, a);
    }

    public void setClearColor(float r, float g, float b) {
        setClearColor(r, g, b, 1);
    }

    public void clearColorBuffer() {
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public void swapBuffers() {
        glfwSwapBuffers(id);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public void resize(int width, int height) {
        if (width <= 0 || height <= 0) throw new WindowSizeInvalidException(width, height);

        glViewport(0, 0, width, height);
        this.width = width;
        this.height = height;
    }

    public void setKeyCallback(@NotNull GLFWKeyCallbackI keyCallback) {
        glfwSetKeyCallback(id, Objects.requireNonNull(keyCallback));
    }

    public void setClickCallback(@NotNull GLFWMouseButtonCallbackI clickCallback) {
        glfwSetMouseButtonCallback(id, Objects.requireNonNull(clickCallback));
    }

    public void setCursorPosCallback(@NotNull GLFWCursorPosCallbackI mouseCallback) {
        glfwSetCursorPosCallback(id, Objects.requireNonNull(mouseCallback));
    }

    public void setWindowSizeCallback(@NotNull GLFWWindowSizeCallbackI sizeCallback) {
        glfwSetWindowSizeCallback(id, Objects.requireNonNull(sizeCallback));
    }
}