import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		
		String[] temp = bf.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i=1; i<N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				result[stack.pop()]=arr[i];
			}
			stack.add(i);
		}
		while(!stack.isEmpty()) {
			result[stack.pop()]=-1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<N; i++) {
			bw.write(result[i]+" ");
		}
		bw.flush();
		bw.close();
	}
}