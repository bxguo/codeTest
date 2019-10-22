package testall;

/**
 * Created by bxguo on 2019/10/16 0:57
 */
public class teststatic {
    private volatile static teststatic singleton;
    private teststatic (){}
    public static teststatic getSingleton() {
        if (singleton == null) {
            synchronized (teststatic.class) {
                if (singleton == null) {
                    singleton = new teststatic();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
    }
}
