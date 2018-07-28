/*작품 내용
 * 1. 오늘 배운 내용에 한해서 3개의 메소드를 개발
 * 2. 반복, 조건 등에 대한 연습이 될 수 있는 하나의 lab 개발
 * 3. 내 짝궁을 생각하는 마음
 */

package step01.syntax;

public class step10MyArt {
	
	public static int getAsk(int value) {
		int retVal = 100;  //기본을 A 로 놓는다. >> 이 조건을 맨 위로 놓아야 하기에 영향을 안준다
		if(value <= 1) {
			retVal = 100;
		}else if(value <= 4) {
			retVal = 70;
		}else if(value <= 8) {
			retVal = 40;		
		}else {
			retVal = 0;
		}
		return retVal;
	}
	
		public static void forTest(){
			char shy = '/';
			String shy2 = "";
			for(int i=1; i<=8; i++) {
				System.out.print(">");
				for(int j=1; i+j<=9; j++) {
				System.out.print(shy);
			}
				System.out.println("<");
			}
		}
		
		public static void whileTest() {
			char angry = '^';
			String angry2 = "";
			int no=1;
			System.out.print("ㅡㅡ");
			while (no<6) {
				System.out.print(angry);
				no++;
			}
		}
	
		
	public static void main(String[] args) {
		System.out.println("상록이의 기분은" +"  " + getAsk(5));
		forTest();
		whileTest();
	}

}
