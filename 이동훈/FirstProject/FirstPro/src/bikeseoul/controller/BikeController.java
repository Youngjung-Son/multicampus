package bikeseoul.controller;

import bikeseoul.domain.BikeSeoulDTO;
import bikeseoul.model.BikeModel;
import bikeseoul.view.EndView;

public class BikeController {
	public static int instance; // instance�� BikeSeoulDTO��ü�� station��ü, Rent��ü, Location��ü�� ���� �����ϴ� ����
	public static void all() {
		EndView.printAll(BikeModel.getAll());
	}
	public static void getId(String id) {
		instance =1;
		EndView.printOne(BikeModel.getId(id),instance);
	}
	public static void getName(String name) {
		instance =1;
		EndView.printOne(BikeModel.getName(name),instance);
	}
	public static void getLocation(String id) {
		instance =2;
		EndView.printOne(BikeModel.getLocation(id),instance);
	}
	public static void getHolder(String holder) {
		EndView.printAll(BikeModel.getHolder(holder));
	}
	public static void getRental(String id) {
		instance =3;
		EndView.printOne(BikeModel.getRental(id),instance);
	}
	public static void DeleteOne(String id) {
		BikeModel.DeleteOne(id);
	}
	public static void InsertOne(BikeSeoulDTO One) {
		instance = 1;
		EndView.printOne(BikeModel.InsertOne(One),instance);
		
	}
	public static void UpdateOne(String id, BikeSeoulDTO One) {
		instance = 1;
		EndView.printOne(BikeModel.UpdateOne(id,One), instance);
		
	}
	public static void DeleteOne2(String name) {
		BikeModel.DeleteOne2(name);
	}
	public static void getNear(String id) {
		EndView.printAll(BikeModel.getNear(id));
	}
	public static void getNear2(String name) {
		EndView.printAll(BikeModel.getNear2(name));
	}
	public static void descending() {
		EndView.printAll2(BikeModel.Descending());
	}
}
