package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.Joystick;

public class Drive{

    public static Robot robotFile = new Robot();

    public static void roboSet(TalonSRX lMaster,TalonSRX lSlave,TalonSRX rMaster, TalonSRX rSlave, double leftPower, double rightPower){

    lMaster.set(ControlMode.PercentOutput,leftPower);
    lSlave.set(ControlMode.PercentOutput,leftPower);
    rMaster.set(ControlMode.PercentOutput,rightPower);
    rSlave.set(ControlMode.PercentOutput,rightPower);
    //CANCoder encoder = new CANCoder(0);
    
    }

    public static void Drive(Joystick joystick, TalonSRX lMaster,TalonSRX lSlave,TalonSRX rMaster, TalonSRX rSlave, Double multiSpeed) {
        
        double y = joystick.getY();
        double x = joystick.getX();


        if ( y != 0 && x != 0){
            if ( y > .1 && x > .1){
                roboSet(lMaster, lSlave, rMaster, rSlave, y, multiSpeed*x);
            }else if( y > .1 && x < -.1){
                roboSet(lMaster, lSlave, rMaster, rSlave, multiSpeed*y, x);
            }else if ( y < -.1 && x > .1){
                roboSet(lMaster, lSlave, rMaster, rSlave, y, multiSpeed*y);
            }else if (y < -.1 && x < -.1){
                roboSet(lMaster, lSlave, rMaster, rSlave, multiSpeed*y, y);
            }
        }else if (( y != 0 && x == 0) || (y == 0 && x != 0)){
            if (y > .1){
                roboSet(lMaster, lSlave, rMaster, rSlave, y, y);
            }
            if (y < -.1){
                roboSet(lMaster, lSlave, rMaster, rSlave, -y, -y);
            }
            if (x > .1){
                roboSet(lMaster, lSlave, rMaster, rSlave, x, -x);
            }
            if (x < -.1){
                roboSet(lMaster, lSlave, rMaster, rSlave, x, -x);
            }
        }else{
            roboSet(lMaster, lSlave, rMaster, rSlave, y, y);
        }
    }






}