package theRooftopOfMemories;
import java.util.*;


public class theRooftopOfMemories {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //エリアの値を取得
        String[] inputEriaInfo = sc.nextLine().split(" ");

        //縦のマス数
        int hMax = Integer.parseInt(inputEriaInfo[0]);
        //横のマス数
        int wMax = Integer.parseInt(inputEriaInfo[1]);
        // マップ全体を表す2次元配列（初期値はすべてfalse）
        boolean[][] mapInfo = new boolean[hMax][wMax];

        //縄張り中心点の個数
        int pointCount = Integer.parseInt(inputEriaInfo[2]);

        // 各ポイントの情報を読み込んで、条件に合致したらtrueに更新する
        for (int line = 0; line < pointCount; line++) {
            String[] inputPointInfo = sc.nextLine().split(" ");
            // 指定された範囲をtrueに設定
            mapInfo = putMapInfo(mapInfo,inputPointInfo);

        }
        int maxSize = -1;
        for (int h = 0;h < hMax ;h++) {
            for (int w = 0;w < wMax ;w++) {
            	//h,wの最大値を測定
            	int result = findMaxSize(h,w, mapInfo, hMax, wMax);

            	if(maxSize < result) {
            		//結果がMaxより大きい場合
            		maxSize = result;
            	}
            }
        }

        System.out.println(maxSize);

        sc.close();

    }

	private static boolean[][] putMapInfo(boolean[][] mapInfo, String[] inputPointInfo) {

        boolean[][] updateMapInfo = mapInfo;
        int h = Integer.parseInt(inputPointInfo[0])-1; // h座標
        int w = Integer.parseInt(inputPointInfo[1])-1; // w座標
        int size = Integer.parseInt(inputPointInfo[2]); // サイズ
        for (int i = 0; i < updateMapInfo.length; i++) {
            for (int j = 0; j < updateMapInfo[0].length; j++) {
                // ここでマンハッタン距離を計算して、size以下だったらtrueに更新する
            	    // マンハッタン距離を計算（中心からの距離）
            	    int distance = Math.abs(h - i) + Math.abs(w - j);
            	    // サイズ以下なら領域内
            	    if (distance <= size) {
            	        mapInfo[i][j] = true;
            	    }
            }
        }
		return updateMapInfo;
	}

	// 最大サイズを見つける関数
	private static int findMaxSize(int h, int w, boolean[][] mapInfo, int hMax, int wMax) {
	    int left = 0;
	    int right = Math.min(hMax, wMax); // 最大サイズは短い辺の長さまで

	    while (left <= right) {
	        int mid = (left + right) / 2;
	        if (canPlace(h, w, mid, mapInfo, hMax, wMax)) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return right;
	}

	private static boolean canPlace(int h, int w, int size, boolean[][] mapInfo, int hMax, int wMax) {
	    // サイズ分の範囲だけをチェック
	    for (int i = Math.max(0, h - size); i <= Math.min(hMax - 1, h + size); i++) {
	        for (int j = Math.max(0, w - size); j <= Math.min(wMax - 1, w + size); j++) {
	            if (Math.abs(h - i) + Math.abs(w - j) <= size && mapInfo[i][j]) {
	                return false;
	            }
	        }
	    }

	    return true;
	}


}