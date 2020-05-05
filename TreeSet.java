import java.util.*;
public class TreeSet<E extends Comparable<E>>
{
	private TreeNode<E> root;
	private String output="[";
	private int resetCount=0;
	private int size;
	public TreeSet()
	{
		root=null;
		size=0;
	}
	public int size()
	{
		return size;
	}
	public String inOrder()
	{
		return inOrder(root);
	}
	public String preOrder()
	{
		return preOrder(root);
	}
	public String postOrder()
	{
		return postOrder(root);
	}
	@SuppressWarnings("unchecked")
	public ArrayList<E> parser(String s)
	{
		ArrayList<E> arr=new ArrayList<E>();
		String[] str=s.substring(1,s.length()-1).split(",");
		for(int x=0;x<str.length;x++)
		{
			arr.add((E)str[x]);
		}
		return arr;
	}
	public String inOrder(TreeNode<E> node)
	{
		if(node!=null)
		{
			inOrder(node.getLeft());
			output+=node.getValue()+",";
			inOrder(node.getRight());
		}
		String temp=output.substring(0,output.length()-1)+"]";
		if(temp.contains("]"))
		{
			resetCount++;
			if(resetCount==size*2+1)
			{
				resetCount=0;
				output="[";
			}
		}
		return temp;
	}
	public String preOrder(TreeNode<E> node)
	{
		if(node!=null)
		{
			output+=node.getValue()+",";
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
		String temp=output.substring(0,output.length()-1)+"]";
		if(temp.contains("]"))
		{
			resetCount++;
			if(resetCount==size*2+1)
			{
				resetCount=0;
				output="[";
			}
		}
		return temp;
	}
	public String postOrder(TreeNode<E> node)
	{
		if(node!=null)
		{
			postOrder(node.getLeft());
			postOrder(node.getRight());
			output+=node.getValue()+",";
		}
		String temp=output.substring(0,output.length()-1)+"]";
		if(temp.contains("]"))
		{
			resetCount++;
			if(resetCount==size*2+1)
			{
				resetCount=0;
				output="[";
			}
		}
		return temp;
	}
	public void add(E ob)
	{
		TreeNode<E> obj=new TreeNode<E>(ob);
		if(root==null)
		{
			root=obj;
		}
		else
		{
			boolean placed=false;
			TreeNode<E> temp=root;
			while(!placed)
			{
				if(temp.compareTo(obj)>0)
				{
					if(temp.getRight()==null)
					{
						temp.setRight(obj);
						placed=true;
					}
					else temp=temp.getRight();
				}
				else if(temp.compareTo(obj)<0)
				{
					if(temp.getLeft()==null)
					{
						temp.setLeft(obj);
						placed=true;
					}
					else temp=temp.getLeft();
				}
				else
				{
					placed=true;
					size--;
				}
			}
		}
		size++;
	}
	public void rotateLeft()
	{
		rotateLeft(root);
	}
	public void rotateRight()
	{
		rotateRight(root);
	}
	public void rotateLeft(TreeNode<E> root)
	{
		if(root==null||root.getRight()==null)
		{
			return;
		}
		TreeNode<E> temp=root.getRight();
		root.setRight(temp.getLeft());
		TreeNode<E> tempLeft=temp.getLeft();
		temp.setLeft(root);
		root.setRight(tempLeft);
		this.root=temp;
	}
	public void rotateRight(TreeNode<E> root)
	{
		if(root==null||root.getLeft()==null)
		{
			return;
		}
		TreeNode<E> temp=root.getLeft();
		root.setLeft(temp.getRight());
		temp.setRight(root);
		this.root=temp;
	}
	public void remove(E ob)
	{
		boolean notInSet=false;
		TreeNode<E> rootTemp=root;
		TreeNode<E> rootTempParent=root;
		TreeNode<E> obj=new TreeNode<E>(ob);
		boolean found=false;
		while(!found)
		{
			if(rootTemp.compareTo(obj)>0)
			{
				if(rootTemp.getRight()!=null)
				{
					rootTemp=rootTemp.getRight();
				}
				else
				{
					found=true;
					notInSet=true;
				}
			}
			else if(rootTemp.compareTo(obj)<0)
			{
				if(rootTemp.getLeft()!=null)
				{
					rootTemp=rootTemp.getLeft();
				}
				else
				{
					found=true;
					notInSet=true;
				}
			}
			else
			{
				found=true;
			}
		}
		if(!notInSet)
		{
			if((rootTemp.getLeft()==null&&rootTemp.getRight()==null))
			{
				found=false;
				while(!found)
				{
					if(rootTempParent.compareTo(obj)>0)
					{
						if(rootTempParent.getRight()==rootTemp)
						{
							found=true;
						}
						else rootTempParent=rootTempParent.getRight();
					}
					else if(rootTempParent.compareTo(obj)<0)
					{
						if(rootTempParent.getLeft()==rootTemp)
						{
							found=true;
						}
						else rootTempParent=rootTempParent.getLeft();
					}
				}
				if(rootTemp.getLeft()==null&&rootTemp.getRight()==null)
				{
					if(rootTempParent.getLeft()==rootTemp)
					{
						rootTempParent.setLeft(null);
					}
					else
					{
						rootTempParent.setRight(null);
					}
				}
			}
			else if((rootTemp.getRight()==null||rootTemp.getLeft()==null))
			{
				found=false;
				while(!found)
				{
					if(rootTempParent.compareTo(obj)>0)
					{
						if(rootTempParent.getRight()==rootTemp)
						{
							found=true;
						}
						else rootTempParent=rootTempParent.getRight();
					}
					else if(rootTempParent.compareTo(obj)<0)
					{
						if(rootTempParent.getLeft()==rootTemp)
						{
							found=true;
						}
						else rootTempParent=rootTempParent.getLeft();
					}
					else
					{
						found=true;
					}
				}
				if(rootTempParent.getLeft()==rootTemp)
				{
					if(rootTemp.getLeft()!=null)
					{
						rootTempParent.setLeft(rootTemp.getLeft());
					}
					else
					{
						rootTempParent.setLeft(rootTemp.getRight());
					}
				}
				else
				{
					if(rootTemp.getLeft()!=null)
					{
						rootTempParent.setRight(rootTemp.getLeft());
					}
					else
					{
						rootTempParent.setRight(rootTemp.getRight());
					}
				}
			}
			else
			{
				TreeNode<E> temp=rootTemp;
				TreeNode<E> tempParent=temp;
				temp=temp.getRight();
				if(temp.getLeft()!=null)
				{
					while(true)
					{
						if(temp.getLeft()==null)
						{
							break;
						}
						tempParent=temp;
						temp=temp.getLeft();
					}
					temp=tempParent.getLeft();
					tempParent.setLeft(null);
					rootTemp.setValue(temp.getValue());
				}
				else
				{
					rootTemp.setValue(temp.getValue());
					rootTemp.setRight(temp.getRight());
					rootTemp.setValue(temp.getValue());
					rootTemp.setRight(temp.getRight());
				}
			}
			size--;
		}
	}
	public class TreeNode<E extends Comparable<E>>
	{
		private E value;
		private TreeNode<E> left;
		private TreeNode<E> right;
		public TreeNode(E initValue)
		{
			value=initValue;
			left=null;
			right=null;
		}
		public E getValue()
		{
			return value;
		}
		public TreeNode<E> getLeft()
		{
			return left;
		}
		public TreeNode<E> getRight()
		{
			return right;
		}
		public void setValue(E theNewValue)
		{
			value=theNewValue;
		}
		public void setLeft(TreeNode<E> newLeft)
		{
			left=newLeft;
		}
		public void setRight(TreeNode<E> newRight)
		{
			right=newRight;
		}
		public String toString()
		{
			return value+"";
		}
		public int compareTo(TreeNode<E> other)
		{
			return other.getValue().compareTo(getValue());
		}
	}
}