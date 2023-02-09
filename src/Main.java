public class Main {
    public static void main(String[] args) {
        Tank.justTank.goForward(200);
        Tank.justTank.printPosition();
        Tank.anywareTank.goBackward(-200);
        Tank.anywareTank.printPosition();
        Tank.customTank.goForward(201);
        Tank.customTank.printPosition();
        Tank.justTank.refill("?");
        Tank.anywareTank.refill("30 litrov");
        Tank.customTank.refill("- (20) litrov");



    }
}