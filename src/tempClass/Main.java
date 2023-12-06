package tempClass;

import java.util.Scanner;

import consoleColor.ConsoleColor;

public class Main {

	// field variables
	private static Scanner sc;
	private static BinaryTree binaryTree = new BinaryTree();

	public static void main(String[] args) {
		MenuScreen();
	}// end main

	// methods
	public static void MenuScreen() {
		sc = new Scanner(System.in);

		//@formatter:off
		System.out.print("" + 
						"━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Display	┃\n" +
						"┃ 【 2 】 Insert 	┃\n" + 
						"┃ 【 3 】 Delete 	┃\n" +
						"┃ 【 4 】 Search 	┃\n" +
						"┃ 【 5 】 Exit 	┃\n" + 
						"━━━━━━━━━━━━━━━━━\n" + 
						ConsoleColor.GREEN+"》 " + ConsoleColor.RESET);
		//@formatter:on

		switch (sc.nextInt()) {
		case 1:// display values
			Display();
			break;
		case 2:// insert
			System.out.print("Enter Element To Insert" + ConsoleColor.GREEN + "》 " + ConsoleColor.RESET);
			binaryTree.insert(binaryTree.getRoot(), OperationMenu());
			break;
		case 3:// delete
			System.out.print("Enter Element To Delete" + ConsoleColor.GREEN + "》 " + ConsoleColor.RESET);
			binaryTree.Delete(binaryTree.getRoot(), OperationMenu());
			System.out.print("Element is deleted successfully");
			Display();
			break;
		case 4:// search
			System.out.print("Enter Element To Search" + ConsoleColor.GREEN + "》 " + ConsoleColor.RESET);
			Node searchResult = null;
			searchResult = binaryTree.Search(binaryTree.getRoot(), OperationMenu());

			if (searchResult == null) {
			// @formatter:off
			System.out.print("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Searching:			   ┇\n" +
								"┇ Binary Search Tree    	   ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" + 
								"┇ Output: ?		   	   ┇\n" +
								"┇ Element Not Found!		   ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
			} else {
			// @formatter:off
			System.out.print("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Searching:			   ┇\n" +
								"┇ Binary Search Tree    	   ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" + 
								"┇ Output: " + searchResult.getKey() + "		   	   ┇\n" +
								"┇ \033[3mElement Found!\033[0m 		   ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
			} // end if else
			break;
		case 5:// exit
			System.out.println(ConsoleColor.RED + "「Exiting now...」" + ConsoleColor.RESET);
			System.exit(0);
			break;
		default:
			// @formatter:off
			System.out.println("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Error:			    ┇\n" +
								"┇ Input is not a valid Menu choice. ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Msg: 				    ┇\n" +
								"┇ \033[3mPlease enter only 1 to 5 as input\033[0m	┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			// @formatter:on
			break;
		}// end switch
		MenuScreen();
	}// end method

	public static int OperationMenu() {
		sc = new Scanner(System.in);
		int key = sc.nextInt();
		return key;
	}// end method

	public static void Display() {
		// @formatter:off
			System.out.print("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Display:			   ┇\n" +
								"┇ Binary Search Tree    	   ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" + 
								"┇ Output: ");
			// @formatter:on
		binaryTree.Display(binaryTree.getRoot());
		System.out.println("\n⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
	}// end method

}// end class
