//package com.ayush.article.opencv;
//
//import org.apache.pdfbox.cos.COSName;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.rendering.PDFRenderer;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDResources;
//import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
//
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//
//public class PdfImageExtractor {
//    public static void main(String[] args) {
//        String pdfFilePath = "/home/shady/Desktop/Jasper/BloodBankFinalProposal.pdf";
//        String outputFolder = "/home/shady/Desktop/Jasper/";
//
//        try (PDDocument document = PDDocument.load(new File(pdfFilePath))) {
//            int pageNum = 0;
//            for (PDPage page : document.getPages()) {
//                PDResources resources = page.getResources();
//                for (COSName name : resources.getXObjectNames()) {
//                    if (resources.isImageXObject(name)) {
//                        PDImageXObject imageObject = (PDImageXObject) resources.getXObject(name);
//                        BufferedImage image = imageObject.getImage();
//                        String outputFilePath = outputFolder + "page_" + (pageNum + 1) + "_image_" + name.getName() + ".png";
//                        ImageIO.write(image, "png", new File(outputFilePath));
//                    }
//                }
//                pageNum++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
