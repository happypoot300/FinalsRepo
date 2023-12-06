package tempClass;

import java.util.Scanner;

import consoleColor.ConsoleColor;

public class BinaryTree {

	// field variables
	private Node root;
	private Scanner sc;

	public Node getRoot() {
		return this.root;
	}// end method

	public void Display(Node pointer) {
		if (root == null) {
			System.out.print("\033[3mNo root available\033[0m		   ┇");
			return;
		} // end if

		if (pointer != null) {
			System.out.print(ConsoleColor.GREEN + pointer.getKey() + " ▶ " + ConsoleColor.RESET);
			Display(pointer.getLeftChild());
			Display(pointer.getRightChild());
		} // end if
	}// end method

	public Node insert(Node pointer, int key) {

		if (root == null) {
			// @formatter:off
			System.out.println("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Error:			   ┇\n" +
								"┇ There is no root created yet.    ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Msg: 				   ┇\n" +
								"┇ \033[3mCreating key as new root...Done!\033[0m ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
			CreateRoot(key);
			return null;
		} // end if

		if (pointer == null) {// insert condition
			pointer = new Node(key);// put the new val to pointer current node
			return pointer;
		} // end if

		// determine if pointer goes left or right
		if (key < pointer.getKey()) {// less than key
			pointer.setLeftChild(insert(pointer.getLeftChild(), key));
		} else if (key > pointer.getKey()) {// greater than key
			pointer.setRightChild(insert(pointer.getRightChild(), key));
		} // end if else

		return pointer;
	}// end method

	public Node Delete(Node pointer, int key) {

		if (pointer == null) {
			return null;
		} // end if

		if (key < pointer.getKey()) {
			pointer.setLeftChild(Delete(pointer.getLeftChild(), key));
			return pointer;
		} else if (key > pointer.getKey()) {
			pointer.setRightChild(Delete(pointer.getRightChild(), key));
			return pointer;
		} // end if else

		if (pointer.getLeftChild() == null || pointer.getRightChild() == null) {
			// @formatter:off
			Node tempNode = null;
			tempNode = 
					pointer.getLeftChild() == null ? 
					pointer.getRightChild() : pointer.getLeftChild();
			// @formatter:on

			if (tempNode == null) {// means no children
				if (pointer == root) {
					return root = null;
				} // end if
				return null;
			} else {
				if (pointer == root) {
					return root = tempNode;
				} // end if
				return tempNode;// if it has one child on any side
			} // end if else

		} else {
			Node tempChild = pointer.getRightChild();

			while (tempChild.getLeftChild() != null) {
				tempChild = tempChild.getLeftChild();
			} // end while

			pointer.setKey(tempChild.getKey());
			pointer.setRightChild(Delete(pointer.getRightChild(), tempChild.getKey()));
		} // end if else

		return pointer;
	}// end method

	public Node Search(Node pointer, int key) {

		while (key != pointer.getKey()) {
			if (key < pointer.getKey()) {
				pointer = pointer.getLeftChild();
			} else if (key > pointer.getKey()) {
				pointer = pointer.getRightChild();
			} // end if else

			if (pointer == null) {
				return null;
			} // end if
		} // end while

		return pointer;
	}// end method

	public void CreateRoot(int key) {
		sc = new Scanner(System.in);
		Node tempNode = new Node(key);
		root = tempNode;
	}// end method

}// end class
