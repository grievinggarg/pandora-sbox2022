package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class IterativeOpMode {
}

@TeleOp(name="Basic: Iterative Option", group="Iterative Opmode")
abstract
class BasicOpMode_Iterative_Skeleton extends OpMode
{

    //Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    public DcMotor aMotor;
    public double leftBack;
    public double leftFront;
    public double rightBack;
    public double rightFront;
    public DcMotor intake;
    RobotHardwareMap robot;

    public void init(HardwareMap ahwMap){
        aMotor = hardwareMap.get(DcMotor.class, "aMotor");

        aMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        aMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        intake = hardwareMap.get(DcMotor.class, "aMotor");
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake.setDirection(DcMotorSimple.Direction.FORWARD);

        robot.init(hardwareMap);


        //Tell the driver that initialization is complete
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {





    }

    @Override
    public void start(){

        runtime.reset();
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            intake.setPower(0.5);
        } else intake.setPower(gamepad1.left_stick_y);
        telemetry.addData("Motor Power", intake.getPower());

        double drive = -gamepad1.left_stick_y;
        double turn  =gamepad1.right_stick_x;

        leftBack = Range.clip(drive+turn, -1.0, 1.0);
        leftFront = Range.clip(drive + turn, -1.0, 1.0);
        rightBack = Range.clip(drive - turn, -1.0, 1.0);
        rightFront = Range.clip(drive - turn, -1.0, 1.0);


    }
}