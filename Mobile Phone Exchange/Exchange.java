package assignment2;

public class Exchange 
{
	int num;
	int d;
	Exchange par=null;
	Exchange next=null;
	Exchange prev=null;
	ExchangeList list=new ExchangeList();
	MobilePhoneSet set=new MobilePhoneSet();
	public Exchange mobileex(int a)//given a mobile id it returns exchange
	{
		Exchange temp2=null;
		Exchange temp;
		temp=list.top;
		set=this.residentSet();
		if(set.IsMemberid(a)==true && temp==null)
		{
			temp2=this;
			return temp2;
		}
		else if(set.IsMemberid(a))
		{
			while(temp!=null)
			{
				if(temp.mobileex(a)!=null)
					{
					temp2=temp.mobileex(a);
					}
				temp=temp.next;
			}
		}
		return temp2;
	}
	/*public Exchange get(int identifier)//retruns exchange for a particular id
	{
		Exchange temp;
		Exchange temp1=null;
		if(num==identifier)
		{
			temp1=this;
		}
		temp=list.top;
		while(temp!=null)
		{
			
			if(temp.get(identifier)!=null)
			{
			temp1=temp.get(identifier);
			}
			temp=temp.next;
		}
		return temp1;
	}*/
	Exchange(int number)
	{
		num=number;
	}
	public Exchange parent()
	{
		return par;
	}
	public int numChildren()
	{
		return list.c;
	}
	public Exchange child(int i) throws IllegalArgumentException
	{
		Exchange temp;
		int a=numChildren();
		if(i+1>a)
		{
			throw new IllegalArgumentException();
		}
		Exchange temp2=null;
		temp=list.top;
		for(d=1;d<=a-i-1;d++)
		{
			temp=temp.next;
		}
		temp2=temp;
		return temp2;
	}
	public boolean isRoot()
	{
		if (par==null)
			return true;
		else
			return false;
	}
	public RoutingMapTree subtree(int i)
	{
		RoutingMapTree sub=new RoutingMapTree();
		sub.root=child(i);
		return sub;
		
	}
	public MobilePhoneSet residentSet()
	{
		
		MobilePhoneSet set1=new MobilePhoneSet();
		Exchange temp;
		temp=list.top;
		int c=0;
		if(temp==null)
		{
			return set;
		}
		
		while(temp!=null)
		{
			//System.out.println(temp.residentSet().getid(1));
			if(c==0)
			{
				set1=set.Union(temp.residentSet());
				temp=temp.next;
				c++;
			}
			else
			{
				set1=set1.Union(temp.residentSet());
				temp=temp.next;
			}
		}
		//System.out.println(set.getid(2));
		return set1;
	}
	public Exchange leastRouter(Exchange a, Exchange b)
	{
		
		Exchange lowest=null;
		if(a==b)
		{
			return a;
		}
		else
		{
			Exchange temp;
				temp=list.top;
				
				while(temp!=null)
				{
					if(temp.findex(a)==true&&temp.findex(b)==true)
					{
						lowest=temp.leastRouter(a, b);
						break;
					}
					else
					{
						temp=temp.next;
					}
				}
				if(temp==null)
				{
					lowest=this;
				}
			
		}
		return lowest;
	}
	public boolean findex(Exchange a)// checks wether a particular exchange exists
	{
		boolean b=false;
		Exchange temp=list.top;
		if(num==a.num)
		{
			b=true;
		}
		while(temp!=null)
		{
			if(temp.num==a.num)
			{		
				b=true;
				break;
			}
			if(temp.findex(a)==true)
			{
				b=temp.findex(a);
			}
			temp=temp.next;
		}
		return b;
	}
	public Exchange get(int identifier)//returns exchange for a particular id
	{
		Exchange temp;
		Exchange temp1=null;
		if(num==identifier)
		{
			temp1=this;
		}
		temp=list.top;
		while(temp!=null)
		{
			
			if(temp.get(identifier)!=null)
			{
			temp1=temp.get(identifier);
			}
			temp=temp.next;
		}
		return temp1;
	}
	/*public static void main (String args[])
	{
		Exchange b=new Exchange(1);
		Exchange c=new Exchange(2);
		Exchange d=new Exchange(3);
		Exchange e=new Exchange(4);
		Exchange f=new Exchange(5);
		
		b.list.Insert(d, 3);
		d.list.Insert(c, 2);
		e=b.get(2);
		System.out.println(e.num+" "+b.findex(d)+" "+b.findex(c));
	}*/
}
class ExchangeList
{
	Exchange parent=null;
	Exchange top=null;
	Exchange last=null;
	int c=0;
	public void Insert(Exchange o,Exchange p)
	{
		o.par=p;
		if(top==null)
		{
			top=o;
			last=o;
		}
		else 
		{
			Exchange temp=null;
			temp=o;
			temp.next=top;
			top.prev=temp;
			top=temp;			
		}
		c++;
	}
}
