package sivan.yue.ml.common;

import java.util.Vector;

/**
 * Created by xiwen.yxw on 2017/5/12.
 */
public class KDTree {

    private KDNode root = null;

    public KDTree() {

    }

    public void makeKdTree(Vector<Vector<Double>> input) {
        root = makeKdTree(input ,null, 0);
    }

    private KDNode makeKdTree(Vector<Vector<Double>> input, KDNode parent, int level) {
        if (input.size() == 0) {
            return null;
        }
        KDNode curNode = new KDNode();
        curNode.parent = parent;
        int position = level % input.get(0).size();
        curNode.position = position;
        sort(input, position);
        int pos = input.size() / 2;
        Vector<Vector<Double>> leftInput = new Vector<>();
        Vector<Vector<Double>> rightInput = new Vector<>();
        for (int i = 0; i < pos; ++i) {
            leftInput.add(input.get(i));
        }
        for (int i = pos + 1; i < input.size(); ++i) {
            rightInput.add(input.get(i));
        }
        curNode.x = input.get(pos);
        curNode.left = makeKdTree(leftInput, parent, level + 1);
        curNode.right = makeKdTree(rightInput, parent, level + 1);
        return curNode;
    }

    private void sort(Vector<Vector<Double>> input, int pos) {
        sort(input, 0, input.size()-1, pos);
    }

    private void sort(Vector<Vector<Double>> input, int left, int right, int pos) {
        if (left >= right) {
            return;
        }
        int partPos = partition(input, left, right, pos);
        sort(input, left, partPos - 1, pos);
        sort(input, partPos + 1, right, pos);
    }

    private int partition(Vector<Vector<Double>> input, int left, int right, int pos) {
        int i, j = left;
        for (i = left; i < right; ++i) {
            if (input.get(i).get(pos) < input.get(right).get(pos)) {
                Vector<Double> tmp = input.get(i);
                input.set(i, input.get(j));
                input.set(j++, tmp);
            }
        }
        Vector<Double> tmp = input.get(j);
        input.set(j, input.get(right));
        input.set(right, tmp);
        return j;
    }
}
