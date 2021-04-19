package controller;

import java.util.List;
import java.util.Scanner;

import model.ServiceDAO;
import model.VisitVO;
import model.BusStopsVO;
import model.BusVO;
import view.BusView;

public class BusController {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ServiceDAO service = new ServiceDAO();
		BusController guest = new BusController();
		String p_name = null;
		String p_id = null; // 이용자의 아이디
		String p_password = null; // 이용자의 비밀번호
		String check_pass = null; // 회원가입 시 비밀번호 확인 목적
		boolean check = true;

		while (true) {
			System.out.println("******작업선택******");
			System.out.print("0.회원가입 1.로그인 2.버스 번호로 조회  3.목적지 조회 4.관리자 9.exit >>");
			int option = sc.nextInt();
			switch (option) {

			// 회원가입
			case (0):
				System.out.println("회원가입입니다.");
				System.out.print("이름을 입력해주세요>>");
				p_name = sc.next();
				System.out.print("원하는 아이디 입력>> ");
				p_id = sc.next();
				System.out.println("비밀번호 입력>>");
				p_password = sc.next();
				while (check) {
					System.out.println("비밀번호 확인>>");
					check_pass = sc.next();
					if (!p_password.equals(check_pass)) {
						System.out.println("비밀번호가 일치하지 않습니다.");
						check = true;

					} else
						check = false;
				}
				guest.signIn(p_id, p_password, p_name);
				break;

			// 로그인
			case (1):
				int loginResult = 0;
				String loginId = null;
				String loginPass = null;
				System.out.println("로그인");

				System.out.print("아이디를 입력하세요>>");
				loginId = sc.next();
				System.out.print("비밀번호를 입력하세요>>");
				loginPass = sc.next();

				loginResult = guest.passengerLogin(loginId, loginPass);
				if (loginResult > 0) {
					System.out.println("로그인에 성공하였습니다.");
				} else {
					System.out.println("로그인에 실패하였습니다.");
				}
				break;
			case (2):
				guest.searchByNo();
				break;
			case (3):
				guest.searchDestination();
				break;
			case (4):
				System.out.println("관리자 로그인이 필요합니다.");
				System.out.print("ID>> ");
				String adminId = sc.next();
				System.out.print("PASSWORD>> ");
				String adminPass = sc.next();
				
				int adminLoginResult = service.adminLogin(adminId,adminPass);
				if (adminLoginResult>0) {
					System.out.println("로그인 성공");
					System.out.println("***관리자 작업 선택***");
					System.out.print("1.노선 추가 2.노선 삭제 >> ");
					int adminOpt = sc.nextInt();
					switch(adminOpt) {
					case(1):
						int addStopno=0;
						String addStopName = null;
						System.out.print("추가할 정류장 번호를 입력하세요>> ");
						addStopno = sc.nextInt();
						System.out.print("추가할 정류장 이름을 입력하세요>> ");
						addStopName = sc.next();
						
						int addRes = service.addStops(addStopno,addStopName);
						if(addRes>0) {
							System.out.println("정류장 추가에 성공하였습니다.");
						}else System.out.println("실패하였습니다.");
						int addBusno=0;
						System.out.print("노선을 추가할 버스번호>> ");
						addBusno = sc.nextInt();
						int res = service.addBusno(addBusno, addStopno);
						if(res>0) {
							System.out.println("버스 노선을 성공적으로 추가하였습니다.");
							
						}else {
							System.out.println("노선 추가에 실패하였습니다.");
						
						}
						break;
					
					case(2):
						int deleteBusNo=0;
						int deleteStopNo = 0;
						System.out.print("노선을 삭제할 버스 번호를 입력하세요>> ");
						deleteBusNo = sc.nextInt();
						System.out.print("삭제할 정류장 번호를 입력하세요>> ");
						deleteStopNo = sc.nextInt();
						
						int result = service.delete(deleteBusNo,deleteStopNo);
						BusView.display(result > 0 ? "삭제에 성공하였습니다." : "삭제에 실패하였습니다.");
						break;
					}
					
				}else {
					System.out.println("로그인 실패");
					break;
				}
			case (9):
				sc.close();
				System.exit(0);
				
			default:
				break;
			}

		}
	

	}



	private void searchDestination() {
		ServiceDAO service = new ServiceDAO();
		String depart = null;
		String arrive = null;
		System.out.print("출발 정류장을 입력하세요>>");
		depart = sc.next();
		System.out.print("목적 정류장을 입력하세요>>");
		arrive = sc.next();
		List<VisitVO> res = service.searchByDest(depart, arrive);
		if (res == null || res.size() == 0) {
			System.out.println("잘못된 정류장을 입력하였습니다. 다시 입력해주세요");
			searchDestination();
		}
		BusView.print(res);

	}

	public int passengerLogin(String loginId, String loginPass) {
		ServiceDAO service = new ServiceDAO();
		int result = service.login(loginId, loginPass);
		return result;

	}

	public void signIn(String id, String password, String name) {
		ServiceDAO service = new ServiceDAO();
		int result = service.PassengerSignIn(id, password, name);
		BusView.display(result > 0 ? "회원가입에 성공하였습니다." : "회원가입에 실패하였습니다.");
	}

	public void searchByNo() {
		ServiceDAO service = new ServiceDAO();
		int busNo = 0;
	
		System.out.print("조회를 원하는 버스 번호를 입력하세요>>");
		busNo = sc.nextInt();
		System.out.println("버스번호 : " + busNo);
		BusView.display(service.selectByNo(busNo));
	}

}
