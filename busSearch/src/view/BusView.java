package view;

import java.util.List;

import model.BusStopsVO;
import model.VisitVO;

public class BusView {

	public static void display(BusStopsVO spt) {
		// TODO Auto-generated method stub

		System.out.println(spt);
	}

	public static void display(List<BusStopsVO> stoplist) {

		for (BusStopsVO spt : stoplist) {

			System.out.println(spt);
		}
	}

	public static void display(String message) {
		System.out.println("알림");
		System.out.println(message);
	}

	public static void print(List<VisitVO> res) {
		// TODO Auto-generated method stub
		for (VisitVO v : res) {

			System.out.println(v);
		}
	}

}
