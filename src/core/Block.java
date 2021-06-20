package core;

import util.Util;

import java.util.ArrayList;

public class Block {
    private int blockID;
    private int nonce;
    private ArrayList<Transaction> transactionList;
    private String prevBlockHash;

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public ArrayList<Transaction> getData() {
        return transactionList;
    }

    public void setData(ArrayList<Transaction> data) {
        this.transactionList = transactionList;
    }

    public String getPrevBlockHash() { return prevBlockHash; }

    public void setPrevBlockHash(String prevBlockHash) { this.prevBlockHash = prevBlockHash; }

    public Block(int blockID, int nonce, ArrayList<Transaction> transactionList, String prevBlockHash) {
        this.blockID = blockID;
        this.nonce = nonce;
        this.transactionList = transactionList;
        this.prevBlockHash = prevBlockHash;
    }

    public void printInformation() {
        System.out.println("=========");
        System.out.println("BlockID: " + blockID);
        System.out.println("Previous Block hash: " + prevBlockHash);
        System.out.println("Nonce: " + nonce);
        System.out.println("Transactions: " + transactionList.size());
        for(int i = 0; i < transactionList.size(); i++)
            System.out.println(transactionList.get(i).getInformation());
        System.out.println("Block hash: " + getBlockHash());
        System.out.println("=========");
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public String getBlockHash() {
        String transactionInfo = "";
        for (int i = 0; i < transactionList.size(); i++)
            transactionInfo += transactionList.get(i).getInformation();
        return Util.getHash(nonce + transactionInfo + prevBlockHash);
    }

    public void mine() {
        while (true) {
            if (getBlockHash().substring(0, 4).equals("0000")) {
                System.out.println("Mining finished: " + blockID);
                break;
            }
            nonce++;
        }
    }
}
