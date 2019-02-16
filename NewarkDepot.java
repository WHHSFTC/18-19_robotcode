package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotProcessor.RobotProcessor;
import org.firstinspires.ftc.teamcode.robot.Mode;
import org.firstinspires.ftc.teamcode.robot.Robot;

/**
 * Created by khadija on 1/5/2019.
 */
@Autonomous(name = "NewarkDepot", group = "tensor")
public class NewarkDepot extends LinearOpMode {

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

        proc.identifyLocation();
        telemetry.addData("location", proc.locationMineral);

        proc.descend();
        proc.driveTrainProcessor.goAngle(2.5,0,.3);
        proc.driveTrainProcessor.goAngle(2.5,90 ,.3);
        proc.turntoGold();
        proc.driveTrainProcessor.goAngle(35,0,.5);
        //proc.alignForSample();
        //proc.driveTrainProcessor.goAngle(30,0,.5);

        proc.setUpToDropDepot();
        proc.dropMarker();
        sleep(1000);
        proc.realignForParkDepot();

        //proc.driveTrainProcessor.turn(205);
        //proc.dropMarker();


    }

    //fpublic void kill(){
    // kill();
    // }
}
