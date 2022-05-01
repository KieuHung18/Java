package neural_model;


public class Function {
	double deltaC[][],deltaA[],deltaB[];
	public Function() {
		// TODO Auto-generated constructor stub
	}
	public Function(int row,int col) {
		deltaC=new double[row][col];
		deltaB=new double[row];
		deltaA=new double[col];
	}
	public Function(double[][]weight) {
		deltaC=new double[weight.length][weight[0].length];
		deltaA=new double[weight[0].length];
		deltaB=new double[weight.length];
	}
	public void updateWeight(double[][]weight,double[]preActivation,double[]nextActivation) {
		for(int w=0;w<weight.length;w++) {
			for(int pa=0;pa<preActivation.length;pa++) {
				deltaC[w][pa]+=adjust(preActivation[pa],nextActivation[w],zfunc(weight[w],preActivation));
			}
		}
	}
//	public void updateBias(double[][]weight,double[]preActivation,double[]nextActivation) {
//		for(int b=0;b<bias.length;b++) {
//				deltaB[b]+=adjust(1,nextActivation[b],zfunc(weight[b],preActivation));}
//	}
	public void updateActivation(double[][]weight,double[]preActivation,double[]nextActivation) {
		for(int pa=0;pa<preActivation.length;pa++) {
			for(int na=0;na<nextActivation.length;na++) {
				deltaA[pa]+=adjust(weight[na][pa], nextActivation[na], zfunc(weight[na],preActivation));
			}
		}
	}
	public double adjust(double derivative,double nextActivation, double zl) {
		return sigmoidfunc(zl)*(1-sigmoidfunc(zl))*derivative*2*(sigmoidfunc(zl)-nextActivation);
	}
	public double zfunc(double w[],double[]a) {
		double result=0;
		for(int i=0;i<w.length;i++) {
			result+=w[i]*a[i];
		}
		return result;
		}
	public double sigmoidfunc(double zl) {
		return 1/(1+Math.pow(Math.E, -zl));
	}
	
	public double cost(double [] activation,double [] nextActivation) {
		double result=0.0;
		for(int i=0;i<activation.length;i++) {
			result +=Math.pow(activation[i]-nextActivation[i], 2);
		}
		return result;
	}
	public double[] process(Layer arg0){
		double[]result=new double[arg0.getWeights().length];
		for(int i=0;i<result.length;i++) {
			result[i]=sigmoidfunc(zfunc(arg0.getWeights()[i],arg0.getActivation()));
		}
		return result;
		
	}
	public double[][] getDeltaC() {
		return deltaC;
	}
	public double[] getDeltaB() {
		return deltaB;
	}
	public double[] getDeltaA() {
		return deltaA;
	}
	
	
	
	
	
//	public double costFunc(double[]output,double [] goodData){
//		double result=0;
//		for(int i=0;i<output.length;i++) {
//			result+=Math.sqrt((output[i]-goodData[i]));
//		}
//		return result;
//	}
//	
//	
//	
//	public double sigmoidFunc(double[]weight,double[]activation,double bias) {
//		double result=0;
//		for(int i=0;i<activation.length;i++) {
//			result+=weight[i]*activation[i];
//		}result+=bias;
//		return 1/(1+Math.pow(Math.E, -result));
//	}
}
