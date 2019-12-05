package Model;
import java.io.*;
import java.util.ArrayList;

public class FileSystem {
		private String path;
		private File file;
		
		public FileSystem(String path) {
			this.path = path;
			file = new File(path);
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public ArrayList<Object> load() {
			FileInputStream fileIN;
			ObjectInputStream in;
			ArrayList<Object> result = new ArrayList<Object>();
			try {
				fileIN = new FileInputStream(path);
				in = new ObjectInputStream(fileIN);

				while(file.canRead() && in.available() != 0) {
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
