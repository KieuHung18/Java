package neural_model;

import java.util.HashMap;
import java.util.Random;

import object.DataBase;

public class WorkSpace {
	DataBase dataBase=new DataBase();
	HashMap<Integer, double[]>dataBatch=new HashMap<>();
	Layer tmp;
	Layer layer1,layer2;
	double []input;
	boolean active=false;
	public WorkSpace(int row, int col) {
	input =new double[col*row];
		for(int tmp=0;tmp<input.length;tmp++) {
		input[tmp]=0;
		}
		layer1=new Layer(null, dataBase.getWeight(DataBase.WEIGHT_1));
		layer2=new Layer(null, dataBase.getWeight(DataBase.WEIGHT_2));
	}
	
	public void process(int data,int timeRun) {
		dataBase.loadData(data);
		double [][]pixel=dataBase.getPixel();
		int[]lable=dataBase.getLabel();
		int k=0;int goodData=0;
		
		int dataBacth=100;double learnRate = 200;
		
		for(int n=0;n<timeRun;n++) {
		int r=new Random().nextInt((data/dataBacth));
		double result=0;
		for(k=0;k<pixel.length;k++){
			layer1.setActivation(pixel[k]);goodData=lable[k];
			layer2.setActivation(layer1.process());
			result+=layer2.cost(new GoodData().get(goodData));
			}System.out.println(result/k);
			
			
			for(k=r*dataBacth;k<(r+1)*dataBacth;k++){
			layer1.setActivation(pixel[k]);goodData=lable[k];
			layer2.setActivation(layer1.process());
			layer2.updateActivation(new GoodData().get(goodData));
			layer1.updateWeight(layer2.backpropagation(learnRate,100));
			}
			layer1.save(dataBacth);dataBase.setWeight(layer1.getWeights(), DataBase.WEIGHT_1);

			

			for(k=r*dataBacth;k<(r+1)*dataBacth;k++){
			layer1.setActivation(pixel[k]);goodData=lable[k];
			layer2.setActivation(layer1.process());
			layer2.updateWeight(new GoodData().get(goodData));
			}
			layer2.save(dataBacth);dataBase.setWeight(layer2.getWeights(), DataBase.WEIGHT_2);
			}
		}
	public String test(int data) {
		dataBase.loadDatatk(data);
		double [][]pixel=dataBase.getTkpixel();
		int[]lable=dataBase.getTklabel();
		int k=0;int goodData=0;int identify=0;int wrong=0;double result=0;
		for(k=0;k<pixel.length;k++){
			goodData=lable[k];identify=identify(pixel[k]);
//			System.out.println("label: "+goodData);
//			System.out.println("identify: "+identify);
			if(goodData!=identify) {wrong++;}
//			System.out.println("............................");
		}
		result=((data-wrong)*100)/data;
		return String.valueOf(result)+"%";
		
	}
	public int identify(double [] activation) {
		double max=0;int result=0;int i=0;
		layer1.setActivation(activation);
		layer2.setActivation(layer1.process());
		for(double d:layer2.process()) {if(d>max) {max=d;result=i;}
		i++;}
		return result;
	}
	public void reset() {
		for(int tmp=0;tmp<input.length;tmp++) {
			input[tmp]=0;
		}
	};
	public void updateActivation(int x,int y,int col,int size) {double color=0.2;
		input[y/size*col+x/size]=1;
		if((input[(y/size-1)*col+x/size]+color)<1) {input[(y/size-1)*col+x/size]+=color;}
		if((input[(y/size+1)*col+x/size]+color)<1) {input[(y/size+1)*col+x/size]+=color;}
		if((input[y/size*col+x/size+1]+color)<1) {input[y/size*col+x/size+1]+=color;}
		if((input[y/size*col+x/size-1]+color)<1) {input[y/size*col+x/size-1]+=color;}
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}
	public double[] getInput() {
		return input;
	}
	public DataBase getDataBase() {
		return dataBase;
	}
}
