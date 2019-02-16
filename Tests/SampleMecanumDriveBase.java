package org.firstinspires.ftc.teamcode.Tests;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.drive.MecanumDrive;
import com.acmerobotics.roadrunner.followers.MecanumPIDVAFollower;
import com.acmerobotics.roadrunner.followers.TrajectoryFollower;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;
import com.acmerobotics.roadrunner.trajectory.constraints.DriveConstraints;
import com.acmerobotics.roadrunner.trajectory.constraints.MecanumConstraints;

/**
 * Created by khadija on 1/18/2019.
 */
@Config
public abstract class SampleMecanumDriveBase extends MecanumDrive {
    public static PIDCoefficients TRANSLATIONAL_PID = new PIDCoefficients(0, 0, 0);
    public static PIDCoefficients HEADING_PID = new PIDCoefficients(0.18,0,0);


    private DriveConstraints constraints;
    private TrajectoryFollower follower;

    public SampleMecanumDriveBase() {
        super(driveConstants.TRACK_WIDTH);

        constraints = new MecanumConstraints(driveConstants.BASE_CONSTRAINTS, driveConstants.TRACK_WIDTH);
        follower = new MecanumPIDVAFollower(this, TRANSLATIONAL_PID, HEADING_PID,
                driveConstants.kV, driveConstants.kA, driveConstants.kStatic);
    }

    public TrajectoryBuilder trajectoryBuilder() {
        return new TrajectoryBuilder(getPoseEstimate(), constraints);
    }

    public void followTrajectory(Trajectory trajectory) {
        follower.followTrajectory(trajectory);
    }

    public void updateFollower() {
        follower.update(getPoseEstimate());
    }

    public void update() {
        updatePoseEstimate();
        updateFollower();
    }

    public boolean isFollowingTrajectory() {
        return follower.isFollowing();
    }

    public Pose2d getFollowingError() {
        return follower.getLastError();
    }

}

