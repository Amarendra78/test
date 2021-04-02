import java.util.*;
class SolutionPalindrome {
	
	public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left += 1;
            right -= 1;
        }
        return true;
    }
	
    public String shortestPalindrome(String s) {
        
        
        if (s == "" || s.length() == 1)
            return s;
       
        if (isPalindrome(s))
            return s;
        
        int length = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        for (int i=length - 2; i>=0; i--) {   
           
            sb.append(s.charAt(i));
            String temp = sb.toString();
            sb.append(s);
            String current = sb.toString();
            if (isPalindrome(current))
                return current;
            else {
                sb.setLength(0);
                sb.append(temp);
            }
        }
        return sb.toString();
    }
    
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		SolutionPalindrome sp=new SolutionPalindrome();
		String ans=sp.shortestPalindrome(s);
		System.out.println(ans);		
}
}