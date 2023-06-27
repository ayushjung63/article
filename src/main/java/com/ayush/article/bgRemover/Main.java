package com.ayush.article.bgRemover;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Main {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        System.out.println("Welcome to OpenCV " + Core.VERSION);

        Imgcodecs imageCodecs = new Imgcodecs();
        String file ="sign.jpg";
        Mat image = imageCodecs.imread(file);
        System.out.println("Image Loaded ..........");

        Rect rectangle = new Rect(1, 1, image.width(), image.height());
        Mat result = Mat.zeros(image.height(),image.width(),CvType.CV_8U);
        Mat bgdModel = Mat.zeros(1,65,CvType.CV_64F);
        Mat fgdModel = Mat.zeros(1,65,CvType.CV_64F);
        Mat source = new Mat(1, 1, CvType.CV_8U, new Scalar(3));
        Imgproc.grabCut(image, result, rectangle, bgdModel, fgdModel, 8, Imgproc.GC_INIT_WITH_MASK);
        Core.compare(result, source, result, Core.CMP_EQ);
        Mat foreground = new Mat(image.size(), CvType.CV_8UC3, new Scalar(255, 255, 255));
        image.copyTo(foreground, result);
        //Imgcodecs.imwrite(fileNameWithCompletePath, foreground);


        //Writing the image
        String file2 = "src/myCode/img2.jpg";
        Imgcodecs.imwrite(file2, foreground);
        System.out.println("Image Saved ............");
        
    }
}