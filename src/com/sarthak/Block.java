package com.sarthak;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
    private String previoushash;
    private String hash;
     private String version;
    private Date time;
    private String soursename;
    private String destinanname;
    private int amount;

    public String getPrevioushash() {
		return previoushash;
	}

	public void setPrevioushash(String previoushash) {
		this.previoushash = previoushash;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getSoursename() {
		return soursename;
	}

	public void setSoursename(String soursename) {
		this.soursename = soursename;
	}

	public String getDestinanname() {
		return destinanname;
	}

	public void setDestinanname(String destinanname) {
		this.destinanname = destinanname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Block(String version, Date time, String soursename, String destinanname, int amount) {
        this.version = version;
        this.time = time;
        this.soursename = soursename;
        this.destinanname = destinanname;
        this.amount = amount;
        this.hash = findhash();
    }

    public String findhash() {
        String dataToHash = "" + this.version + this.time + this.previoushash + this.amount;
		
		MessageDigest digest;
		String encoded = null;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.hash = encoded;
		return encoded;
    }

}

