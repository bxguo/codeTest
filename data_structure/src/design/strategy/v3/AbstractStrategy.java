package design.strategy.v3;


import design.strategy.Strategy;

public abstract class AbstractStrategy implements Strategy {
    // 类注册方法
    public void register() {
        StrategyContextV3.registerStrategy(getClass().getSimpleName(), this);
    }
}
