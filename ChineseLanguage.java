package SoftwareClass;
import java.util.Scanner;
class Cnum{
	int setnum(String arr) {
		switch(arr) {
		case "零" :
			return 0;
		case "一" :
			return 1;
		case "二" :
			return 2;
		case "三" :
			return 3;
		case "四" :
			return 4;
		case "五" :
			return 5;
		case "六" :
			return 6;
		case "七" :
			return 7;
		case "八" :
			return 8;
		case "九" :
			return 9;
		case "十" :
			return 10;
		default :
            System.out.println("输入有误"); 
		}
		return 0;
	}
	String Csetnum(char c) {
		switch(c) {
		case '零' :
			return "0";
		case '一' :
			return "1";
		case '二' :
			return "2";
		case '三' :
			return "3";
		case '四' :
			return "4";
		case '五' :
			return "5";
		case '六' :
			return "6";
		case '七' :
			return "7";
		case '八' :
			return "8";
		case '九' :
			return "9";
		default :
            System.out.println("输入有误"); 
		}
		return "0";
	}
	String Fsetnum(int b) {
		switch(b) {
		case 0 :
			return "零";
		case 1 :
			return "一";
		case 2 :
			return "二";
		case 3 :
			return "三";
		case 4 :
			return "四";
		case 5 :
			return "五";
		case 6 :
			return "六";
		case 7 :
			return "七";
		case 8 :
			return "八";
		case 9 :
			return "九";
		case 10 :
			return "十";
		default :
            System.out.println("输入有误"); 
		}
		return null;
	}
	String Zsetnum(char c) {
		switch(c) {
		case '0':
			return "零";
		case '1' :
			return "一";
		case '2' :
			return "二";
		case '3' :
			return "三";
		case '4' :
			return "四";
		case '5' :
			return "五";
		case '6' :
			return "六";
		case '7' :
			return "七";
		case '8' :
			return "八";
		case '9' :
			return "九";
		default :
            System.out.println("输入有误"); 
		}
		return null;
	}
	String Jsetnum(int d) {
		switch(d) {
		case 1 :
			return "十";
		case 2 :
			return "百";
		case 3 :
			return "千";
		case 4 :
			return "万";
		default :
            System.out.println("输入有误"); 
		}
		return null;
	}
}
public class ChineseLanguage {
	public static void main(String[] args) {
		Scanner w = new Scanner(System.in);
		Cnum p = new Cnum();
		int wd = 0;
		int i,j,k,t = 0;
		String kk = "";
		System.out.println("编码过程如要退出请输入esc");
		System.out.println("大于十的请按一十一输入");
		while (true) {
			String result = w.nextLine();// 取出输入的字符串
            String arr[] = result.split("\\s+");// 正则按空格匹配
			if (arr.length == 4) { // 识别定义
                if(arr[3].length()==1)//区别个位十位
                    wd = p.setnum(arr[3]);
                else if (arr[3].length() > 1) {
                    kk = "";
                    for (i = 0; i < arr[3].length(); i++) {
                        if (arr[3].charAt(0) == '负')
                            i++;
                        if (arr[3].charAt(i) == '十' || arr[3].charAt(i) == '百' || arr[3].charAt(i) == '千'
                                || arr[3].charAt(i) == '万') {
                            i++;
                            if (i == arr[3].length()) {
                                kk = kk + '0';
                                wd = Integer.parseInt(kk);
                                break;
                            }
                        }
                        kk = kk + p.Csetnum(arr[3].charAt(i));
                        wd = Integer.parseInt(kk);
                    }
                    if (arr[3].charAt(0) == '负')
                        wd = 0 - wd;
                }
            } 
            else if (arr.length == 3) { // 识别运算
                if (arr[2].length() == 1) {
                    if (arr[1].equals("增加")) {
                        wd = wd + p.setnum(arr[2]);
                    }
                    if (arr[1].equals("减少")) {
                        wd = wd - p.setnum(arr[2]);
                    }
                }
                else if(arr[2].length() > 1) {
                    kk = "";
                    for (i = 0; i < arr[2].length(); i++) {
                        if (arr[2].charAt(0) == '负')
                            i++;
                        if (arr[2].charAt(i) == '十' || arr[2].charAt(i) == '百' || arr[2].charAt(i) == '千'
                                || arr[2].charAt(i) == '万') {
                            i++;
                            if (i == arr[2].length()&&arr[2].charAt(i-1) == '十') {
                                kk = kk + '0';
                                t = Integer.parseInt(kk);
                                break;
                            }
                            if (i == arr[2].length()&&arr[2].charAt(i-1) == '百') {
                                kk = kk + "00";
                                t = Integer.parseInt(kk);
                                break;
                            }
                            if (i == arr[2].length()&&arr[2].charAt(i-1) == '千') {
                                kk = kk + "000";
                                t = Integer.parseInt(kk);
                                break;
                            }
                            if (i == arr[2].length()&&arr[2].charAt(i-1) == '万') {
                                kk = kk + "0000";
                                t = Integer.parseInt(kk);
                                break;
                            }
                        }
                        kk = kk + p.Csetnum(arr[2].charAt(i));
                        t = Integer.parseInt(kk);
                    }
                    if (arr[2].charAt(0) == '负')
                        t = 0 - t;
                    if (arr[1].equals("增加")) {
                        wd = wd + t;
                    }
                    if (arr[1].equals("减少")) {
                        wd = wd - t;
                    }
                }
            } 
            else if (arr.length == 2) {  //识别输出
                kk="";
                if(wd>=0&&wd<=10)//区别个位十位
                    System.out.println(p.Fsetnum(wd));
                else if(wd<0){
                    wd=0-wd;
                    System.out.print("负");
                    kk=String.valueOf(wd);
                    for (i = 0; i < kk.length(); i++) {
                        if(i!=0)//十百千万单位
                            System.out.print(p.Jsetnum(i));
                        System.out.print(p.Zsetnum(kk.charAt(i)));
                    }
                    wd=0-wd;
                    System.out.println();
                }
                else {//大于10
                    k=wd;
                    for(j=0;k!=0;j++)
                        k=k/10;
                    j--;
                    kk=String.valueOf(wd);
                    for (i = 0; i < kk.length(); i++) {
                        System.out.print(p.Zsetnum(kk.charAt(i)));
                        if(kk.charAt(i)=='0')//零后无单位，一百零五
                            j--;
                        if(j!=0) {//十百千万单位
                            System.out.print(p.Jsetnum(j));
                            j--;
                        }
                    }
                    System.out.println();
                }
            } 
            else if (arr.length == 10) {  //识别判断
                kk="";
                if (wd > p.setnum(arr[3])) {
                    for (i = 0; i < arr[6].length(); i++) {
                        if(arr[6].charAt(i)!='“' && arr[6].charAt(i)!='”')
                        kk = kk+arr[6].charAt(i);           
                    }
                    System.out.println(kk);
                } 
                else {
                    for (i = 0; i < arr[9].length(); i++) {
                        if(arr[9].charAt(i)!='“' && arr[9].charAt(i)!='”')
                        kk = kk+arr[9].charAt(i);           
                    }
                    System.out.println(kk);
                }
            }
			if(arr[0].equals("esc"))
				break;
		}
	}
}
