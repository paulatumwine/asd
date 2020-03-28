public class Record {
    private String licensePlate;
    private double speed;
    private int cameraId;

    public Record() {
    }

    public Record(String licensePlate, double speed, int cameraId) {
        this.licensePlate = licensePlate;
        this.speed = speed;
        this.cameraId = cameraId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }
}
