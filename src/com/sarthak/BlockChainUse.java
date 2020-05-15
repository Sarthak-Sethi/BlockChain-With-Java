package com.sarthak;

public class BlockChainUse {

	public static void main(String[] args) {
		BlockChain bchain = new BlockChain(); 
		Block a = new Block("1.0",new java.util.Date(),"saahil","shaurya",200);
		Block b = new Block("2.0",new java.util.Date(),"shaurya","saksham",900);
		Block c = new Block("3.0",new java.util.Date(),"saksham","saahil",2900);
		Block d = new Block("4.0",new java.util.Date(),"saahil","sarthak",2070);
		Block e = new Block("5.0",new java.util.Date(),"sarthak","shaurya",2060);
		
		bchain.addBlock(a);
		bchain.addBlock(b);
		bchain.addBlock(c);
		bchain.addBlock(d);
		bchain.addBlock(e);
	
		bchain.printchainpath();
	}

}
