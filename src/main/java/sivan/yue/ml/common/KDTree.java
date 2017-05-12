package sivan.yue.ml.common;

import java.util.Vector;

/**
 * Created by xiwen.yxw on 2017/5/12.
 */
public class KDTree {
    private KDNode root = null;

    public KDTree() {

    }

    public void makeKdTree(Vector<Vector<Integer>> input) {
        root = makeKdTree(input ,0);
    }

    private KDNode makeKdTree(Vector<Vector<Integer>> input, int level) {
        if (input.size() == 0) {
            return null;
        }
        KDNode curNode = new KDNode();
        int position = level % input.get(0).size();
        curNode.position = position;
        sort(input, position);
        int pos = input.size() / 2;
        Vector<Vector<Integer>> leftInput = new Vector<Vector<Integer>>();
        Vector<Vector<Integer>> rightInput = new Vector<Vector<Integer>>();
        for (int i = 0; i < pos; ++i) {
            leftInput.add(input.get(i));
        }
        for (int i = pos + 1; i < input.size(); ++i) {
            rightInput.add(input.get(i));
        }
        curNode.x = input.get(pos);
        curNode.left = makeKdTree(leftInput, level + 1);
        curNode.right = makeKdTree(rightInput, level + 1);
        return curNode;
    }

    private void sort(Vector<Vector<Integer>> input, int position) {

    }
}
