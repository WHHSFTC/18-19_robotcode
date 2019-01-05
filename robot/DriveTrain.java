package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by khadija on 12/29/2018.
 */
public class DriveTrain {
    public DcMotor motorLF;
    public DcMotor motorLB;
    public DcMotor motorRB;
    public DcMotor motorRF;


    public DriveTrain(HardwareMap hwMap, Mode mode){

        motorLF = hwMap.dcMotor.get("motorLF");
        motorLB = hwMap.dcMotor.get("motorLB");
        motorRB = hwMap.dcMotor.get("motorRB");
        motorRF = hwMap.dcMotor.get("motorRF");

        motorLF.setDirection(DcMotor.Direction.FORWARD);
        motorLB.setDirection(DcMotor.Direction.FORWARD);
        motorRF.setDirection(DcMotor.Direction.FORWARD);
        motorRB.setDirection(DcMotor.Direction.FORWARD);

        motorLB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        setMotorRunMode(mode);

    }


    public void setMotorRunMode(Mode mode){
        if(mode == Mode.Auto){
            motorLF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorRF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorLB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorRB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorLF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorRF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorLB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorRB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        else{
            motorLF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorRF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorLB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorRB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorLF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motorRF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motorLB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motorRB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }


}
