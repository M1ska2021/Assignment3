public class RasterRenderer implements Renderer {

    @Override
    public String renderCircle(double radius) {
        return "RASTER circle radius=" + format(radius);
    }

    @Override
    public String renderSquare(double side) {
        return "RASTER square side=" + format(side);
    }

    private String format(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
