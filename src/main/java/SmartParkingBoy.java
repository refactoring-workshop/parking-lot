import exceptions.AllParkingLotsIsFullException;

import java.util.List;

import static java.util.Comparator.comparing;

public class SmartParkingBoy extends Parker {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws Exception {
        return parkingLots.stream()
                .filter(ParkingLot::hasSpace)
                .max(comparing(ParkingLot::getRemainingSpace))
                .orElseThrow(AllParkingLotsIsFullException::new)
                .receive(car);
    }

}
