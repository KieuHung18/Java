package JavaIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Stack;

import javax.annotation.processing.FilerException;

public class FileProcessing {
	
	//NOTE: All these task assume that your file have less than 2^31 bytes
	
	/**
	 * Copy data from source file to destination file
	 * @param sFile Source file path 
	 * @param destFile Destination file path
	 * @param moved Delete the source file if this is true
	 * @throws IOException
	 */
	public void fileCopy(String sFile, String destFile, boolean moved) throws IOException{
		File source =new File(sFile);
		byte[]array=new byte[(int)source.length()];
		FileInputStream fis =new FileInputStream(source);
		BufferedInputStream bis =new BufferedInputStream(fis);
		bis.read(array);
		bis.close();
		fis.close();
		
		File destination =new File(destFile);
		if(!destination.exists()) {
			destination.createNewFile();
		}
		FileOutputStream fos =new FileOutputStream(destination);
		BufferedOutputStream bos =new BufferedOutputStream(fos);
		bos.write(array);
		bos.close();
		fos.close();
		if(moved) {source.delete();}
	}
	
	/**
	 * copy all data from the source folder to the destination folder, create new destination folder if not yet exists
	 * @param sPath Source folder path
	 * @param destPath Destination folder path
	 * @param moved  Delete the source file if this is true
	 * @throws IOException
	 */
	public void folderCopy(String sPath, String destPath, boolean moved) throws IOException{
		File source =new File(sPath);
		File destination =new File(destPath);
		
		if(source.isFile()) {
			fileCopy(sPath, destPath, moved);
		}
		
		if(source.isDirectory()) {
			if(!destination.exists()) {
				destination.mkdir();
			}
			for(File f: source.listFiles()) {
				folderCopy(f.getAbsolutePath(), destPath.concat("\\"+f.getName()), moved);
			}
		}
	}
	
	/**
	 * Split specific file to couple component file which have size=size(Byte).
	 * Each component file will be mark with a spl extension use to join later
	 * @param path Path of the file want to split 
	 * @param size the size of those component file after split
	 * @param delete Delete the original file after split
	 * @throws IOException
	 */
	 public void spliter(String path, int size,boolean delete) throws IOException {
		File file =new File(path);
	 	byte[]array=new byte[(int)file.length()];
		FileInputStream fis =new FileInputStream(file);
		BufferedInputStream bis =new BufferedInputStream(fis);
		bis.read(array);
		bis.close();
		fis.close();
		
		File destination;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		int part =(int) (file.length()/size);
		int rest= (int) (file.length()-part*size);
		
		for(int i=0;i<file.length();i+=size) {
			destination=new File(file.getAbsolutePath().concat("_spl"+String.valueOf((i+size)/size)));
			destination.createNewFile();
			fos =new FileOutputStream(destination);
			bos =new BufferedOutputStream(fos);
			if(i<part*size) {
				bos.write(array, i, size);}
			else {
				bos.write(array, part*size, rest);
			}
			bos.close();
			fos.close();
		}
		
		
		if(delete) {file.delete();}
	 }
	 
