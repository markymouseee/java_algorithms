/**
 * @author markymouseee
 **/

package oop_homework_problem;

public class Smartphone {
    private String capture = "Capturing photo with 108MP camera";

    class Camera{
        public void capturePhoto(){
            System.out.println(capture);
        }
    }

    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();

        Camera camera = smartphone.new Camera();

        camera.capturePhoto();
    }
}