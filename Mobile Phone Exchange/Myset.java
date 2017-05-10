package assignment2;

/*public class Myset {
	ob top =new ob();
	int flag;
	public Boolean IsEmpty()
	{
		if (top==null)
			return true;
		else 
			return false;
	}
	public Boolean IsMember(Object o)
	{
		flag=0;
		ob temp=top;
		while(temp!=null)
		{
			if(temp.data==o)
			{
				flag=1;
				break;
			}
			temp=temp.next;
		}
		if(flag==1)
			return true;
		else 
			return false;
	}
	public ob get(Object o)
	{
		ob temp=top;
		while(temp!=null)
		{
			if(temp.data==o)
			{
				break;
			}
			temp=temp.next;
		}
		return temp;
	}
	public void Insert(Object o)
	{
		if(top==null)
		{
			top.data=o;
		}
		else
		{
			ob temp=new ob();
			temp.data=o;
			temp.next=top;
			top=temp;			
		}
	}
	public void Delete(Object o)
	{
		if(top==null)
		{
			
		}
		else
		{
			top=top.next;
		}
	}
	public Myset Union(Myset a)
	{
		Myset union =new Myset();
		union.top=top;
		ob temp2=new ob();
		temp2=a.top;
		while(temp2!=null)
		{
			if(union.IsMember(temp2))
			{
				temp2=temp2.next;
			}
			else
			{
				union.Insert(temp2);
				temp2=temp2.next;
			}
		}
		return union;
	}
	public Myset Intersection(Myset a)
	{
		Myset intersection=new Myset();
		ob temp3=new ob();
		temp3=top;
		while(temp3!=null)
		{
			if(a.IsMember(temp3))
			{
				intersection.Insert(temp3);
			}
			temp3=temp3.next;			
		}
		return intersection;
	}
	public static void main (String args[])
	{
		Myset a=new Myset();
		Myset b=new Myset();
		Myset f=new Myset();
		int c=5;
		int d=6;
		int r=8;
		int h=8;
		a.Insert(c);
		a.Insert(r);
		b.Insert(d);
		f=a.Union(b);
		System.out.println(a.top.data+" "+b.top.data+" "+f.top.data+" "+a.IsMember(h));
	}
}
class ob
{
	ob next;
	Object data=new Object();
}
*/


public class Myset {
	ob top =new ob();
	int flag;
	
	public Boolean IsEmpty()
	{
		if (top.data==null)
			return true;
		else 
			return false;
	}
	public Boolean IsMember(Object o)
	{
		flag=0;
		ob temp=top;
		while(temp!=null)
		{
			if(temp.data==o)
			{
				flag=1;
				break;
			}
			temp=temp.next;
		}
		if(flag==1)
			return true;
		else 
			return false;
	}
	public void Insert(Object o)
	{
		if(top==null)
		{
			top.data=o;
		}
		else
		{
			ob temp=new ob();
			temp.data=o;
			temp.next=top;
			top=temp;			
		}
	}
	public void Delete(Object o)
	{
		
		ob temp=null;
		ob temp2=null;
		temp2=top;
		temp=top;
		if(temp.data==o)
		{
			top=top.next;
		}
		else
		{
			temp=temp.next;
			while(temp.data!=null)
			{
				if(temp.data==o)
				{
					temp2.next=temp.next;
					break;
				}
				temp=temp.next;
				temp2=temp2.next;
			}
		}
	}
	public Myset Union(Myset a)
	{
		Myset union =new Myset();
		if(a.IsEmpty()==true && this.IsEmpty()==true )
		{
		}
		else if(a.IsEmpty()==true && this.IsEmpty()==false)
		{
			union=this;
		}
		else if(a.IsEmpty()==false && this.IsEmpty()==true)
		{
			union=a;
		}
		else{
		union.top=top;
		ob temp2=new ob();
		temp2=a.top;
		while(temp2!=null)
		{
			if(union.IsMember(temp2.data))
			{
				temp2=temp2.next;
			}
			else
			{
				union.Insert(temp2.data);
				temp2=temp2.next;
			}
		}}
		return union;
	}
	public Myset Intersection(Myset a)
	{
		Myset Intersection=new Myset();
		ob temp3=new ob();
		temp3=top;
		while(temp3!=null)
		{
			if(a.IsMember(temp3.data))
			{
				Intersection.Insert(temp3.data);
				//System.out.println(Intersection.top.data + "aa");
			}
			temp3=temp3.next;			
		}
		return Intersection;
	}
	/*public static void main (String args[])
	{
		Myset a=new Myset();
		Myset b=new Myset();
		Myset f=new Myset();
		a.Insert(5);
		a.Insert(6);
		a.Insert(8);
		b.Insert(6);
		b.Insert(11);
		a.Delete(6);
		//f=a.Intersection(b);
		System.out.println(a.top.data+ " " + a.top.next.next.data + " "+b.top.data + " "+b.top.next.data + " "+f.top.data+" "+a.IsMember(9));
	}*/
}
class ob
{
	ob next=null;
	Object data;
}