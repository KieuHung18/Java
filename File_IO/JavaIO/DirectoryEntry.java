package JavaIO;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * @author MioRiy
 * <p>The .pack file storage all file in to a single file so theirs bytes will basically next to each other, because of that
 *  we can't tell where each file begin to read it, so we need an Directory entry
 * <p>This class will create a directory entry storing the information of all those file. The information contain following data: 
 * <p><b>File position:</b> storing as long 8 bytes. position of the first byte data of the file. storing at first 8 byte if an entry
 * <p><b>File relative path length:</b> length of the relative path to the file storing as int(4bytes). we will read form 
 * current file pointer to this length to get all bytes of the relative path.
 * <p><b>File relative path:</b> storing as byte. the path will be converting to an array of byte and storage next to File path length
 * So each file will have an entry with these 3 parameter
 */
public class DirectoryEntry {
	/**
	 * Storage the data
	 */
	private ArrayList<Byte> data;
	
	/**
	 * Parent path use to get relative path
	 */
	private String root;

	/**
	 * @param root Use to get relative path of all child file to this file.
	 * <p>Example: root=Desktop/thisFolder.
	 * Then it will return /thisFolder
	 */
	public DirectoryEntry(String root) {
		data=new  ArrayList<Byte>();
		this.root=root;
	}
	
	/**
	 * Write an entry to the directory entry
	 * @param path Path of the file which will be converted to relative path later
	 * @param pos position of the file in the .pack file 
	 */
	public void writeEntry(String path,long pos) {
		path=toRelativePath(path);
		byte[]entryInfo = null;
		entryInfo=ByteBuffer.allocate(8).putLong(pos).array();
		add(entryInfo);
		
		entryInfo=ByteBuffer.allocate(4).putInt(path.getBytes().length).array();
		add(entryInfo);
		
		entryInfo=path.getBytes();
		add(entryInfo);
	}
	
	/**
	 * @param path the path of the file want to convert
	 * @return the relative path to the root folder
	 */
	private String toRelativePath(String path){
		return path.substring(root.length(), path.length());
	}
	
	/**
	 * Get total number of entry
	 * @return size of the entry
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Get sub list of the data
	 * @param off start at this position
	 * @param len get this amount of data
	 * @return a sub list of the data 
	 */
	public byte[] get(int off,int len){
		byte []result =new byte[len];
		for(int i=off;i<len+off;i++) {
			result[i]=data.get(i);
		}
		return result;} {
		
	}
	
	/**
	 * Add all byte in the value to this data
	 * @param value An array of byte data
	 */
	public void add(byte[]value) {
		for(byte b: value) {data.add(b);}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result="";
		for(int i=0;i<data.size();i++) {
			result+=(char)(byte)data.get(i);
		}
		return result;
	}
}
