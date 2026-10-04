import java.util.Objects;

public abstract class Shape {
    protected final String id;
    protected Renderer renderer;

    public Shape(String id, Renderer renderer) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.renderer = Objects.requireNonNull(renderer, "renderer must not be null");
    }

    public String getId() {
        return id;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setImplementation(Renderer renderer) {
        this.renderer = Objects.requireNonNull(renderer, "renderer must not be null");
    }

    public abstract String execute();
}
