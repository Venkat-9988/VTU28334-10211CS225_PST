import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Stores active check-ins: id -> CheckInInfo(stationName, checkInTime)
    private Map<Integer, CheckInInfo> checkInMap;
    
    // Stores route statistics: "startStation->endStation" -> RouteData(totalTime, count)
    private Map<String, RouteData> journeyMap;

    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private static class RouteData {
        double totalTime;
        int count;

        RouteData(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        String routeKey = checkIn.stationName + "->" + stationName;
        int travelTime = t - checkIn.checkInTime;

        RouteData route = journeyMap.getOrDefault(routeKey, new RouteData(0, 0));
        route.totalTime += travelTime;
        route.count += 1;
        journeyMap.put(routeKey, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteData route = journeyMap.get(routeKey);
        return route.totalTime / route.count;
    }
}
