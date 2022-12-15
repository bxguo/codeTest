package design.strategy.service;


import design.strategy.request.FoodRequest;

public class FoodService {
    public void getCoupon(FoodRequest request) {
        System.out.println("获得优惠券");
    }

    public void payCoupon(FoodRequest request) {
        System.out.println("支付优惠券");
    }
}
