class insertionSort{
    // 初期動作
    public static void main (String[] args){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ START @@@@@@@@@@@@@@@@@@@@@@@@@");
        int arr[]={35,2,14,63,23,53,52, 5};
        show(arr,"Array before insertion sort");

        insertionSort(arr);//sorting array elements using insertion sort  

        show(arr,"\nArray after insertion sort");
   }

// arrayを表示するだけの人
   private static void show(int[] arr, String title) {
        
        System.out.println(title);
        System.out.print("\t");
            for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();  
   }
   
   // ソート
   // https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
   // https://www.youtube.com/watch?v=OGzPmgsI-pQ
   public static void insertionSort(int[] arr) {  
    int n = arr.length;  
    int total = 1;
    int swap = 0;
     for(int basekey=1; basekey < n; basekey++){  // basekey position of searching next numbers
		int comparefrom = arr[basekey];
		int comparekey = basekey;
             while( comparekey > 0 && arr[comparekey-1] > comparefrom ){ 
                    System.out.println("\n[try:"+total+"]");
                    int compareto = arr[comparekey-1];  // target compering number
					System.out.println("\t\t\t***swapping***");
					arr[comparekey] = arr[comparekey - 1];
					show(arr, "\tkeys="+basekey+","+ (comparekey-1) + " array=["+comparefrom+","+compareto+"]");
					swap++;
					 total++;
					 comparekey--;
			}
			arr[comparekey] = comparefrom;
		}  
	     System.out.println("\n\n=========================\nTOTAL LOOPS: "+total+" times.\nTOTAL SWAP: "+swap+" times.\n=========================");
    }
}



/**
 * RESULT
 * 
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8
@@@@@@@@@@@@@@@@@@@@@@@@@ START @@@@@@@@@@@@@@@@@@@@@@@@@
Array before insertion sort
	35 2 14 63 23 53 52 5 

[try:1]
			***swapping***
	keys=1,0 array=[2,35]
	35 35 14 63 23 53 52 5 

[try:2]
			***swapping***
	keys=2,1 array=[14,35]
	2 35 35 63 23 53 52 5 

[try:3]
			***swapping***
	keys=4,3 array=[23,63]
	2 14 35 63 63 53 52 5 

[try:4]
			***swapping***
	keys=4,2 array=[23,35]
	2 14 35 35 63 53 52 5 

[try:5]
			***swapping***
	keys=5,4 array=[53,63]
	2 14 23 35 63 63 52 5 

[try:6]
			***swapping***
	keys=6,5 array=[52,63]
	2 14 23 35 53 63 63 5 

[try:7]
			***swapping***
	keys=6,4 array=[52,53]
	2 14 23 35 53 53 63 5 

[try:8]
			***swapping***
	keys=7,6 array=[5,63]
	2 14 23 35 52 53 63 63 

[try:9]
			***swapping***
	keys=7,5 array=[5,53]
	2 14 23 35 52 53 53 63 

[try:10]
			***swapping***
	keys=7,4 array=[5,52]
	2 14 23 35 52 52 53 63 

[try:11]
			***swapping***
	keys=7,3 array=[5,35]
	2 14 23 35 35 52 53 63 

[try:12]
			***swapping***
	keys=7,2 array=[5,23]
	2 14 23 23 35 52 53 63 

[try:13]
			***swapping***
	keys=7,1 array=[5,14]
	2 14 14 23 35 52 53 63 


=========================
TOTAL LOOPS: 14 times.
TOTAL SWAP: 13 times.
=========================

Array after insertion sort
	2 5 14 23 35 52 53 63 

 */