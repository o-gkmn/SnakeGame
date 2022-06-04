
package com.snakegame;

import com.snakegame.Staff.Food;
import com.snakegame.Staff.Snake;
import com.snakegame.Staff.Staff;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Özgür
 */
public class Game{
    
    public Game(){
        start();
    }
    
    public void start(){
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        
        Snake snake = new Snake();
        Food food = new Food();
        Staff staff = new Staff(snake, food);
        
        frame.getContentPane().add(staff);
        frame.pack();
        frame.setSize(new Dimension(300,300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    

}
