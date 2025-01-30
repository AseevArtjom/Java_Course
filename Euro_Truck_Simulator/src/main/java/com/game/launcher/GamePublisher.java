package com.game.launcher;

import com.game.dao.DriverRepository;
import com.game.model.Driver;
import com.game.model.Request;
import com.game.model.Truck;
import com.game.service.DriverService.DriverService;
import com.game.service.ProgressService;
import com.game.service.RequestService.RequestService;
import com.game.service.TruckService.TruckService;
import com.game.service.TxtFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.io.IOException;
import java.util.List;

@Service
public class GamePublisher
{
    public static String map = new String(

            "████████████████████████████████████████████████████████████████████████████████████████▓ φ█` ┌░\"\"`             ,██████▓                     ┌██████████████████████████████████████████████████████████\n" +
                    "████████████████████████████████████████████████████████████████████████████████████████▌██▀ ░░               ,▓██████▌`                     ▓██████████████████████████████████████████████████████████\n" +
                    "██████████████████████████████████████████████████████████████████████████████████████╙ ╙    ▌`              ╠███████▀                      ╫███████████████████████████████████████████████████████████\n" +
                    "█████████████████████████████████████████████████████████████████████████████████▌░ ▌        ░             ,▓█████████                     )████████████████████████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████▓▒░\"          └░            ▒██████████▒                   ╓█████████████████████████████████████████████████████████████\n" +
                    "████████████████████████████████████████████████████████████████████████████▌▓▒▄             .░            ╠███████████M       Helsinki  ╟██████████████████████████████████████████████████████████████\n" +
                    "████████████████████████████████████████████████████████████████████████████╖    ,            ░,           ████████████▌           ¤ ╖,▓████████████████████████████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████╣╫m@N▒▓             ░`          ╠███████████▓,         ,▓████████████████████████████████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████▌░  '▀             ░,            ▓███████████████Ç, ▄████████████████████████████████████████████████████████████████████████\n" +
                    "████████████████████████████████████████████████████████████████████████████▌,        Oslo     ░               ▀█████████████████████▌▀▌▌▀▌█████████████████████████████████████████████████████████████\n" +
                    "█████████████████████████████████████████████████████████████████████████████▓           ¤   ,¿┘             ▄. ,███████████████▌         ██████████████████████████████████████████████████████████████\n" +
                    "█████████████████████████████████████████████████████████████████████████████░          '█░ .░           º▓████╬███████████████▌          ╙█████████████████████████████████████████████████████████████\n" +
                    "█████████████████████████████████████████████████████████████████████████████▀`        , ██▄,░   Stockholm ¤ └▓█████████████████µ,▄        ▓████████████████████████████████████████████████████████████\n" +
                    "████████████████████████████████████████████████████████████████████████████\"        ,██████░'            ╓╖▌██████████████▓▄██████░²ⁿ░«, ,]████████████████████████████████████████████████████████████\n" +
                    "█████████████████████████████████████████████████████████████████████████████▄,     ╠███████░▄             ]███████████████████████░    ''  '███████████████████████████████████████████████████████████\n" +
                    "██████████████████████████████████████████████████████████████████████████████████████████████`            j██████▒█████████╙ ▀█████         ²██████████████████████████████████████████████████████████\n" +
                    "██████████████████████████████████████████████████████████████████████████████████████████████∩            j█████▒║████████     ╙█▌¤ Riga      ╙████████████████████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████████▌ j█████,           j██████████████▌      .,,,¿╖,,      ░░└▀ ██\" ▀███████████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████▓██▒╙╙███████▄          ▐▓█████████████▌,r*'''` ``    '*┐╖░`          '██████████████████████████████████████████████\n" +
                    "██████████████████████████████████████████████████████████████████████████████████▌▀└╙   ▌███████▀       ,,████████████████┘                ░┐            ▓█████████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████µ    j░███████    ┌██████████████████████⌐     Vilnius  ░'               ▀███████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████░  :g█████`╙░██─  ▐███████████████████████████▄      ¤ ░░                   ▀╙▓██████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████▓  ,░█,░██╣¿███████████████████████████████████       ,▒░       Minsk       ▄,▄██████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████░   ███████▓█████████████████╙  ╙█████████████▀\"\"░,,¿╜`      ¤             \"█████████████████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████▓╕  ███████████▀█████████▀                      └░                          ▓█████`  ▓███████████████████████████████\n" +
                    "█████████████████████████████████████████████████████████████████████████████████████░    ╓███▓▀   ▀█████└                           '░                        ,¿▀█▀      ▀█████████████████████████████\n" +
                    "███████████████████████████████████████████████████████████████████████████████████▓╙',              ▀▓█@                             '░                      ░'           └\"  ▓████████████████████████\n" +
                    "██████████████████████████████████████████████████████████████████████████▀╙`\"▓H  ▀╙                  ,░             Warsaw          ¿░`                 ,,.,∩░∩                ╙██▀▌▀    ╙`      ▐█████\n" +
                    "███████████████████████████████████████████████████████████████████████▓█▌    ░              Berlin   ░,                    ¤        **, .,r**\"\"\"\"\"²*M┘└╙```                    ¤                 ▓█████\n" +
                    "██████████████████████████████████████████████████████████████████████`▓█╢░  ╜░                    ¤   ┌░                              ▒«░                        ¤              Kharkiv          '▀████\n" +
                    "████████████████████████████████████████████████████████████████████▓       ,░`                         ░                              ░,                      Kiev                                 ╫███\n" +
                    "██████████████████████████████████████████████████████████████████▓▓▓░,   ▒░`                           ░,                              `▒                                                    ¤  ▐██████\n" +
                    "███████████████████████████████████████████████████████████████▀ '╙╙╙ `²»╓]'                             ░,                              ╓░  Lviv                                       Donetsk  ███████\n" +
                    "███████████████████████████████████████████████████████████   └░┐       '░░                          ,¿╜░╜╙ª┬╓,.         Krakow        ¿░   ¤                                                    ███████\n" +
                    "██████████████████████████████████████████████████████████▌     `╙∩,      └░    Frankfurt        ,¿r┘         ²░░▒*]∩       ¤         ;`                                                     ,▓█████████\n" +
                    "██████████████████████████████████████████████▀▓██████▓▀└          ░»▒` . ░        ¤           '╜,     ¤        `   ''\"░, ,     .,,,  ░                                                    ╓▌███████████\n" +
                    "██████████████████████████████████████████████░ └╙▓█▀                '\"≡,░,░                     ░   Prague           ,┘╙░'╙w░'\"'   \"j╜┘             ,╓»┘'\"┴m≡╖┐                         ▓██████████████\n" +
                    "███████████████████████████████████m    ╙█████µ                           `└╖,,                  '²╖                 ¿┘              ░`             ░░ └┐      └,                       ████████████████\n" +
                    "███████████████████████████████████░,                        ¤               ``'░k                  '²┐   #┘'²\\»*j░'Bratislava,░''`\"*└░╓,»=====,,░'`    '²┐     `╙╖     ,╓▒█▌Ñ    ,    █████████████████\n" +
                    "███████████████████████████████████████Ç                Paris                   ░        Munich     ,░└\"\"'       └░ ¤    ,,≡░░`       ,≡░                  \"░,     └░  ▓██████▌████L    ╙███▌ ██████████\n" +
                    "█████████████████████████████████████████▓                                     ░            ¤     j░`   Vienna ¤  ░░░,,,¿╜           ¿`                      └  ┌░╜╙└`┌██████████░        ╓█████████████\n" +
                    "██████████████████████████████████████████▌                                   ┌░ ,╓m,,        .,╓«,▒            '▒`        ¤        j░                       :, ,░  ,╟██████████████▌   ╫███████████████\n" +
                    "███████████████████████████████████████████⌐                                #░'       ]░░░`\"░\"`                 ░░    Budapest      ░                         ░,░  ,▓████████████████,,█████████████████\n" +
                    "█████████████████████████████████████████████¿                            ┌░  ¤ Bern   ╙░┐≡╖,┌r**░,           .,p░,                ,░                           ╙░*└` ██████████████████████████████████\n" +
                    "█████████████████████████████████████████████▌                           ░░╓      ,  ,, j░░``    `'**jH\\¿¿░```,¿░└*,        ,***░░                                ╠█████████████████████████████████████\n" +
                    "█████████████████████████████████████████████▓                          '╜`└░   ┌░░╖¿░\"'╙`           ░░       ░     \"²»,,»╙▒      ▒          Bucharest           ╥██████████████████████████████████████\n" +
                    "████████████████████████████████████████████▒░▒                            ²░'`'   '╙              ,▓██╖,,╓,;▒`            ╙╖,     ''▒                 ¤    .  .  ╫█████████████████████████████████████\n" +
                    "████████████████████████████████████████████w ¤                             ░r   Turin           ██████░`█▓░`  ≡╓¿r**^*r***╓▒░       ╙░¿╓▒m─             ¿*'````└*░█████████████████████████████████████\n" +
                    "████████████▌└    ▀████████████████████████▒  Bordeaux                     ░,   ¤                ░██████████C  ░,           ;░    ¤       ░h¿      ,, ,¿░        ▓███████████████████████████▓`╙██▀└███▓\n" +
                    "███████████▌             `▀████████████████                                ;░      ,             ████████████▄, └╓  Sarajevo'░╖, Belgrade ░'└\"''\"\"'              ██████████████████████▌                \n" +
                    "███████████▌                      ▓▓▓█████`                                 └*∩. ▌█████,,        ²████████████▄  `²,     ¤    ▒,           ²┐,                  @████████████████████`                  \n" +
                    "███████████░j∩                           ]w,,                 ,▄,,, ,      j░▌███████████▓        └ ▓████████████▄φ;░╓      ░░``\"r         ,╖░  Sofia           `▐█████████████████\"                    \n" +
                    "██████████░ '\"\"░*░░┐                      ``└»┐,            █████████▌,, ,╟███████████████Ç            ▓██████████████▓╖,  ░`    '▒        ░,  ¤             ∩┘''' ██████████████▌                      \n" +
                    "██████████         └≡                           ```'░m┐    ╬███████████████████████████████╖            ██████████████████▌▒   ,░░░,   ,,»┘╙░,             ░░░.      ░░░▓░└░,                   Ankara  \n" +
                    "██████████       ╓*`                                 ``**`*░████████████████████████▓▀███████∩           █████████████████████ç░   `░░``      ░   .¿»\\╓«,,r*░░   .████████▀▀`                       ¤   \n" +
                    "████████▌       ,░                                         ▐███████████████████████   ██████████,          ╬████████████████████▓   ░         ░░\"\"   , ,▓▒▄▌@░,▄▄████████╙                              \n" +
                    "███████▌       ,░              Madrid                  ▄███████████████████████████░ j████████████,  ¤ Rome      ███████████████▌   └r    ¿░└'    ╓▌▓██████████▓▌`╙╙                                    \n" +
                    "██████\"     .,,░`            ¤                  ,▓███████████████████████████████████████████████████▄▄▄,         ▀▓█████████████    '²░'`    ╢▌  ,███████████▀                                         \n" +
                    "████▀ Lisbon ░                                 ▄████████████████████████████████████▀└▓███████████████████╓,            ▀███████▓     ]`      ████████████████▄▄█H                                      \n" +
                    "████,¤       ░r                              ▄███████████████████████████████████░    '███████████████████████       ╠████▒└██████▌,.µ'        ▓██████████████████,                                     \n" +
                    "██████▀     ░`                             ╓██████████████████████████████████████    ]██████████████████████████,  j███████████████░`          ▌█████████████████▀                                  ,▄▄\n" +
                    "█████▒      ░∩                             █████████████▓,,▓██████████████████████`   ]███████████████████████████, ╙█████████████████▌,,,     ╓▓██▓█████████████▓▓░                                ▄███\n" +
                    "█████`    ,░`                              ╙█████████████████████████████████████▓  , ╠████████████████████████████    ╬████████████████▓      ,  ╙▓█▓███████████████                ,,▄,,,       ,▓████\n" +
                    "█████▓▄   ░                              ,████████████████████████████████████████▄▄████████████████████████████████ ███████████████████████▌▀████▓▄█╖█████████████████, ,,         ╫████████▒╓@████████\n" +
                    "██████████████,                         ▓█████████████████████████████████████████████████████████████████████████▓ ╓█████████████████████▓      ,▒███████████████████████▓███▌   ,▄████████████████████\n" +
                    "███████████████`                   ,╢████████████████████████████████████████████████████████████████████████▓▓▌██,▓████████████████████████▓    ▓███████████████████████████████████████████████▌╙ ,▓██\n" +
                    "███████████████░   ,▄,╟███▌▄▄, ,, ╠█████████████████████████████████████████████████████████████████           ╠█████████████████████████████╖▓▌ ,░████████████████████████████████████████████▌  ╓▓████\n" +
                    "████████████████████████████████████████████████████████████████████████████████████████████████████████▄,     █████████████████████████████████████████████████████████████████████████████████████████\n" +
                    "████████████████████████████████████████████████████████████████████████████████████████████████████████████▌,,▌████████████████████████████████████████████████████████████████████████████████████████\n"
    );

