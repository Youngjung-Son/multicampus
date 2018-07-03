/* �н����� - �迭
 * 1. �ټ��� �����͸� �ϳ��� ������ ����
 * 2. ������ �����ʹ� ������ index �� ����
 * 		- ù��° ������ ������ ������ 0
 * 3. ��� �迭�� ������ ��ü
 * 		- �迭�� ���� ��� �����ϰ� ������ ��� � �޸𸮿� ����
 * 		  : heap�� ����
 * 4. �ѹ� ������Ų �迭�� ũ��� ���� �Ұ�
 * 		- �������� ������ ǥ���� ���ؼ��� �迭�� �ƴ� list ������ ����
 * 		- java.util package �н� ����
 * 5. ������Ų �迭���� �迭 �޸� ũ�Ⱚ�� ������ length ��� 
 *     ������ �ڵ� ����   */

package step01.syntax;

import step01.domain.PeopleDTO;

public class Step11Array1 {
	
	//int �迭
	public static int[] intArray(){
		int [] i = {1, 2, 3}; 
		return i;
	}
	//String �迭
	public static String[] stringArray() {
		String[] s = {"������", "������", "������"};
		return s;
	}
	//PeopleDTO �迭
	public static PeopleDTO[] peopleArray() {
		PeopleDTO [] all = {new PeopleDTO("�ŵ���", 30),
									new PeopleDTO("�̿���", 31)};
		return all;
	}
	public static void main(String[] args) {
		//? index 1��° ģ���� �̸����� ����� ���� 
		PeopleDTO[] all = peopleArray();
		PeopleDTO p = all[1];
		String name = p.getName();
		System.out.println(name);
		
		/* peopleArray(): PeopleDTO �迭 ��ȯ
		 * peopleArray()[1] : �迭 ���� �ִ� index 1��° ��ü��
		 * 							 PeopleDTO ��ü ��ȯ
		 * peopleArray()[1].getName() : ��ü�� getName() ȣ��
		 */
		String p1 = peopleArray()[1].getName();
		
		int[] i = intArray();
		System.out.println(i[0]);
		int i2 = intArray()[2];
		System.out.println(stringArray()[1]);//index 1�� ���� ���
	}
}



