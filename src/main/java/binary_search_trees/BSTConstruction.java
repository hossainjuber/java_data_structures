package binary_search_trees;

import java.util.ArrayList;
import java.util.List;


class BSTConstruction {
    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(7);
        list.add(17);
        list.add(18);
        list.add(19);

        System.out.println("The End");
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
        public BST insert(int value) {
            return insertHelper(this, value);
        }

        public BST insertHelper(BST node, int value){
            if(node==null){
                return new BST(value);
            }

            if(node!=null && value<node.value){
                node.left = insertHelper(node.left, value);
            }else if(node!=null && value>=node.value){
                node.right = insertHelper(node.right, value);
            }
            return node;
        }

        public boolean contains(int value) {
            // Write your code here.
            return containsHelper(this, value);
        }

        public boolean containsHelper(BST node, int value){
            if(node==null){
                return false;
            }
            if(node.value == value){
                return true;
            }else if(node.left!=null && value < node.value){
                return containsHelper(node.left, value);
            }else if(node.right!=null && value >= node.value){
                return containsHelper(node.right, value);
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            return removeHelper(this, value);
        }

        public BST removeHelper(BST node, int value){
            if(node==null){
                return node;
            }

            if(value<node.value){
                node.left = removeHelper(node.left, value);
            }else if(value>node.value){
                node.right = removeHelper(node.right, value);
            }else{
                if(node.left==null && node.right==null){
                    return null;
                }else if(node.right==null && node.left!=null){
                    node.value = node.left.value;
                    node.right = node.left.right;
                    node.left = node.left.left;
                }else if(node.left==null && node.right!=null){
                    node.value = node.right.value;
                    node.left = node.right.left;
                    node.right = node.right.right;
                }else if(node.right!=null && node.left!=null){
                    int minVal = getMinValue(node.right);
                    node.value = minVal;
                    node.right = removeHelper(node.right, minVal);
                    return node;
                }

            }
            return node;
        }

        public static int getMinValue(BST node){
            return node.left!=null ? getMinValue(node.left) :  node.value;
        }

    }
}




