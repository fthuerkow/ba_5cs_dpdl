package serilization;

import java.io.*;

public class Launcher {

	public static void main(String[] args) throws Exception {
		/*
		FileOutputStream fs = new FileOutputStream("readwrite/test1.ser");
		ObjectOutputStream os = new ObjectOutputStream(fs);
		Time time = new Time(10,20);
		os.writeObject(time);
		os.writeInt(123);
		os.writeObject("Hallo");
		os.writeObject(new Time(11, 25));
		os.close();
		*/
		
		FileInputStream fs = new FileInputStream("readwrite/test1.ser");
		ObjectInputStream is = new ObjectInputStream(fs);
		Time time = (Time) is.readObject();
		System.out.println(time.toString());
		System.out.println("" + is.readInt());
		System.out.println((String) is.readObject());
		Time t = (Time) is.readObject();
		System.out.println(t.toString());
		is.close();
		
		}
}
