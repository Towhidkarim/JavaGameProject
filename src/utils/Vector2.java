package utils;

public class Vector2 {
    public float x = 0, y = 0;
    public static Vector2 right = new Vector2(1, 0);
    public static Vector2 left = new Vector2(-1, 0);
    public static Vector2 up = new Vector2(0, 1);
    public static Vector2 down = new Vector2(0, -1);

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public double sqrMagnitude() {
        return x * x + y * y;
    }

    public Vector2 normalized() {
        float mag = (float)this.magnitude();
        return new Vector2(this.x / mag , y / mag);
    }

    public void set(float x, float y) {
        this.x = x; this.y = y;
    }

    public boolean equals(Vector2 vector) {
       return this.x == vector.x && this.y == vector.y? true : false;
    }

    public void add(Vector2 secondVector) {
        this.set(this.x + secondVector.x, this.y + secondVector.y);
    }

    public void subtract(Vector2 secondVector) {
        this.set(this.x - secondVector.x, this.y - secondVector.y);
    }

    public void multiply(float a) {
        this.x *= a; this.y *= a;
    }

    public void divide(float a) {
        this.x /= a; this.y /= a;
    }

    public static Vector2 dot(Vector2 a, Vector2 b) {
        return new Vector2(a.x * b.x, a.y * b.y);
    }

    public static double distance(Vector2 a,Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y).magnitude();
    }
    public static double sqDistance(Vector2 a, Vector2 b) {
        return vectorDistance(a, b).sqrMagnitude();
    }

    public static Vector2 vectorDistance(Vector2 a,Vector2 b) {
        return new Vector2(a.x - b.x, a.y - b.y);
    }

    
}
