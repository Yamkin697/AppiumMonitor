package routine;
import org.apache.commons.cli.*;
public class ArgumentManager {
    private static String[] arguments;
    private static String avd;
    private static int appiumPort = 4723;
    private static boolean call = true;
    private static int adbPort = 0;
    private static String adbDeviceName;
    private static String appiumAddress = "127.0.0.1";



    public static int getAdbPort() {
        return adbPort;
    }


    public static String[] getArguments() {
        return arguments;
    }
    public static void setArguments(String[] arguments) {
        ArgumentManager.arguments = arguments;
    }

    public static String getAdbDeviceName() {
        return adbDeviceName;
    }
    public static String getAppiumAddress() { return appiumAddress; }

    public static void parseArgs() {
        String[] args = arguments;
        Options options = new Options();

        Option avdOption = Option.builder()
                .longOpt("avd")
                .desc("Android Virtual Device name")
                .hasArg()
                .build();

        Option appiumPortOption = Option.builder()
                .longOpt("appium-port")
                .desc("Appium server port")
                .hasArg()
                .build();

        Option noCall = Option.builder()
                .longOpt("no-call")
                .desc("No call")
                .hasArg()
                .build();
        Option adbPortOption = Option.builder()
                .longOpt("adb-port")
                .desc("Adb port")
                .hasArg()
                .build();
        Option adbDeviceOption = Option.builder()
                .longOpt("adb-device")
                .desc("Adb device")
                .hasArg()
                .build();
        Option appiumAddressOption = Option.builder()
                .longOpt("appium-address")
                .desc("Appium address")
                .hasArg()
                .build();

        options.addOption(avdOption);
        options.addOption(appiumPortOption);
        options.addOption(noCall);
        options.addOption(adbPortOption);
        options.addOption(adbDeviceOption);
        options.addOption(appiumAddressOption);


        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("avd")) {
                avd = cmd.getOptionValue("avd");
                Secrets.Device.deviceName = avd;
            }
            if (cmd.hasOption("appium-port")) {
                appiumPort = Integer.parseInt(cmd.getOptionValue("appium-port"));
            }
            if (cmd.hasOption("no-call")) {
                call = false;
            }
            if (cmd.hasOption("adb-port")) {
                adbPort = Integer.parseInt(cmd.getOptionValue("adb-port"));
            }
            if (cmd.hasOption("adb-device")) { // тут можно указывать не только имя, но и IP
                adbDeviceName = cmd.getOptionValue("adb-device");
            }
            if (cmd.hasOption("appium-address")) {
                appiumAddress = cmd.getOptionValue("appium-address");
            }
        } catch (ParseException e) {
            System.err.println("Error parsing command line arguments: " + e.getMessage());
        }
    }

    public static String getAvd() {
        return avd;
    }

    public static int getAppiumPort() {
        return appiumPort;
    }

    public static boolean getCall() {
        return call;
    }
}

