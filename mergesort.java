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
        System.out.print("\t[ ");
            for (int i=0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		System.out.print("]");
        System.out.println();  
   }
   
   // mergeソート
   // http://www.java2novice.com/java-sorting-algorithms/merge-sort/
   private void sort(int[] arr) {  
		this.array = arr;
		this.length = arr.length;

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
		// array lengthを定義
		int lstart = lowerIndex;
		int lend = middle;
		int llength = lend - lstart + 1;
		int rstart = middle + 1;
		int rend = higherIndex;
		int rlength = rend - rstart + 1;

		System.out.println("[lstart="+lstart+" , lend="+lend+" , llength="+llength+"], [rstart="+rstart+" , rend="+rend+" , rlength="+rlength+"]");

		// 比較するarray（左・右）を作る
		int [] larr = new int[length];   // 長さ全arrの空配列 左用。長さはindexを本arrayと合わせるため
		int [] rarr = new int[length];   // 長さ全arrの空配列 右用。長さはindexを本arrayと合わせるため
		for (int i = lstart; i <= lend; i++) {
			larr[i] = array[i];
		}
		for (int i = rstart; i <= rend; i++) {
			rarr[i] = array[i];
		}
		
		System.out.println("\n--START mergeParts ----------------------------");
		int l = lstart;   // 左側の最小idx
		int r = rstart;   // 右側の最小idx
		int k = lstart;	  // 本体の最小idx

		int swap_ext = 0;
		System.out.println("l="+l+", r="+r+", k="+k+", lend="+lend+", rend="+rend);
		show(larr, "\t# larr l="+l+", lstart,end="+lstart+","+lend);
		show(rarr, "\t# rarr r="+r+", rstart,end="+rstart+","+rend);
		show(array, "\t# 本体array");

		// ２つの数字を比較して、大きい方を全arrayの左側に入れていく
		// 右側の配列が全部小さくて、左側の配列が全部残る事もありえる
		int whiletry=1;
		while (l <= lend && r <= rend) { // 左右ともに最後のindexじゃなくなったらやめる
			System.out.println("\n[try:"+total+"]");
			System.out.println("[while1try="+whiletry++ + "]");
			show(array, "\twhile before1: l="+l+", r="+r+", k="+k+" | ["+larr[l]+", "+rarr[r]+"]");

			if (larr[l] <= rarr[r]) {  // 左の方が右より小さい
				array[k] = larr[l];   // 本体に小さい左の値を入れる
				l++;     // 左側のidxを１進める
				System.out.println("\t\t\t***Lをいれました***");
			} else {
				array[k] = rarr[r];   // 右の方が小さければ右を入れる
				r++;    // 右側のidxを1進める
				System.out.println("\t\t\t***Rをいれました***");
			}
			k++;      // 本体は必ず１個埋まるので1進める
			show(array, "\twhile after1: l="+l+", r="+r+", k="+k);

			total++;
			swap_ext = 1;
		} /* 左右いずれかの処理が終了したら抜ける。
		    右が先に終了したら: 次のwhileで左の処理をする。
		    左が先に終了したら: swap発生していない=右は全arrayにいるまま変更なし、なので処理なし
		  */

		////  r <= rendは処理されて、l <= lend だけ残った場合の処理
		// 右に勝てずに残った *左* の数字（左の配列全部かも）を全arrayに入れていく 
		/* （右はこの前のwhileで終わりきっていない可能性があるが、
			左が勝つ＝swap発生しない=左右ともに同じ位置のママなので、
			スルーしてokということで処理しない 
		*/
		whiletry=1;
		while ( l <= lend ) { //左が終わりまでいってなければ
			System.out.println("\n[***while2try="+whiletry++ + "] l="+l+", lend="+lend);
			System.out.println("\t[try:"+total+"]");
			array[k] = larr[l];  // 左を本体の次に入れる
			k++;
			l++;
			System.out.println("\t\t\t***余ったLをいれました***");
			System.out.println("\t\t\t***swapped***");

			show(array, "\twhile after2: l="+l+", r="+r+", k="+k);
			
			total++;
			swap_ext = 1;
		} // 残った左の処理終了

		whiletry=1;
		while ( r <= rend ) { //右が終わりまでいってなければ
			System.out.println("\n[***while3try="+whiletry++ + "] r="+r+", rend="+rend);
			System.out.println("\t\t\tr="+r+", rarr[r]="+rarr[r]);
			System.out.println("\t\t\t***余ったRはスルーしました***");
			r++;
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
	[ 35 2 14 63 23 53 52 5 ]
[lstart=0 , lend=0 , llength=1], [rstart=1 , rend=1 , rlength=1]

--START mergeParts ----------------------------
l=0, r=1, k=0, lend=0, rend=1
	# larr l=0, lstart,end=0,0
	[ 35 0 0 0 0 0 0 0 ]
	# rarr r=1, rstart,end=1,1
	[ 0 2 0 0 0 0 0 0 ]
	# 本体array
	[ 35 2 14 63 23 53 52 5 ]

[try:1]
[while1try=1]
	while before1: l=0, r=1, k=0 | [35, 2]
	[ 35 2 14 63 23 53 52 5 ]
			***Rをいれました***
	while after1: l=0, r=2, k=1
	[ 2 2 14 63 23 53 52 5 ]

[***while2try=1] l=0, lend=0
	[try:2]
			***余ったLをいれました***
			***swapped***
	while after2: l=1, r=2, k=2
	[ 2 35 14 63 23 53 52 5 ]
[lstart=2 , lend=2 , llength=1], [rstart=3 , rend=3 , rlength=1]

--START mergeParts ----------------------------
l=2, r=3, k=2, lend=2, rend=3
	# larr l=2, lstart,end=2,2
	[ 0 0 14 0 0 0 0 0 ]
	# rarr r=3, rstart,end=3,3
	[ 0 0 0 63 0 0 0 0 ]
	# 本体array
	[ 2 35 14 63 23 53 52 5 ]

[try:3]
[while1try=1]
	while before1: l=2, r=3, k=2 | [14, 63]
	[ 2 35 14 63 23 53 52 5 ]
			***Lをいれました***
	while after1: l=3, r=3, k=3
	[ 2 35 14 63 23 53 52 5 ]

[***while3try=1] r=3, rend=3
			r=3, rarr[r]=63
			***余ったRはスルーしました***
[lstart=0 , lend=1 , llength=2], [rstart=2 , rend=3 , rlength=2]

--START mergeParts ----------------------------
l=0, r=2, k=0, lend=1, rend=3
	# larr l=0, lstart,end=0,1
	[ 2 35 0 0 0 0 0 0 ]
	# rarr r=2, rstart,end=2,3
	[ 0 0 14 63 0 0 0 0 ]
	# 本体array
	[ 2 35 14 63 23 53 52 5 ]

[try:4]
[while1try=1]
	while before1: l=0, r=2, k=0 | [2, 14]
	[ 2 35 14 63 23 53 52 5 ]
			***Lをいれました***
	while after1: l=1, r=2, k=1
	[ 2 35 14 63 23 53 52 5 ]

[try:5]
[while1try=2]
	while before1: l=1, r=2, k=1 | [35, 14]
	[ 2 35 14 63 23 53 52 5 ]
			***Rをいれました***
	while after1: l=1, r=3, k=2
	[ 2 14 14 63 23 53 52 5 ]

[try:6]
[while1try=3]
	while before1: l=1, r=3, k=2 | [35, 63]
	[ 2 14 14 63 23 53 52 5 ]
			***Lをいれました***
	while after1: l=2, r=3, k=3
	[ 2 14 35 63 23 53 52 5 ]

[***while3try=1] r=3, rend=3
			r=3, rarr[r]=63
			***余ったRはスルーしました***
[lstart=4 , lend=4 , llength=1], [rstart=5 , rend=5 , rlength=1]

--START mergeParts ----------------------------
l=4, r=5, k=4, lend=4, rend=5
	# larr l=4, lstart,end=4,4
	[ 0 0 0 0 23 0 0 0 ]
	# rarr r=5, rstart,end=5,5
	[ 0 0 0 0 0 53 0 0 ]
	# 本体array
	[ 2 14 35 63 23 53 52 5 ]

[try:7]
[while1try=1]
	while before1: l=4, r=5, k=4 | [23, 53]
	[ 2 14 35 63 23 53 52 5 ]
			***Lをいれました***
	while after1: l=5, r=5, k=5
	[ 2 14 35 63 23 53 52 5 ]

[***while3try=1] r=5, rend=5
			r=5, rarr[r]=53
			***余ったRはスルーしました***
[lstart=6 , lend=6 , llength=1], [rstart=7 , rend=7 , rlength=1]

--START mergeParts ----------------------------
l=6, r=7, k=6, lend=6, rend=7
	# larr l=6, lstart,end=6,6
	[ 0 0 0 0 0 0 52 0 ]
	# rarr r=7, rstart,end=7,7
	[ 0 0 0 0 0 0 0 5 ]
	# 本体array
	[ 2 14 35 63 23 53 52 5 ]

[try:8]
[while1try=1]
	while before1: l=6, r=7, k=6 | [52, 5]
	[ 2 14 35 63 23 53 52 5 ]
			***Rをいれました***
	while after1: l=6, r=8, k=7
	[ 2 14 35 63 23 53 5 5 ]

[***while2try=1] l=6, lend=6
	[try:9]
			***余ったLをいれました***
			***swapped***
	while after2: l=7, r=8, k=8
	[ 2 14 35 63 23 53 5 52 ]
[lstart=4 , lend=5 , llength=2], [rstart=6 , rend=7 , rlength=2]

--START mergeParts ----------------------------
l=4, r=6, k=4, lend=5, rend=7
	# larr l=4, lstart,end=4,5
	[ 0 0 0 0 23 53 0 0 ]
	# rarr r=6, rstart,end=6,7
	[ 0 0 0 0 0 0 5 52 ]
	# 本体array
	[ 2 14 35 63 23 53 5 52 ]

[try:10]
[while1try=1]
	while before1: l=4, r=6, k=4 | [23, 5]
	[ 2 14 35 63 23 53 5 52 ]
			***Rをいれました***
	while after1: l=4, r=7, k=5
	[ 2 14 35 63 5 53 5 52 ]

[try:11]
[while1try=2]
	while before1: l=4, r=7, k=5 | [23, 52]
	[ 2 14 35 63 5 53 5 52 ]
			***Lをいれました***
	while after1: l=5, r=7, k=6
	[ 2 14 35 63 5 23 5 52 ]

[try:12]
[while1try=3]
	while before1: l=5, r=7, k=6 | [53, 52]
	[ 2 14 35 63 5 23 5 52 ]
			***Rをいれました***
	while after1: l=5, r=8, k=7
	[ 2 14 35 63 5 23 52 52 ]

[***while2try=1] l=5, lend=5
	[try:13]
			***余ったLをいれました***
			***swapped***
	while after2: l=6, r=8, k=8
	[ 2 14 35 63 5 23 52 53 ]
[lstart=0 , lend=3 , llength=4], [rstart=4 , rend=7 , rlength=4]

--START mergeParts ----------------------------
l=0, r=4, k=0, lend=3, rend=7
	# larr l=0, lstart,end=0,3
	[ 2 14 35 63 0 0 0 0 ]
	# rarr r=4, rstart,end=4,7
	[ 0 0 0 0 5 23 52 53 ]
	# 本体array
	[ 2 14 35 63 5 23 52 53 ]

[try:14]
[while1try=1]
	while before1: l=0, r=4, k=0 | [2, 5]
	[ 2 14 35 63 5 23 52 53 ]
			***Lをいれました***
	while after1: l=1, r=4, k=1
	[ 2 14 35 63 5 23 52 53 ]

[try:15]
[while1try=2]
	while before1: l=1, r=4, k=1 | [14, 5]
	[ 2 14 35 63 5 23 52 53 ]
			***Rをいれました***
	while after1: l=1, r=5, k=2
	[ 2 5 35 63 5 23 52 53 ]

[try:16]
[while1try=3]
	while before1: l=1, r=5, k=2 | [14, 23]
	[ 2 5 35 63 5 23 52 53 ]
			***Lをいれました***
	while after1: l=2, r=5, k=3
	[ 2 5 14 63 5 23 52 53 ]

[try:17]
[while1try=4]
	while before1: l=2, r=5, k=3 | [35, 23]
	[ 2 5 14 63 5 23 52 53 ]
			***Rをいれました***
	while after1: l=2, r=6, k=4
	[ 2 5 14 23 5 23 52 53 ]

[try:18]
[while1try=5]
	while before1: l=2, r=6, k=4 | [35, 52]
	[ 2 5 14 23 5 23 52 53 ]
			***Lをいれました***
	while after1: l=3, r=6, k=5
	[ 2 5 14 23 35 23 52 53 ]

[try:19]
[while1try=6]
	while before1: l=3, r=6, k=5 | [63, 52]
	[ 2 5 14 23 35 23 52 53 ]
			***Rをいれました***
	while after1: l=3, r=7, k=6
	[ 2 5 14 23 35 52 52 53 ]

[try:20]
[while1try=7]
	while before1: l=3, r=7, k=6 | [63, 53]
	[ 2 5 14 23 35 52 52 53 ]
			***Rをいれました***
	while after1: l=3, r=8, k=7
	[ 2 5 14 23 35 52 53 53 ]

[***while2try=1] l=3, lend=3
	[try:21]
			***余ったLをいれました***
			***swapped***
	while after2: l=4, r=8, k=8
	[ 2 5 14 23 35 52 53 63 ]


=========================
TOTAL LOOPS: 22 times.
TOTAL SWAP: 7 times.
=========================

Array after merge sort
	[ 2 5 14 23 35 52 53 63 ]

 */