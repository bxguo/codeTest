package structure;

import java.util.HashMap;

/**
 *
 * 最近最少使用缓存机制
 *
 * save(key, value)，首先在 HashMap 找到 Key 对应的节点，如果节点存在，更新节点的值，并把这个节点移动队头。如果不存在，需要构造新的节点，
 *      并且尝试把节点塞到队头，如果LRU空间不足，则通过 tail 淘汰掉队尾的节点，同时在 HashMap 中移除 Key。
 * get(key)，通过 HashMap 找到 LRU 链表节点，因为根据LRU 原理，这个节点是最新访问的，所以要把节点插入到队头，然后返回缓存的值。
 *
 *
 * 此处map做缓存作用， node实现结构
 *
 *
 * 作者：码蹄疾
 * 链接：https://juejin.im/post/5cab4ae46fb9a0688d2e24b4
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * Created by bxguo on 2019/4/9 22:30
 */
public class DLinkedNodeCatch {
    /**
     * 总是在头节点中插入新节点.
     */
    private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    /**
     * 总是在头节点中插入新节点.
     */
    private void addNode(DLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * 摘除一个节点.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * 摘除一个节点,并且将它移动到开头
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    /**
     * 弹出最尾巴节点
     */
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;


    public DLinkedNodeCatch(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // cache里面没有
        }

        // cache 命中,挪到开头
        this.moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // 最后一个节点弹出
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }
        } else {
            // cache命中,更新cache.
            node.value = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        DLinkedNodeCatch catchNodeCatch = new DLinkedNodeCatch(2);
        catchNodeCatch.put(1,1);
        catchNodeCatch.put(2,2);
        catchNodeCatch.put(1,11);

    }

}
