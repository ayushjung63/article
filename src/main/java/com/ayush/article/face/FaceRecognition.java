//package com.ayush.article.face;
//
//import org.opencv.core.*;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.*;
//import org.opencv.imgproc.Imgproc;
//
//public class FaceRecognition {
//    public static void main(String[] args) {
//        String referenceImagePath="/home/shady/Downloads/18307.png";
//        Mat referenceImage = Imgcodecs.imread(referenceImagePath);
//
//        String capturedImagePath="/home/shady/Downloads/18307.png";
//        Mat capturedImage = Imgcodecs.imread(capturedImagePath);
//
//        Mat capturedGray = new Mat();
//        Mat referenceGray = new Mat();
//
//        Imgproc.cvtColor(capturedImage, capturedGray, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.cvtColor(referenceImage, referenceGray, Imgproc.COLOR_BGR2GRAY);
//
//        // Resize the images to a common size (optional)
//        Size commonSize = new Size(640, 480);
//        Imgproc.resize(capturedGray, capturedGray, commonSize);
//        Imgproc.resize(referenceGray, referenceGray, commonSize);
//
//        // Calculate SSIM score
//        MatOfFloat ssimScore = new MatOfFloat();
//        Imgproc.compareSSIM(capturedGray, referenceGray, ssimScore);
//
//        // Get the SSIM score value
//        double similarity = ssimScore.get(0, 0)[0];
//
//        System.out.println("Similarity score: " + similarity);
//
//        // Release the images and cleanup
//        capturedImage.release();
//        referenceImage.release();
//        capturedGray.release();
//        referenceGray.release();
//    }
//
//
//    }
//}
