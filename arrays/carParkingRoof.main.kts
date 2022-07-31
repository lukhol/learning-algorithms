// I had it in Booking.com

/*
  Booking Logistics would like to quickly set up a roof over a parking lot. 
  There are many cars parked in the parking lot and the lot is in a straight line. There are n cars currently
  parked and a roofer needs to cover them with a roof . The requirement is that atleast k cars currently in the lot are covered
  by the roof. Determine the minimum length of the roof to cover k cars.
  Example 
  n = 4
  cars = [6,2,12,7]
  k = 3
  Two roofs that cover three cars are possible: one covering spots 2 through 7 with a length of 6, and another covering
  slots 6 through 12 with a length of 7. The shortest roof that meets the requirement is of length 6.
*/

// S: O(1)
// T: O(nlogn)
fun carParkingRoof(cars: Array<Long>, k: Int): Long {
    cars.sort()

    var minRequiredRoof = Long.MAX_VALUE
    for (carIdx in 0 .. cars.size - k) {
        val startCar = cars[carIdx]
        val endCarIdx = carIdx + k - 1
        val endCar = if (endCarIdx >= cars.size) cars.last() else cars[endCarIdx]
        minRequiredRoof = Math.min(minRequiredRoof, endCar - startCar + 1)
    }

    return minRequiredRoof
}
