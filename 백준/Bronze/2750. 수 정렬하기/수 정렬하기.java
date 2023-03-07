import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i=0; i<num; i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0; i<num-1; i++) {
			int min=arr[i];
			int minidx=i;
			for(int j=i+1; j<num; j++) {
				if(min>arr[j]) {min=arr[j]; minidx=j; }
			}
			int temp = arr[i];
			arr[i]=min;
			arr[minidx]=temp;
		}
	
		for(int i=0; i<num; i++) {
			System.out.println(arr[i]);
		}
	}
}
