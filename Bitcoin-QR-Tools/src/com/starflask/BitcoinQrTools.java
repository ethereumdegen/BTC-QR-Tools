package com.starflask;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Wallet;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.wallet.DeterministicSeed;

import com.google.common.base.Joiner;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
 

public class BitcoinQrTools {

	public static void main(String[] args) {
		 
		generateSeededWalletWithAddresses(10000);
		
	}
	
	public static void generateSeededWalletWithAddresses(int numAddresses)
	{
		NetworkParameters params = new MainNetParams();
		Wallet wallet = new Wallet( params );
		
		
		
		DeterministicSeed seed = wallet.getKeyChainSeed();
		System.out.println("Seed words are: " + Joiner.on(" ").join(seed.getMnemonicCode()));
		System.out.println("Seed birthday is: " + seed.getCreationTimeSeconds());

		/*String seedCode = "yard impulse luxury drive today throw farm pepper survey wreck glass federal";
		long creationtime = 1409478661L;
		DeterministicSeed newseed = new DeterministicSeed(seedCode, null, "", creationtime);
		Wallet restoredWallet = Wallet.fromSeed(params, newseed);
		*/
		
		
		DeterministicKey key = wallet.freshReceiveKey() ;
		System.out.println( key.getPrivateKeyAsHex() );
		
		
		for(int i=0; i< numAddresses; i++)
		{
		Address address = wallet.freshReceiveAddress();
		System.out.println(address.toString() + ",");
		}
		 
		/*	
		// get QR file from text using defaults
		QRCode code = QRCode.from( address.toString() ) ;
		
		
		 
		// get QR stream from text using defaults
		ByteArrayOutputStream pngStream = new ByteArrayOutputStream();  //this uses j2se zxing somehow 
		
		
		code.to(ImageType.PNG).writeTo(pngStream); //send this to a opengl texture 
		
		*/
		
		 
		
		 
		
			 
	}

}
