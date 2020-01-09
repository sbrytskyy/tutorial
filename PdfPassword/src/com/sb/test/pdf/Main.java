package com.sb.test.pdf;

import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfEncryptor;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;
import com.itextpdf.kernel.pdf.WriterProperties;

import java.io.*;

public class Main {

	private static final String PWD_OWNER = "d8erEAgncGKYJaKD";
	
	private static final String PWD_USER = "d8erEAgncGKYJaKD";
	
	public static final String DEST = "Decl_of_Fed_ Empl_NK_enc.pdf";
	public static final String SRC = "Decl_of_Fed_ Empl_NK.pdf";

	public static void main(String[] args) {
		try {
			setPdfPwd();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setPdfPwd() throws IOException {
		PdfReader reader = new PdfReader(SRC, new ReaderProperties().setPassword(PWD_OWNER.getBytes()));
		PdfWriter writer = new PdfWriter(DEST,
				new WriterProperties().setStandardEncryption(PWD_USER.getBytes(), PWD_OWNER.getBytes(),
						EncryptionConstants.ALLOW_PRINTING | 
						EncryptionConstants.ALLOW_COPY | 
						EncryptionConstants.ALLOW_MODIFY_ANNOTATIONS | 
						EncryptionConstants.ALLOW_FILL_IN | 
						EncryptionConstants.ALLOW_SCREENREADERS | 
//						EncryptionConstants.ALLOW_ASSEMBLY | 
						EncryptionConstants.ALLOW_MODIFY_CONTENTS,
						EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA));
		PdfDocument pdfDoc = new PdfDocument(reader, writer);
		pdfDoc.close();
	}

}
