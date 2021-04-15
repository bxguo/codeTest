package structure.VisitorPattern;

import structure.VisitorPattern.node.Building;
import structure.VisitorPattern.node.Factory;
import structure.VisitorPattern.node.Node;
import structure.VisitorPattern.node.School;

/**
 * Created by 郭炳侠 on 2021/1/4.
 */
public class DrawService {
    public void draw(Building building) {
        System.out.println("draw building");
    }
    public void draw(Factory factory) {
        System.out.println("draw factory");
    }
    public void draw(School school) {
        System.out.println("draw school");
    }
    public void draw(Node node) {
        System.out.println("draw node");
    }
}
