package org.firstinspires.ftc.teamcode.Tests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.canvas.Canvas;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.profile.MotionProfile;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Util.DashboardUtil;

/**
 * Created by khadija on 1/18/2019.
 */
/*
 * This routine is designed to tune the PID coefficients used by the REV Expansion Hubs for closed-
 * loop velocity control. Although it may seem unnecessary, tuning these coefficients is just as
 * important as the positional parameters. Like the other manual tuning routines, this op mode
 * relies heavily upon the dashboard. To access the dashboard, connect your computer to the RC's
 * WiFi network and navigate to https://192.168.49.1:8080/dash in your browser. Once you've
 * successfully connected, start the program, and your robot will begin moving forward and backward
 * according to a motion profile. Your job is to graph the velocity errors over time and adjust the
 * PID coefficients (it's highly suggested to leave F at its default value) like any normal PID
 * controller. Once you've found a satisfactory set of gains, add them to your drive class init.
 */
@Autonomous(name = "StraightTestOpMode", group = "Spline")
public class StraightTestOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        SampleMecanumDriveBase drive = new SampleMecanumDriveREV(hardwareMap);

        Trajectory trajectory = drive.trajectoryBuilder()
                .forward(5)

                .build();


        waitForStart();

        if (isStopRequested()) {
            return;
        }



        while (opModeIsActive()) {
            drive.followTrajectory(trajectory);
            while (!isStopRequested() && drive.isFollowingTrajectory()) {
                Pose2d currentPose = drive.getPoseEstimate();

                TelemetryPacket packet = new TelemetryPacket();
                Canvas fieldOverlay = packet.fieldOverlay();

                packet.put("x: ", currentPose.getX());
                packet.put("y: ", currentPose.getY());
                packet.put("heading: ", currentPose.getHeading());

                fieldOverlay.setStrokeWidth(4);
                fieldOverlay.setStroke("yellow");
                DashboardUtil.drawSampledTrajectory(fieldOverlay, trajectory);

                fieldOverlay.setFill("blue");
                fieldOverlay.fillCircle(currentPose.getX(), currentPose.getY(), 3);

                dashboard.sendTelemetryPacket(packet);

                drive.update();
            }
        }
    }
}
