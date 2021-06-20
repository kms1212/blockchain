package main;

import core.Block;
import core.Transaction;
import util.Util;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Block block1 = new Block(1, 0, new ArrayList<>(), null);
        block1.mine();
        block1.printInformation();

        Block block2 = new Block(2, 0, new ArrayList<>(), block1.getBlockHash());
        block2.addTransaction(new Transaction("sen1", "rec1", 1.44));
        block2.addTransaction(new Transaction("sen2", "rec2", 4.4212));
        block2.mine();
        block2.printInformation();

        Block block3 = new Block(3, 0, new ArrayList<>(), block2.getBlockHash());
        block3.addTransaction(new Transaction("sen1", "rec3", 44));
        block3.addTransaction(new Transaction("sen3", "rec2", 255.3));
        block3.mine();
        block3.printInformation();
    }
}