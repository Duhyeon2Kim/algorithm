import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
	public static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
		
	
		while(!mydeque.isEmpty() && mydeque.getLast().value > now) mydeque.pollLast();
		
		mydeque.offer(new Node(now, i));

		if(mydeque.getFirst().index <= i-L) {
			mydeque.poll();
		}
		bw.write(mydeque.peek().value+" ");
		}

		bw.flush();
		bw.close();
	
	}
	
	static class Node {
		public int value;
		public int index;
	
		Node(int value,int index) {
			this.value = value;
			this.index = index;
			
		}
	
	}
}