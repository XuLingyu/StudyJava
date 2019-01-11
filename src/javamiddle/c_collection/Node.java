package javamiddle.c_collection;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    // 左子节点
    public Node<T> leftNode;
    // 右子节点
    public Node<T> rightNode;
    // 对象（值）
    public T value;

    // 插入 数据
    public void add(T t) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = t;

            // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同

            if ((Integer) t -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node();
                leftNode.add(t);


            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node();
                rightNode.add(t);
            }

        }
    }

    // 中序遍历所有的节点
    // 当左边为空时，把左边获得的值，和当前的value，添加到ArrayList里，
    // 再等右边为空时,右边的添加到这个ArrayList里，
    // 结束后return給上一层（  Values.addAll(leftNode.Values());）
    public List<T> inOrderTraversal() {
        List<T> values = new ArrayList<>();

        // 左节点的遍历结果
        // 左节点不为空一直往下找 找到为空了 add value
        if (null != leftNode)
            values.addAll(leftNode.inOrderTraversal());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if (null != rightNode)

            values.addAll(rightNode.inOrderTraversal());

        return values;
    }

    public static void main(String[] args) {

        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };

        Node<Integer> roots = new Node<>();
        for (Integer number : randoms) {
            roots.add(number);
        }
        List<Integer> list = roots.inOrderTraversal();
        System.out.println(list);
    }

}
