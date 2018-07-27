package model.domain;

public class CompoListDTO {
	private String compo_name;
	private int compo_life;
	
	
	public CompoListDTO() {}
	public CompoListDTO(String compo_name, int compo_life) {
		super();
		this.compo_name = compo_name;
		this.compo_life = compo_life;
	}
	public String getCompo_name() {
		return compo_name;
	}
	public void setCompo_name(String compo_name) {
		this.compo_name = compo_name;
	}
	public int getCompo_life() {
		return compo_life;
	}
	public void setCompo_life(int compo_life) {
		this.compo_life = compo_life;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComponentList [compo_name=");
		builder.append(compo_name);
		builder.append(", compo_life=");
		builder.append(compo_life);
		builder.append("]");
		return builder.toString();
	}
	
}
