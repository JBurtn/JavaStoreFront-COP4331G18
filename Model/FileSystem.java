package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileSystem {
		private String path;
		
		public FileSystem(String path) {
			this.path = path;
		}
		public ArrayList<Object> load() {
			FileInputStream fileIN;
			ObjectInputStream in;
			ArrayList<Object> result = new ArrayList<Object>();
			try {
				fileIN = new FileInputStream(path);
				in = new ObjectInputStream(fileIN);

				while(in.available() != 0) {
					result.add(in.readObject());
				}
			}
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return result;
		}
		public void save(Object obj) {
			FileOutputStream fileOut;
			ObjectOutputStream out;
			try {
				fileOut = new FileOutputStream(path);
				out = new ObjectOutputStream(fileOut);

				out.writeObject(obj);
			}
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
