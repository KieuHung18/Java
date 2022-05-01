
package neural_model;


public class Layer {
private double[] activation;
private double[][]weights;
double deltaC[][],deltaA[];
public Layer(double[] activation, double[][] weights) {
	this.activation = activation;
	this.weights = weights;
	deltaC=new double[weights.length][weights[0].length];
	deltaA=new double[weights[0].length];
}
public double[] getActivation() {
	return activation;
}
public void setActivation(double[] activation) {
	this.activation = activation;
}
public double[][] getWeights() {
	return weights;
}
public void setWeights(double[][] weight) {
	this.weights = weight;
}
public void updateWeight(double[]nextActivation) {
	for(int w=0;w<weights.length;w++) {
		for(int pa=0;pa<activation.length;pa++) {
			deltaC[w][pa]+=adjust(activation[pa],nextActivation[w],zfunc(weights[w],activation));
		}
	}
}
public double[] backpropagation (double LearnRate,int k) {
	for(int i=0;i<activation.length;i++) { 
		activation[i]-=LearnRate*(deltaA[i]/k);
	}
	deltaA=new double[this.weights[0].length];
	return activation;
	
}
public void updateActivation(double[]nextActivation) {
	for(int i=0;i<activation.length;i++) {
		for(int j=0;j<nextActivation.length;j++) {
			deltaA[i]+=adjust(weights[j][i], nextActivation[j], zfunc(weights[j], activation));
		}
	}
}
public void save(int k) {
	for(int i=0;i<deltaC.length;i++) {
		for(int j=0;j<deltaC[0].length;j++) {
				weights[i][j]-=deltaC[i][j]/k;
		}
	}
	deltaA=new double[this.weights[0].length];
	deltaC=new double[this.weights.length][this.weights[0].length];
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
public double cost(double [] nextActivation) {
	double result=0.0;double [] activation=process();
	for(int i=0;i<activation.length;i++) {
		result +=Math.pow(activation[i]-nextActivation[i], 2);
	}
	return result;
}
public double[] process(){
	double[]result=new double[weights.length];
	for(int i=0;i<result.length;i++) {
		result[i]=sigmoidfunc(zfunc(weights[i],activation));
	}
	return result;
	
}
public double[][] getDeltaC() {
	return deltaC;
}
public double[] getDeltaA() {
	return deltaA;
}
}
