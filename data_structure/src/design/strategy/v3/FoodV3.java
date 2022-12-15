package design.strategy.v3;


import design.strategy.Strategy;
import design.strategy.request.FoodRequest;
import design.strategy.service.FoodService;

public class FoodV3 extends AbstractStrategy implements Strategy {
    private static final FoodV3 instance = new FoodV3();
    private FoodService foodService;

    private FoodV3() {
        this.foodService = new FoodService();
        register();
    }

    public static FoodV3 getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {
        FoodRequest request = new FoodRequest(params);
        foodService.payCoupon(request);
    }
}
