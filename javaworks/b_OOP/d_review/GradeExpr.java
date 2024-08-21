package d_review;

public class GradeExpr {
	 int [] jumsu ; //
	
	 GradeExpr(int [] jumsu){
		this.jumsu = jumsu ;// 생성자 함수 선언및 객체생성
		
	}
	
	double getAverage() {
		int total = getTotal(); //총합 메서드를 호출
		
		return (double)total/jumsu.length;
	}
	int getTotal() {
		int total = 0; //총합을 저장 받을 변수 선언
		for (int i = 0; i<jumsu.length; i+=1) {
			total += jumsu[i];
		}return total;
		 //총합을 받고 저장을 하고 값을 반환
		
	}
	int getGoodScore() {
		int max = jumsu[0];
		for (int i = 1 ; i<jumsu.length;i+=1) {
			if(jumsu[max]<jumsu[i]) {
				max = jumsu[i];			
			}
		}	return max;
	}
	int getBadScore() {
		int min = jumsu[0];
		for (int i = 1 ;i<jumsu.length;i+=1) {
			if(min>jumsu[i]) {
				min = jumsu[i];
			}
		}return min;
		
		
	}
}
