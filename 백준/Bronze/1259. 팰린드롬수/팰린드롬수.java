import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input=sc.nextLine();
		while(!input.equals("0")) {
			if(input.length()==1) {
				System.out.println("yes");
				input=sc.nextLine();
				continue;
			}
			for(int i=0;i<input.length()/2;i++) {
				if(input.charAt(i)!=input.charAt(input.length()-i-1)) {
					System.out.println("no");
					break;
				}
				if(i==(input.length()/2)-1) System.out.println("yes");
			}
			input=sc.nextLine();
		}
	}
}
