import java.util.Scanner;  // Import the Scanner class

public class GuessingGame {
    
	protected GameTree GuessingGameTree;

    /**
	 * Constructor creates a game tree based on the file passed in
	 * filename the name of the .txt file containg the tree
	 */
	public GuessingGame(String filename) {
		GuessingGameTree = new GameTree(filename);
		//System.out.println(GuessingGameTree);

	}

	// constructor
	public GuessingGame() {
	}

	// play function conducts guessing game
	public void play() {
		// create scanner object
		Scanner userInput = new Scanner(System.in);
		// currentNode = root
		BinaryTreeNode<String> currentNode = GuessingGameTree.getRoot();
		// until end(while current is not a leaf)
		System.out.println(GuessingGameTree);
		while (!currentNode.isLeaf()) {
			//System.out.println("here");
			// print current.data
			System.out.println(currentNode.getData());
			// Scanner for userInput 
			String userAnswer = userInput.nextLine();  // Read user input
			System.out.println("You answered: " + userAnswer);
			// if userInput = yes
			if (userAnswer.contains("y")) {
				// current = current.getLeftchild	
				currentNode = currentNode.getLeftChild();
				//System.out.println("LEFT CHILD: " + currentNode);
			// else (it = no)			
			} else {
				// current = get.rightChild
				currentNode= currentNode.getRightChild();
			}
		}	
		isLeaf(currentNode);
		// close scanner
		userInput.close();
	}

	// helpter method for isLeaf 
	public void isLeaf(BinaryTreeNode<String> currentNode) {
		// is leaf
		// print (The answer is: current.getData)
		System.out.println(currentNode.getData());
	}
	public static void main(String[] args) {
		// prompt user to play
		System.out.println("20 questions game!(Enter 'y' or 'n' only)");
		// create GuessingGame object called "GamePlay" representing a new game
		GuessingGame GamePlay = new GuessingGame("favoriteArtist.txt"); 
		GamePlay.play();

	}
}