    @Autowired
    private TxtFileReader txtFileReader;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private TruckService truckService;

    @Autowired
    private ProgressService progressService;

    public GamePublisher(){}

    private static final String EMPTY = "Empty";
    private static final String END_LINE = "\n";
    private static final String SEPARATOR = "-";
    private static final String DOT = ". ";
    private static final String EXIT = "0. Exit";
    private static final String BACK = "0. Back";

    private static final String DRIVERS = "Drivers";
    private static final String HIRE = "Hire new driver";
    private static final String FIRE = "Fire driver";

    private static final String TRUCKS = "Trucks";
    private static final String BUY_TRUCK = "Buy new truck";
    private static final String SELL_TRUCK = "Sell truck";

    private static final String REQUESTS = "Requests";
    private static final String ONGOING_REQUESTS = "Ongoing requests";
    private static final String AVAILABLE_REQUESTS = "Available requests";
    private static final String TAKE_REQUEST = "Take request";

    private static final String NEXT_DAY = "Next day";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";



    public void printMap(){
        System.out.print(map);
    }

    public void showMenu(){
        int menuLine = 1;
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(SEPARATOR.repeat(20))
                .append("Menu")
                .append(SEPARATOR.repeat(20))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(DRIVERS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(TRUCKS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(REQUESTS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(HIRE)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(FIRE)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(BUY_TRUCK)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(SELL_TRUCK)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(NEXT_DAY)
                .append(END_LINE)
                .append(EXIT);
        System.out.println(resultStr.toString());
    }

    public void showHiredDrivers(){
        System.out.println("Hired drivers: ");
        List<Driver> HiredDrivers = driverService.findByIsHiredTrue();
        if (!HiredDrivers.isEmpty()){
            for (int i = 0; i < HiredDrivers.size(); i++) {
                System.out.println((i + 1) + ". " + HiredDrivers.get(i).GetInfo());
            }
        }
        else{
            System.out.println(EMPTY);
        }
    }

    public void showAvailableDriversToHire(){
        System.out.println("Available drivers to hire: ");
        List<Driver> DriversToHire = driverService.findByIsHiredFalse();
        for (int i = 0; i < DriversToHire.size(); i++) {
            System.out.println((i + 1) + ". " + DriversToHire.get(i).GetInfo());
        }
    }

    public void showAvailableDriversToTrip(float requiredExperience) {
        System.out.println("Available drivers to trip: ");
        List<Driver> availableDrivers = driverService.findDriverByIsInTripFalseAndIsHiredTrue();

        for (int i = 0; i < availableDrivers.size(); i++) {
            Driver driver = availableDrivers.get(i);
            float driverExperience = driver.getExperience();

            if (driverExperience < requiredExperience) {
                System.out.println((i + 1) + "." + driver.getName() + " [" + driver.getCash() + "$, " + ANSI_RED + driver.getExperience() + " years" + ANSI_RESET + "]");
            } else {
                System.out.println((i + 1) + "." + driver.GetInfo());
            }
        }
    }

    public void showAvailableTrucksToTrip(Double required_tonnage){
        System.out.println("Available truck to trip: ");
        List<Truck> availableTrucks = truckService.findByIsInTripFalseAndBoughtTrue();

        for (int i = 0; i < availableTrucks.size(); i++) {
            Truck truck = availableTrucks.get(i);
            Double truck_max_weight = truck.getMaxWeight();

            if(truck_max_weight < required_tonnage){
                System.out.println((i + 1) + "." + truck.getName() + ", " + ANSI_RED + truck.getMaxWeight() + " tons" + ANSI_RESET);
            }
            else{
                System.out.println((i + 1) + "." + truck.GetInfo());
            }
        }
    }

    public void showRequestsMenu(){
        int menuLine = 1;
        StringBuilder resultStr = new StringBuilder();
        resultStr.append(SEPARATOR.repeat(20))
                .append(REQUESTS)
                .append(SEPARATOR.repeat(20))
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(ONGOING_REQUESTS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(AVAILABLE_REQUESTS)
                .append(END_LINE)
                .append(menuLine++)
                .append(DOT)
                .append(TAKE_REQUEST)
                .append(END_LINE)
                .append(BACK);
        System.out.println(resultStr);
    }

    public void showAvailableRequests(){
        System.out.println("Available requests: ");
        List<Request> AvailableRequests = requestService.findByProgressFalse();
        if(AvailableRequests.isEmpty()){
            System.out.println(EMPTY);
            return;
        }
        for (int i = 0; i < AvailableRequests.size(); i++) {
            System.out.println((i + 1) + ". " + AvailableRequests.get(i).GetInfo());
        }
    }

    public void showOnGoingRequests() {
        System.out.println("OnGoing requests: ");
        List<Request> ongoingRequests = requestService.findByProgressTrue();

        if (ongoingRequests.isEmpty()) {
            System.out.println("No ongoing requests.");
            return;
        }

        for (int i = 0; i < ongoingRequests.size(); i++) {
            Request request = ongoingRequests.get(i);
            double progressPercentage = progressService.calculateProgressPercentage(request.getDeliveryDays(), request.getRemainingDays());
            String progressBar = progressService.generateProgressBar(progressPercentage);

            System.out.println((i + 1) + ". " + request.GetInfo() + " " + progressBar + " " + (int)progressPercentage + "%");
        }
    }

    public void showBoughtTrucks(){
        System.out.println("Bought trucks: ");
        List<Truck> BoughtTrucks = truckService.findByBoughtTrue();
        for (int i = 0; i < BoughtTrucks.size(); i++) {
            System.out.println((i + 1) + ". " + BoughtTrucks.get(i).GetInfo());
        }
    }

    public void showTrucksAvailableForBuying(){
        System.out.println("Truck available for buying: ");
        List<Truck> AvailableTrucks = truckService.findByBoughtFalse();
        for (int i = 0; i < AvailableTrucks.size(); i++) {
            System.out.println((i + 1) + ". " + AvailableTrucks.get(i).GetInfo());
        }
    }
}
