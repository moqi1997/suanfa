package com.moqi.tree;

/**
 * @author moqi
 * @date 2020/3/24 9:13
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree BinaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1,"宋江");
        HeroNode heroNode1 = new HeroNode(2,"无用");
        HeroNode heroNode2 = new HeroNode(3,"卢俊义");
        HeroNode heroNode3 = new HeroNode(4,"林冲");
        root.setLeft(heroNode1);
        root.setRight(heroNode2);
        heroNode2.setRight(heroNode3);
        BinaryTree.setRoot(root);
        //测试前序遍历
        System.out.println("前序遍历");
        BinaryTree.preOrder();
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder() {
        //线束如父节点
        System.out.println(this);
        //左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder() {
        //递归向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();;
        }
    }
    //后续遍历
    public void afterOrder() {

        //左子树前序遍历
        if (this.left != null) {
            this.left.afterOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.afterOrder();
        }
        //线束如父节点
        System.out.println(this);
    }
}
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后续遍历
    public void afterOrder() {
        if (this.root != null) {
            this.root.afterOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}