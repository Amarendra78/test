import java.util.*;

class SalesTax
{

double tax=0.0,totalbill=0.0;
int flag=0,taxfree=0;

public void calculateTax(int flag,int taxfree,String s,List<String> ans,List<String> al)
{
	flag=0;
  taxfree=0;
   if(s.contains("imported"))
   {
   flag=1;
   }
	   for(int i=0;i<al.size();i++)
	   {
		   String match=al.get(i);
		   if(s.contains(match))
		   taxfree=1;
	   }
	
	String str[]=s.split(" ");
			   if(str.length-2>=0)
			   str[str.length-2]=":";
	
			   Integer i1=Integer.parseInt(str[0]);
		
			   double i2=Double.parseDouble(str[str.length-1]);
			   double imptax=0.0;
	
		   if(taxfree==1)
		   {
			   
			   if(flag==1){
			   imptax=Math.round((i1*(i2+(i2*0.05))*100.0))/100.0;
			   tax=tax+Math.round((i1*(i2*0.05)*100.0))/100.0;
			   totalbill=totalbill+imptax;
			   }else{
				   imptax=i1*(i2);
			       tax=tax+0;
			       totalbill=totalbill+imptax;
			   }
			   double d1=imptax;
			   str[str.length-1]=""+d1;
			   
			   StringBuffer sb=new StringBuffer("");
			   for(int i11=0;i11<str.length;i11++)
				   sb=sb.append(str[i11]+" ");
			   
			   String store=sb.toString();
			   ans.add(store);
			   
		   }else{
			   
			   if(flag==1){
			       imptax=(i1*(i2+(i2*0.05)+(i2*0.10)));
			       System.out.println(imptax);
		    	   imptax=Math.round(imptax*100.0)/100.0; 
			   tax=tax+Math.round((i1*((i2*0.05) + (i2*0.1))*100.0))/100.0;
			   totalbill=totalbill+imptax;
			   }else{
			   imptax=Math.round((i1*(i2+(i2*0.1))*100.0))/100.0; 
			   tax=tax+Math.round((i1*(i2*0.1)*100.0))/100.0;
			   totalbill=totalbill+imptax;
			   }
			   double add=imptax;
			   str[str.length-1]=""+add;
			   
			   StringBuffer sb=new StringBuffer("");
			   for(int j=0;j<str.length;j++)
				   sb=sb.append(str[j]+" ");
			   
			   String store=sb.toString();
			   ans.add(store);
			   
		   }
}

public void printBill(List<String> ans)
{
	for(String i:ans)
System.out.println(i);
System.out.println("Sales Taxes : "+Math.round(tax*100.0)/100.0);
System.out.println("Total : "+Math.round(totalbill*100.0)/100.0);
}

public static void main(String[] args)
{

Scanner sc=new Scanner(System.in);
List<String> al=new ArrayList<String>();
al.add("chocolates");
al.add("pills");
al.add("book");
List<String> ans=new ArrayList<String>();

SalesTax st=new SalesTax();

while(sc.hasNextLine())
{
   String s=sc.nextLine();
   if(s.equals(""))
   break;

   st.calculateTax(0,0,s,ans,al);
	   
}
   st.printBill(ans); 

}

}