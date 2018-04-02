class selectionSort{
    // 初期動作
    public static void main (String[] args){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ START @@@@@@@@@@@@@@@@@@@@@@@@@");
        int arr[]={35,2,14,63,23,53,52, 5};
        show(arr,"Array before selection sort");

        selectionSort(arr);//sorting array elements using selection sort  

        show(arr,"\nArray after selection sort");
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
   public static void selectionSort(int[] arr) {  
    int n = arr.length;  
    int temp = 0;  
    int total = 1;
    int swap = 0;
     for(int base=0; base < n; base++){  // base position of searching next numbers
        int comparefrom = arr[base];        
		int min = comparefrom;
		int minkey = 0;
             for(int s=base+1; s < n; s++){  // s=second number 
                    System.out.println("\n[try:"+total+"]");
                    int compareto = arr[s];  // target compering number
                    if(compareto < min){    // [2,1の場合]
							 min = compareto;
							 minkey = s;
                     } 
                     show(arr, "\tkeys="+base+","+s + " array=["+comparefrom+","+compareto+"], min="+min+", minkey="+minkey);
                     total++;
			 }  
			 // minを探してスワップ
			 if (min != comparefrom) {
				//swap elements  
				arr[minkey] = arr[base];
				arr[base] = min;
				System.out.println("\t\t\t***swapping***");
				swap++;
			 }
     }  

     System.out.println("\n\n=========================\nTOTAL LOOPS: "+total+" times.\nTOTAL SWAP: "+swap+" times.\n=========================");
    }
}



/**
 * RESULT
 * 
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8
@@@@@@@@@@@@@@@@@@@@@@@@@ START @@@@@@@@@@@@@@@@@@@@@@@@@
Array before selection sort
	35 2 14 63 23 53 52 5 

[try:1]
	keys=0,1 array=[35,2], min=2, minkey=1
	35 2 14 63 23 53 52 5 

[try:2]
	keys=0,2 array=[35,14], min=2, minkey=1
	35 2 14 63 23 53 52 5 

[try:3]
	keys=0,3 array=[35,63], min=2, minkey=1
	35 2 14 63 23 53 52 5 

[try:4]
	keys=0,4 array=[35,23], min=2, minkey=1
	35 2 14 63 23 53 52 5 

[try:5]
	keys=0,5 array=[35,53], min=2, minkey=1
	35 2 14 63 23 53 52 5 

[try:6]
	keys=0,6 array=[35,52], min=2, minkey=1
	35 2 14 63 23 53 52 5 

[try:7]
	keys=0,7 array=[35,5], min=2, minkey=1
	35 2 14 63 23 53 52 5 
			***swapping***

[try:8]
	keys=1,2 array=[35,14], min=14, minkey=2
	2 35 14 63 23 53 52 5 

[try:9]
	keys=1,3 array=[35,63], min=14, minkey=2
	2 35 14 63 23 53 52 5 

[try:10]
	keys=1,4 array=[35,23], min=14, minkey=2
	2 35 14 63 23 53 52 5 

[try:11]
	keys=1,5 array=[35,53], min=14, minkey=2
	2 35 14 63 23 53 52 5 

[try:12]
	keys=1,6 array=[35,52], min=14, minkey=2
	2 35 14 63 23 53 52 5 

[try:13]
	keys=1,7 array=[35,5], min=5, minkey=7
	2 35 14 63 23 53 52 5 
			***swapping***

[try:14]
	keys=2,3 array=[14,63], min=14, minkey=0
	2 5 14 63 23 53 52 35 

[try:15]
	keys=2,4 array=[14,23], min=14, minkey=0
	2 5 14 63 23 53 52 35 

[try:16]
	keys=2,5 array=[14,53], min=14, minkey=0
	2 5 14 63 23 53 52 35 

[try:17]
	keys=2,6 array=[14,52], min=14, minkey=0
	2 5 14 63 23 53 52 35 

[try:18]
	keys=2,7 array=[14,35], min=14, minkey=0
	2 5 14 63 23 53 52 35 

[try:19]
	keys=3,4 array=[63,23], min=23, minkey=4
	2 5 14 63 23 53 52 35 

[try:20]
	keys=3,5 array=[63,53], min=23, minkey=4
	2 5 14 63 23 53 52 35 

[try:21]
	keys=3,6 array=[63,52], min=23, minkey=4
	2 5 14 63 23 53 52 35 

[try:22]
	keys=3,7 array=[63,35], min=23, minkey=4
	2 5 14 63 23 53 52 35 
			***swapping***

[try:23]
	keys=4,5 array=[63,53], min=53, minkey=5
	2 5 14 23 63 53 52 35 

[try:24]
	keys=4,6 array=[63,52], min=52, minkey=6
	2 5 14 23 63 53 52 35 

[try:25]
	keys=4,7 array=[63,35], min=35, minkey=7
	2 5 14 23 63 53 52 35 
			***swapping***

[try:26]
	keys=5,6 array=[53,52], min=52, minkey=6
	2 5 14 23 35 53 52 63 

[try:27]
	keys=5,7 array=[53,63], min=52, minkey=6
	2 5 14 23 35 53 52 63 
			***swapping***

[try:28]
	keys=6,7 array=[53,63], min=53, minkey=0
	2 5 14 23 35 52 53 63 


=========================
TOTAL LOOPS: 29 times.
TOTAL SWAP: 5 times.
=========================

Array after selection sort
	2 5 14 23 35 52 53 63 

 */