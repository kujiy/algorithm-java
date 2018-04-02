class BubbleSort{
    // 初期動作
    public static void main (String[] args){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ START @@@@@@@@@@@@@@@@@@@@@@@@@");
        int arr[]={35,2,14,63,23,53,52, 5};
        show(arr,"Array before bubble sort");

        bubbleSort(arr);//sorting array elements using bubble sort  

        show(arr,"\nArray after bubble sort");
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
   
   // バブルソート
   // https://www.javatpoint.com/bubble-sort-in-java
   // http://www.baeldung.com/java-bubble-sort
   public static void bubbleSort(int[] arr) {  
    int n = arr.length;  
    int temp = 0;  
    int total = 1;
    int swap = 0;
     for(int base=0; base < n; base++){  // base position of searching next numbers
             for(int s=1; s < (n - base); s++){  // s=second number 
                    System.out.println("\n[try:"+total+"]");
                    int keyf = s-1;  // 0 as first number
                    int keys = s;    // 1 as second number
                    int first = arr[keyf];  //35 
                    int second = arr[keys];   // 2
                    if(first > second){    // [2,1の場合]
                             //swap elements  
                             arr[keyf] = second;     // arr
                             arr[keys] = first;  
                             System.out.println("\t\t\t***swapping***");
                             swap++;
                     } 
                     show(arr, "\tkeys="+keyf+","+keys + " array=["+first+","+second+"]");
                     total++;
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
Array before bubble sort
	35 2 14 63 23 53 52 5 

[try:1]
			***swapping***
	keys=0,1 array=[35,2]
	2 35 14 63 23 53 52 5 

[try:2]
			***swapping***
	keys=1,2 array=[35,14]
	2 14 35 63 23 53 52 5 

[try:3]
	keys=2,3 array=[35,63]
	2 14 35 63 23 53 52 5 

[try:4]
			***swapping***
	keys=3,4 array=[63,23]
	2 14 35 23 63 53 52 5 

[try:5]
			***swapping***
	keys=4,5 array=[63,53]
	2 14 35 23 53 63 52 5 

[try:6]
			***swapping***
	keys=5,6 array=[63,52]
	2 14 35 23 53 52 63 5 

[try:7]
			***swapping***
	keys=6,7 array=[63,5]
	2 14 35 23 53 52 5 63 

[try:8]
	keys=0,1 array=[2,14]
	2 14 35 23 53 52 5 63 

[try:9]
	keys=1,2 array=[14,35]
	2 14 35 23 53 52 5 63 

[try:10]
			***swapping***
	keys=2,3 array=[35,23]
	2 14 23 35 53 52 5 63 

[try:11]
	keys=3,4 array=[35,53]
	2 14 23 35 53 52 5 63 

[try:12]
			***swapping***
	keys=4,5 array=[53,52]
	2 14 23 35 52 53 5 63 

[try:13]
			***swapping***
	keys=5,6 array=[53,5]
	2 14 23 35 52 5 53 63 

[try:14]
	keys=0,1 array=[2,14]
	2 14 23 35 52 5 53 63 

[try:15]
	keys=1,2 array=[14,23]
	2 14 23 35 52 5 53 63 

[try:16]
	keys=2,3 array=[23,35]
	2 14 23 35 52 5 53 63 

[try:17]
	keys=3,4 array=[35,52]
	2 14 23 35 52 5 53 63 

[try:18]
			***swapping***
	keys=4,5 array=[52,5]
	2 14 23 35 5 52 53 63 

[try:19]
	keys=0,1 array=[2,14]
	2 14 23 35 5 52 53 63 

[try:20]
	keys=1,2 array=[14,23]
	2 14 23 35 5 52 53 63 

[try:21]
	keys=2,3 array=[23,35]
	2 14 23 35 5 52 53 63 

[try:22]
			***swapping***
	keys=3,4 array=[35,5]
	2 14 23 5 35 52 53 63 

[try:23]
	keys=0,1 array=[2,14]
	2 14 23 5 35 52 53 63 

[try:24]
	keys=1,2 array=[14,23]
	2 14 23 5 35 52 53 63 

[try:25]
			***swapping***
	keys=2,3 array=[23,5]
	2 14 5 23 35 52 53 63 

[try:26]
	keys=0,1 array=[2,14]
	2 14 5 23 35 52 53 63 

[try:27]
			***swapping***
	keys=1,2 array=[14,5]
	2 5 14 23 35 52 53 63 

[try:28]
	keys=0,1 array=[2,5]
	2 5 14 23 35 52 53 63 


=========================
TOTAL LOOPS: 29 times.
TOTAL SWAP: 13 times.
=========================

Array after bubble sort
	2 5 14 23 35 52 53 63 

 */