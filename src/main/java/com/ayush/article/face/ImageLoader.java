package com.ayush.article.face;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageLoader {
    public static void main(String[] args) {
        // Load OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        // Load local image file and assign it to a Mat object
        String imagePath = "/path/to/your/image.jpg"; // Replace with the actual path to your image file
        Mat imageMat = Imgcodecs.imread(imagePath);

        // Check if the image was loaded successfully
        if (imageMat.empty()) {
            System.out.println("Failed to load the image.");
            return;
        }

        // Perform further processing with the imageMat object

        // Release the imageMat and cleanup
        imageMat.release();
    }
}