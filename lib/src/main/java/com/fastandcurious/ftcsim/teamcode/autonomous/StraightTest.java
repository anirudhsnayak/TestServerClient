package com.fastandcurious.ftcsim.teamcode.autonomous;


import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import com.fastandcurious.ftcsim.teamcode.MecanumDrivetrain;
import com.fastandcurious.ftcsim.robotcore.LinearOpMode;

/*
 * This is a simple routine to test translational drive capabilities.
 */

public class StraightTest extends LinearOpMode {
    public static double DISTANCE = 60; // in

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrivetrain drive = new MecanumDrivetrain(hardwareMap);

        Trajectory trajectory = drive.trajectoryBuilder(new Pose2d())
                .forward(DISTANCE)
                .build();

        waitForStart();

        if (isStopRequested()) return;

        drive.followTrajectory(trajectory);

        while (!isStopRequested() && opModeIsActive()) ;
    }
}
