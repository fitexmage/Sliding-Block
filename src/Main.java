/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fitexmage
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Block main = new Block(new int[]{0, 3}, 0, 2);
        Block b1 = new Block(new int[]{0, 0}, 0, 2);
        Block b2 = new Block(new int[]{0, 2}, 0, 2);
        Block b3 = new Block(new int[]{0, 4}, 1, 2);
        Block b4 = new Block(new int[]{1, 4}, 0, 2);
        Block b5 = new Block(new int[]{2, 2}, 1, 2);
        Block b6 = new Block(new int[]{3, 0}, 0, 2);
        Block b7 = new Block(new int[]{3, 1}, 1, 2);
        Block b8 = new Block(new int[]{3, 3}, 1, 2);
        Block b9 = new Block(new int[]{4, 1}, 0, 2);
        Block b10 = new Block(new int[]{1, 5}, 0, 3);
        Block b11 = new Block(new int[]{5, 2}, 1, 3);
        
        Block[] blockList = {main, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11};
        SlidingBlock solution = new SlidingBlock(blockList);
    }
}
