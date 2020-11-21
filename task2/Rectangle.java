package task2;

public class Rectangle {
    static int i = 0;
    float[] x = new float[4];
    float[] y = new float[4];

    float xi;
    float yi;

    public Rectangle() {
    }

    public void setCoordinates(float x, float y) {
        this.x[i] = x;
        this.y[i] = y;
        i++;
    }

    public void showRectangle(int j) {
        System.out.println(x[j] + " " + y[j]);
    }

    public boolean checkPointOfVertex(float a, float b) {
        for (int j = 0; j < i; j++) {
            if (x[j] == a && y[j] == b)
                return true;
        }
        return false;
    }

    private int intersectIs(float a, float b, float xi, float yi, float x, float y) {
        if (yi == y)
            return 0;
        if (yi > y) {
            float g = xi;
            xi = x;
            x = g;
            g = yi;
            yi = y;
            y = g;
        }
        if (a < yi || b >= y)
            return 0;
        if (xi == x)
            return a <= xi ? 1 : 0;
        float s = xi + (b - yi) * (x - xi) / (y - yi);
        return a <= s ? 1 : 0;
    }

    private float sqr(float a) {
        return a * a;
    }

    public boolean checkPointOnTheEdge(float a, float b) {
        int j = 0;
        while (j < i - 1) {
            if (Math.abs(Math.sqrt(sqr(x[j] - a) + sqr(y[j] - b)) + Math.sqrt(sqr(x[j + 1] - a) + sqr(y[j + 1] - b))
                    - Math.sqrt(sqr(x[j + 1] - x[j]) + sqr(y[j + 1] - y[j]))) < 0.01)
                return true;
            j++;
        }
        if (Math.abs(Math.sqrt(sqr(x[j] - a) + sqr(y[j] - b)) + Math.sqrt(sqr(x[0] - a) + sqr(y[0] - b))
                - Math.sqrt(sqr(x[0] - x[j]) + sqr(y[0] - y[j]))) < 0.01)
            return true;
        return false;
    }

    public boolean checkPointInRectangle(float a, float b) {
        int intersects = 0;
        xi = x[i - 1];
        yi = y[i - 1];
        for (int j = 0; j < i; ++j) {
            intersects += intersectIs(a, b, xi, yi, x[j], y[j]);
            xi = x[j];
            yi = y[j];
        }
        return intersects % 2 != 0 ? true : false;
    }
}
