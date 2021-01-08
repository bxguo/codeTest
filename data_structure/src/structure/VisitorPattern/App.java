package structure.VisitorPattern;

import structure.VisitorPattern.node.Factory;

/**
 * Created by 郭炳侠 on 2021/1/4.
 */
public class App {
    public static void main(String[] args) {
        DrawService drawService = new DrawService();
        drawService.draw(new Factory());
    }

}
