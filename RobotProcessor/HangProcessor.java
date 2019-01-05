package org.firstinspires.ftc.teamcode.RobotProcessor;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robot.Hang;

/**
 * Created by khadija on 1/5/2019.
 */
public class HangProcessor {
    public Hang hang;

    public HangProcessor(Hang hang){
        this.hang = hang;
    }

    public void setPower(double power){
        hang.hangMotor.setPower(power);
    }

    public void setMode(DcMotor.RunMode runMode){
        hang.hangMotor.setMode(runMode);
    }




}
