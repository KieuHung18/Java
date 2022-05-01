package JavaFile;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FileManagement {
	public boolean exists(File file) {
		return file.exists();
	}
	
	public boolean exists(String path) {
		return new File(path).exists();
	}
	
	public boolean deleteFile(File file) {
		if(file.isDirectory()) {return false;}
		return file.delete();
	}
	
	public boolean deleteFile(String path) {
		File file =new File(path);
		if(file.isDirectory()) {return false;}
		return file.delete();
	}
	
	//without recursion
	/**
	 * Delete every file in this directory leave empty directory structure
	 * @param path
	 * @return true if all file successfully delete, false otherwise
	 */
	public boolean clearDirectory(String directory) {
		File dir = new File(directory);
		if(!dir.isDirectory()) {return deleteFile(dir);}
		Stack<File> stack = new Stack<File>();
		File []listFile;
		stack.push(dir);
		boolean tracking = true;
		while(!stack.isEmpty()) {
			dir = stack.pop();
			if(dir.isDirectory()) {
				listFile=dir.listFiles();
				for(File f: listFile) {stack.push(f);}
			}
			else {
				if(!deleteFile(dir)) {tracking=false;}
			}
		}
		return tracking;
	}
	
	//with recursion
	/**
	 * Delete this directory every thing in this directory even empty folder,
	 * if any file can't be delete it will leave the structure folder to that file
	 * @param path
	 * @return true if all file and folder successfully delete, false otherwise
	 */
	public boolean deleteDirectory(String directory) {
		File dir =new File(directory);
		File[] listFiles=dir.listFiles();
		for(File f:dir.listFiles()) {
			if(f.isDirectory()) {
				deleteDirectory(f.getAbsolutePath());
			}
			if(f.isFile()) {
				deleteFile(f);
			}
		}
		return dir.delete();
	}
	
	
	//requirement of this task is must use FileFilter
	/**
	 * search every file and within the given directory and return it if the name of the file contain "name" 
	 * @param name : name of the file/folder or part of the name
	 * @param ParentDirPath: path of the directory want to search
	 * @return list of the file base on the "name", return null if can not find any
	 */
	public File[] find(String directory,String name) {
		File path = new File(directory);
		if(!path.isDirectory()) {return null;}
		
		File[] listFile = null;
		Stack<File> stack = new Stack<File>();
		Queue<File> result = new  LinkedList<File>();
		stack.push(path);
		while(!stack.isEmpty()) {
			path = stack.pop();
			listFile=path.listFiles(new Filter(name));
			if(listFile!=null) {
				for(File f: listFile) {result.add(f);}
			}
			
			listFile=path.listFiles();
			for(File f: listFile) {
				if(f.isDirectory()) {
					stack.push(f);
				}
			}
		}
		listFile=new File[result.size()];
		int i=0;
		while(!result.isEmpty()) {
			listFile[i]=result.poll();
			i++;
		}
		return listFile;
	}
	
	// with recursion
	/**
	 * Print the tree structure of given  directory "-" is file, "+" is folder
	 * @param directory: directory want to print
	 */
	public void dirTree(String directory) {
		File dir =new File(directory);
		recursion(dir,"");
	}
	/**
	 * call recursion to print
	 * @param path: path of the folder
	 * @param level: space out to visualize file level
	 */
	private void recursion(File path,String level) {
		String lv=level;
		if(path.isFile()) {
			System.out.println(level+"|- "+path.getName()+": ");
		}
		if(path.isDirectory()) {
			System.out.println(level+"|+ "+path.getName()+": ");
			lv+=" ";
			for(File f: path.listFiles()) {
				recursion(f, lv);
			}
		}
	}
	
	// without recursion
	/**
	 * Print the tree structure of given directory with name of file/folder and size.
	 *  "-" is file, "+" is folder
	 * @param directory: directory want to print
	 */
	public void dirStat(String directory) {
		File dir =new File(directory);
		Stack<File> stack = new  Stack<File>();
		File[] listFile = null;
		stack.push(dir);
		while(!stack.isEmpty()) {
			dir = stack.pop();
			if(dir.isFile()){
				System.out.println(level(directory,dir.getAbsolutePath())
									+"|- "
									+dir.getName()+" Size: "
									+dir.length()+" Byte");
			}
			if(dir.isDirectory()) {
				System.out.println(level(directory,dir.getAbsolutePath())
									+"|+ "
									+dir.getName()
									+" Size: "+Size(dir.getAbsolutePath())+" Byte");
				listFile =dir.listFiles();
				for(File f: listFile) {
					stack.push(f);
				}
			}
		}
		
	}
	
	/**
	 * calculate the level of the child compare to the parent 
	 * @param parent: upper level folder path
	 * @param child lower level folder path 
	 * @return " " for each level use to space out to visualize file level
	 */
	private String level(String parent,String child) {
		int lv=child.split("\\\\").length-parent.split("\\\\").length;
		String result="";
		for(int i=0;i<lv;i++) {
			result+=" ";
		}
		return result;
	}
	
	/** 
	 * Calculate Byte size of the specific directory
	 * @param directory  want to calculate
	 * @return Byte size of the directory
	 */
	public long Size (String directory) {
		File dir = new File(directory);
		long size=0;
		Stack<File> stack = new Stack<File>();
		File []listFile;
		stack.push(dir);
		while(!stack.isEmpty()) {
			if(dir.isDirectory()) {
				listFile=dir.listFiles();
				for(File f: listFile) {stack.push(f);}
			}
			else {
				size+=dir.length();
			}
			dir = stack.pop();
		}
		return size;
	}
}
