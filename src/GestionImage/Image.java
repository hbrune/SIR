package GestionImage; 

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.Scanner;


/**
 * This class represents a single PPM Image and transformations that can be performed
 * over the Image. Currently, the only supported version is P2 (greyscale, ASCII).
 * 
 * @author David
 * @version 04/03/2015
 */
public class Image
{
    int width;
    int height;
    Pixel[][] canvas;

    
    public Image(String filename) {
        this.open(filename);
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Pixel[][] getCanvas() {
        return canvas;
        
    }
    
    public void inverseTranform() {
        for(int i = 0; i < this.height ; i++ ) {
            for(int j = 0; j < this.width ; j++) {
                canvas[i][j].invertIntensity();
            }
        }
    }
    
    public void logTransform(double coeff) {
        for(int i = 0; i < this.height ; i++ ) {
            for(int j = 0; j < this.width ; j++) {
                canvas[i][j].logIntensity(coeff);
            }
        }
    }
    
    public void powerLawTransform(double coeff, double gamma) {
        for(int i = 0; i < this.height ; i++ ) {
            for(int j = 0; j < this.width ; j++) {
                canvas[i][j].powerLawIntensity(coeff, gamma);
            }
        }
    }
    
    public void flipHorizontal() {        
        for (int i = 0; i<height; i++) {
            for (int j = 0; j<width/2; j++) {
                Pixel tmp = canvas[i][j];
                int index =width - j - 1;
                canvas[i][j] = canvas[i][index];
                canvas[i][index] = tmp;
            }
        }  
    }
    
    public void rotateClockwise() {
        Pixel[][] imgRotation = new Pixel[this.width][this.height];
        for (int i=0; i<height; i++)
                {
                    for (int j=0;  j<this.width; j++)
                    {
                        imgRotation[j][this.height-i-1] = canvas[i][j];
                    }
                }
        int tmp = width;
        width = height;
        height = tmp;
        canvas = imgRotation; 
        
    }
    
    /*********************************************
     * 
     * DO NOT EDIT ANYTHING BELOW THIS COMMENT
     * 
     * BUT READ THE METHODS' COMMENTS AND SIGNATURE
     * TO UNDERSTAND HOW TO USE THEM IN YOUR CODE
     * 
     ********************************************/
     
    /**
     * The String representation of this image. The format is:
     * PPM_VERSION
     * width height
     * 255
     * (pixel values)
     * 
     */
    public String toString()
    {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("P2\n");
        strBuffer.append(this.width + " " + this.height + "\n");
        strBuffer.append("255\n");
        for (int i=0 ; i<this.height; i++)
        {
            for (int j=0; j<this.width; j++)
                strBuffer.append(this.canvas[i][j].getValue() + " "); 
            strBuffer.append("\n");
        }
        
        return strBuffer.toString();       
    }
     
    
    /**
     * Open a PPM file and return a 2D array of pixels
     * 
     * @param   filename is a path to the PPM file to be opened
     */
    public void open(String filename)
    {        
        File f = new File(filename);
        try {
            
            //use Scanner on the file for input
            Scanner fileScanner = new Scanner(f);

            //read in PPM version
            //this.PPMversion = fileScanner.nextLine();
            //if (this.PPMversion.equalsIgnoreCase("P2"))
            String PPMversion = fileScanner.nextLine();
            if (PPMversion.equalsIgnoreCase("P2"))
            {
                String line;

                //skip comments (starts with #)
                while ((line = fileScanner.nextLine()).startsWith("#"))
                    ;
                    
                //get and set dimensions
                String[] dim = line.split("\\s");
                this.width = Integer.parseInt(dim[0]);
                this.height = Integer.parseInt(dim[1]);

                //initialize the pixel 2D array
                this.canvas = new Pixel[this.height][this.width];

                //read and discard the maximum pixel value (should be 255)
                fileScanner.nextInt();

                //read in the pixels
                for (int i=0; i<this.height; i++)
                {
                    for (int j=0;  j<this.width; j++)
                    {
                        this.canvas[i][j] = new Pixel(fileScanner.nextInt());
                    }
                }
            }
            else
            {
                System.err.println("PPM version " + PPMversion + " does not support ASCII. Exiting...");
                System.exit(-1);
            }
        }
        catch(IOException e)
        {
            System.err.println("Problem opening: " + filename + ". Exiting...");
            System.exit(-1);
        }
    }

    
    /**
     * Writes contents of current Image into the file specified
     * 
     * @param   filename    The name of file into which to save current image.
     */
    public void save(String filename)
    {
        File f = new File(filename);
        try {
            System.err.println("Saving " + filename + "... ");

            //open file for writing
            PrintWriter fileOut = new PrintWriter(f);

            //get string representation of file and print it out to file
            fileOut.print(this.toString());

            //close out the file
            fileOut.close();
            
            System.err.println("Success!");
        }
        catch(IOException e)
        {
            System.err.println("Problem saving: " + filename + ". Exiting...");
            System.exit(-1);
        }
    }
        
    public ByteArrayOutputStream toJpg() throws IOException {        
        ByteArrayOutputStream myJpg = null;
        BufferedImage image = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = image.getRaster();
        for(int h=0; h < getHeight(); h++)
        {
            for(int w=0; w < getWidth(); w++)
            {
                raster.setSample(w,h,0, canvas[h][w].getValue()); 
            }
        }

        myJpg = new ByteArrayOutputStream();
        javax.imageio.ImageIO.write(image, "jpg", myJpg);

        return myJpg;
    }
    
}
