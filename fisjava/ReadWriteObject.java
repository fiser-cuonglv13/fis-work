package fisjava;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ReadWriteObject {

   // kiem tra file co object hay khong
   public static boolean hasObject(File f) {
       // thu doc xem co object nao chua
       FileInputStream fi;
       boolean check = true;
       try {
           fi = new FileInputStream(f);
           ObjectInputStream inStream = new ObjectInputStream(fi);
           if (inStream.readObject() == null) {
               check = false;
           }
           inStream.close();

       } catch (FileNotFoundException e) {
           check = false;
       } catch (IOException e) {
           check = false;
       } catch (ClassNotFoundException e) {
           check = false;
           e.printStackTrace();
       }
       return check;
   }

   public static void write(MyStudent s) {
       try {

           File f = new File("student.txt");
           FileOutputStream fo;
           ObjectOutputStream oStream = null;

           // neu file chu ton tai thi tao file va ghi binh thuong
           if (!f.exists()) {
               fo = new FileOutputStream(f);
               oStream = new ObjectOutputStream(fo);
           } else { // neu file ton tai

               // neu chua co thi ghi binh thuong
               if (!hasObject(f)) {
                   fo = new FileOutputStream(f);
                   oStream = new ObjectOutputStream(fo);
               } else { // neu co roi thi ghi them vao

                   fo = new FileOutputStream(f, true);

                   oStream = new ObjectOutputStream(fo) {
                       protected void writeStreamHeader() throws IOException {
                           reset();
                       }
                   };
               }
           }

           oStream.writeObject(s);
           oStream.close();

       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static void read() {
       try {
           File f = new File("student.txt");
           FileInputStream fis = new FileInputStream(f);
           ObjectInputStream inStream = new ObjectInputStream(fis);
           Object s;
           int i = 0;
           while (true) {
               s = inStream.readObject();
               System.out.println(++i + ":" + s.toString());
           }
       } catch (ClassNotFoundException e) {
       } catch (IOException e) {
       }
   }

   public static void main(String[] args) {

       // ghi sinh vien 1
	   int[] a = {22,23};
       write(new MyStudent("nguyenvanquan7826",a ));
       int[] b = {22,24};
       // ghi tiep sinh vien 2
       write(new MyStudent("phamha", b));

       // doc file
       read();

   }
}

class MyStudent implements Serializable {
   String name;
   int[] age;

   public MyStudent(String name, int[] age) {
       super();
       this.name = name;
       this.age = age;
   }

   public String toString() {
       return "MyStudent [name=" + name + ", age=" + age + "]";
   }
}