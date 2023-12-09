import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class EdgeDetection {
    private final Mat image;

    public EdgeDetection(String imagePath) {
        this.image = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_COLOR);
        if (this.image.empty()) {
            throw new IllegalArgumentException("Could not load image");
        }
    }

        public Mat detectEdges() {
            Mat gray = new Mat();
            Imgproc.cvtColor(this.image, gray, Imgproc.COLOR_BGR2GRAY);
            Imgproc.GaussianBlur(gray, gray, new Size(3, 3), 0);

            Mat edges = new Mat();
            Imgproc.Canny(gray, edges, 50, -100);

            gray.release();
            return edges;
        }

        public void saveImage(String savePath, Mat image) {
            Imgcodecs.imwrite(savePath, image);
        }

        public void release() {
            this.image.release();
        }
    }
