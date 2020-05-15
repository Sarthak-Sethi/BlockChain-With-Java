package com.sarthak;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {		 	
	private List<Block> blockchain;
	public BlockChain() {
		blockchain = new ArrayList<>();
		blockchain.add(generateblock());
	}

	private Block generateblock() {
		Block firstblock = new Block("1.0",new java.util.Date(),"sarthak","saahil",500); // sending paparmeters
		firstblock.setPrevioushash(null); // initally no prev block so null
		firstblock.findhash();          //compute hash
		return firstblock;
	}
	public void addBlock(Block block) {
		Block newblock = block; // create new block
		newblock.setPrevioushash(blockchain.get(blockchain.size()-1).getHash()); // get hash of last block added in list
		newblock.findhash(); // compute has of new block
		this.blockchain.add(newblock);     // add this new block in the list
	}
	public void printchainpath() {
		for(int i=0;i<blockchain.size();i++) {
			System.out.println(" Block : "+i);
			System.out.println("Vesrion of Block : "+blockchain.get(i).getVersion());
			System.out.println("Time of transfer : "+blockchain.get(i).getTime());
			System.out.println("Previous Hash : "+blockchain.get(i).getPrevioushash());
			System.out.println("Current Block Hash : "+blockchain.get(i).getHash());
			System.out.println("Sender : "+blockchain.get(i).getSoursename());
			System.out.println("Reciever : "+blockchain.get(i).getDestinanname());
			System.out.println("Amount sent : "+blockchain.get(i).getAmount());
			System.out.println();
			System.out.println();
			System.out.println();
		}
	}

}
