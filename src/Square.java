public class Square extends Shape {
    private final double side;

    public Square(String id, double side, Renderer renderer) {
        super(id, renderer);
        this.side = side;
    }

    public Square(String id, Renderer renderer) {
        this(id, 3.0, renderer);
    }

    public double getSide() {
        return side;
    }

    @Override
    public String execute() {
        return renderer.renderSquare(side);
    }
}
