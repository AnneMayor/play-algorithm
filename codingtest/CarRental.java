package codingtest;
import java.util.*;
import java.text.SimpleDateFormat;

public class CarRental {
    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
        boolean canScheduleAll = true;

        long prevStartEpochTime = 0L;
        long prevEndEpochTime = 0L;


        for(RentalTime rentalTime : rentalTimes) {
            long currentStartEpochTime = rentalTime.getStart().getTime();
            long currentEndEpochTime = rentalTime.getEnd().getTime();

            if (prevStartEpochTime == 0 && prevEndEpochTime == 0) {
                prevStartEpochTime = currentStartEpochTime;
                prevEndEpochTime = currentEndEpochTime;
                continue;
            }

            if (prevEndEpochTime > currentStartEpochTime) {
                canScheduleAll = false;
                break;
            }

            prevStartEpochTime = currentStartEpochTime;
            prevEndEpochTime = currentEndEpochTime;
        }

        return canScheduleAll;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:10"), sdf.parse("03/05/2020 20:20")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 23:35")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));

        Comparator<RentalTime> comparator = new Comparator<RentalTime>() {
            @Override
            public int compare(RentalTime a, RentalTime b) {
                return (int) (a.getStart().getTime() - b.getStart().getTime());
            }
        };

        rentalTimes.sort(comparator);

        System.out.println(CarRental.canScheduleAll(rentalTimes));
    }
}

class RentalTime {
    private Date start, end;
    
    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    }
}