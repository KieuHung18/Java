package generic;

public class Score {
	private Pair<String, Double>[] listScore;
	public Score(Pair<String, Double>[] listScore) {
		this.listScore = listScore;
	}
	public void saveScore(String name,double score) {
		Pair<String, Double>[] tmp=this.listScore;
		listScore=(Pair<String,Double>[])new Pair[listScore.length+1];
			for(int i=0;i<tmp.length;i++) {
				listScore[i]=tmp[i];
			}
		listScore[listScore.length-1]=new Pair<String, Double>(name, score);
	}
	public Pair<String,Double> maxScore() {
		Pair<String, Double> max=listScore[0];
		for(int i=1;i<listScore.length;i++) {
			if(listScore[i].getSecond()>max.getSecond()) {max=listScore[i];}
		}
		return max;
	}
	public Pair<String,Double> maxScoreEx(int[] exceptIndex) {
		Pair<String, Double> max=listScore[0];
		for(int i=1;i<listScore.length;i++) {
			for(int ei:exceptIndex) {
				if(listScore[i].getSecond()>max.getSecond()&&i!=ei) {max=listScore[i];
				}
			}
		}
		return max;
	}
	public Pair<String, Double>[] topTenScore(int numberOfScore) {
		Pair<String, Double>[] topScore=(Pair<String,Double>[])new Pair[numberOfScore];
		int[]checked=new int[numberOfScore];
		double max=listScore[0].getSecond();int count=0;
		while(count<numberOfScore) {
		for(int i=1;i<listScore.length;i++) {
			for(int c:checked) {
				if(i!=c&&listScore[i].getSecond()>=max) {
					max=listScore[i].getSecond();
					}
			}checked[count]=i;count++;
		}max=0;
		}
		return topScore;
	}
	public Pair<String, Double>[] getListScore() {
		return listScore;
	}
public static void main(String[] args) {
}
}
