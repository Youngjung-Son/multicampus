package restaurant.controller;

import restaurant.model.RestaurantModel;
import restaurant.view.EndView;

public class RestaurantController {
	RestaurantModel one= new RestaurantModel();
	
	public void create() {
		System.out.println("추가할 매장을 입력해 주세요.");
		System.out.println("(업소명,영업자 성명,소재지명,전화번호,음식 카테고리,메인메뉴)");
		if(one.create()) {
			EndView.printmsg("잘 입력됐습니다.");
		}else {
			EndView.printmsg("매장 추가를 실패했습니다.");
		}
	}

	public void read(String input2) {
		if(input2.equals("1")) {
			System.out.println("검색하실 업소명을 입력해주세요");
			RestaurantModel.read1();
		}else if(input2.equals("2")) {
			System.out.println("검색하실 음식종류를 입력해주세요");
			EndView.printAll(one.read2());
		}
	}

	public void upgrade() {
		if(one.update()) {
			EndView.printmsg("잘 수정되었습니다.");
		}else {
			EndView.printmsg("수정 실패!!");
		}
	}

	public void delete() {
		System.out.println("삭제할 업소명을 입력해주세요");
		if(one.delete()) {
			EndView.printmsg("잘 지워졌습니다.");
		}else {
			EndView.printmsg("지워지질 않습니다");
		}
	}

	public void fileIO() {
		one.fileIO();
	}



}

/*public static void getOne(String id) {
	CustomerDTO one = CustomerModel.getOne(id);
	if(one!= null) {
		EndView.printOne(one);
	}else {
		EndView.printmsg("요청하신 정보가 미존재합니다.");*/