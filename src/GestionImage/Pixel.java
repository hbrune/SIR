package GestionImage;
/**
 * Write a description of class Pixel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pixel
{

    final int BIT_DEPTH = 8;
    final int MAX_PIXEL_VAL = (int) Math.pow(2,BIT_DEPTH) - 1;
    int value;
    
    public Pixel(int value) {
        if(value < 0) {
            value = 0;
        } else if (value > MAX_PIXEL_VAL) {
            value = MAX_PIXEL_VAL;
        } else {
            this.value = value;
        }
    }
    
    public void setValue(int value) {
        if(value < 0) {
            value = 0;
        } else if (value > MAX_PIXEL_VAL) {
            value = MAX_PIXEL_VAL;
        } else {
            this.value = value;
        }
    }
    
    public int getValue() {
        return value;
    }
    
    public void invertIntensity() {
        value = MAX_PIXEL_VAL - value;
    }
    
    public void logIntensity(double coeff) {
        value = (int) ((int) coeff * Math.log(value+1));
    }
    
    public void powerLawIntensity(double coeff, double gamma) {
        value = (int) (coeff * Math.pow(value, gamma));
    }
}
