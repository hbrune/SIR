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
    
    /**
    *Créer un nouveau pixel
    *@param value : valeur du pixel
    */
    public Pixel(int value) {
        if(value < 0) {
            value = 0;
        } else if (value > MAX_PIXEL_VAL) {
            value = MAX_PIXEL_VAL;
        } else {
            this.value = value;
        }
    }
    
    /**
    *Modifier la valeur du pixel
    *@param value : valeur du pixel que l'on veut mettre
    */
    public void setValue(int value) {
        if(value < 0) {
            value = 0;
        } else if (value > MAX_PIXEL_VAL) {
            value = MAX_PIXEL_VAL;
        } else {
            this.value = value;
        }
    }
    
    /**
    *Récupérer la valeur du pixel
    *@return : valeur du pixel
    */
    public int getValue() {
        return value;
    }
    
    /**
    *Inverser niveau de gris du pixel
    */
    public void invertIntensity() {
        value = MAX_PIXEL_VAL - value;
    }
    
}
