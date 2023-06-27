//package com.ayush.article.predict;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//import org.apache.commons.math3.random.RandomDataGenerator;
//import org.apache.commons.math3.util.Pair;
//import weka.core.Instances;
//import weka.core.converters.ArffLoader;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import weka.classifiers.trees.RandomForest;
//import weka.classifiers.Evaluation;
//
//public class TaskDurationPrediction {
//    public static void main(String[] args) {
//        try {
//            // Load the dataset (CSV or ARFF format)
//            BufferedReader reader = new BufferedReader(new FileReader("task_dataset.csv"));
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
//
//            // Prepare the data for Weka
//            List<Pair<Instance, Double>> dataset = new ArrayList<>();
//            for (CSVRecord record : csvParser) {
//                // Extract the task characteristics (features) and duration (target variable)
//                double feature1 = Double.parseDouble(record.get("Feature1"));
//                double feature2 = Double.parseDouble(record.get("Feature2"));
//                double duration = Double.parseDouble(record.get("Duration"));
//
//                // Create an instance for Weka
//                Instance instance = new Instance(2);
//                instance.setValue(0, feature1);
//                instance.setValue(1, feature2);
//
//                // Create a pair of instance and duration
//                Pair<Instance, Double> pair = new Pair<>(instance, duration);
//
//                // Add the pair to the dataset
//                dataset.add(pair);
//            }
//
//            // Convert the dataset to Weka Instances
//            Instances wekaInstances = new Instances("TaskDataset", new ArrayList<>(), dataset.size());
//            wekaInstances.setClassIndex(wekaInstances.numAttributes() - 1);
//            for (Pair<Instance, Double> pair : dataset) {
//                wekaInstances.add(pair.getFirst());
//                wekaInstances.lastInstance().setClassValue(pair.getSecond());
//            }
//
//            // Initialize and configure the Random Forest Regression model
//            RandomForest randomForest = new RandomForest();
//            randomForest.setNumTrees(100);  // Number of trees in the forest
//
//            // Build the model
//            randomForest.buildClassifier(wekaInstances);
//
//            // Evaluate the model using cross-validation
//            Evaluation evaluation = new Evaluation(wekaInstances);
//            evaluation.crossValidateModel(randomForest, wekaInstances, 10, new RandomDataGenerator());
//
//            // Print the evaluation results
//            System.out.println("Mean Absolute Error: " + evaluation.meanAbsoluteError());
//            System.out.println("Root Mean Squared Error: " + evaluation.rootMeanSquaredError());
//
//            // Predict task duration for a new instance
//            Instance newInstance = new Instance(2);
//            newInstance.setValue(0, 7.5);  // Example feature 1 value
//            newInstance.setValue(1, 4.2);  // Example feature 2 value
//
//            double predictedDuration = randomForest.classifyInstance(newInstance);
//            System.out.println("Predicted Task Duration: " + predictedDuration);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