	 /**
	  * Filter out all the file end with spl extension
	  * @return FileFilter 
	  */
	 public FileFilter getSplFilter() {
		 return new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if(pathname.isFile()) {
					String name[]=pathname.getName().split("_");
					if(name[name.length-1].contains("spl")) {
						return true;
					}
				}
				return false;
			}
		};
	 }
	 
	 //this method also use to join file for the task "create method pack" below
	 /**
	  * Join the every file within the exactly folder base on the filter.
	  * Child folder dosen't count
	  * @param path Path of folder have contain the component file 
	  * @param dest Path of the new file after join. If this file already exists
	  * 		it will continue append to the end of the file
	  * @param delete Delete all component file after join
	  * @param filter If filter = null this method will join all file 
	 * @throws IOException 
	  */
	 public void joiner(String path,String dest,FileFilter filter,boolean delete) throws IOException {
		File dir =new File(path);
		if(!dir.isDirectory()) {throw new FilerException(dir.getName()+" is not directory");}
		File[]listFile;
		if(filter==null) {
			listFile=dir.listFiles(isFile());
		}else
		{
			listFile=dir.listFiles(filter);
		}
		
		int fileLength=0;
		for(File f:listFile) {
			fileLength+=(int)f.length();
		}
		
		byte[]array=new byte[fileLength];
		FileInputStream fis;
		BufferedInputStream bis;
		int pointer=0;
		for(File f:listFile) {
			fis =new FileInputStream(f);
			bis =new BufferedInputStream(fis);
			bis.read(array, pointer, (int) f.length());
			pointer+=(int) f.length();
			bis.close();
			fis.close();
		}
		
		File destination =new File(dest);
		FileOutputStream fos;
		if(!destination.exists()) {
			destination.createNewFile();
			fos =new FileOutputStream(destination);
		}else {
			fos =new FileOutputStream(destination,true);
		}
		
		BufferedOutputStream bos =new BufferedOutputStream(fos);
		bos.write(array);
		bos.close();
		fos.close();
		 if(delete){
			 for(File f:listFile) {
				 f.delete();
			 }
		 }
	 }
	 
	 /**
	  * filter out all the file in the exact folder. Child file dosen't count
	  * @return File filter
	  */
	 private FileFilter isFile() {
		 return new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if(pathname.isFile()) {return true;}
				return false;
			}
		};
	 }
	 
	 
	 /*Work like .zip but not compress
	  * It will write all the data of the file in the specific folder to one single file and add a Directory entry at the end of the file.
	  * The position where Directory entry start storing at 8 last bytes of the .pack file
	  * The Directory file(a byte array to be exact) will contain all the relative path of those file and theirs position in the .pack file. 
	  * More detail at DirectoryEntry class
	 */
	 /**
	  * Write data of every file in this folder in to one file. New file name = (folder name) + .pack
	  * Location of the new .pack file will be same level with the folder
	  * @param path The path to the  folder want to pack
	  * @throws IOException
	  */
	 public void pack(String path) throws IOException {
		File file = new File(path);
		if(!file.isDirectory()) {throw new FilerException(file.getName()+" is not directory");}
		String dest= file.getParent().concat("\\"+file.getName()+".pack");
		DirectoryEntry entry =new DirectoryEntry(file.getParent());
		
		Stack<File> stack = new  Stack<>();
		File[] listFile = null;
		stack.add(file);
		long pos=0;
		
		while(!stack.isEmpty()) {
			file = stack.pop();
			joiner(file.getAbsolutePath(), dest, null, false);
			listFile =file.listFiles();
			for(File f: listFile) {
				if(f.isDirectory()) {
					stack.push(f);
				}
				if(f.isFile()) {
					entry.writeEntry(f.getAbsolutePath(),pos);
					pos+=f.length();
				}
			}
		}
		
		FileOutputStream fos =new FileOutputStream(dest,true);
		entry.add(ByteBuffer.allocate(8).putLong(pos).array());
		fos.write(entry.get(0, entry.size()));
		fos.close();
	 }
	 
	 
	 /*
	  * byteInt used to storage the bytes of pathLength
	  * 	pathLength: storage the length of the relative path to the file
	  * 
	  * byteLong used to storage the bytes position
	  * 	position: storage the position where the file begin in the .pack file)
	  * 	nextPosition: storage the position where the next file begin in the .pack file)
	  * 
	  * byteString used to storage the bytes the filePath
	  * 	filePath: storage the relative path of the file
	  * 
	  * byteData: used to storage the bytes data of the file
	  * 
	  * It will read the end of the file which is at file.length-8 and return the position where Directory Entry file start 
	  *	Then it will seek to that position read 8 bytes and assign it to the position (now we have the position of the first file)
	  *	The while clause will: 
	  *		First read the 4 bytes and assign it to the pathLength (now we have the length of the relative path 
	  *		of the first file).
	  *		Then it will read (pathLength) bytes and assign it to the filePath(now we have the file relative path).
	  *		Then it will read more 8 bytes and assign it to the nextPosition (now we have the position where the next file will start or
	  *		where this file should stop reading). 
 	  *		Now we have everything so we reassign DirectoryEntry to DirectoryEntry+=(4+pathLength+8)
 	  *														(4 bytes (integer) pathLength + pathLength bytes + 8 bytes (long) position )
	  * 	
	  * 	Done with reading now to the writing	
	  * 	seek to position(first byte of the file start at) read to nextPosition assign to byteData
	  * 	create new file and it parent folder write the byteData array to it, close it
	  * 	seek back to DirectoryEntry assign position=nextPosition
	  * (loop until End)Done. 
	  */
	 /**
	  * unpack the .pack file to specific destination folder
	  * @param filePath The path of the.pack file
	  * @param dest Destination folder to unpack
	  * @throws IOException
	  */
	 public void unpack(String path,String dest) throws IOException {
		File file = new File(path);
		byte[]  byteLong=new byte[8],
				byteInt=new byte[4],
				byteString,
				byteData;
		RandomAccessFile reader =new RandomAccessFile(file, "r");
		RandomAccessFile writer;
		
		reader.seek(file.length()-8);
		reader.readFully(byteLong);
		
		long DirectoryEntry=ByteBuffer.allocate(8).put(byteLong).flip().getLong();
		int pathLength;
		long position;
		long nextPosition;
		String filePath;
		reader.seek(DirectoryEntry);
		reader.readFully(byteLong, 0, 8);
		position=ByteBuffer.allocate(8).put(byteLong).flip().getLong();
		DirectoryEntry+=8;
		while(reader.getFilePointer()!=file.length()) {
			reader.readFully(byteInt, 0, 4);
			pathLength=ByteBuffer.allocate(4).put(byteInt).flip().getInt();
			
			byteString =new byte[pathLength];
			reader.read(byteString, 0, pathLength);
			filePath=new String(byteString);
			
			reader.readFully(byteLong, 0, 8);
			nextPosition=ByteBuffer.allocate(8).put(byteLong).flip().getLong();
			
			DirectoryEntry+=(4+pathLength+8);
			
			reader.seek(position);
			
			byteData=new byte[(int) (nextPosition-position)];
			reader.read(byteData, 0, (int) (nextPosition-position));
			
			File destination=new File(dest+filePath);
			if(!destination.getParentFile().exists()) {
				destination.getParentFile().mkdirs();
			}
			destination.createNewFile();
			writer=new RandomAccessFile(destination, "rw");
			writer.write(byteData);
			writer.close();
			reader.seek(DirectoryEntry);
			position=nextPosition;
		}
		reader.close();
	 }
}
