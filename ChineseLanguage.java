package SoftwareClass;
import java.util.Scanner;
class Cnum{
	int setnum(String arr) {
		switch(arr) {
		case "��" :
			return 0;
		case "һ" :
			return 1;
		case "��" :
			return 2;
		case "��" :
			return 3;
		case "��" :
			return 4;
		case "��" :
			return 5;
		case "��" :
			return 6;
		case "��" :
			return 7;
		case "��" :
			return 8;
		case "��" :
			return 9;
		case "ʮ" :
			return 10;
		default :
            System.out.println("��������"); 
		}
		return 0;
	}
	String Csetnum(char c) {
		switch(c) {
		case '��' :
			return "0";
		case 'һ' :
			return "1";
		case '��' :
			return "2";
		case '��' :
			return "3";
		case '��' :
			return "4";
		case '��' :
			return "5";
		case '��' :
			return "6";
		case '��' :
			return "7";
		case '��' :
			return "8";
		case '��' :
			return "9";
		default :
            System.out.println("��������"); 
		}
		return "0";
	}
	String Fsetnum(int b) {
		switch(b) {
		case 0 :
			return "��";
		case 1 :
			return "һ";
		case 2 :
			return "��";
		case 3 :
			return "��";
		case 4 :
			return "��";
		case 5 :
			return "��";
		case 6 :
			return "��";
		case 7 :
			return "��";
		case 8 :
			return "��";
		case 9 :
			return "��";
		case 10 :
			return "ʮ";
		default :
            System.out.println("��������"); 
		}
		return null;
	}
	String Zsetnum(char c) {
		switch(c) {
		case '0':
			return "��";
		case '1' :
			return "һ";
		case '2' :
			return "��";
		case '3' :
			return "��";
		case '4' :
			return "��";
		case '5' :
			return "��";
		case '6' :
			return "��";
		case '7' :
			return "��";
		case '8' :
			return "��";
		case '9' :
			return "��";
		default :
            System.out.println("��������"); 
		}
		return null;
	}
	String Jsetnum(int d) {
		switch(d) {
		case 1 :
			return "ʮ";
		case 2 :
			return "��";
		case 3 :
			return "ǧ";
		case 4 :
			return "��";
		default :
            System.out.println("��������"); 
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
		System.out.println("���������Ҫ�˳�������esc");
		System.out.println("����ʮ���밴һʮһ����");
		while (true) {
			String result = w.nextLine();// ȡ��������ַ���
			String arr[] = result.split("\\s+");// ���򰴿ո�ƥ��
			if (arr.length == 4) { // ʶ����
				if(arr[3].length()==1)//�����λʮλ
					wd = p.setnum(arr[3]);
				else if (arr[3].length() > 1) {
					kk = "";
					for (i = 0; i < arr[3].length(); i++) {
						if (arr[3].charAt(0) == '��')
							i++;
						if (arr[3].charAt(i) == 'ʮ' || arr[3].charAt(i) == '��' || arr[3].charAt(i) == 'ǧ'
								|| arr[3].charAt(i) == '��') {
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
					if (arr[3].charAt(0) == '��')
						wd = 0 - wd;
				}
			} 
			else if (arr.length == 3) { // ʶ������
				if (arr[2].length() == 1) {
					if (arr[1].equals("����")) {
						wd = wd + p.setnum(arr[2]);
					}
					if (arr[1].equals("����")) {
						wd = wd - p.setnum(arr[2]);
					}
				}
				else if(arr[2].length() > 1) {
					kk = "";
					for (i = 0; i < arr[2].length(); i++) {
						if (arr[2].charAt(0) == '��')
							i++;
						if (arr[2].charAt(i) == 'ʮ' || arr[2].charAt(i) == '��' || arr[2].charAt(i) == 'ǧ'
								|| arr[2].charAt(i) == '��') {
							i++;
							if (i == arr[2].length()&&arr[2].charAt(i-1) == 'ʮ') {
								kk = kk + '0';
								t = Integer.parseInt(kk);
								break;
							}
							if (i == arr[2].length()&&arr[2].charAt(i-1) == '��') {
								kk = kk + "00";
								t = Integer.parseInt(kk);
								break;
							}
							if (i == arr[2].length()&&arr[2].charAt(i-1) == 'ǧ') {
								kk = kk + "000";
								t = Integer.parseInt(kk);
								break;
							}
							if (i == arr[2].length()&&arr[2].charAt(i-1) == '��') {
								kk = kk + "0000";
								t = Integer.parseInt(kk);
								break;
							}
						}
						kk = kk + p.Csetnum(arr[2].charAt(i));
						t = Integer.parseInt(kk);
					}
					if (arr[2].charAt(0) == '��')
						t = 0 - t;
					if (arr[1].equals("����")) {
						wd = wd + t;
					}
					if (arr[1].equals("����")) {
						wd = wd - t;
					}
				}
			} 
			else if (arr.length == 2) {  //ʶ�����
				kk="";
				if(wd>=0&&wd<=10)//�����λʮλ
					System.out.println(p.Fsetnum(wd));
				else if(wd<0){
					wd=0-wd;
					System.out.print("��");
					kk=String.valueOf(wd);
					for (i = 0; i < kk.length(); i++) {
						if(i!=0)//ʮ��ǧ��λ
							System.out.print(p.Jsetnum(i));
						System.out.print(p.Zsetnum(kk.charAt(i)));
					}
					wd=0-wd;
					System.out.println();
				}
				else {//����10
					k=wd;
					for(j=0;k!=0;j++)
						k=k/10;
					j--;
					kk=String.valueOf(wd);
					for (i = 0; i < kk.length(); i++) {
						System.out.print(p.Zsetnum(kk.charAt(i)));
						if(kk.charAt(i)=='0')//����޵�λ��һ������
							j--;
						if(j!=0) {//ʮ��ǧ��λ
							System.out.print(p.Jsetnum(j));
							j--;
						}
					}
					System.out.println();
				}
			} 
			else if (arr.length == 10) {  //ʶ���ж�
				kk="";
				if (wd > p.setnum(arr[3])) {
					for (i = 0; i < arr[6].length(); i++) {
						if(arr[6].charAt(i)!='��' && arr[6].charAt(i)!='��')
						kk = kk+arr[6].charAt(i);			
					}
					System.out.println(kk);
				} 
				else {
					for (i = 0; i < arr[9].length(); i++) {
						if(arr[9].charAt(i)!='��' && arr[9].charAt(i)!='��')
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
