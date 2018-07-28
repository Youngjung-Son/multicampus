package restaurant.domain;

public class RestaurantDTO {
	private String restaurant_name; 
	private String host_name;
	private String restaurant_address;
	private String telephone_number;
	private String food_type;
	private String main_dish;
	
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public RestaurantDTO() {
		super();
	}
	public RestaurantDTO(String restaurant_name, String host_name, String restaurant_address, String telephone_number,
			String food_type, String main_dish) {
		super();
		this.restaurant_name = restaurant_name;
		this.host_name = host_name;
		this.restaurant_address = restaurant_address;
		this.telephone_number = telephone_number;
		this.food_type = food_type;
		this.main_dish = main_dish;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getHost_name() {
		return host_name;
	}
	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public String getTelephone_number() {
		return telephone_number;
	}
	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}
	public String getFood_type() {
		return food_type;
	}
	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	public String getMain_dish() {
		return main_dish;
	}
	public void setMain_dish(String main_dish) {
		this.main_dish = main_dish;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		//builder.append("업소명\t");
		builder.append(restaurant_name);
		builder.append(" / ");
		//builder.append("영업자 성명\t");
		builder.append(host_name);
		builder.append(" / ");

		//builder.append("소재지 명\t");
		builder.append(restaurant_address);
		builder.append(" / ");

		//builder.append("전화 번호\t");
		builder.append(telephone_number);
		builder.append(" / ");

		//builder.append("음식 카테고리\t");
		builder.append(food_type);
		builder.append(" / ");

		//builder.append("메인 메뉴\t");
		builder.append(main_dish);
		//builder.append("\t");

		return builder.toString();
	}
	
	
}
