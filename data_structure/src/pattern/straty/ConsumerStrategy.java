package pattern.straty;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by 郭炳侠 on 2021/1/23.
 */
public interface ConsumerStrategy<P, C> {

    /**
     * 暴露当前策略的钩子
     *
     * @return 判断钩子
     */
    Predicate<P> predicate();

    /**
     * 暴露当前策略的消费逻辑
     *
     * @return 消费逻辑
     */
    Consumer<C> consumer();

    /**
     * 真实的消费数据
     *
     * @param p 钩子来源
     * @param c 消费来源
     */
    default void handle(P p, C c) {
        if (this.predicate().test(p)) {
            this.consumer().accept(c);
        }
    }

}
