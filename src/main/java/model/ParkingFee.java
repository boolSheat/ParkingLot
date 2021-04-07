package model;

public class ParkingFee {
    private static double feeForFirstHour = 50;
    private static double feeForSecondHour = 40;
    private static double feeAfterSecondHour = 30;

    public static double getTicketFee(int hours) {
        double fee = feeForFirstHour;
        if(hours>1) fee += feeForSecondHour;
        if(hours>2) fee += (hours-2)*feeForSecondHour;
        return fee;
    }
}
