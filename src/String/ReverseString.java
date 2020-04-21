package String;

/**
 * @author linzhiyu
 * @date 2020/2/28 14:03
 * @Email:1360482168@qq.com
 * @Describe 反转字符串  abcdfg
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = new char[]{'a','b','c','d','e'};
        String str = new String("abcdef");
        System.out.println(reverse(s));
        System.out.println(reverse1(str,0,3));


    }
    /**
     * 反转连续的字符串
     */
    public static String reverse(char[] chars){
        for (int l = 0,r = chars.length-1;l < r;l++,r--){
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
        }
        return new String(chars);

    }
    /**
     * 反转一个字符串中的一部分
     * 方法是转换成字符串数组。
     */
    public static String reverse1(String str,int startIndex,int endIndex){
        if (str != null){
            char [] chars = str.toCharArray();
            for (int x = startIndex,y = endIndex;x < y; x++,y--){
                char temp = chars[x];
                chars[x] = chars[y];
                chars[y] = temp;

            }
            return new String(chars);
        }
        return null;
    }
    /**
     * 反转字符串中的一部分
     * 使用StringBuilder
     */
    public static String reverse2(String str,int strating,int ending) {
        StringBuilder builder = new StringBuilder(str.length());
        //第一部分
        builder.append(str.substring(0, strating));
        //第二部分
        for (int i = ending; i >= strating; i--) {
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(ending + 1));
        return builder.toString();
    }




}
