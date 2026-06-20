import java.util.Scanner;

public class OTPGenerator {
    
    public static int generateOTP() {
        int otp = 100000 + (int)(Math.random() * 900000);
        return otp;
    }
    
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length - 1; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] otps = new int[10];
        
        System.out.println("Generating 10 six-digit OTP numbers:");
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
        
        System.out.println("\nChecking OTP Uniqueness:");
        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique!");
        } else {
            System.out.println("Some OTPs are duplicate!");
        }
    }
}
