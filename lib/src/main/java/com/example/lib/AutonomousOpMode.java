package com.example.lib;
import java.util.*;
import com.example.lib.robotcore.*;

@Autonomous
public class AutonomousOpMode extends LinearOpMode{
    DcMotor motorLeftFront;
    DcMotor motorRightFront;
    DcMotor motorLeftBack;
    DcMotor motorRightBack;
    DistanceSensor ds1;
    DistanceSensor ds2;
    @Override
    public void runOpMode(){
        motorLeftFront = hardwareMap.dcMotor.get("Motor1");
        motorRightFront = hardwareMap.dcMotor.get("Motor2");
        motorLeftBack = hardwareMap.dcMotor.get("Motor3");
        motorRightBack = hardwareMap.dcMotor.get("Motor4");
        ds1 = hardwareMap.get(DistanceSensor.class, "DS1");
        ds2 = hardwareMap.get(DistanceSensor.class, "DS2");
        //makeParallel();
        while (opModeIsActive()) {
            StrafeRight();
            sleep(2000);
            StopMotors();
            sleep(2000);
        }
    }
    void SpinClockwise(){
        motorLeftFront.setPower(-200);
        motorLeftBack.setPower(-200);
        motorRightFront.setPower(200);
        motorRightBack.setPower(200);
    }
    void SpinCounterClockwise(){
        motorLeftFront.setPower(200);
        motorLeftBack.setPower(200);
        motorRightFront.setPower(-200);
        motorRightBack.setPower(-200);
    }
    void StrafeLeft(){
        motorLeftFront.setPower(200);
        motorRightFront.setPower(-200);
        motorLeftBack.setPower(200);
        motorRightBack.setPower(-200);
    }
    void StrafeRight(){
        motorLeftFront.setPower(-200);
        motorRightFront.setPower(200);
        motorLeftBack.setPower(-200);
        motorRightBack.setPower(200);
    }
    void MoveForward(float p){
        motorLeftFront.setPower(p);
        motorRightFront.setPower(p);
        motorLeftBack.setPower(p);
        motorRightBack.setPower(p);
    }
    void MoveBackward(){
        motorLeftFront.setPower(-200);
        motorRightFront.setPower(-200);
        motorLeftBack.setPower(-200);
        motorRightBack.setPower(-200);
    }
    void StopMotors(){
        motorLeftFront.setPower(0);
        motorRightFront.setPower(0);
        motorLeftBack.setPower(0);
        motorRightBack.setPower(0);
    }
    public void makeParallel() {
        double dis1 = ds1.getDistance(DistanceUnit.CM);
        double dis2 = ds1.getDistance(DistanceUnit.CM);
        while (opModeIsActive()){
            if (dis1>dis2){
                SpinClockwise();
            } else {
                SpinCounterClockwise();
            }
        }
    }
}
