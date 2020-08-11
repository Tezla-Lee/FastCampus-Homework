package day7;
import java.util.Arrays;

/**
 * 아래 테스트 코드가 정상 동작하도록 클래스들을 완성하시오.
 *
 * getArea(): 사각형의 넓이를 반환한다.
 * getCenterOfMass(): 사각형의 질량중심을 반환한다.
 * GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
 * rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다.
 */

class Vector2D {
    public float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class RectCore {
    protected Vector2D pos;
    protected float w, h;

    public RectCore(float x, float y, float w, float h) {
        this.pos = new Vector2D(x, y);
        this.w = w;
        this.h = h;
    }

    public String toString() {
        return "(" + (pos.x + w)/2 + ", " + (pos.y + h)/2 + ")";
    }
}

public class Rect extends RectCore {
    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public float getArea() {
        return w * h;
    }

    public Vector2D getCenterOfMass() {
        return new Vector2D(pos.x + w/2, pos.y + h/2);
    }

    public Vector2D [] getAllPoints() {
        Vector2D[] vector2DS = new Vector2D[4];
        vector2DS[0] = new Vector2D(pos.x, pos.y);
        vector2DS[1] = new Vector2D(pos.x + w, pos.y);
        vector2DS[2] = new Vector2D(pos.x + w, pos.y + h);
        vector2DS[3] = new Vector2D(pos.x, pos.y + h);
        return vector2DS;
    }

    public void rot90(Vector2D pivot) {
        float x2 = pos.x;
        float y2 = pos.y;
        float w2 = w;
        float h2 = h;
        pos.x = -y2 + pivot.x + pivot.y;
        pos.y = x2 - pivot.x + pivot.y - w;
        w = h2;
        h = w2;
    }

    public String toString() {
        return "(" + pos.x + ", " + pos.y + ", " + w + ", " + h + ")";
    }
}

class RectTest {
    public static void main(String[] args) {
        Rect rect = new Rect(0.5f, 0.7f, 1.5f, 2.3f);
        System.out.println("Area: " + rect.getArea());
        System.out.println("CoM: " + rect.getCenterOfMass());
        System.out.println("All Points: " + Arrays.toString(rect.getAllPoints()));

        rect.rot90(new Vector2D(0.4f, 0.2f));

        System.out.println("Rotated rect: " + rect);
    }
}