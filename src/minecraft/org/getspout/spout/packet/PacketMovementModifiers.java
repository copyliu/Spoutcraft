package org.getspout.spout.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.getspout.spout.gui.predownload.GuiPredownload;

import net.minecraft.client.Minecraft;


public class PacketMovementModifiers implements SpoutPacket{
	double gravityMod = 1;
	double walkingMod = 1;
	double swimmingMod = 1;
	double jumpingMod = 1;
	double airspeedMod = 1;
	
	public PacketMovementModifiers() {
		
	}
	
	public PacketMovementModifiers(double gravity, double walking, double swimming, double jumping, double airspeed) {
		this.gravityMod = gravity;
		this.walkingMod = walking;
		this.swimmingMod = swimming;
		this.jumpingMod = jumping;
		this.airspeedMod = airspeed;
	}

	public int getNumBytes() {
		return 40;
	}

	public void readData(DataInputStream input) throws IOException {
		gravityMod = input.readDouble();
		walkingMod = input.readDouble();
		swimmingMod = input.readDouble();
		jumpingMod = input.readDouble();
		airspeedMod = input.readDouble();
	}

	public void writeData(DataOutputStream output) throws IOException {
		output.writeDouble(gravityMod);
		output.writeDouble(walkingMod);
		output.writeDouble(swimmingMod);
		output.writeDouble(jumpingMod);
		output.writeDouble(airspeedMod);
	}

	public void run(int playerId) {
		if (Minecraft.theMinecraft.currentScreen instanceof GuiPredownload) {
			((GuiPredownload)Minecraft.theMinecraft.currentScreen).queuedPacket = this;
		}
		else {
			Minecraft.theMinecraft.thePlayer.gravityMod = gravityMod;
			Minecraft.theMinecraft.thePlayer.walkingMod = walkingMod;
			Minecraft.theMinecraft.thePlayer.swimmingMod = swimmingMod;
			Minecraft.theMinecraft.thePlayer.jumpingMod = jumpingMod;
			Minecraft.theMinecraft.thePlayer.airspeedMod = airspeedMod;
		}
	}

	public void failure(int playerId) {
		// TODO Auto-generated method stub
		
	}

	public PacketType getPacketType() {
		return PacketType.PacketMovementModifiers;
	}

	public int getVersion() {
		return 2;
	}
}
