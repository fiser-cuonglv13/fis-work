package fisjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bai5 {

	private static Scanner scan;
	private static int[][] matrix;// ma trận đầu vào
	/* Mảng danh sách lưu trữ tọa độ các điểm của đường đi */
	private static ArrayList<Point> pointList = new ArrayList<Point>();

	/**
	 * Constructor
	 */
	public Bai5() {

	}

	/**
	 * 
	 * class điểm của đường đi cần tìm
	 *
	 */
	class Point {
		int x;
		int y;

		/**
		 * getter,setter
		 */
		public int getX() {
			return x + 1;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y + 1;
		}

		public void setY(int y) {
			this.y = y;
		}

	}

	/**
	 * Method tìm đường đi theo giải thuật BFS
	 * 
	 * @param matrix
	 * @param i1
	 * @param j1
	 * @param i2
	 * @param j2
	 */
	public void findPath(int[][] matrix, int i1, int j1, int i2, int j2) {
		int n = matrix.length;
		int m = matrix[0].length;
		/* Các mảng lưu vị trí vừa duyệt qua */
		int[][] posX = new int[n][m];
		int[][] posY = new int[n][m];

		/* Các mảng lưu các vị trí sẽ duyệt */
		int[] queueX = new int[n * m];
		int[] queueY = new int[n * m];

		/* Các hướng duyệt bước đi tiếp theo */
		int u[] = { 1, 0, -1, 0 };
		int v[] = { 0, 1, 0, -1 };

		int first = 0, last = 0;

		int x, y, i, xNext, yNext, k;

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				posX[a][b] = 0;
			}
		}
		Point point[] = new Point[n * m];
		for (int z = 0; z < n * m; z++) {
			point[z] = new Point();
		}
		/**
		 * Xét từ điểm đích Lưu tọa độ điểm đích vào hàng đợi
		 */
		queueX[0] = i2;
		queueY[0] = j2;

		/* Đánh dấu điểm đích */
		posX[i2][j2] = -1;

		while (first <= last && last < n * m - 2) {

			/* Lấy điểm xét tiếp theo trong hàng đợi */
			x = queueX[first];
			y = queueY[first];
			first++;

			/* Kiểm tra các bước tiếp theo có thể đi từ điểm đang xét */
			for (k = 0; k < 4; k++) {
				xNext = x + u[k];
				yNext = y + v[k];

				/* Nếu đã gặp điểm đầu(duyệ ngược) thì lưu kết quả */
				if (xNext == i1 && yNext == j1) {
					posX[i1][j1] = x;
					posY[i1][j1] = y;
					i = 0;
					while (true) {
						point[i].setX(i1);
						point[i].setY(j1);
						pointList.add(point[i]);
						i++;
						k = i1;
						i1 = posX[i1][j1];
						if (i1 == -1)
							break;
						j1 = posY[k][j1];
					}
				}

				if (!(xNext >= 0 && xNext < n && yNext >= 0 && yNext < m))
					continue;

				if (posX[xNext][yNext] == 0 && matrix[xNext][yNext] == 0) {
					last++;
					queueX[last] = xNext;
					queueY[last] = yNext;
					posX[xNext][yNext] = x;
					posY[xNext][yNext] = y;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		File file = new File("input\\bai5.txt");
		FileInputStream fis = new FileInputStream(file);
		scan = new Scanner(fis);

		int n;
		int m;
		String nm = "";
		nm = scan.nextLine();
		String[] strNM = nm.split("[ .,!]");
		n = Integer.parseInt(strNM[0]);
		m = Integer.parseInt(strNM[1]);
		String str = new String();
		String[] str1 = new String[n];
		while (scan.hasNext()) {
			str += scan.nextLine();
		}

		str1 = str.split("[ .,!]");
		matrix = new int[n][m];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(str1[index++]);
			}
		}
		Bai5 b5 = new Bai5();
		b5.findPath(matrix, 0, 0, n - 1, m - 1);

		if (pointList.size() == 0) {
			System.out.println("Không có đường đi");
		} else {
			for (int i = 0; i < pointList.size(); i++) {
				System.out.println(pointList.get(i).getX() + " "
						+ pointList.get(i).getY());
			}
		}

	}
}
