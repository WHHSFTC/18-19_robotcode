package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotProcessor.RobotProcessor;
import org.firstinspires.ftc.teamcode.robot.Mode;

/**
 * Created by khadija on 2/16/2019.
 */
@Autonomous(name = "craterLever", group = "Nutcracker")
public class craterLever extends LinearOpMode  {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotProcessor proc = new RobotProcessor(this,hardwareMap,Mode.Auto,telemetry);
        proc.displayINIT();

        proc.identifyLocationV2();
        telemetry.addData("location", proc.locationMineral);

        proc.driveTrainProcessor.goAngle(2.5,90 ,1);
        proc.turntoGold();
        proc.driveTrainProcessor.goAngle(27,0,1);
    }
}
