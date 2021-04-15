package structure.VisitorPattern;

import structure.VisitorPattern.node.Building;
import structure.VisitorPattern.node.Factory;
import structure.VisitorPattern.node.School;

/**
 * Created by 郭炳侠 on 2021/1/4.
 */
public interface Visitor {
    //void visit(Node node);
    void visit(Factory factory);
    void visit(Building building);
    void visit(School school);
}
