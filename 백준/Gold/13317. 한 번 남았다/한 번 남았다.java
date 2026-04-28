public class Main {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("50 49\n");
		for(int i=50;i>1;i--) sb.append(i-1).append(" ").append(i).append(" -1\n");
		System.out.println(sb);
	}
}
