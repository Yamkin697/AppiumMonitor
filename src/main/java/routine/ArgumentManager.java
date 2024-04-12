package routine;
import org.apache.commons.cli.*;
public class ArgumentManager {
    private static String[] arguments;
    private static String avd;
    private static int appiumPort = 4723;
    private static boolean call = true;
    public static String[] getArguments() {
        return arguments;
    }
    public static void setArguments(String[] arguments) {
        ArgumentManager.arguments = arguments;
    }
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

        options.addOption(avdOption);
        options.addOption(appiumPortOption);
        options.addOption(noCall);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("avd")) {
                avd = cmd.getOptionValue("avd");
            }
            if (cmd.hasOption("appium-port")) {
                appiumPort = Integer.parseInt(cmd.getOptionValue("appium-port"));
            }
            if (cmd.hasOption("no-call")) {
                call = false;
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
}

