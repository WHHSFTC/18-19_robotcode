package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.ExpansionHubMotor;
import org.openftc.revextensions2.RevExtensions2;

/**
 * Created by khadija on 2/15/2019.
 */
@TeleOp(name ="TME" , group = "RevExtensions2Examples")
public class TemperatureMonitorExample extends OpMode
{
    ExpansionHubMotor motorRF, motorLF, motorLB, motorRB;
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
        expansionHub = hardwareMap.get(ExpansionHubEx.class, "imu");
        motorRF = (ExpansionHubMotor) hardwareMap.dcMotor.get("motorRF");
        motorLF = (ExpansionHubMotor) hardwareMap.dcMotor.get("motorLF");
        motorLB = (ExpansionHubMotor) hardwareMap.dcMotor.get("motorLB");
        motorRB = (ExpansionHubMotor) hardwareMap.dcMotor.get("motorRB");
    }

    @Override
    public void loop()
    {
        /*
         * ------------------------------------------------------------------------------------------------
         * Temperature monitors
         * ------------------------------------------------------------------------------------------------
         */

        String header =
                "**********************************\n" +
                        "TEMPERATURE MONITORS EXAMPLE      \n" +
                        "**********************************\n";
        telemetry.addLine(header);

        telemetry.addData("Module temp", expansionHub.getInternalTemperature());
        telemetry.addData("Module over temp", expansionHub.isModuleOverTemp());
        telemetry.addData("M0 H-bridge over temp", motorRF.isBridgeOverTemp());
        telemetry.addData("M1 H-bridge over temp", motorLF.isBridgeOverTemp());
        telemetry.addData("M2 H-bridge over temp", motorLB.isBridgeOverTemp());
        telemetry.addData("M3 H-bridge over temp", motorRB.isBridgeOverTemp());

        telemetry.update();
    }
}
