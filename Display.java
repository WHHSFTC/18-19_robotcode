package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotProcessor.RobotProcessor;
import org.firstinspires.ftc.teamcode.robot.Mode;

/**
 * Created by khadija on 1/5/2019.
 */
@Autonomous(name = "Display", group = "tensor")
public class Display extends LinearOpMode {

    RobotProcessor proc = new RobotProcessor();
    /**
     * Override this method and place your code here.
     * <p>
     * Please do not swallow the InterruptedException, as it is used in cases
     * where the op mode needs to be terminated early.
     *
     * @throws InterruptedException
     */
    @Override
    public void runOpMode() throws InterruptedException {
        proc.bot.initBot(this,hardwareMap,Mode.Auto,telemetry);
        waitForStart();

        proc.displayTFOD();

    }
}
