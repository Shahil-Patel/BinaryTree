import java.util.*;
public class TreeSetRunner
{
	public TreeSetRunner()
	{
		//FIRST PART OF RUNNER
		TreeSet<String> treeSet=new TreeSet<String>();
		double sum=0.0;
		int sizeTemp=0;
		for(int x=0;x<26;x++)
		{
			int random=(int)(Math.random()*26)+97;
			sizeTemp=treeSet.size();
			treeSet.add((char)(random)+"");
			if(treeSet.size()>sizeTemp)
				sum+=random;
		}
		System.out.println("Avg ASCII Value: "+(sum/treeSet.size())+"\nAvg Character: "+(char)((int)Math.round(sum/treeSet.size()))+"\nSize: "+treeSet.size()+"\n\nOriginal - Pre-Order"+treeSet.preOrder()+"\nOriginal - Post-Order"+treeSet.postOrder()+"\nOriginal - In-Order"+treeSet.inOrder());

		ArrayList<String> treeSetParsed=treeSet.parser(treeSet.preOrder()); //THE TREE PARSER METHOD TAKES IN THE STRING AND CHOPS IT UP INTO THE ARRAYLIST FOR EASY ACCESS (I JUST WANTED TO SAVE SPACE)
		TreeSet<String> preOrderSet=new TreeSet<String>();
		for(int x=0;x<treeSetParsed.size();x++)
		{
			preOrderSet.add(treeSetParsed.get(x));
		}
		System.out.println("\nPreOrderSet - Pre-Order"+preOrderSet.preOrder()+"\nPreOrderSet - Post-Order"+preOrderSet.postOrder()+"\nPreOrderSet - In-Order"+preOrderSet.inOrder());

		treeSetParsed=treeSet.parser(treeSet.inOrder());
		TreeSet<String> inOrderSet=new TreeSet<String>();
		for(int x=0;x<treeSetParsed.size();x++)
		{
			inOrderSet.add(treeSetParsed.get(x));
		}
		System.out.println("\nInOrderSet - Pre-Order"+inOrderSet.preOrder()+"\nInOrderSet - Post-Order"+inOrderSet.postOrder()+"\nInOrderSet - In-Order"+inOrderSet.inOrder());

		treeSetParsed=treeSet.parser(treeSet.postOrder());
		TreeSet<String> postOrderSet=new TreeSet<String>();
		for(int x=0;x<treeSetParsed.size();x++)
		{
			postOrderSet.add(treeSetParsed.get(x));
		}
		System.out.println("\nPostOrderSet - Pre-Order"+postOrderSet.preOrder()+"\nPostOrderSet - Post-Order"+postOrderSet.postOrder()+"\nPostOrderSet - In-Order"+postOrderSet.inOrder()+"\n");

		String removedChar=(char)((int)(Math.random()*26)+97)+"";
		postOrderSet.remove(removedChar);
		System.out.println("Removed: "+removedChar+"\nPostOrderSet w/removed - Pre-Order"+postOrderSet.preOrder()+"\nPostOrderSet w/removed - Post-Order"+postOrderSet.postOrder()+"\nPostOrderSet w/removed - In-Order"+postOrderSet.inOrder()+"\n");

		//SECOND PART OF RUNNER

		System.out.println("------------------------------------------------------------------------------------------------------------");
		TreeSet<Integer> tree=new TreeSet<Integer>();
		for(int x=0;x<30;x++)
		{
			tree.add((int)(Math.random()*100)+1);
		}
		System.out.println("\nSize: "+tree.size()+"\nOriginal - Pre-Order"+tree.preOrder()+"\nOriginal - Post-Order"+tree.postOrder()+"\nOriginal - In-Order"+tree.inOrder()+"\n");

		ArrayList<Integer> treeParsed=tree.parser(tree.preOrder());
		TreeSet<Integer> preTree=new TreeSet<Integer>();
		for(int x=0;x<treeParsed.size();x++)
		{
			preTree.add(treeParsed.get(x));
		}
		System.out.println("PreOrderTree - Pre-Order"+preTree.preOrder()+"\nPreOrderTree - Post-Order"+preTree.postOrder()+"\nPreOrderTree - In-Order"+preTree.inOrder()+"\nThe traversals are arranged in a way where the first digit is prioritized over the next and so on\n");

		treeParsed=tree.parser(tree.inOrder());
		TreeSet<Integer> inTree=new TreeSet<Integer>();
		for(int x=0;x<treeParsed.size();x++)
		{
			inTree.add(treeParsed.get(x));
		}
		System.out.println("InOrderTree - Pre-Order"+inTree.preOrder()+"\nInOrderTree - Post-Order"+inTree.postOrder()+"\nInOrderTree - In-Order"+inTree.inOrder()+"\nThe traversals are arranged in a way where the first digit is prioritized over the next and so on\n");

		treeParsed=tree.parser(tree.postOrder());
		TreeSet<Integer> postTree=new TreeSet<Integer>();
		for(int x=0;x<treeParsed.size();x++)
		{
			postTree.add(treeParsed.get(x));
		}
		System.out.println("PostTree - Pre-Order"+postTree.preOrder()+"\nPostTree - Post-Order"+postTree.postOrder()+"\nPostTree - In-Order"+postTree.inOrder()+"\nThe traversals are arranged in a way where the first digit is prioritized over the next and so on\n");
		System.out.println("No Rotation - Pre-Order"+tree.preOrder()+"\nNo Rotation - Post-Order"+tree.postOrder()+"\nNo Rotation - In-Order"+tree.inOrder());
		TreeSet<Integer> rotationTree=tree;
		rotationTree.rotateLeft();
		System.out.println("\n1 Left Rotation - Pre-Order"+rotationTree.preOrder()+"\n1 Left Rotation - Post-Order"+rotationTree.postOrder()+"\n1 Left Rotation - In-Order"+rotationTree.inOrder());
		rotationTree.rotateRight();
		System.out.println("\n1 Right Rotation - Pre-Order"+rotationTree.preOrder()+"\n1 Right Rotation - Post-Order"+rotationTree.postOrder()+"\n1 Right Rotation - In-Order"+rotationTree.inOrder());
		rotationTree.rotateLeft();
		rotationTree.rotateLeft();
		System.out.println("\n2 Left Rotation - Pre-Order"+rotationTree.preOrder()+"\n2 Left Rotation - Post-Order"+rotationTree.postOrder()+"\n2 Left Rotation - In-Order"+rotationTree.inOrder());
		rotationTree.rotateRight();
		rotationTree.rotateRight();
		rotationTree.rotateRight();
		System.out.println("\n3 Right Rotation - Pre-Order"+rotationTree.preOrder()+"\n3 Right Rotation - Post-Order"+rotationTree.postOrder()+"\n3 Right Rotation - In-Order"+rotationTree.inOrder());
		String rootTemp="";
		while(!rootTemp.equals(rotationTree.preOrder().split(",")[0]))
		{
			rootTemp=rotationTree.preOrder().split(",")[0];
			rotationTree.rotateLeft();
		}
		System.out.println("\nMax Left Rotation - Pre-Order"+rotationTree.preOrder()+"\nMax Left Rotation - Post-Order"+rotationTree.postOrder()+"\nMax Left Rotation - In-Order"+rotationTree.inOrder());
		rootTemp="";
		while(!rootTemp.equals(rotationTree.preOrder().split(",")[0]))
		{
			rootTemp=rotationTree.preOrder().split(",")[0];
			rotationTree.rotateRight();
		}
		System.out.println("\nMax Right Rotation - Pre-Order"+rotationTree.preOrder()+"\nMax Right Rotation - Post-Order"+rotationTree.postOrder()+"\nMax Right Rotation - In-Order"+rotationTree.inOrder());
	}
	public static void main(String[] args)
	{
		TreeSetRunner app=new TreeSetRunner();
	}
}