
class splitArray {


	static int splittheArray(int arr[], int n)
	{
	
	
	int leftSum = 0;
	
	for (int i = 0 ; i < n ; i++)
		leftSum += arr[i];


	int rightSum = 0;
	
	for (int i = n-1; i >= 0; i--)
	{
		// add current element to right_sum
		rightSum += arr[i];

		// exclude current element to the left_sum
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
			System.out.println("Not Possible" );
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
	
	int arr[] = {1 , 2 , 3 ,8, 4 , 5 , 5,7 };
	int n = arr.length;
	
	printArray(arr, n);
		
	}
}


