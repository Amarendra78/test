import java.util.*;
class SendingMails
{


void sendMail(String email,String msg,String[][] arr)
{
	
HashMap<String,String> hm=new HashMap<String,String>();
for(int i=0;i<3;i++)
{
	hm.put(arr[i][0],arr[i][1]);
}

HashSet<String> hs=new HashSet<String>();

String f=hm.get(email);
String s[]=f.split(", ");

for(int i=0;i<s.length;i++)
{
	if(!s[i].equals(email))
	     hs.add(s[i]);	           
}

for(int i=0;i<s.length;i++)
{
	if(hm.get(s[i])!=null)
	{
	String f1=hm.get(s[i]);

    String s1[]=f1.split(", ");

    for(int i1=0;i1<s1.length;i1++)
    {
    	if(!s1[i1].equals(email))
	            hs.add(s1[i1]);
     }
	 
     }
 }


System.out.println("Iterating over list:");
        Iterator<String> i = hs.iterator();
        while (i.hasNext())
		{
			String emailAdd=i.next();	
            sendMail(emailAdd,msg);
		}
	
}

void sendMail(String email,String msg)
{
	System.out.println("Mail sent to : "+email+" message is:"+msg);
}

public static void main(String[] args)
{

Scanner sc=new Scanner(System.in);
String s[][]= new String[3][2];
for(int i=0;i<3;i++)
{
 for(int j=0;j<2;j++)
 {
  s[i][j]=sc.nextLine();
 }
}

SendingMails sm=new SendingMails();
sm.sendMail("vineet","Hi all frnds",s);

}


}