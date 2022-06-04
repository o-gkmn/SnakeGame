
package com.snakegame.Staff;

import java.util.Random;
/**
 *
 * @author Özgür
 */
public final class Food{
    private final int WIDHT = 10;
    private final int HEIGHT = 10;
    private final int RAND_POS = 29;
    private final int DOT_SIZE = 10;
    private int apple_x;
    private int apple_y;
    private Random rand = new Random(); // Random sayı üretmek için kullanılacak
    
    public Food() {        
        locateApple();
    }
    
    public void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    public int getApple_x() {
        return apple_x;
    }

    public void setApple_x(int apple_x) {
        this.apple_x = apple_x;
    }

    public int getApple_y() {
        return apple_y;
    }

    public void setApple_y(int apple_y) {
        this.apple_y = apple_y;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }
    
    public int getWIDHT() {
        return WIDHT;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
    
}
