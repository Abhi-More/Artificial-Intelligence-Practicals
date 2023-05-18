import java.util.*;

class TreeNode
{
	char val;
	List<TreeNode> child = new ArrayList<>();
	int noc;
	boolean flag;
	TreeNode(char val, int N)
	{
	    Scanner sc = new Scanner(System.in);
		this.val = val;
		this.noc = N;
		this.flag = false;
		for(int i = 0; i < this.noc; i++)
		{
			System.out .print("Enter Child " + (i+1) +" of " +this.val + " : ");
			char c = sc.next().charAt(0);
			System.out.print("Enter Number of child of " + c + " : ");
			int n = sc.nextInt();
			this.child.add(new TreeNode(c, n));
		}
		sc.close();
	}
}

public class BfsDfs
{
	static boolean searchFlag;
	static Scanner in;
	
	//DFS Preorder
	static void preOrder(TreeNode root)
	{
		if(root != null)
		{
			System.out.print(root.val + "  ");
			for(int i=0; i<root.noc; i++)
			{
				preOrder(root.child.get(i));
			}
		}
	}
	
	//BFS 
	static void BFS(TreeNode root)
	{
		if(root.flag == false)
		{
			System.out.print(root.val + "  ");
			root.flag = true;
		}
		for(int i = 0; i<root.noc; i++)
		{
			if(root.child.get(i).flag == false)
			{
				System.out.print(root.child.get(i).val + "  ");
				root.child.get(i).flag = true;
			}
		}
		for(int i = 0; i<root.noc; i++)
		{
			BFS(root.child.get(i));
		}
	}
	
	static void searchDFS(TreeNode root, char key)
	{
		if(root != null && searchFlag == false)
		{
			System.out.print(root.val + "  ");
			if(root.val == key)
			{
				searchFlag = true;
				return;
			}
				
			for(int i=0; i<root.noc; i++)
			{
				searchDFS(root.child.get(i), key);
			}
		}
	}

	static void searchBFS(TreeNode root, char key)
	{
		if(root.flag == false && searchFlag == false)
		{
			if(root.val == key)
			{
				System.out.print(root.val);
				searchFlag = true;
				return;
			}
			System.out.print(root.val + "  ");
			root.flag = true;
		}
		for(int i = 0; i<root.noc && searchFlag != true; i++)
		{
			if(root.child.get(i).flag == false)
			{
				System.out.print(root.child.get(i).val + "  ");
				if(root.child.get(i).val == key)
				{
					searchFlag = true;
					return;
				}
				root.child.get(i).flag = true;
			}
		}
		for(int i = 0; i<root.noc && searchFlag != true; i++)
		{
			BFS(root.child.get(i));
		}
	}

	public static void main(String[] args)
	{
		in = new Scanner(System.in);
		searchFlag = false;
		
		System.out.print("Enter Root Node: ");
		char rootVal = in.next().charAt(0);
		System.out.print("Enter Number Of Child of root: ");
		int N = in.nextInt();
		TreeNode root = new TreeNode(rootVal, N);
		
		System.out.println("\n DFS Preorder: ");
		preOrder(root);
		System.out.println("\n\n BFS: ");
		// BFS(root);
		
		System.out.print("Enter destination : ");
		rootVal = in.next().charAt(0);
		
		System.out.print("Path for : " + rootVal + " by DFS : ");
		searchFlag = false;
		
		searchDFS(root, rootVal);
		
		searchFlag = false;
		System.out.print("\nPath for : " + rootVal + " by BFS : ");
		searchBFS(root, rootVal);
	}
}
