package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by khadija on 2/8/2019.
 */
@TeleOp(name = "servoTest",group = "Tests")
public class servoTest extends OpMode {
    double xpow;
    double ypow;
    double zpow;
    public Servo marker;

    @Override
    public void init() {
        //initalizes hardware map


    }
    public void readGamePad() {
        //assigns joystick values to variables
        zpow = gamepad1.right_stick_x;
        ypow = -gamepad1.left_stick_y;
        xpow = gamepad1.left_stick_x;

        //creates a deadzone for left stick y
        if (Math.abs(ypow) < .1) {
            ypow = 0;

        }
        //creates a deadzone for left stick x
        if (Math.abs(xpow) < .1) {
            xpow = 0;

        }
    }
    public void loop(){
        readGamePad();
        if(gamepad1.a){
            marker.setPosition(1);
        }
        if(gamepad1.b){
            marker.setPosition(0);
        }
        if(gamepad1.x){
            marker.setPosition(0.7);
        }
        if(gamepad1.y){
            marker.setPosition(0.3);
        }
    }
}
