package i_inherit2;

import java.util.Scanner;

//
//super : 부모객체의 레퍼런스
public class main {

	public static void main(String[] args) {
		Item i = null;
		Scanner in = new Scanner(System.in);
		System.out.println("상품(1.책 2.DVD 3.CD) -> ");
		int sel = in.nextInt();
		switch(sel) {
		case 1: i = new Book(); 
		break;
		case 2: i = new Dvd(); 
		break;
		case 3: i = new Cd();
		break;
		}i.output();
	}
	

}
