package com.ayush.article.jaccard;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TikaException, IOException, SAXException {
/*        String str1 = readContentFromPdf("/home/shady/Desktop/Jasper/5.pdf");
        String str2 = readContentFromPdf("/home/shady/Desktop/Jasper/6.pdf");*/

        String str1 = "Hello World";
        String str2 ="He is a man";

        double value = WholeFileChecker.checkWholeFile(str1, str2);
        System.out.println(value);
    }

    public static String readContentFromPdf(String path) throws IOException, TikaException, SAXException {
        // Create a content handler
        BodyContentHandler contenthandler
                = new BodyContentHandler();

        // Create a file in local directory
        File f = new File(path);

        // Create a file input stream
        // on specified path with the created file
        FileInputStream fstream = new FileInputStream(f);

        // Create an object of type Metadata to use
        Metadata data = new Metadata();

        // Create a context parser for the pdf document
        ParseContext context = new ParseContext();

        // PDF document can be parsed using the PDFparser
        // class
        PDFParser pdfparser = new PDFParser();

        // Method parse invoked on PDFParser class
        pdfparser.parse(fstream, contenthandler, data,
                context);

        return  contenthandler.toString();
    }

}
