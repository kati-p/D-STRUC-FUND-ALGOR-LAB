public class AVLNode extends BTNode {

    private int weight, leftH, rightH;

    public AVLNode (int element, BTNode left, BTNode right, int weight, int leftH, int rightH) {
        super(element, left, right);
        this.weight = weight; this.leftH = leftH; this.rightH = rightH;
    }

    public int getWeight() {
        return  weight;
    }

    public int getLeftH() {
        return leftH;
    }

    public int getRightH() {
        return rightH;
    }

    public void setWeight(int w) {
        weight = w;
    }

    public void setLeftH(int lh) {
        leftH = lh;
    }
    public void setRightH(int rh) {
        rightH = rh;
    }
}
