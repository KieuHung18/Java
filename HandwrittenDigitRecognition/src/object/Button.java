package object;

public class Button {
private String name;
private int x,y,w,h;
public Button(String name, int x, int y, int w, int h) {
	super();
	this.name = name;
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public int getW() {
	return w;
}
public void setW(int w) {
	this.w = w;
}
public int getH() {
	return h;
}
public void setH(int h) {
	this.h = h;
}

}
