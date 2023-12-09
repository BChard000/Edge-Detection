import org.opencv.core.Core;
import org.opencv.core.Mat;

public class Main {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        try {
            EdgeDetection edgeDetector = new EdgeDetection("filePath");
            Mat edges = edgeDetector.detectEdges();
            edgeDetector.saveImage("processedImageFilePath", edges);

            edges.release();
            edgeDetector.release();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}