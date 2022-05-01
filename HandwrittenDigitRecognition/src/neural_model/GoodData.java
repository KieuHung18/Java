package neural_model;

public class GoodData {
	public static final double[]zero={1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	public static final double[]one={0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	public static final double[]two={0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	public static final double[]three={0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0,0.0};
	public static final double[]four={0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0,0.0};
	public static final double[]five={0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0,0.0};
	public static final double[]six={0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0,0.0};
	public static final double[]seven={0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0,0.0};
	public static final double[]eight={0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0,0.0};
	public static final double[]nine={0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,1.0};
	public double[] get(int index) {
		double []result;
		switch (index) {
		case 0:
			result= zero;
			break;
		case 1:
			result= one;
			break;
		case 2:
			result= two;
			break;
		case 3:
			result= three;
			break;
		case 4:
			result= four;
			break;
		case 5:
			result= five;
			break;
		case 6:
			result= six;
			break;
		case 7:
			result= seven;
			break;
		case 8:
			result= eight;
			break;
		case 9:
			result= nine;
			break;
		default:
			result= null;
			break;
		}
		return result;
	}
}
