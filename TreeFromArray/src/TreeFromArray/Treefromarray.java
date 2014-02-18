package TreeFromArray;

public class Treefromarray {
	public static void main(String[] args){
		BinaryTree t=new BinaryTree();
		CreateTree c=new CreateTree();
		c.createTree(new int[]{2, 5, 6, 8, 11, 22, 33});
	}
}
class CreateTree{
	BinaryTree t=new BinaryTree();
	public BinaryTree createTree(int[] array){
		if(array.length<1){
			return t;
		}
		int low=0;
		int high=array.length-1;
		createBalancedTree(array, low, high);
		t.preorder();
		return t;
	}
	public void createBalancedTree(int[] array, int low, int high){
		if(high<low){
			return;
		}
		int mid=(low+high)/2;
		t.insert(array[mid]);
		createBalancedTree(array, low, mid-1);
		createBalancedTree(array, mid+1, high);
	}
}
class BinaryTree{
	private class Node{
		Node left;
		Node right;
		int data;
		Node(int newdata){
			left=null;
			right=null;
			data=newdata;
		}
	}
	private Node root;
	public void BinaryTree(){
		root=null;
	}
	
	public boolean lookup(int data){
		return lookup(root, data);
	}
	
	public boolean lookup(Node node, int data){
		if(node==null){
			return false;
		}
		if(data==node.data){
			return true;
		}
		else if(data<node.data){
			return lookup(node.left, data);
		}
		else{
			return lookup(node.right, data);
		}
	}
	
	public void insert(int data){
		Node temp=root;
		Node newnode=new Node(data);
		newnode.left=null;
		newnode.right=null;
		newnode.data=data;
		root=insert(root, newnode);
	}
	public Node insert(Node temp, Node newnode){
		int data;
		if(temp==null){
			temp=newnode;
		}
		else{
			if(temp.data<=newnode.data){
				insert(temp.right, newnode);
				if(temp.right==null)
					temp.right=newnode;
			}
			else{
				insert(temp.left, newnode);
				if(temp.left==null)
					temp.left=newnode;
			}
		}
		return temp;
	}
	
	public String preorder(){
		return preorder(root);
	}
	String s1=" ";
	
	public String preorder(Node node){
		if(node==null)
		{
			return null;
		}
			System.out.print(node.data+"\t");
			s1=s1+node.data;
			String pre=s1;
			preorder(node.left);
			preorder(node.right);
			return pre;
	}
	String s2=" ";
	public String inorder(){
		return inorder(root);
	}
	public String inorder(Node node){
		if(node==null)
		{
			return null;
		}
		inorder(node.left);
		System.out.print(node.data+" ");
		s2=s2+node.data;
		String in=s2;
		inorder(node.right);
		return in;
	}	
	//If we want to check if a tree is a subtree of parent tree then 
	//do the inorder, preorder of parent, sub trees and if the parent inrder contains subtree inorder
	//or parent preorder contains subtree preorder, then a tree is subtree 
}
