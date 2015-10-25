package fisjava;
class TinhTien{
		public float calcu(int min){
		float money = 0.0f;
		if(min < 0){
			System.out.println("Thoi gian phai lon hon 0");
		}
		else if(min >= 1 || min <= 200){
			money = 27000 + 120 * min;
		}else if(min >= 201 || min <= 400){
			money = 51000 + 80*(min-200);
		}else if(min >= 401){
			money = 67000 + 40*(min - 400);
		}
		System.out.println(money);
		return money;
		
	}
	public static void main(String args1[]){
		TinhTien tt = new TinhTien();
		tt.calcu(Integer.valueOf(args1[0]));
	}
}