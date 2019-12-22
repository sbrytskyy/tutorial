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

	public static final String DEST = "outputWithPwdTest.pdf";
	public static final String SRC = "inputTest.pdf";

	public static void main(String[] args) {
		try {
			setPdfPwd();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setPdfPwd() throws IOException {
		PdfReader reader = new PdfReader(SRC, new ReaderProperties().setPassword("World".getBytes()));
		PdfWriter writer = new PdfWriter(DEST,
				new WriterProperties().setStandardEncryption("Hello".getBytes(), "World".getBytes(),
						EncryptionConstants.ALLOW_PRINTING,
						EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA));
		PdfDocument pdfDoc = new PdfDocument(reader, writer);
		pdfDoc.close();
	}

}
