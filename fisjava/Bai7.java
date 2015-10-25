package fisjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @version 1.0
 * @author Admin
 *
 */
public class Bai7 {

	public static void main(String args[]) {
		Menu menu = new Menu();
		try {
			menu.login();
		} catch (FileNotFoundException e) {
			System.out.println("Không tìm thấy file dữ liệu");
		}
	}
}

/**
 * Class Menu
 * @author Admin
 *
 */
class Menu {

	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan1;
	int check = 0;// count the times of number login
	String log = "";

	/**
	 * Nếu nhập sai 3 lần sẽ chờ 1p mới đc đăng nhập lại
	 * @throws FileNotFoundException
	 */
	public void login() throws FileNotFoundException {

		while (check != 3) {
			System.out.println("Nhập user name:");
			String user = "";
			user = scan.next().toString();
			System.out.println("Nhập password:");
			String pass = "";
			pass = scan.next().toString();
			if (check == 2) {
				check = 0;
				System.out.println("Bạn đã nhập sai 3 lần.Xin vui lòng đợi");
				for (int i = 0; i < 6; i++) {
					System.out.println("Sau " + (6 - i) * 10 + " nữa!");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Mời bạn đăng nhập lại.");
			} else {
				if (checkLogin(user, pass)) {
					System.out.println("Bạn đã đăng nhập thành công");
					mainMenu();
					check = 3;
				} else {
					check++;
					System.out
							.println("Bạn đã nhập sai.Xin vui lòng nhập lại.");
				}
			}
		}
	}

	/**
	 * Kiểm tra user name và password
	 * 
	 * @param user
	 * @param pass
	 * @return
	 * @throws FileNotFoundException
	 */
	public static boolean checkLogin(String user, String pass)
			throws FileNotFoundException {
		boolean isCheck = false;
		File file = new File("input\\bai7.txt");
		FileInputStream fis = new FileInputStream(file);
		scan1 = new Scanner(fis);
		String userName;
		String passWord;
		userName = scan1.nextLine().toString();
		passWord = scan1.nextLine().toString();
		if (user.equals(userName) && pass.equals(passWord)) {
			isCheck = true;
		}
		return isCheck;
	}

	/**
	 * Hiển thị menu chính
	 */
	public void mainMenu() {

		String exit = "";
		while (!exit.equals("Y")) {
			System.out.println("<=============Main Menu=============>");
			System.out.println("1.Login");
			System.out.println("2.Import");
			System.out.println("3.Export");
			System.out.println("4.Price Management");
			System.out.println("5.Print Bill");
			System.out.println("6.Exit");
			System.out.println("-------------------------------------");
			scan = new Scanner(System.in);
			int choice = 0;
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				importMenu();
				break;
			case 2:
				exportMenu();
				break;
			case 3:
				managementPrice();
				break;
			case 4:
				printBill();
				break;
			case 5:
				System.out.println("5.Exit");
				System.out.println("Bạn có muốn thoát không(Y/N)");
				exit = scan.next().toString();
				break;
			default:
				System.out.println("Chức năng bạn chọn không đúng");
			}
		}
		System.out.println("Cảm ơn đã sử dụng!Good Bye!!!");
	}

