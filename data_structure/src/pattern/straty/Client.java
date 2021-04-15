package pattern.straty;

/**
 * Created by 郭炳侠 on 2021/1/23.
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.returnHome("HIGH_RISK",1);
    }
    /**
     * 某人回家
     *
     * @param from 代表来自区域风险系数
     * @param id   打工人
     */
    public void returnHome(String from, Integer id) {
        for (ReturnHomeStrategy value : ReturnHomeStrategy.values()) {
            value.handle(from, id);
        }
    }


}