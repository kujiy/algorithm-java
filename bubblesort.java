class BubbleSort{
    // 初期動作
    public static void main (String[] args){
        System.out.println("JavaSample2");
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
   public static void bubbleSort(int[] arr) {  
    int n = arr.length;  
    int temp = 0;  
    int total = 1;
    int swap = 0;
     for(int f=0; f < n; f++){  // f=first number
             for(int s=1; s < (n-f); s++){  //s=second number 
                    System.out.println("\n[try:"+total+"]");
                    int keyf = s-1;  // 0
                    int keys = s;    // 1
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
