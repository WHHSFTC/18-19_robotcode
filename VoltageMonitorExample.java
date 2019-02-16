package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotProcessor.RobotProcessor;
import org.firstinspires.ftc.teamcode.robot.Mode;
import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.RevExtensions2;

/**
 * Created by khadija on 2/15/2019.
 */
@TeleOp(name = "VME" , group = "RevExtensions2Examples")
public class VoltageMonitorExample extends OpMode
{
    ExpansionHubEx expansionHub;
    TeleMap bot = new TeleMap();


    @Override
    public void init()
    {
        /*
         * Call this ONCE as the first thing in each of your OpModes
         */
        RevExtensions2.init();
        bot.init(hardwareMap);

        /*
         * Now that RevExtensions2.init() has been called, there are new objects in the
         * hardwareMap :)
         */
        expansionHub = hardwareMap.get(ExpansionHubEx.class, "Expansion Hub 2");
        bot.init(hardwareMap);
    }

    @Override
    public void loop()
    {
        /*
         * ------------------------------------------------------------------------------------------------
         * Voltage monitors
         * ------------------------------------------------------------------------------------------------
         */

        String header =
                "**********************************\n" +
                        "VOLTAGE MONITORS EXAMPLE          \n" +
                        "**********************************\n";
        telemetry.addLine(header);

        telemetry.addData("5v monitor", expansionHub.read5vMonitor() / 1000d); //Voltage from the phone
        telemetry.addData("12v monitor", expansionHub.read12vMonitor() / 1000d); //Battery voltage
        telemetry.update();
    }
}
