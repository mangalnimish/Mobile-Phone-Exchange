package assignment2;

public class MobilePhone 
{
	int id;
	boolean status;
	Exchange loc;
	MobilePhone(int number)
	{
		id=number;
	}
	public int number()
	{
		return id;
	}
	public boolean status()
	{
		return status;
	}
	public void switchOn()
	{
		status =true;
	}
	public void switchOff()
	{
		status=false;
	}
	public Exchange location()
	{
		return loc;
	}
	/*public static void main (String args[])
	{
		MobilePhone a=new MobilePhone(989);
		MobilePhone b=new MobilePhone(990);
		MobilePhone d=new MobilePhone(991);
		MobilePhoneSet c=new MobilePhoneSet();
		MobilePhoneSet e=new MobilePhoneSet();
		MobilePhoneSet union=new MobilePhoneSet();
		MobilePhoneSet inter=new MobilePhoneSet();
		c.Insert(a);
		c.Insert(b);
		c.Insert(d);
		e.Insert(a);
		e.Insert(b);
		union=c.Union(e);
		inter=c.Intersection(e);
		System.out.println(union.IsMember(a)+" "+union.IsMember(b)+" "+union.IsMember(d));
		
	}*/
}
class MobilePhoneSet
{
	Myset mobile=new Myset();
	public int getid(int a)//id of child i
	{
		ob temp1=mobile.top;
		for(int i=1;i<a;i++)
		{
			temp1=temp1.next;
		}
		MobilePhone temp2=(MobilePhone)temp1.data;
		return temp2.id;
	}
	public String returnallid()//list of all id of mobiles
	{ 
		
		String abc=null;
		ob temp1;
		int c=0;
		temp1=mobile.top;
		while(temp1.data!=null)
		{
			
			MobilePhone temp2=(MobilePhone)temp1.data;
			if(temp2.status==true)
				if(c==0)
				{
					abc=" "+temp2.id;
					c++;
				}
				else
				{
					abc=abc+" ,"+temp2.id;
				}
				temp1=temp1.next;
		}
		return abc;
	}
	public boolean IsEmpty()
	{
		return mobile.IsEmpty();
	}
	public boolean IsMember(MobilePhone o)
	{
		return mobile.IsMember(o);
	}
	/*public boolean IsMemberid(int o)
	{
		Object temp1=new Object();
		temp1=mobile.top;
		while(temp1!=null)
		{
			if(temp1.num==o)
			{
				return true;
			}
			temp1=temp1.next;
		}
		return false;
	}*/
	public MobilePhone getMember(int o)//returns mobilephone given its id
	{ 
		ob temp1;
		temp1=mobile.top;
		MobilePhone temp3=null;
		while(temp1!=null)
		{
			MobilePhone temp2=(MobilePhone)temp1.data;
			if(temp2.id==o)
			{
				temp3= temp2;
				break;
			}
			temp1=temp1.next;
		}
		return temp3;
	}
	public boolean IsMemberid(int o)//check wether mobile phone with id exist
	{ 
		boolean b=false;
		ob temp1;
		temp1=mobile.top;
		while(temp1.data!=null)
		{
			MobilePhone temp2=MobilePhone.class.cast(temp1.data);
		 if(temp2.id==o)
			{
				b=true;
				break;
			}
			temp1=temp1.next;
		}
		return b;
	}
	public void Insert(MobilePhone o)
	{
		mobile.Insert(o);
	}
	public void Delete(MobilePhone o)
	{
		mobile.Delete(o);
	}
	public MobilePhoneSet Union(MobilePhoneSet a)
	{
		MobilePhoneSet temp=new MobilePhoneSet();
		temp.mobile=mobile.Union(a.mobile);
		return temp;
	}
	public MobilePhoneSet Intersection(MobilePhoneSet a)
	{
		MobilePhoneSet temp=new MobilePhoneSet();
		temp.mobile=mobile.Intersection(a.mobile);
		return temp;
	}
	
}