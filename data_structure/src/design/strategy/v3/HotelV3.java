package design.strategy.v3;


import design.strategy.Strategy;
import design.strategy.request.HotelRequest;
import design.strategy.service.HotelService;

public class HotelV3 extends AbstractStrategy implements Strategy {
    private static final HotelV3 instance = new HotelV3();
    private HotelService hotelService;

    private HotelV3() {
        this.hotelService = new HotelService();
        register();
    }

    public static HotelV3 getInstance() {
        return instance;
    }

    @Override
    public void issue(Object... params) {
        HotelRequest request = new HotelRequest();
        request.addHotelReq(params);
        hotelService.sendPrize(request);
    }
}
