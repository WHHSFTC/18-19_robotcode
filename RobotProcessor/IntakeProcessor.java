package org.firstinspires.ftc.teamcode.RobotProcessor;

import org.firstinspires.ftc.teamcode.robot.Intake;

/**
 * Created by khadija on 1/5/2019.
 */
public class IntakeProcessor {
    public Intake intake;

    public IntakeProcessor(Intake intake){
        this.intake = intake;
    }

    public void intakeOn(){

        intake.intakeMotor.setPower(-1);
    }

    public void intakeOff(){

        intake.intakeMotor.setPower(0);
    }
}
