package model;

public class enviandoDatitos {
    private String se�alesMoviento;
    private int r,g,b;
    private int movimientoPixel;

    public enviandoDatitos() {


    }

    public enviandoDatitos(String se�alesMoviento, int r, int g, int b, int movimientoPixel) {
        this.se�alesMoviento = se�alesMoviento;
        this.r = r;
        this.g = g;
        this.b = b;
        this.movimientoPixel = movimientoPixel;
    }

    public String getSe�alesMoviento() {
        return se�alesMoviento;
    }

    public void setSe�alesMoviento(String se�alesMoviento) {
        this.se�alesMoviento = se�alesMoviento;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getMovimientoPixel() {
        return movimientoPixel;
    }

    public void setMovimientoPixel(int movimientoPixel) {
        this.movimientoPixel = movimientoPixel;
    }
}
