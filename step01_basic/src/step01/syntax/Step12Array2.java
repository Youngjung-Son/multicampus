/* �н�����
 * 1. �迭 Ÿ���� �̿��� ����� ���
 * 2. String �����Ͱ� ���ϱ�
 * 		 - public boolean equals(String v){���ڿ� ��}
 * 3. ����� ������
 * 		==
 * 		1. �⺻ Ÿ�� : ���� ����
 * 		2. ��ü Ÿ�� : �ּҰ�(��ġ) �� 
 */
package step01.syntax;

import step01.domain.PeopleDTO;

public class Step12Array2 {
	//���ڿ� �� 
	public static void equalsTest(String v) {
		String id = "tester";
		System.out.println(id.equals(v));
	}
	//== ���� �� �����ڷ� �⺻ Ÿ�� ��
	public static void operator(int i) {
		int data = 10;
		System.out.println(data == i);
	}
	
	//== ��ü Ÿ�� �� : �ּҰ� ��
	/*p.getName().equals( dto.getName() )  �������
	 * p : PeopleDTO
	 * p.getName() : PeopleDTO�� name String �� ��ȯ�� ����
	 * p.getName().equals() : String�� equals() ȣ�⸸ 
	 *  dto.getName() : dto�� getName() �� name������ ȹ��
	 *  dto.getName() �� ������� Ȯ���� ��ȯ�Ǹ� equals() ����
	 */
	public static void operator(PeopleDTO dto) {
		PeopleDTO p = new PeopleDTO("name", 10);
		System.out.println(p == dto);
		System.out.println(p.getName().equals( dto.getName() ) );
		
		//p.getName().equals( dto.getName() ) �� ������ �ڵ�
		String name = p.getName();
		String name2 = dto.getName();
		name.equals(name2);
	}

	//�迭�� length ���� ��� ���� - 5���� �ݺ����� �Ἥ ���
	public static void lenghtTest() {
		int [] i = {1, 4, 65, 7, 8};
		for(int index=0; index < i.length; index++) {
			System.out.print(i[index] + "\t");
		}
	}
	
	public static void main(String[] args) {
		equalsTest("tester");//true
		equalsTest("e");//false
		operator(10);//true
		operator(3);//false
		operator(new PeopleDTO("name", 10));//false
		lenghtTest();
		

		
		
	}
}






