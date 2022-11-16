import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class splitArray {


	static int splittheArray(int arr[], int n)
	{
	
		int leftSum = 0;
	
	    for (int i = 0 ; i < n ; i++)
		leftSum += arr[i];


	int rightSum = 0;
	
	for (int i = n-1; i >= 0; i--)
	{
		rightSum += arr[i];

		leftSum -= arr[i] ;

		if (rightSum == leftSum)
			return i ;
	}

	return -1;
	}


	static void printArray(int arr[], int n)
	{
		int splitPoint = splittheArray(arr, n);
	
		if (splitPoint == -1 || splitPoint == n )
		{
			System.out.println("Cann't be split with given condition" );
			return;
		}
		for (int i = 0; i < n; i++)
		{
			if(splitPoint == i)
				System.out.println();
				
			System.out.print(arr[i] + " ");
		}
	}

	public static void main (String[] args) {
	
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter numbers, with 0 to end");
        final List<Integer> list = new ArrayList<>();
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            list.add(input);
        }
        System.out.println("You entered: " + list);

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
        int arrLen = arr.length;
        printArray(arr, arrLen);

    } catch (Exception e) {
        System.out.println(e);
    }
      
		
	}
}


