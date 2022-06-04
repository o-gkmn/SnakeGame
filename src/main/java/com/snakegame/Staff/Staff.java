
package com.snakegame.Staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Özgür
 */
public class Staff extends JPanel implements ActionListener{
    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;    
    private final int DELAY = 140;
    private boolean inGame = true;    
    private int puan = 0;
    private int foodCounter = 0;
    private Snake snake;
    private Food food;
    private Timer timer;
    
    public Staff(){

    }
    
    public Staff(Snake snake, Food food){
        this.snake = snake;
        this.food = food;
        
        this.setSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        addKeyListener(snake);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        initGame();
    }
    private void initGame() {

        snake.setDots(3);

        for (int z = 0; z < snake.getDots(); z++) {
            snake.getX()[z] = 50 - z * 10;
            snake.getY()[z] = 50;
        }
        
        food.locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);        
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {
            g.setColor(Color.BLACK);
            g.fillOval(food.getApple_x(), food.getApple_y(), food.getWIDHT(), food.getHEIGHT());
            
            for (int z = 0; z < snake.getDots(); z++) {
                if (z == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(snake.getX()[z], snake.getY()[z], snake.getWIDHT(), snake.getHEIGHT());
                } else {
                    g.fillRect(snake.getX()[z], snake.getY()[z], snake.getWIDHT(), snake.getHEIGHT());
                }
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }        
    }    
    
    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.RED);
        g.setFont(small);
        g.drawString(msg, (300 - metr.stringWidth(msg)) / 2, 300 / 2);
    }
    
    private void checkApple() {

        if ((snake.getX()[0] == food.getApple_x()) && (snake.getY()[0] == food.getApple_y())) {

            snake.setDots(snake.getDots() + 1);;
            food.locateApple();
        }
    }
    
    private void checkCollision() {

        for (int z = snake.getDots(); z > 0; z--) {

            if ((z > 4) && (snake.getX()[0] == snake.getX()[z]) && (snake.getY()[0] == snake.getY()[z])) {
                inGame = false;
            }
        }
        if (snake.getY()[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (snake.getY()[0] < 0) {
            inGame = false;
        }

        if (snake.getX()[0] >= B_WIDTH) {
            inGame = false;
        }

        if (snake.getX()[0] < 0) {
            inGame = false;
        }
        
        if (!inGame) {
            timer.stop();
        }        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {

            checkApple();
            checkCollision();
            snake.move();
        }

        repaint();
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getFoodCounter() {
        return foodCounter;
    }

    public void setFoodCounter(int foodCounter) {
        this.foodCounter = foodCounter;
    }

}
