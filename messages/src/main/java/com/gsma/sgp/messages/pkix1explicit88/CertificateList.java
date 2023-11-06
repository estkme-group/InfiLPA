/**
 * This class file was automatically generated by jASN1 v1.11.3 (http://www.beanit.com)
 */

package com.gsma.sgp.messages.pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class CertificateList implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	private TBSCertList tbsCertList = null;
	private AlgorithmIdentifier signatureAlgorithm = null;
	private BerBitString signature = null;
	
	public CertificateList() {
	}

	public CertificateList(byte[] code) {
		this.code = code;
	}

	public void setTbsCertList(TBSCertList tbsCertList) {
		this.tbsCertList = tbsCertList;
	}

	public TBSCertList getTbsCertList() {
		return tbsCertList;
	}

	public void setSignatureAlgorithm(AlgorithmIdentifier signatureAlgorithm) {
		this.signatureAlgorithm = signatureAlgorithm;
	}

	public AlgorithmIdentifier getSignatureAlgorithm() {
		return signatureAlgorithm;
	}

	public void setSignature(BerBitString signature) {
		this.signature = signature;
	}

	public BerBitString getSignature() {
		return signature;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += signature.encode(reverseOS, true);
		
		codeLength += signatureAlgorithm.encode(reverseOS, true);
		
		codeLength += tbsCertList.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(TBSCertList.tag)) {
			tbsCertList = new TBSCertList();
			subCodeLength += tbsCertList.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(AlgorithmIdentifier.tag)) {
			signatureAlgorithm = new AlgorithmIdentifier();
			subCodeLength += signatureAlgorithm.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerBitString.tag)) {
			signature = new BerBitString();
			subCodeLength += signature.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (tbsCertList != null) {
			sb.append("tbsCertList: ");
			tbsCertList.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("tbsCertList: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (signatureAlgorithm != null) {
			sb.append("signatureAlgorithm: ");
			signatureAlgorithm.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("signatureAlgorithm: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (signature != null) {
			sb.append("signature: ").append(signature);
		}
		else {
			sb.append("signature: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}