	/**
	 * Hiển thị menu nhập hàng
	 */
	public void importMenu() {

		String exit = "";
		while (!exit.equals("Y")) {
			System.out.println("<==========Import Menu=========>");
			System.out.println("1.Nhập số lượng một đơn vị");
			System.out.println("2.Nhập theo thùng 20 đơn vị");
			System.out.println("3.Nhập theo tá 10 đơn vị");
			System.out.println("4.Chỉnh sửa số lượng");
			System.out.println("5.Back to Main menu");
			System.out.println("--------------------------------");
			scan = new Scanner(System.in);
			int choice = 0;
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				String isExit1 = "";
				while (!isExit1.equals("N")) {
					System.out.println("1.Nhập số lượng một đơn vị");
					System.out.println("Số lượng(1 đơn vị):");
					System.out.println("Bạn có muốn nhập tiếp không(Y/N):");
					isExit1 = scan.next().toString();
				}
				break;
			case 2:
				String isExit2 = "";
				while (!isExit2.equals("N")) {
					System.out.println("2.Nhập theo thùng 20 đơn vị");
					System.out.println("Số thùng(20 đơn vị):");
					System.out.println("Bạn có muốn nhập tiếp không(Y/N):");
					isExit2 = scan.next().toString();
				}
				break;
			case 3:
				String isExit3 = "";
				while (!isExit3.equals("N")) {
					System.out.println("3.Nhập theo tá 10 đơn vị");
					System.out.println("Số tá(10 đơn vị):");
					System.out.println("Bạn có muốn nhập tiếp không(Y/N):");
					isExit3 = scan.next().toString();
				}
				break;
			case 4:
				String isExit4 = "";
				while (!isExit4.equals("N")) {
					System.out.println("4.Chỉnh sửa số lượng");
					System.out.println("Sửa số lượng :");
					System.out.println("Bạn có muốn sửa tiếp không(Y/N):");
					isExit4 = scan.next().toString();
				}
				break;
			case 5:
				System.out.println("5.Back to Main menu");
				System.out.println("Bạn có muốn quay lại Main Menu không(Y/N)");
				exit = scan.next().toString();
				break;
			default:
				System.out.println("Chức năng bạn chọn không đúng");
			}
		}
	}

	/**
	 * Hiển thị menu xuất hàng
	 */
	public void exportMenu() {

		String exit = "";
		while (!exit.equals("Y")) {
			System.out.println("<==========Export Menu=========>");
			System.out.println("1.Xuất theo một đơn vị");
			System.out.println("2.Xuất theo thùng");
			System.out.println("3.Xuất theo tá");
			System.out.println("4.Chỉnh sửa số lượng");
			System.out.println("5.Kiểm tra số lượng");
			System.out.println("6.Back to Main menu");
			System.out.println("--------------------------------");
			scan = new Scanner(System.in);
			int choice = 0;
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				String isExit1 = "";
				while (!isExit1.equals("N")) {
					System.out.println("1.Xuất theo một đơn vị");
					System.out.println("Số lượng(1 đơn vị):");
					System.out.println("Bạn có muốn xuất tiếp không(Y/N):");
					isExit1 = scan.next().toString();
				}
				break;
			case 2:
				String isExit2 = "";
				while (!isExit2.equals("N")) {
					System.out.println("2.Xuất theo thùng");
					System.out.println("Số thùng:");
					System.out.println("Bạn có muốn xuất tiếp không(Y/N):");
					isExit2 = scan.next().toString();
				}
				break;
			case 3:
				String isExit3 = "";
				while (!isExit3.equals("N")) {
					System.out.println("3.Xuất theo tá");
					System.out.println("Số tá:");
					System.out.println("Bạn có muốn xuất tiếp không(Y/N):");
					isExit3 = scan.next().toString();
				}
				break;
			case 4:
				String isExit4 = "";
				while (!isExit4.equals("N")) {
					System.out.println("4.Chỉnh sửa số lượng");
					System.out.println("Sửa số lượng :");
					System.out.println("Bạn có muốn sửa tiếp không(Y/N):");
					isExit4 = scan.next().toString();
				}
				break;
			case 5:
				String isExit5 = "";
				while (!isExit5.equals("N")) {
					System.out.println("5.Kiểm tra số lượng");
					System.out.println("Kết quả :");
					System.out.println("Bạn có muốn kiểm tra tiếp không(Y/N):");
					isExit5 = scan.next().toString();
				}
				break;
			case 6:
				System.out.println("6.Back to Main menu");
				System.out.println("Bạn có muốn quay lại Main Menu không(Y/N)");
				exit = scan.next().toString();
				break;
			default:
				System.out.println("Chức năng bạn chọn không đúng");
			}
		}
	}

	/**
	 * Hiển thị menu quản lý giá
	 */
	public void managementPrice() {

		String exit = "";
		while (!exit.equals("Y")) {
			System.out.println("<==========Price Menu==========>");
			System.out.println("1.Hiển thị giá");
			System.out.println("2.Sửa giá");
			System.out.println("3.Tổng tiền hàng");
			System.out.println("4.Back to Main menu");
			System.out.println("--------------------------------");
			scan = new Scanner(System.in);
			int choice = 0;
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				String isExit1 = "";
				while (!isExit1.equals("N")) {
					System.out.println("1.Hiển thị giá");
					System.out.println("Giá:");
					System.out.println("Bạn có muốn hiển thị tiếp không(Y/N):");
					isExit1 = scan.next().toString();
				}
				break;
			case 2:
				String isExit2 = "";
				while (!isExit2.equals("N")) {
					System.out.println("2.Sửa giá");
					System.out.println("Giá mới:");
					System.out.println("Bạn có muốn sửa tiếp không(Y/N):");
					isExit2 = scan.next().toString();
				}
				break;
			case 3:
				String isExit4 = "";
				while (!isExit4.equals("N")) {
					System.out.println("3.Tổng tiền hàng");
					System.out.println("Số tiền:");
					System.out.println("Bạn có muốn hiển thị tiếp không(Y/N):");
					isExit4 = scan.next().toString();
				}
				break;
			case 4:
				System.out.println("4.Back to Main menu");
				System.out.println("Bạn có muốn quay lại Main Menu không(Y/N)");
				exit = scan.next().toString();
				break;
			default:
				System.out.println("Chức năng bạn chọn không đúng");
			}
		}
	}

	/**
	 * Hiển thị menu in hóa đơn
	 */
	public void printBill() {

		String exit = "";
		while (!exit.equals("Y")) {
			System.out.println("<===========Bill Menu==========>");
			System.out.println("1.In theo lượng hàng");
			System.out.println("2.In theo giá");
			System.out.println("3.In theo cả hàng và giá");
			System.out.println("4.Back to Main menu");
			System.out.println("--------------------------------");
			scan = new Scanner(System.in);
			int choice = 0;
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				String isExit1 = "";
				while (!isExit1.equals("N")) {
					System.out.println("1.In theo lượng hàng");
					System.out.println("Lượng hàng:");
					System.out.println("Bạn có muốn in tiếp không(Y/N):");
					isExit1 = scan.next().toString();
				}
				break;
			case 2:
				String isExit2 = "";
				while (!isExit2.equals("N")) {
					System.out.println("2.In theo giá");
					System.out.println("Giá:");
					System.out.println("Bạn có muốn in tiếp không(Y/N):");
					isExit2 = scan.next().toString();
				}
				break;
			case 3:
				String isExit4 = "";
				while (!isExit4.equals("N")) {
					System.out.println("4.In theo giá và lượng hàng");
					System.out.println("Lượng hàng:");
					System.out.println("Giá:");
					System.out.println("Bạn có muốn in tiếp không(Y/N):");
					isExit4 = scan.next().toString();
				}
				break;
			case 4:
				System.out.println("5.Back to Main menu");
				System.out.println("Bạn có muốn quay lại Main Menu không(Y/N)");
				exit = scan.next().toString();
				break;
			default:
				System.out.println("Chức năng bạn chọn không đúng");
			}
		}
	}
}
