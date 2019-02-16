package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotProcessor.RobotProcessor;
import org.firstinspires.ftc.teamcode.robot.Mode;

/**
 * Created by khadija on 1/16/2019.
 */
@Autonomous(name = "Crater", group = "tensor")
public class NewarkCrater extends LinearOpMode {

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
        RobotProcessor proc = new RobotProcessor(this,hardwareMap,Mode.Auto,telemetry);


        waitForStart();

        // identify location of particle
        proc.identifyLocation();
        telemetry.addData("location", proc.locationMineral);

        // decend off lander
        proc.descend();
        proc.driveTrainProcessor.goAngle(2.5,0,.3);
        proc.driveTrainProcessor.goAngle(2.5,90 ,.3);

        // turn to gold mineral
        proc.turntoGold();
        // hit gold mineral
        proc.driveTrainProcessor.goAngle(25,0,.5);
        //back away
        proc.driveTrainProcessor.align(0);

        proc.driveTrainProcessor.goAngle(10,180,.5);
        proc.driveTrainProcessor.align(0);
        //strafe to wall
        proc.driveTrainProcessor.goAngle(30,-90,.5);

        //drive to depot
        proc.driveTrainProcessor.align(45);
        proc.driveTrainProcessor.goAngle(30,180,.7);
        proc.dropMarker();

        //park crater
        proc.driveTrainProcessor.goAngle(100,0,1);











    }


}
