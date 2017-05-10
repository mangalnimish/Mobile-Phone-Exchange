package assignment2;
import java.util.Scanner;


public class RoutingMapTree
{
	
	Exchange root=new Exchange(0);
	RoutingMapTree()
	{
		root.num=0;
	}
	RoutingMapTree(int i)
	{
		root.num=i;
	}
	public boolean containsNode(Exchange a)
	{
		boolean b;
		b=root.findex(a);
		return b;
	}
	public void switchOn(MobilePhone a, Exchange b)
	{
		if(a.status==false)
		{
			a.status=true;
			a.loc=b;
			b.set.Insert(a);
		}
	}
	/*public void switchOff(MobilePhone a)
	{
		if(a.status==true)
			a.status=false;
	}*/
	public void addex(int a,int b)
	{
		Exchange temp=new Exchange(b);
		Exchange parent=new Exchange(0);
		parent=root.get(a);
		root.get(a).list.Insert(temp,parent);
	}
	public Exchange findPhone(MobilePhone m)//exception mobile phone does not exist
	{
		int a=m.id;
		return root.mobileex(a);
	}
	public Exchange lowestRouter(Exchange a, Exchange b)//exchange a and b don't exist
	{
			return root.leastRouter(a,b);
	}
	public void switchoff(int a)
	{
		MobilePhone mobile=new MobilePhone(a);
		MobilePhoneSet mobileset=new MobilePhoneSet();
		Exchange temp=null;
		if(root.residentSet().IsMemberid(a))
		{
			temp=root.mobileex(a);
			mobileset=temp.set;
			mobile=mobileset.getMember(a);
			mobile.status=false;
		}
		else
		{
			System.out.println("Error : Mobile phone not in tree.");
		}
	}
	public void switchoffd(int a)
	{
		MobilePhone mobile=new MobilePhone(a);
		MobilePhoneSet mobileset=new MobilePhoneSet();
		Exchange temp=null;
		if(root.residentSet().IsMemberid(a))
		{
			temp=root.mobileex(a);
			mobileset=temp.set;
			mobile=mobileset.getMember(a);
			mobile.status=false;
			mobileset.Delete(mobile);
		}
		else
		{
			System.out.println("Error : Mobile phone not in tree.");
		}
	}
	public void switchon(int a,int b)
	{
		MobilePhone mobile=new MobilePhone(a);
		MobilePhoneSet mobileset=new MobilePhoneSet();
		Exchange temp=new Exchange(b);
		temp=root.get(b);
		if(temp==null)
		{
			System.out.println("switchOnMobile "+a+" "+b+" Error : Given Exchange does not exist");
		}
		else{
		mobileset=temp.set;
		if(mobileset.IsMemberid(a))
		{
			mobile=mobileset.getMember(a);
			mobile.status=true;
		}
		else
		{
			mobile.status=true;
			mobileset.Insert(mobile);
		}}
	}
	public ExchangeList routeCall(MobilePhone ab, MobilePhone bc)//exception if mobilephones don't exist
	{
		ExchangeList route1=new ExchangeList();
		ExchangeList route2=new ExchangeList();
		int a=ab.id;
		int b=bc.id;
		Exchange a1=root.mobileex(a);
		Exchange a2=root.mobileex(b);
		//System.out.println(a1.num+" "+a2.num);
		Exchange temp2=lowestRouter(a1,a2);
		//System.out.println(a2.num);

		while(a1.num!=temp2.num)
		{
			Exchange ex=new Exchange(a1.num);
			route1.Insert(ex,ex.par);
			a1=a1.par;
		}
		Exchange c = new Exchange(a1.num);
		route1.Insert(c,c.par);
		while(a2.num!=temp2.num)
		{
			Exchange ex=new Exchange(a2.num);
			route2.Insert(ex,ex.par);
			a2=a2.par;
		}
		a1=route1.top;
		while(a1!=null)
		{
		Exchange d=new Exchange(a1.num);
		route2.Insert(d,d.par);
		a1=a1.next;
		}
		
		
		return route2;
	}
	public void movePhone(MobilePhone a, Exchange b)
	{
		int num=a.id;
		switchoffd(num);
		switchon(num,b.num);
		root.residentSet().getMember(num).status=true;
		//System.out.println(root.mobileex(num).num);
		
	}
	public void performAction(String actionMessage)
	{
		//System.out.println(actionMessage);
		Scanner s=new Scanner(actionMessage);
		String str=s.next();
		switch(str)
		{
		case "addExchange":
		{
			int a,b;
			try{a=s.nextInt();
			b=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			
			Exchange temp=new Exchange(b);
			Exchange temp1=null;
			
			temp1=root.get(a);
			if(temp1==null)
			{
				System.out.println("addExchange "+a+" "+b+" Error: Given Exchange does not exist");
			}
			else{
			temp1.list.Insert(temp,temp1);}
			break;
		}
		case "switchOnMobile":
		{
			int a,b;
			try{a=s.nextInt();
			b=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			
			switchon(a,b);
			//System.out.println(root.residentSet().getMember(a).status);
			
			
			break;
		}
		case "switchOffMobile":
		{
			int a;
			try{a=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			switchoff(a);
			break;
		}
		case "queryNthChild":
		{
			int a,b;
			Exchange temp=null;
			try{a=s.nextInt();
			b=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			temp=root.get(a);
			if(temp==null)
			{
				System.out.println("queryNthChild "+a+" "+b+" Error: Given Exchange does not exist");
			}
			else{
			try{
			temp=temp.child(b);
			}
			catch(IllegalArgumentException e){
				System.out.println("queryNthChild "+a+" "+b+" Error : position exceeds the number of children");
				break;
			}
			System.out.println("queryNthChild "+a+" "+b+" : "+temp.num);
			}
			break;
		
		}
		
		case "queryMobilePhoneSet":
		{
			
			int a;
			try{a=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			Exchange temp=null;
			temp=root.get(a);
			if(temp==null)
			{
				System.out.println("Error : Given Exchange does not exist");
			}
			else{
			MobilePhoneSet mobileset =new MobilePhoneSet();
			mobileset=temp.residentSet();
			//System.out.println(mobileset.IsMemberid(54));
			String abc=mobileset.returnallid();
			abc="queryMobilePhoneSet "+a+":"+abc;
			
			System.out.println(abc);
			}
			break;
		}
		case "findPhone":
		{
			int a=s.nextInt();
			try{
			Exchange temp=null;
			temp= root.mobileex(a);
			System.out.println("queryFindPhone "+a+": "+temp.num);}
			catch(Exception e)
			{
				System.out.println("queryFindPhone "+a+": Error - No mobile phone with identifier "+a +" found in the network");
			}
			break;
		}
		case "lowestRouter":
		{
			int a,b;
			try{a=s.nextInt();
			b=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			Exchange temp=null;
			Exchange temp1=null;
			Exchange temp2=null;
			temp1=root.get(a);
			temp2=root.get(b);
			try{
			temp=lowestRouter(temp1,temp2);
			System.out.println("queryLowestRouter "+a+" "+b+": "+temp.num);
			}
			catch(NullPointerException e)
			{
				System.out.println("querylowestRouter "+a+" "+b+" : Error - The Exchange " + a +" or "+b+" does not exist");
			}
			break;
		}
		case "findCallPath":
		{
			int a,b;
			try{a=s.nextInt();
			b=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			try{
			MobilePhone temp1=null;
			MobilePhone temp2=null;
			temp1=root.residentSet().getMember(a);
			temp2=root.residentSet().getMember(b);
			if(temp1.status==true && temp2.status==true)
			{ExchangeList path=null;
			path=routeCall(temp1,temp2);
			Exchange temp3;
			temp3=path.top;
			//System.out.println(temp3.num);
			String ab=null;
			ab=" "+temp3.num;
			temp3=temp3.next;
			while(temp3!=null)
			{
				ab=ab+", "+temp3.num;
				temp3=temp3.next;
			}
			System.out.println("queryFindCallPath "+a+" "+b+":"+ab);
			
			}
			else
			{
				if(temp1.status==false)
					System.out.println("queryFindCallPath "+a+" "+b+":"+" Error - Mobile phone with identifier "+ temp1.id+" is currently switched off");
				else
				{
					System.out.println("queryFindCallPath "+a+" "+b+":"+" Error - Mobile phone with identifier "+ temp2.id+" is currently switched off");
				}
			}
			}
			catch(NullPointerException e)
			{
				System.out.println("queryFindCallPath "+a+" "+b+":"+" Error - The Mobile Phone " +a +" or " + b+" does not exist");
			}
			break;
		}
		case "movePhone":
		{
			int a,b;
			try{a=s.nextInt();
			b=s.nextInt();
			}
			catch (Exception ef)
			{
				System.out.println("Error : Input format wrong");
				break;
			}
			MobilePhone temp1=null;
			
			temp1=root.residentSet().getMember(a);
			Exchange temp2=null;
			try{
			temp2=root.get(b);
			movePhone(temp1,temp2);
			}
			catch(NullPointerException e)
			{
				System.out.println("Error - The Mobile Phone " + a + " or " + b + " does not exist");
			}
			break;
		}
		default:
		{
			System.out.println("Query not handled in this assignment.");
		}
		}
	}

			
}