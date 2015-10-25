package fisjava;
class Temp {
	static int x = 10; 
	public static void show( ) { 
		System.out.println(x);
	}
	public static void main(String args[ ]) {
		Temp t = new Temp( ); 
		t.show( ); 
		Temp t1 = new Temp( ); 
		t1.x = 20;
		t1.show();
	}
}
