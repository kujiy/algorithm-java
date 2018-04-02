class mergeSort{

	// class内のglobalな変数 this-> で参照される
	// 
	private int[] array;
	private int[] tempMergArr;
	private int length;
 
	private int total;
 	private int swap;

    // 初期動作
    public static void main (String[] args){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@ START @@@@@@@@@@@@@@@@@@@@@@@@@");
        int arr[]={35,2,14,63,23,53,52, 5};
        show(arr,"Array before merge sort");

		mergeSort ms = new mergeSort();
		ms.sort(arr); //sorting array elements using merge sort  

        show(arr,"\nArray after merge sort");
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
   
   // mergeソート
   // http://www.java2novice.com/java-sorting-algorithms/merge-sort/
   private void sort(int[] arr) {  
		this.array = arr;
		this.length = arr.length;
		this.tempMergArr = new int[length];   // 長さarrの空配列を作る（全体の長さと同じ）

		this.total = 1;  // 計測用step数
		this.swap = 0;   // 計測用swap数
		
		doMergeSort(0, length - 1);

		System.out.println("\n\n=========================\nTOTAL LOOPS: "+total+" times.\nTOTAL SWAP: "+swap+" times.\n=========================");
		
	}
	
	// 2分割して回す
	private void doMergeSort(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {   //まだ分解できる場合
			// 分解点を決める (半分) 0-4なら2になる
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);   // lower側の半分で再帰的に回す
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);   // higher側の半分で再帰的に回す
			// Now merge both sides    // 半分ずつのソートが終わったらまとめてソート
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	// ソートして低い順に並べてほんとの入れ物に入れ直す
	private void mergeParts(int lowerIndex, int middle, int higherIndex) {
		// 仮のarrayに値を入れておく、この tempMergArr は 左+右 の合体になる
		for (int i=lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		System.out.println("\n--START mergeParts ----------------------------");
		show(tempMergArr, "\ttempMergArr L,H="+lowerIndex+","+higherIndex);
		show(array, "\t本体array");

		int l = lowerIndex;   // 左側の最小idx
		int r = middle + 1;   // 右側の最小idx
		int k = lowerIndex;	  // 本体の最小idx

		int swap_ext = 0;

		while (l <= middle && r <=higherIndex) { // 左が分解点より下、右が分解より上じゃなくなったらやめる
			System.out.println("\n[try:"+total+"]");
			show(array, "\twhile before1: l="+l+", r="+r+", k="+k+" | ["+tempMergArr[l]+", "+tempMergArr[r]+"]");

			if (tempMergArr[l] <= tempMergArr[r]) {  //右の値が左より大きい
				array[k] = tempMergArr[l];   // 本体に小さい左の値を入れる
				l++;     // 左側のidxを１進める
			} else {
				array[k] = tempMergArr[r];   // 右の方が小さければ右を入れる
				r++;    // 右側のidxを1進める
				System.out.println("\t\t\t***swapping***");
			}
			k++;      // 本体は必ず１個埋まるので1進める
			show(array, "\twhile after1: l="+l+", r="+r+", k="+k);

			total++;
			swap_ext = 1;
		}
		while ( l <= middle ) { //左が終わりまでいってなければ
			System.out.println("\n[try:"+total+"]");
						
			array[k] = tempMergArr[l];  // 左を本体の次に入れる
			k++;
			l++;
			System.out.println("\t\t\t***swapped***");

			show(array, "\twhile after2: l="+l+", r="+r+", k="+k);
			
			total++;
			swap_ext = 1;
		}
		if (swap_ext == 1) swap++;
	}
}

/**
 * RESULT
 * 
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF8
@@@@@@@@@@@@@@@@@@@@@@@@@ START @@@@@@@@@@@@@@@@@@@@@@@@@
Array before merge sort
	35 2 14 63 23 53 52 5 

--START mergeParts ----------------------------
	tempMergArr L,H=0,1
	35 2 0 0 0 0 0 0 
	本体array
	35 2 14 63 23 53 52 5 

[try:1]
	while before1: l=0, r=1, k=0 | [35, 2]
	35 2 14 63 23 53 52 5 
			***swapping***
	while after1: l=0, r=2, k=1
	2 2 14 63 23 53 52 5 

[try:2]
			***swapped***
	while after2: l=1, r=2, k=2
	2 35 14 63 23 53 52 5 

--START mergeParts ----------------------------
	tempMergArr L,H=2,3
	35 2 14 63 0 0 0 0 
	本体array
	2 35 14 63 23 53 52 5 

[try:3]
	while before1: l=2, r=3, k=2 | [14, 63]
	2 35 14 63 23 53 52 5 
	while after1: l=3, r=3, k=3
	2 35 14 63 23 53 52 5 

--START mergeParts ----------------------------
	tempMergArr L,H=0,3
	2 35 14 63 0 0 0 0 
	本体array
	2 35 14 63 23 53 52 5 

[try:4]
	while before1: l=0, r=2, k=0 | [2, 14]
	2 35 14 63 23 53 52 5 
	while after1: l=1, r=2, k=1
	2 35 14 63 23 53 52 5 

[try:5]
	while before1: l=1, r=2, k=1 | [35, 14]
	2 35 14 63 23 53 52 5 
			***swapping***
	while after1: l=1, r=3, k=2
	2 14 14 63 23 53 52 5 

[try:6]
	while before1: l=1, r=3, k=2 | [35, 63]
	2 14 14 63 23 53 52 5 
	while after1: l=2, r=3, k=3
	2 14 35 63 23 53 52 5 

--START mergeParts ----------------------------
	tempMergArr L,H=4,5
	2 35 14 63 23 53 0 0 
	本体array
	2 14 35 63 23 53 52 5 

[try:7]
	while before1: l=4, r=5, k=4 | [23, 53]
	2 14 35 63 23 53 52 5 
	while after1: l=5, r=5, k=5
	2 14 35 63 23 53 52 5 

--START mergeParts ----------------------------
	tempMergArr L,H=6,7
	2 35 14 63 23 53 52 5 
	本体array
	2 14 35 63 23 53 52 5 

[try:8]
	while before1: l=6, r=7, k=6 | [52, 5]
	2 14 35 63 23 53 52 5 
			***swapping***
	while after1: l=6, r=8, k=7
	2 14 35 63 23 53 5 5 

[try:9]
			***swapped***
	while after2: l=7, r=8, k=8
	2 14 35 63 23 53 5 52 

--START mergeParts ----------------------------
	tempMergArr L,H=4,7
	2 35 14 63 23 53 5 52 
	本体array
	2 14 35 63 23 53 5 52 

[try:10]
	while before1: l=4, r=6, k=4 | [23, 5]
	2 14 35 63 23 53 5 52 
			***swapping***
	while after1: l=4, r=7, k=5
	2 14 35 63 5 53 5 52 

[try:11]
	while before1: l=4, r=7, k=5 | [23, 52]
	2 14 35 63 5 53 5 52 
	while after1: l=5, r=7, k=6
	2 14 35 63 5 23 5 52 

[try:12]
	while before1: l=5, r=7, k=6 | [53, 52]
	2 14 35 63 5 23 5 52 
			***swapping***
	while after1: l=5, r=8, k=7
	2 14 35 63 5 23 52 52 

[try:13]
			***swapped***
	while after2: l=6, r=8, k=8
	2 14 35 63 5 23 52 53 

--START mergeParts ----------------------------
	tempMergArr L,H=0,7
	2 14 35 63 5 23 52 53 
	本体array
	2 14 35 63 5 23 52 53 

[try:14]
	while before1: l=0, r=4, k=0 | [2, 5]
	2 14 35 63 5 23 52 53 
	while after1: l=1, r=4, k=1
	2 14 35 63 5 23 52 53 

[try:15]
	while before1: l=1, r=4, k=1 | [14, 5]
	2 14 35 63 5 23 52 53 
			***swapping***
	while after1: l=1, r=5, k=2
	2 5 35 63 5 23 52 53 

[try:16]
	while before1: l=1, r=5, k=2 | [14, 23]
	2 5 35 63 5 23 52 53 
	while after1: l=2, r=5, k=3
	2 5 14 63 5 23 52 53 

[try:17]
	while before1: l=2, r=5, k=3 | [35, 23]
	2 5 14 63 5 23 52 53 
			***swapping***
	while after1: l=2, r=6, k=4
	2 5 14 23 5 23 52 53 

[try:18]
	while before1: l=2, r=6, k=4 | [35, 52]
	2 5 14 23 5 23 52 53 
	while after1: l=3, r=6, k=5
	2 5 14 23 35 23 52 53 

[try:19]
	while before1: l=3, r=6, k=5 | [63, 52]
	2 5 14 23 35 23 52 53 
			***swapping***
	while after1: l=3, r=7, k=6
	2 5 14 23 35 52 52 53 

[try:20]
	while before1: l=3, r=7, k=6 | [63, 53]
	2 5 14 23 35 52 52 53 
			***swapping***
	while after1: l=3, r=8, k=7
	2 5 14 23 35 52 53 53 

[try:21]
			***swapped***
	while after2: l=4, r=8, k=8
	2 5 14 23 35 52 53 63 


=========================
TOTAL LOOPS: 22 times.
TOTAL SWAP: 7 times.
=========================

Array after merge sort
	2 5 14 23 35 52 53 63 

 */