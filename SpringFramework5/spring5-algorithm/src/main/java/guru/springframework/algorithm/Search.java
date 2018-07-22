package guru.springframework.algorithm;

public class Search {

	int[] array = {2,8,10,12,20,34,56,57,77,79,88};
	
	
	public void binarySearch(int n) {
		int low = 0;
		int high = array.length - 1;
		boolean found = false;
		int numberofRetry = 0;
		
		while(!found) {

			if(low > high) {
				System.out.println("Element not found");
				break;
			}
			
			int mid = low + ((high-low)/2);
			numberofRetry = numberofRetry + 1;
			
			if(n == array[mid]) {
				found = true;
				System.out.println("Element Found after " + numberofRetry + " retry");
				break;
			}
			
			if(n > array[mid]) {
				low = mid + 1;
			} else if(n < array[mid]) {
				high = mid - 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Search search = new Search();
		search.binarySearch(34);
	}
}
