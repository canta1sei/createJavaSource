package test20250320;
import java.util.*;


public class loseJavaTest{    
	 /*
     * @param args
     */
    public static void main(String[] args) {
    	
    	System.out.println(String.valueOf((solution(""))));
    	System.out.println(String.valueOf((solution("Hello World, Apple Banana 123test"))));
    	System.out.println(String.valueOf((solution("Apple Apple Banana, Apple. 1test 1test"))));
    	System.out.println(String.valueOf((solution("cat Dog bird Eagle"))));
    	System.out.println(String.valueOf((solution("1st 2nd 3rd first second third"))));
    	System.out.println(String.valueOf((solution("Hello...World,,,Apple   Banana"))));
    	System.out.println(String.valueOf((solution("123 123Test TEST test,Test.1abc"))));

    }
    public static int solution(String text) {
        //まず文章から単語を切り出して文字列にする
        //区切り文字は半角スペース、ピリオド、カンマ
        String[] inputTextList= text.split("[\" ,.]");
        //区切ったそれぞれの単語に対して以下条件でチェック
        //「頭文字が数字か大文字アルファベット」かつ「既出の単語と被りなし」
        //条件満たせたら対象文字列リストに格納
        //最後に対象文字列リストの値返却
        
        //対象文字列リスト
        List<String> countStringList = new ArrayList<String>();
        for(int i = 0; i < inputTextList.length ; i++) {
            //頭文字を取得
        	String head = inputTextList[i]!= "" ? 
        			inputTextList[i].substring(0, 1):""; // "頭文字取得"
            
            if((head.matches("[0-9]")||head.matches("[A-Z]"))&&!countStringList.contains(inputTextList[i])){
            	//頭文字チェックを満たすかつ同じ文字がない場合に対象文字列リストに追加する
            		countStringList.add(inputTextList[i]);
            }
        }
        return countStringList.size();

    }


}