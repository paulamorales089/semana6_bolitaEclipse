package model;

public class enviandoDatitos {
    private String seņalesMoviento;
    private int r,g,b;
    private int movimientoPixel;

    public enviandoDatitos() {


    }

    public enviandoDatitos(String seņalesMoviento, int r, int g, int b, int movimientoPixel) {
        this.seņalesMoviento = seņalesMoviento;
        this.r = r;
        this.g = g;
        this.b = b;
        this.movimientoPixel = movimientoPixel;
    }

    public String getSeņalesMoviento() {
        return seņalesMoviento;
    }

    public void setSeņalesMoviento(String seņalesMoviento) {
        this.seņalesMoviento = seņalesMoviento;
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
