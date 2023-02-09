import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tank {

    private int x = 0;
    private int y;
    private int dir;
    private int fuel;
    static String tankName = "T34";
    public static int count;
    int nr;


    // Create constructor


    public Tank() {
        this(0, 0, 100);


    }

    public Tank(int x, int y) {
        this(x, y, 100);


    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
        count++;
        this.nr = count;


    }

    // Create tank

    public static Tank justTank = new Tank();

    public static Tank anywareTank = new Tank(10, 10);
    public static Tank customTank = new Tank(20, 30, 200);

    //мы считаем, что dir может принимать 4 значения
    //0 (значение по умолчанию) вправо
    //1  - вниз, 2  - влево, 3 - вверх
    public void goForward(int i) {
        if (dir == 0) x += i;
        else if (dir == 1) y += i;
        else if (dir == 2) x -= i;
        else y -= i;
        fuel -= i;
    }

    public void printPosition() {
        System.out.printf("The Tank %s-%d  is at x: %d , y: %d now. Fuel remain: %d ", tankName, this.nr, x, y, this.fuel);
        System.out.println();
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
    }
    public void flight (int x, int y){
        x += x;
        y += y;
        System.out.println("Полёт успешно прошёл");
    }

    public void goBackward(int i) {
        goForward(-i);
    }

    public void refill(String task) {
        if (task.equals("?")) {
            System.out.println("В баке танка " + this.tankName + " - " + this.nr + " " + this.fuel + " литров");
        }
        Pattern positive = Pattern.compile("(\\b\\d+\\d(?=\\s)\\b)");
        Pattern negative = Pattern.compile("(-(?=\\s)\\s\\W)(\\d+)\\W");

        Matcher match = positive.matcher(task);
        Matcher match2 = negative.matcher(task);

        if (match.find()) {
            int newFuel = Integer.valueOf(match.group(1));
            this.fuel = this.fuel + newFuel;
            System.out.printf("Заправка танка %s - %d на %d литров произведена.В баке %d литров", this.tankName, this.nr, newFuel, this.fuel);
            System.out.println();
        }

        if (match2.find()) {
            int b = Integer.valueOf(match2.group(2));
            System.out.println(b);
            System.out.println("hi");
            System.out.printf("На заправке сливать топливо из танка T34 - 3 запрещено", this.tankName, this.nr);
        }


    }
}
