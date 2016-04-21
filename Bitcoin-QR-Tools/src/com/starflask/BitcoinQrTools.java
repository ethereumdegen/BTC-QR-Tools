package com.starflask;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Wallet;
import org.bitcoinj.crypto.DeterministicKey;
import org.bitcoinj.params.MainNetParams;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
 

public class BitcoinQrTools {

	public static void main(String[] args) {
		 
		generateFreshKey();

	}
	
	public static void generateFreshKey()
	{
		NetworkParameters params = new MainNetParams();
		Wallet wallet = new Wallet( params );
		
		DeterministicKey key = wallet.freshReceiveKey() ;
		System.out.println( key.getPrivateKeyAsHex() );
		
		
		
		Address address = wallet.freshReceiveAddress();
		System.out.println(address.toString());
		
		 
			
		// get QR file from text using defaults
		QRCode code = QRCode.from( address.toString() ) ;
		
		
		 
		// get QR stream from text using defaults
		ByteArrayOutputStream pngStream = new ByteArrayOutputStream();  //this uses j2se zxing somehow 
		
		
		code.to(ImageType.PNG).writeTo(pngStream); //send this to a opengl texture 
		
		
		
		 
		
		 
		
			 
	}

}
