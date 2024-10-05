package mypack;

import java.util.*;

public class Runner {
	static int counter =0;
	public static void main(String[] args) {
		System.out.println("Welcome World");
		
		Car c1 = new Car(++counter,"honda1","red");
		Car c2 = new Car(++counter,"honda2","red");
		Car c3 = new Car(++counter,"honda3","red");
		Car c4 = new Car(++counter,"honda4","blue");
		Car c5 = new Car(++counter,"honda5","blue");
		Car c6 = new Car(++counter,"honda6","blue");
		Car c7 = new Car(++counter,"honda7","green");
		Car c8 = new Car(++counter,"honda8","green");

		List<Car> cars = new ArrayList<Car>();
		
		cars.add(c1);cars.add(c2);cars.add(c3);
		cars.add(c4);cars.add(c5);cars.add(c6);
		cars.add(c7);cars.add(c8);
		
		//getCountByColor(cars);
		getCountByColorOptimized(cars);
	}
	private static void getCountByColorOptimized(List<Car> cars) {
		Map<String, Integer> map = new HashMap<>();
		//populate the map
		
		for(int i = 0; i < cars.size();i++) {
			Car carInCurrentInterection = cars.get(i);
			String carColor = carInCurrentInterection.getColor();
			if (!map.containsKey(carColor)) { //map already contatin color
				map.put(carColor, 1);
			}
			else {
				int count = map.get(carColor);
				++count;
				map.put(carColor, count++);
			}
		}
		System.out.println(map);
		
		for(Map.Entry<String, Integer> me:map.entrySet()) {
			String color = me.getKey();
			int count = me.getValue();
			System.out.println(color +": " + count);
		}
		
	}
	private static void getCountByColor(List<Car> cars) {
		int redCount = 0;
		int blueCount = 0;
		int greenCount = 0;
		
		for(Car car:cars) {
			if(car.getColor().equals("red")) {
				redCount++;
			}else if (car.getColor().equals("blue")) {
				blueCount++;
			}else {
				greenCount++;
			}
		}
		System.out.println("red:"+ redCount + "blue:"+ blueCount + "green:"+ greenCount);
	}
}

class Car{
	//get:set
	private int id;
	private String name;
	private String color;
	public Car(int id, String name, String color) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
