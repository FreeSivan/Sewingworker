package sivan.yue.ml.common;

import java.util.Vector;

/**
 * Created by xiwen.yxw on 2017/5/12.
 */
public class KDNode {
    public int position;
    public Vector<Double> x;
    public KDNode left;
    public KDNode right;
    public KDNode parent;
}
