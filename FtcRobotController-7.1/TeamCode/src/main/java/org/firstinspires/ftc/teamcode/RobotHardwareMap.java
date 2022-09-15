package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotHardwareMap {
    HardwareMap haMap;

    DcMotor leftMotor;
    public ColorSensor sensorColor;

    public RobotHardwareMap() {

    }

    public void init(HardwareMap hardwareMap) {
        haMap = hardwareMap;

        leftMotor = haMap.get(DcMotor.class, "leftMotor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DcMotor rightMotor = configureMotor("rightMotor", DcMotorSimple.Direction.FORWARD, DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public DcMotor configureMotor(String motorName, DcMotorSimple.Direction direction, DcMotor.RunMode runMode) {
        DcMotor intake = haMap.get(DcMotor.class, motorName);
        intake.setMode(runMode);
        intake.setPower(0);
        return intake;



    }

}
