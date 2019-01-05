package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotProcessor.RobotProcessor;
import org.firstinspires.ftc.teamcode.robot.Mode;
import org.firstinspires.ftc.teamcode.robot.Robot;

/**
 * Created by khadija on 1/5/2019.
 */
@Autonomous(name = "Depot", group = "Final")
public class Depot extends LinearOpMode {

    RobotProcessor proc = new RobotProcessor();

    public void runOpMode() throws InterruptedException{
        proc.bot.initBot(this,hardwareMap,Mode.Auto,telemetry);
        waitForStart();
        proc.descend();
        proc.activateTFOD();
        proc.displayLOCATION();
        proc.displayTFOD();
        proc.deactivateTFOD();
        proc.turnSampleAngle();


    }




}
