public class EarthVolume {
    public static void main(String[] args) {
        double r = 6378;
        double pi = Math.PI;
        double volKm = (4.0 / 3.0) * pi * Math.pow(r, 3);
        double volMiles = volKm * 0.238585;
        System.out.println("The volume of earth in cubic kilometers is " + volKm + " and cubic miles is " + volMiles);
    }
}
